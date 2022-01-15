package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.actor.ServiceProvider;
import model.actor.ServiceRequester;
import model.item.Document;
import model.item.Location;
import model.item.Order;
import model.item.PremiumRule;
import model.item.PrintRule;

/**
 * Servlet implementation class OrderGenerateServlet
 */
public class OrderGenerateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderGenerateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void init() throws ServletException {
    	Document.init(getServletContext().getRealPath("")+"/");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintRule printRule=new PrintRule();
		for(String item:PrintRule.keyWordList.keySet()) {
			printRule.addRule(item, request.getParameter(item));
		}
		//ServideRequester默认指定 TODO
		ServiceRequester customer=ServiceRequester.allServiceRequester.get(0);
		Location customerLocation=customer.getLocation();
		List<ServiceProvider> sortedServiceProviders=customerLocation.matchList(ServiceProvider.allServiceProvider);
		//File默认指定 TODO
		Document userDocument=Document.allDocuments.get(0);
		
		response.getWriter().println("打印方式：<br />");
		for(Entry<String,String> entry:printRule.ruleNameAndRuleValue.entrySet()) {
			response.getWriter().println(entry.getKey()+": "+entry.getValue()+"<br />");
		}
		response.getWriter().println("您的地址：<br />");
		response.getWriter().println(customer.getLocation().toString("<br />")+"<br />");
		int pages=userDocument.getPages();
		response.getWriter().format("您打印的页数：%d<br />",pages);
		response.getWriter().println("您可选的商家：<br />");
		int count=1;
		for(ServiceProvider sp:sortedServiceProviders) {
			response.getWriter().println(""+count+".<br />");
			response.getWriter().format("距离您%.2fkm<br />",customerLocation.distance(sp.getLocation()));
			PremiumRule premiumRule=sp.findPremiumRule(printRule);
			response.getWriter().format("收费为% .2f元<br />",premiumRule.calCharge(pages));
			response.getWriter().println(sp.getLocation().getLocatAt()+"<br />");
			count++;
		}
		//默认最近的那一个形成订单，当然也可以是别的 TODO
		Order order=new Order(sortedServiceProviders.get(0),customer,printRule,userDocument);
		//.....(存储订单)TODO
		doGet(request, response);
	}

}
