package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import kr.or.iei.member.model.vo.Member;

@Repository(value="mDAO")
public class MemberDAO {

	public Member selectLoginMember(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;

		String query = "select * from member where userId=? and userPwd=? and end_YN ='N'";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member();
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userId"));
				m.setUserPwd(rset.getString("userPwd"));
				m.setUserName(rset.getString("userName"));
				m.setUserAge(rset.getInt("age"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enrollDate"));
				m.setEndYN(rset.getString("end_yn").charAt(0));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return m;
	}

}
