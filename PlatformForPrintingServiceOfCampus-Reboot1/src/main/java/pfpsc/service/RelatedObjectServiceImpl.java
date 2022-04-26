package pfpsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfpsc.dao.impl.ShopMapper;
import pfpsc.model.pojo.Shop;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IRelatedObjectService;

@Service
public class RelatedObjectServiceImpl implements IRelatedObjectService{
	
	@Autowired
	ShopMapper shopMapper;
	
	public Shop selectShopByUser(User user) {
		return shopMapper.selectShopByOwnerId(user.getId());
	}
}
