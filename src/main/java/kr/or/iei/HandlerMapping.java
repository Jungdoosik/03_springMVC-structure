package kr.or.iei;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.iei.member.controller.MemberLoginController;
import kr.or.iei.member.controller.MemberLogoutController;

public class HandlerMapping {

	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("/applicationContext.xml");
		
		mappings.put("/member/login.do", context.getBean("loginController",MemberLoginController.class));
		mappings.put("/member/logout.do", context.getBean("logoutController",MemberLogoutController.class));
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
