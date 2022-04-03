package pfpsc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import pfpsc.constant.JsonConstant;
import pfpsc.constant.QuestionNaireConstant;
import pfpsc.constant.SessionConstant;
import pfpsc.exception.DefinedException;
import pfpsc.model.define.QuestionNaire;
import pfpsc.model.pojo.Document;
import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IFileService;
import pfpsc.service.impl.IPlaceOrderService;
import pfpsc.util.DocumentManager;
import pfpsc.util.WordUtility;

@Controller
public class PlaceOrderJsonController {
	
	@Autowired
	IFileService fileService;
	
	@Autowired
	IPlaceOrderService placeOrderService;
	
	
	@RequestMapping("/createOrder")
	@ResponseBody
	public String createOrder(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		User user = (User)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		
		Trade order=new Trade();
		order.setUserId(user.getId());
		request.getSession().setAttribute(SessionConstant.SESSION_ORDER, order);
		
		return JsonConstant.CODE_SUCCESS;
	}
	
	@RequestMapping("/uploadFile")
	@ResponseBody
	public String fileUpload(HttpServletRequest request, @RequestParam("customFile") CommonsMultipartFile file) {
		if(DocumentManager.root==null||"".equals(DocumentManager.root)) {			//设置DocumentManager
			DocumentManager.root=request.getSession().getServletContext().getRealPath("/") + "document";
		}
		
		Trade order = (Trade)request.getSession().getAttribute(SessionConstant.SESSION_ORDER);
		
		try {
			String stringMD5 = fileService.saveDocumentForCustomer(file);
			order.setDocumentMd5(stringMD5);
		} catch (DefinedException e) {
			e.printStackTrace();
			return e.getCode();
		}
		
		return JsonConstant.CODE_SUCCESS;
	}
	
	@RequestMapping("/addPrintMethod")
	@ResponseBody
	public String addPrintMethod(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@RequestParam("count") String count) {
		
		QuestionNaire questionNaire = QuestionNaireConstant.questionNaires.get(1);
		
		List<String> choiceList=new ArrayList<String>();
		for (int i = 0; i < questionNaire.getKeys().size(); i++) {
			String str = request.getParameter("q" + (i + 1));
			choiceList.add(str);
		}
		
		String choiceString=questionNaire.choiceStringListToString(choiceList);
		
		Trade order = (Trade)request.getSession().getAttribute(SessionConstant.SESSION_ORDER);
		
		order.setMethodString(choiceString);
		
		try {
			Integer countInteger=Integer.parseInt(count);
			order.setCount(countInteger);
		} catch (NumberFormatException e) {
			return JsonConstant.CODE_ILLEGAL;
		}
		
		return JsonConstant.CODE_SUCCESS;
	}
	
	@RequestMapping("/addShop")
	@ResponseBody
	public String addShop(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@RequestParam("shopId") Integer shopId) {
		Trade order = (Trade) request.getSession().getAttribute(SessionConstant.SESSION_ORDER);
		if(shopId>=0) {
			order.setShopId(shopId);
			return JsonConstant.CODE_SUCCESS;
		}
		else {
			return JsonConstant.CODE_ILLEGAL;
		}
	}
	
	@RequestMapping("/calculateFee")
	@ResponseBody
	public String calculateFee(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@RequestParam("shopId") Integer shopId) {
		Trade order = (Trade) request.getSession().getAttribute(SessionConstant.SESSION_ORDER);
		
		String documentMD5= order.getDocumentMd5();
		
		String printmethod = order.getMethodString();

		try {
			return placeOrderService.calculateFee(shopId, documentMD5, printmethod);
		} catch (DefinedException e1) {
			e1.printStackTrace();
			return "NaN";
		}
		
	}
	
	@RequestMapping("/transfer")
	@ResponseBody
	public String transfer(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@RequestParam("shopId") Integer shopId) {
		Trade order = (Trade) request.getSession().getAttribute(SessionConstant.SESSION_ORDER);
		
		order.setShopId(shopId); 
		
		String documentMD5= order.getDocumentMd5();
		
		String printmethod = order.getMethodString();

		
		try {
			String money = placeOrderService.calculateFee(shopId, documentMD5, printmethod);
			Double moneyDouble = Double.parseDouble(money);
			
			boolean b1=placeOrderService.createOrder(order);
			boolean b2=placeOrderService.makeTransfer(order);
			if(b1&&b2) {
				return JsonConstant.CODE_SUCCESS;
			} else {
				return JsonConstant.CODE_UNKNOWNERROR;
			}
			
		} catch (DefinedException|NumberFormatException e) {
			e.printStackTrace();
			return JsonConstant.CODE_UNKNOWNERROR;
		}
		
	}
}
