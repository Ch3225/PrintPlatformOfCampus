package model.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintRule {
	static {
		init();
	}
	public Map<String,String> ruleNameAndRuleValue;
	public static Map<String,Set<String>> keyWordList;
	public PrintRule() {
		ruleNameAndRuleValue=new HashMap<String,String>();
	}
	public boolean addRule(String key,String value) {
		if(ruleNameAndRuleValue.containsKey(key)) {
			this.ruleNameAndRuleValue.put(key, value);
			return false;
		}
		else {
			this.ruleNameAndRuleValue.put(key, value);
			return true;
		}
	}
	public boolean deleteRule(String key) {
		if(!ruleNameAndRuleValue.containsKey(key)) {
			return false;
		}
		else {
			this.ruleNameAndRuleValue.remove(key);
			return true;
		}
	}
	//需保证打印方式表里没有重复的项，有重复的项会失效
	@Override
	public int hashCode() {
		int ans=0;
		for(Entry<String,String> entry:ruleNameAndRuleValue.entrySet()) {
			String str=entry.getKey()+entry.getValue();
			ans^=str.hashCode();
		}
		return ans;
	}
	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==((PrintRule)obj).hashCode();
	}
	public static List<PrintRule> allPrintRule;
	private static void init() {
		Map<String, Set<String>> map=new HashMap<String,Set<String>>();
		String a="打印用纸";
		String b="a4";
		String c="b5";
		Set<String> set=new HashSet<String>();
		set.add(b);
		set.add(c);
		map.put(a, set);
		String d="单双面打印";
		String e="单面";
		String f="双面";
		Set<String> set1=new HashSet<String>();
		set1.add(e);
		set1.add(f);
		map.put(d,set1);
		keyWordList=map;
		
		allPrintRule=new ArrayList<PrintRule>();
		PrintRule rule1=new PrintRule();
		rule1.addRule("单双面打印", "单面");
		rule1.addRule("打印用纸", "a4");
		PrintRule rule2=new PrintRule();
		rule2.addRule("单双面打印", "双面");
		rule2.addRule("打印用纸", "a4");
		allPrintRule.add(rule1);
		allPrintRule.add(rule2);
	}
}
