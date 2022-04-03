package pfpsc.service.impl;

import java.util.List;

import pfpsc.model.pojo.Shop;
import pfpsc.model.pojo.Trade;

public interface IDueOrderService {
	List<Trade> selectAllPendingTrades(Shop shop);
	boolean dueAPendingTrade(Trade trade, Shop shop);
}
