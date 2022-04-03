package pfpsc.service.impl;

import java.util.List;

import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.User;

public interface IFinishOrderService {
	List<Trade> selectAllReadyTrades(User user);
	boolean finishAPendingTrade(Trade trade, User user);
}
