package pfpsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pfpsc.dao.impl.notused.ShopMapper;
import pfpsc.model.pojo.Shop;
import pfpsc.model.pojo.User;

public interface IRelatedObjectService {
	Shop selectShopByUser(User user);

}
