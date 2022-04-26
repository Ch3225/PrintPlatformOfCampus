package pfpsc.model.render;

public class OrderForCustomer {
	int tradeId;
	String documentName;
	String documentMethod;
	int count;
	String state;
	
	public OrderForCustomer() {}
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
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
