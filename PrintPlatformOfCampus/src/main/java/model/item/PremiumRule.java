package model.item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PremiumRule {
	// TODO should limit the amount of achors
	
	private Map<Integer,Double> priceAchorList;
	private PremiumRule(Set<Achor> set){
		priceAchorList=new HashMap<Integer,Double>();
		for(Achor item:set) {
			priceAchorList.put(item.pages, item.charge);
		}
	}
	private PremiumRule() {
		priceAchorList=new HashMap<Integer,Double>();
		if(!priceAchorList.containsKey(0)) {
			priceAchorList.put(0, 0.);
		}
		priceAchorList.put(1, 0.15);
	}
	public PremiumRule generateRules(Set<Achor> set) {
		if(!set.contains(Achor.ACHOR)) {
			priceAchorList.put(0, 0.);
		}
		if(set.size()>=2) {
			return new PremiumRule(set);
		}
		else {
			return new PremiumRule();
		}
	}
	public PremiumRule generateRules() {
		return new PremiumRule();
	}
	
	public boolean addAchor(Achor item) {
		if(priceAchorList.containsKey(item.pages)) {
			priceAchorList.put(item.pages, item.charge);
			return false;
		}else {
			priceAchorList.put(item.pages, item.charge);
			return true;
		}
	}
	
	public boolean deleteAchor(Achor item) {
		if(item.pages!=0) {
			if(priceAchorList.containsKey(item.pages)) {
				priceAchorList.remove(item.pages);
				return true;
				
			}
			return false;
		}
		else{
			return false;
		}
	}
	//running time O(n)
	public double calCharge(int pages) {
		List<Achor> list=new ArrayList<Achor>();
		for(Entry<Integer, Double> item:priceAchorList.entrySet()) {
			list.add(new Achor(item.getKey(),item.getValue()));
		}
		double ans=0;
		list.sort(new ComparatorOfAchor());
		for(int i=1;i<list.size();i++) {
			if(pages>list.get(i-1).pages) {
				double lamda=(pages-list.get(i-1).pages)*1./(list.get(i).pages-list.get(i-1).pages);
				ans=lamda*list.get(i).charge+(1-lamda)*list.get(i-1).charge;
			}
		}
		return ans;
	}
	public static class ComparatorOfAchor implements Comparator<Achor>{
		@Override
		public int compare(Achor arg0, Achor arg1) {
			return arg0.pages-arg1.pages;
		}
	}
	public static class Achor{
		static Achor ACHOR=new Achor(0,0.);
		int pages;
		double charge;
		Achor(int page,double charge){
			this.pages=page;
			this.charge=charge;
		}
		@Override
		public int hashCode() {
			return pages;
		}
		@Override
		public boolean equals(Object obj) {
			Achor aobj=(Achor)obj;
			return super.equals(aobj.pages);
		}
	}
	
	public static List<PremiumRule> allPremiumRule;
	static {
		init();
	}
	private static void init() {
		allPremiumRule=new ArrayList<PremiumRule>();
		Achor achor0=new Achor(0,0);
		Achor achor1=new Achor(1,0.15);
		Achor achor2=new Achor(1,0.2);
		Achor achor3=new Achor(1,0.1);
		PremiumRule premiumRule1=new PremiumRule();
		premiumRule1.addAchor(achor0);
		premiumRule1.addAchor(achor1);
		PremiumRule premiumRule2=new PremiumRule();
		premiumRule2.addAchor(achor0);
		premiumRule2.addAchor(achor2);
		PremiumRule premiumRule3=new PremiumRule();
		premiumRule3.addAchor(achor0);
		premiumRule3.addAchor(achor3);
		allPremiumRule.add(premiumRule1);
		allPremiumRule.add(premiumRule2);
		allPremiumRule.add(premiumRule3);
	}
}
