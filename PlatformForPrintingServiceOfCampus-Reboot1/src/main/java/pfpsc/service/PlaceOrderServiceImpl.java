package pfpsc.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pfpsc.constant.ChargeFunctionConstant;
import pfpsc.constant.EntityPropertyConstant;
import pfpsc.dao.impl.ShopMapper;
import pfpsc.dao.impl.SupportMapper;
import pfpsc.dao.impl.TradeMapper;
import pfpsc.dao.impl.TransferMapper;
import pfpsc.dao.impl.UserMapper;
import pfpsc.constant.CodeConstant;
import pfpsc.exception.DefinedException;
import pfpsc.model.define.ChargeFunction;
import pfpsc.model.define.Reference;
import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.Shop;
import pfpsc.model.pojo.Support;
import pfpsc.model.pojo.Transfer;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IPlaceOrderService;
import pfpsc.util.DocumentManager;
import pfpsc.util.MapUtility;
import pfpsc.util.WordUtility;

@Service
public class PlaceOrderServiceImpl implements IPlaceOrderService {
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	ShopMapper shopMapper;
	
	@Autowired
	SupportMapper supportMapper;
	
	@Autowired
	TradeMapper tradeMapper;
	
	@Autowired
	TransferMapper transferMapper;

	@Override
	public List<Shop> selectShopByString(String string) {
		if(string==null||"".equals(string)) {
			return shopMapper.selectAllShop();
		}else {
			return shopMapper.selectShopByName(string);
		}
	}

	@Override
	public String calculateFee(Integer shopId, String documentMD5, String printMethodString) throws DefinedException{
		File file=DocumentManager.selectDocumentByMD5(documentMD5);
		try {
			Integer pages = WordUtility.pages(file);
			Shop shop=shopMapper.selectByPrimaryKey(shopId);
			
			Support support=new Support();
			support.setMethod(printMethodString);
			support.setShopId(shopId);
			Support selectedSupport = supportMapper.selectByShopAndMethod(support);
			
			ChargeFunction chargeFunction=ChargeFunctionConstant.findChargeMethodById(1);
			
			Map<String,String> argMap=new HashMap<String,String>();
			argMap.put("page", pages.toString());
			String customerReferences=MapUtility.makeString("m", 1, argMap);
			
			String shopReferences=selectedSupport.getArguments();
			
			return chargeFunction.calculatePrice(customerReferences, shopReferences);
		} catch (IOException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DefinedException(CodeConstant.CODE_ILLEGAL);
		}
	}

	@Override
	public boolean createOrder(Trade order) {
		int insert = tradeMapper.insertSelective(order);
		if(insert>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean makeTransfer(Trade trade) throws NumberFormatException, DefinedException {
		String stringMD5=trade.getDocumentMd5();
		
		String methodString=trade.getMethodString();
		
		Integer fromId=trade.getUserId();
		
		Integer shopId=trade.getShopId();
		Shop selectedShop = shopMapper.selectByPrimaryKey(shopId);
		Integer toId=selectedShop.getUserId();
		
		Double fee=Double.parseDouble(calculateFee(shopId, stringMD5, methodString));
		BigDecimal bigDecimalFee=new BigDecimal(fee);
		
		Date date=new Date();
		
		User userFrom=userMapper.selectByPrimaryKey(fromId);
		User userTo=userMapper.selectByPrimaryKey(toId);
		BigDecimal userFromBalance=userFrom.getBalance();
		BigDecimal userToBalance=userTo.getBalance();
		BigDecimal userFromAfterBalance=userFromBalance.add(bigDecimalFee.negate());
		BigDecimal userToAfterBalance=userToBalance.add(bigDecimalFee);
		BigDecimal zeroDecimal=new BigDecimal(0);
		if(!userFromAfterBalance.min(zeroDecimal).equals(zeroDecimal)) {
			throw new DefinedException(CodeConstant.CODE_ILLEGAL);
		}
		userFrom.setBalance(userFromAfterBalance);
		userTo.setBalance(userToAfterBalance);
		userMapper.updateByPrimaryKey(userFrom);
		userMapper.updateByPrimaryKey(userTo);
		
		Transfer transfer=new Transfer();
		transfer.setFromUser(fromId);
		transfer.setToUser(toId);
		transfer.setMoney(bigDecimalFee);
		transfer.setTradeId(trade.getId());
		transfer.setTransferTime(date);
		transferMapper.insert(transfer);
		
		trade.setState(EntityPropertyConstant.ORDER_STATE_PENDING.toString());
		//TODO
		tradeMapper.updateByPrimaryKeySelective(trade);
		
		return true;
	}

}
