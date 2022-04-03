package pfpsc.model.define;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import pfpsc.util.MapUtility;

public class ChargeFunction {
	private Integer mid;
	private String function;
	private Set<Reference> shopReferences;
	private Set<Reference> customerReferences;
	private Reference charge;
	
	public ChargeFunction() {
		shopReferences=new HashSet<Reference>();
		customerReferences=new HashSet<Reference>();
	}
	
	public void setFunction(String function) {
		this.function = function;
	}
	public void addShopReference(Reference reference) {
		shopReferences.add(reference);
	}
	public void addcustomerReferences(Reference reference) {
		customerReferences.add(reference);
	}
	
	public String compile(String customerArgument,String shopArgument) {
		String function=new String(this.function.toCharArray());
		Map<String,String> customerMap=MapUtility.getMapByString(customerArgument);
		Map<String,String> shopMap=MapUtility.getMapByString(shopArgument);
		for(String item:customerMap.keySet()) {
			function=function.replace("${"+item+"}", customerMap.get(item));
		}
		for(String item:shopMap.keySet()) {
			function=function.replace("${"+item+"}", shopMap.get(item));
		}
		return function;
	}
	public String calculatePrice(String customerArgument,String shopArgument) throws ScriptException {
		String function=new String(this.function.toCharArray());
		Map<String,String> customerMap=MapUtility.getMapByString(customerArgument);
		Map<String,String> shopMap=MapUtility.getMapByString(shopArgument);
		for(String item:customerMap.keySet()) {
			function=function.replace("${"+item+"}", customerMap.get(item));
		}
		for(String item:shopMap.keySet()) {
			function=function.replace("${"+item+"}", shopMap.get(item));
		}
		ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
		ee.eval(function);
		return ee.get(charge.getName()).toString();
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Reference getCharge() {
		return charge;
	}

	public void setCharge(Reference charge) {
		this.charge = charge;
	}
	
	
}
