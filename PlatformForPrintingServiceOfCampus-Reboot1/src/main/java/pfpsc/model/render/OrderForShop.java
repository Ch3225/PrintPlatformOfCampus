package pfpsc.model.render;

public class OrderForShop {
	int tradeId;
	String documentMD5;
	String documentMethod;
	int count;
	String state;
	
	public OrderForShop() {}
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getDocumentMD5() {
		return documentMD5;
	}
	public void setDocumentMD5(String documentMD5) {
		this.documentMD5 = documentMD5;
	}
	public String getDocumentMethod() {
		return documentMethod;
	}
	public void setDocumentMethod(String documentMethod) {
		this.documentMethod = documentMethod;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
