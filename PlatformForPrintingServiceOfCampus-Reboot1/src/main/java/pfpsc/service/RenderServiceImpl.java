package pfpsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfpsc.constant.QuestionNaireConstant;
import pfpsc.dao.impl.DocumentMapper;
import pfpsc.dao.impl.TradeMapper;
import pfpsc.model.pojo.Trade;
import pfpsc.model.render.OrderForCustomer;
import pfpsc.model.render.OrderForShop;
import pfpsc.service.impl.IRenderService;

@Service
public class RenderServiceImpl implements IRenderService{
	
	@Autowired
	TradeMapper tradeMapper;
	
	@Autowired
	DocumentMapper documentMapper;

	@Override
	public OrderForCustomer renderOrderForCustomer(Trade trade) {
		Trade selectedTrade=tradeMapper.selectByPrimaryKey(trade.getId());
		
		OrderForCustomer orderForCustomer=new OrderForCustomer();
		orderForCustomer.setTradeId(selectedTrade.getId());
		
		orderForCustomer.setDocumentMethod(QuestionNaireConstant.translate(selectedTrade.getMethodString()));
		
		orderForCustomer.setDocumentName(documentMapper.selectByMD5(selectedTrade.getDocumentMd5()).getName());
		
		orderForCustomer.setState(selectedTrade.getState());
		
		orderForCustomer.setCount(selectedTrade.getCount());
		
		return orderForCustomer;
	}

	@Override
	public OrderForShop renderOrderForShop(Trade trade) {
		Trade selectedTrade=tradeMapper.selectByPrimaryKey(trade.getId());
		
		OrderForShop orderForShop=new OrderForShop();
		orderForShop.setTradeId(selectedTrade.getId());
		
		orderForShop.setDocumentMethod(QuestionNaireConstant.translate(selectedTrade.getMethodString()));
		
		orderForShop.setDocumentMD5(selectedTrade.getDocumentMd5());
		
		orderForShop.setState(selectedTrade.getState());
		
		orderForShop.setCount(selectedTrade.getCount());
		
		return orderForShop;
	}

}
