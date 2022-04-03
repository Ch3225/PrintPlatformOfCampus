package pfpsc.exception;

import java.util.HashMap;
import java.util.Map;

public class DefinedException extends Throwable{
	public static Map<String,String> codeAndString=new HashMap<String, String>();
	public static void loadStringAndCode(String code,String string) {
		codeAndString.put(code, string);
	}
	private static String getStringByCode(String code) {
		String string=codeAndString.get(code);
		return string==null?"":string;
	}
	private String code;
	private String message;
	private Object obj;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public DefinedException(String code) {
		this.code = code;
		this.message=getStringByCode(code);
	}
	public DefinedException(String code, Object obj) {
		this.code = code;
		this.message=getStringByCode(code);
		this.obj = obj;
	}
}
