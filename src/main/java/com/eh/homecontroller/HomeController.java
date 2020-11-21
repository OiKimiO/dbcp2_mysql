package com.eh.homecontroller;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eh.homeVo.homeVo;
import com.eh.homeservice.homeService;


@Controller
public class HomeController {
		
		@Inject homeService service;

		@RequestMapping(value = "/")
		public String home(Model model) {		
			List<homeVo> vo = service.readDB();
			model.addAttribute("example", vo);
			return "home";
		}
		
		@RequestMapping(value = "/transSms")
		public String transSms(Model model,HttpServletRequest reqeust) throws Exception{		
			service.transSms(reqeust);
			return "home";
		}
		
}
