package kr.or.iei;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	String handlesRequest(HttpServletRequest request, HttpServletResponse response);

}
