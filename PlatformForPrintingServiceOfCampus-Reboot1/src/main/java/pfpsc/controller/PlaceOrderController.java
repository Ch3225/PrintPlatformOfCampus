package pfpsc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfpsc.constant.SessionConstant;
import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.Shop;
import pfpsc.service.impl.IPlaceOrderService;
@Controller
public class PlaceOrderController {
	
	@Autowired
	IPlaceOrderService shopService;

	@RequestMapping("/order_step1")
	public String order_step1(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		return "order_step1";
	}
	
	@RequestMapping("/order_step2")
	public String order_step2(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		return "order_step2";
	}
	
	@RequestMapping("/order_step3")
	public String order_step3(HttpServletRequest request, HttpServletResponse httpServletResponse,
			Model model) {
		Trade order = (Trade)request.getSession().getAttribute(SessionConstant.SESSION_ORDER);
		
		List<Shop> shops=shopService.selectShopByString("");
		Map<Integer, String> shopMap = new HashMap<Integer, String>();
		for(Shop shop:shops) {
			shopMap.put(shop.getId(), shop.getName());
		}
		
		model.addAttribute("shopMap",shops);
		model.addAttribute("order",order);

		return "order_step3";
	}

	@RequestMapping("/order_step4")
	public String order_step4(HttpServletRequest request, HttpServletResponse httpServletResponse,
			Model model) {
		Trade order = (Trade)request.getSession().getAttribute(SessionConstant.SESSION_ORDER);
		
		return "order_step4";
	}
}
