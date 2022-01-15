package model.actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.impl.Locatable;
import model.item.Location;
import model.item.PremiumRule;
import model.item.PrintRule;

public class ServiceProvider extends User implements Locatable{
	private Location location;
	private Map<PrintRule,PremiumRule> chargeRules;
	@Override
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location=location;
	}
	public ServiceProvider() {
		this.chargeRules=new HashMap<PrintRule,PremiumRule>();
	}
	public boolean hasPrintRule(PrintRule printRule) {
		return chargeRules.containsKey(printRule);
	}
	public void addPrintRule(PrintRule printRule,PremiumRule premiumRule){
		chargeRules.put(printRule, premiumRule);
	}
	public PremiumRule findPremiumRule(PrintRule printRule) {
		return chargeRules.get(printRule);
	}
	
	public static List<ServiceProvider> allServiceProvider;
	static {
		allServiceProvider=new ArrayList<ServiceProvider>();
		ServiceProvider sp1=new ServiceProvider();
		ServiceProvider sp2=new ServiceProvider();
		PrintRule a4dan=PrintRule.allPrintRule.get(0);
		PrintRule a4shuang=PrintRule.allPrintRule.get(1);
		PremiumRule yimaowu=PremiumRule.allPremiumRule.get(0);
		PremiumRule liangmao=PremiumRule.allPremiumRule.get(1);
		PremiumRule yimao=PremiumRule.allPremiumRule.get(2);
		Location bashi=Location.allLocation.get(0);
		Location jiushi=Location.allLocation.get(1);
		sp1.setLocation(bashi);
		sp1.addPrintRule(a4dan, yimao);
		sp1.addPrintRule(a4shuang, yimaowu);
		
		sp2.setLocation(jiushi);
		sp2.addPrintRule(a4dan, yimaowu);
		sp2.addPrintRule(a4shuang, liangmao);
		allServiceProvider.add(sp1);
		allServiceProvider.add(sp2);
	}
}
