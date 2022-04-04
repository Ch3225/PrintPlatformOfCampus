package pfpsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pfpsc.constant.PageNameConstant;
import pfpsc.constant.RequestMapConstant;

@Controller
public class FinishOrderController {
	
	@RequestMapping(RequestMapConstant.addPrintMethod)
	public String dueOrder() {
		return PageNameConstant.getPaperDocument;
	}
}
