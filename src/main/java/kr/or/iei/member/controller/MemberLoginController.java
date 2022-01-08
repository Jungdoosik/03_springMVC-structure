package kr.or.iei.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.Controller;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;


@org.springframework.stereotype.Controller(value="loginController")
public class MemberLoginController implements Controller {
	
	@Resource(name="mService")
	private MemberService mService;

	@Override
	public String handlesRequest(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member m = mService.selectLoginMember(userId, userPwd);
		
		if(m!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			
			request.setAttribute("result", true);
		}else{
			request.setAttribute("result", false);
		}
		return "member/loginResult";
	}
	
	

}
