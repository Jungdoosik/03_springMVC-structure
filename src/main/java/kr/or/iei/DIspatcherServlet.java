package kr.or.iei;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DIspatcherServlet
 */
public class DIspatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HandlerMapping handlerMapping = new HandlerMapping();
	private ViewResolver viewResolver = new ViewResolver();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DIspatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String uri =request.getRequestURI();//요청한 uri값을 저장하고 있는 메소드(로그인을 누르면 /member/login.do를 자동으로 찾아서 저장)
		
		Controller con = handlerMapping.getController(uri);
		
		String viewName = con.handlesRequest(request, response);//찾은 Controller를 바탕으로 Controller를 동작
		
		String view = null;
		
		if(viewName.contains(".do") || viewName.equals("/")) {
			//.do라는 경로가 포함되어 있다면
			view = viewName;
			response.sendRedirect(view);
			
		}else {
			
			view = viewResolver.getView(viewName);
			RequestDispatcher viewPage = request.getRequestDispatcher(view);
			viewPage.forward(request, response);
		}
		
		
		
	}

}
