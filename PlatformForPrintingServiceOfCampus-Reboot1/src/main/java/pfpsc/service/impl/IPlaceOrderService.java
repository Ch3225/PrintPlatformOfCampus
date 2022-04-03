package pfpsc.service.impl;

import java.util.List;

import pfpsc.exception.DefinedException;
import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.Shop;

public interface IPlaceOrderService {
	List<Shop> selectShopByString(String string);
	String calculateFee(Integer shopId, String documentMD5, String printMethodString) throws DefinedException;
	boolean createOrder(Trade order);
	boolean makeTransfer(Trade order) throws NumberFormatException, DefinedException;
}
