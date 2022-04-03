package pfpsc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import pfpsc.constant.JsonConstant;
import pfpsc.constant.SessionConstant;
import pfpsc.dao.impl.TradeMapper;
import pfpsc.model.pojo.Document;
import pfpsc.model.pojo.Shop;
import pfpsc.model.pojo.Trade;
import pfpsc.model.pojo.User;
import pfpsc.service.impl.IDueOrderService;
import pfpsc.service.impl.IFileService;
import pfpsc.service.impl.IRelatedObjectService;
import pfpsc.util.DocumentManager;

@Controller
public class FinishOrderJsonController {
	
	@Autowired
	IDueOrderService dueOrderService;
	
	@Autowired
	IRelatedObjectService relatedObjectService;
	
	@Autowired
	IFileService fileService;
	
	@RequestMapping("allPendingTrades")
	@ResponseBody
	List<Trade> selectAllPendingTrades(HttpServletRequest request, HttpServletResponse httpServletResponse){
		User user = (User)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		Shop shop=relatedObjectService.selectShopByUser(user);
		List<Trade> trades=dueOrderService.selectAllPendingTrades(shop);
		return trades;
	}
	
	@RequestMapping("dueAPendingTrade")
	@ResponseBody
	String dueAPendingTrade(HttpServletRequest request, HttpServletResponse httpServletResponse, @RequestParam("tradeId")Integer tradeId) {
		User user = (User)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		Shop shop=relatedObjectService.selectShopByUser(user);
		Trade trade=new Trade();
		trade.setId(tradeId);
		dueOrderService.dueAPendingTrade(trade,shop);
		return JsonConstant.CODE_SUCCESS;
	}
	
	@RequestMapping(value="/document")
	@ResponseBody
	public String downloadResource(HttpSession session, HttpServletRequest request,
	        HttpServletResponse response,@RequestParam("documentMd5")String documentMd5) {
		if(DocumentManager.root==null||"".equals(DocumentManager.root)) {			//设置DocumentManager
			DocumentManager.root=request.getSession().getServletContext().getRealPath("/") + "document";
		}
		
		File file=DocumentManager.selectDocumentByMD5(documentMd5);
	    if (file.exists()) {
	    	Document document=fileService.getDocumentByMD5(documentMd5);
	    	String[] splitedFileName=document.getName().split("\\.");
	    	String fileType=splitedFileName[splitedFileName.length-1];
	        //设置响应类型，这里是下载pdf文件
	        response.setContentType("application/"+fileType);
	        //设置Content-Disposition，设置attachment，浏览器会激活文件下载框；filename指定下载后默认保存的文件名
	        //不设置Content-Disposition的话，文件会在浏览器内打卡，比如txt、img文件
	        
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("multipart/form-data");
	        response.addHeader("Content-Disposition",
	                "attachment; filename="+documentMd5+"."+fileType);
			try {
				InputStream input = new FileInputStream(file);
				OutputStream out = response.getOutputStream();
				byte[] buff =new byte[1024];
				int index=0;
				while((index= input.read(buff))!= -1){
					out.write(buff, 0, index);
					out.flush();
				}
				out.close();
				input.close();
				return JsonConstant.CODE_SUCCESS;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return JsonConstant.CODE_ILLEGAL;
	}
	
}
