package kr.or.iei;

import java.util.HashMap;

import kr.or.iei.member.controller.MemberLoginController;
import kr.or.iei.member.controller.MemberLogoutController;

public class HandlerMapping {

	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/member/login.do", new MemberLoginController());
		mappings.put("/member/logout.do", new MemberLogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
