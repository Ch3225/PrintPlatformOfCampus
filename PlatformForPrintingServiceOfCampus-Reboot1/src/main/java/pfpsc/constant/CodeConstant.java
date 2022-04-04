package pfpsc.constant;

import pfpsc.exception.DefinedException;

public class CodeConstant {
	public static final String CODE_UNKNOWNERROR="0";	//未知错误
	public static final String CODE_SUCCESS="100";		//成功
	public static final String CODE_NOTFILLED="101";	//字段缺少	
	public static final String CODE_ILLEGAL="102";		//字段不合法
	public static final String CODE_NOTEXIST="103";		//请求的对象不存在
	
	public static void onLoad() {
		DefinedException.loadStringAndCode(CODE_UNKNOWNERROR, "未知错误");
		DefinedException.loadStringAndCode(CODE_SUCCESS, "成功");
		DefinedException.loadStringAndCode(CODE_NOTFILLED, "字段缺少");
		DefinedException.loadStringAndCode(CODE_ILLEGAL, "字段不合法");
		DefinedException.loadStringAndCode(CODE_NOTEXIST, "请求的对象不存在");
	}
}
