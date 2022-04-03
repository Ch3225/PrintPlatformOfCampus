package pfpsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DueOrderController {
	
	@RequestMapping("dueOrder")
	public String dueOrder() {
		
		return "dueOrder";
	}
}
