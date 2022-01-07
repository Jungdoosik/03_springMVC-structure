package kr.or.iei.member.model.service;

import java.sql.Connection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDAO;
import kr.or.iei.member.model.vo.Member;
@Service(value="mService")
public class MemberService {
	
	@Autowired
	@Qualifier(value="mDAO")
	private MemberDAO mDAO;
	
	@Resource(name="jdbc")
	private JDBCTemplate jdbc;

	public Member selectLoginMember(String userId, String userPwd) {
		Connection conn = jdbc.getConnection();
		Member m = mDAO.selectLoginMember(conn, userId, userPwd);
		jdbc.close(conn);
		return m;
	}

}
