package pfpsc.constant;

public class RequestMapConstant {
	//In UserJsonController
	public static final String login="login";
	//In UserController
	public static final String index="index";
	
	//In PlaceOrderJsonController
	public static final String createOrder="createOrder";
	public static final String uploadFile="uploadFile";
	public static final String addPrintMethod="addPrintMethod";
	public static final String addShop="addShop";
	public static final String calculateFee="calculateFee";
	public static final String transfer="transfer";
	//In PlaceOrderController
	public static final String order_step1="order_step1";
	public static final String order_step2="order_step2";
	public static final String order_step3="order_step3";
	public static final String order_step4="order_step4";
	
	//In FinishOrderJsonController
	public static final String allPendingTrades="allPendingTrades";
	public static final String dueAPendingTrade="dueAPendingTrade";
	public static final String document="document";
	//In FinishOrderController
	public static final String getPaperDocument="getPaperDocument";
	
	//In DueOrderJsonController
	public static final String allReadyTrades="allReadyTrades";
	public static final String finishAPendingTrade="finishAPendingTrade";
	//In DueOrderController
	public static final String dueOrder="dueOrder";
}
