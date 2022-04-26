package pfpsc.service.impl;

import pfpsc.model.pojo.Trade;
import pfpsc.model.render.OrderForCustomer;
import pfpsc.model.render.OrderForShop;

public interface IRenderService {
	OrderForCustomer renderOrderForCustomer(Trade trade);
	OrderForShop renderOrderForShop(Trade trade);
}
