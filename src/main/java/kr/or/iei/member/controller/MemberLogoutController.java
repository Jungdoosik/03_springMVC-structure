package kr.or.iei.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.Controller;


@org.springframework.stereotype.Controller(value="logoutController")
public class MemberLogoutController implements Controller {

	@Override
	public String handlesRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		return "/";
	}

}
