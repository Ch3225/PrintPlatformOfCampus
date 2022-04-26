package pfpsc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pfpsc.constant.EntityPropertyConstant;
import pfpsc.constant.RequestMapConstant;
import pfpsc.constant.CodeConstant;
import pfpsc.constant.SessionConstant;
import pfpsc.dao.impl.TradeMapper;
import pfpsc.model.pojo.Document;
import pfpsc.model.pojo.Shop;
import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.User;
import pfpsc.model.render.OrderForShop;
import pfpsc.service.impl.IDueOrderService;
import pfpsc.service.impl.IFileService;
import pfpsc.service.impl.IFinishOrderService;
import pfpsc.service.impl.IRelatedObjectService;
import pfpsc.service.impl.IRenderService;
import pfpsc.util.DocumentManager;

@Controller
public class DueOrderJsonController {
	
	@Autowired
	IDueOrderService dueOrderService;
	
	@Autowired
	IRelatedObjectService relatedObjectService;
	
	@Autowired
	IFileService fileService;
	
	@Autowired
	IFinishOrderService finishOrderService;
	
	@Autowired
	IRenderService renderService;
	
	@RequestMapping(RequestMapConstant.allPendingTrades)
	@ResponseBody
	List<OrderForShop> selectAllPendingTrades(HttpServletRequest request, HttpServletResponse httpServletResponse){
		User user = (User)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		List<Trade> trades=dueOrderService.selectAllPendingTrades(relatedObjectService.selectShopByUser(user));
		List<OrderForShop> orders=new ArrayList<OrderForShop>();
		for(Trade item:trades) {
			orders.add(renderService.renderOrderForShop(item));
		}
		return orders;
	}
	
	@RequestMapping(RequestMapConstant.dueAPendingTrade)
	@ResponseBody
	String dueAPendingTrade(HttpServletRequest request, HttpServletResponse httpServletResponse, @RequestParam("tradeId")Integer tradeId) {
		User user = (User)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		Trade trade=new Trade();
		trade.setId(tradeId);
		finishOrderService.finishAPendingTrade(trade,user);
		return CodeConstant.CODE_SUCCESS;
	}
	
	
}
