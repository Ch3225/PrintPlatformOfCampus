package pfpsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FinishOrderController {
	
	@RequestMapping("getPaperDocument")
	public String dueOrder() {
		return "getPaperDocument";
	}
}
