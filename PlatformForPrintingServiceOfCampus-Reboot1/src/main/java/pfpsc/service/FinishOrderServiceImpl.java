package pfpsc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfpsc.constant.EntityPropertyConstant;
import pfpsc.dao.impl.TradeMapper;
import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IFinishOrderService;

@Service
public class FinishOrderServiceImpl implements IFinishOrderService {
	
	@Autowired
	TradeMapper tradeMapper;
	
	@Override
	public List<Trade> selectAllReadyTrades(User user) {
		List<Trade> trades=tradeMapper.selectAllReadyByUser(user.getId());
		return trades;
	}

	@Override
	public boolean finishAPendingTrade(Trade trade, User user) {
		Trade selectedTrade=tradeMapper.selectByPrimaryKey(trade.getId());
		if(selectedTrade.getUserId()==user.getId()) {
			selectedTrade.setState(EntityPropertyConstant.ORDER_STATE_FINISHED.toString());
			tradeMapper.updateByPrimaryKeySelective(selectedTrade);
			return true;
		}
		else {
			return false;
		}
	}

}
