package pfpsc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfpsc.constant.EntityPropertyConstant;
import pfpsc.dao.impl.notused.TradeMapper;
import pfpsc.model.pojo.Shop;
import pfpsc.model.pojo.Trade;
import pfpsc.service.impl.IDueOrderService;

@Service
public class DueOrderServiceImpl implements IDueOrderService{
	
	@Autowired
	TradeMapper tradeMapper;

	@Override
	public List<Trade> selectAllPendingTrades(Shop shop) {
		List<Trade> trades=tradeMapper.selectAllPendingsByShop(shop.getId());
		return trades;
	}

	@Override
	public boolean dueAPendingTrade(Trade trade, Shop shop) {
		Trade selectedTrade=tradeMapper.selectByPrimaryKey(trade.getId());
		if(selectedTrade.getShopId()==shop.getId()) {
			selectedTrade.setState(EntityPropertyConstant.ORDER_STATE_READY.toString());
			tradeMapper.updateByPrimaryKeySelective(selectedTrade);
			return true;
		}
		else {
			return false;
		}
	}

}
