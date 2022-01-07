package kr.or.iei;

public class ViewResolver {

	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
	
	
}
