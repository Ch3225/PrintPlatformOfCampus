package pfpsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pfpsc.constant.PageNameConstant;
import pfpsc.constant.RequestMapConstant;

@Controller
public class DueOrderController {
	
	@RequestMapping(RequestMapConstant.dueOrder)
	public String dueOrder() {
		return PageNameConstant.dueOrder;
	}
}
