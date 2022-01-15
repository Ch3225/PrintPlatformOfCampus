package model.item;

import java.util.ArrayList;
import java.util.List;

import model.actor.ServiceProvider;
import model.actor.ServiceRequester;

public class Order {
	public static List<Order> allOrder;
	static int count=0;
	int id;
	ServiceProvider serviceProvider;
	ServiceRequester serviceRequester;
	Document document;
	PrintRule printRule;
	public Order(ServiceProvider serviceProvider,ServiceRequester serviceRequester,PrintRule printRule,Document document) {
		this.serviceProvider=serviceProvider;
		this.serviceRequester=serviceRequester;
		this.document=document;
		this.printRule=printRule;
		this.id=count++;
	}
	static {
		init();
	}
	private static void init() {
		allOrder=new ArrayList<Order>();
		
		Order order1=new Order(ServiceProvider.allServiceProvider.get(0),
				ServiceRequester.allServiceRequester.get(0),
				PrintRule.allPrintRule.get(0),
				Document.allDocuments.get(0));
		Order order2=new Order(ServiceProvider.allServiceProvider.get(1),
				ServiceRequester.allServiceRequester.get(1),
				PrintRule.allPrintRule.get(0),
				Document.allDocuments.get(0));
		Order order3=new Order(ServiceProvider.allServiceProvider.get(0),
				ServiceRequester.allServiceRequester.get(1),
				PrintRule.allPrintRule.get(1),
				Document.allDocuments.get(1));
		allOrder.add(order1);
		allOrder.add(order2);
		allOrder.add(order3);
	}
	public ServiceProvider getServiceProvider(){
		return this.serviceProvider;
	}
	public Document getDocument() {
		return document;
	}
	public PrintRule getPrintRule() {
		return printRule;
	}
	
}
