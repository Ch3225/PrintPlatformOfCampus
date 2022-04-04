package pfpsc.model.transfer;

import pfpsc.constant.CodeConstant;

public class TransferedJson<T> {
	private String code;
	private T data;
	
	public TransferedJson(String code, T data) {
		this.code = code;
		this.data = data;
	}
	public TransferedJson(String code) {
		this.code = code;
	}
	public TransferedJson(T data) {
		this.data=data;
		this.code=CodeConstant.CODE_SUCCESS;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	
}
