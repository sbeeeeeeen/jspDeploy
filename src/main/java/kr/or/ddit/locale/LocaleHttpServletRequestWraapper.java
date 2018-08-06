package kr.or.ddit.locale;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LocaleHttpServletRequestWraapper extends HttpServletRequestWrapper{
	private Map<String, String[]> map;

	public LocaleHttpServletRequestWraapper(HttpServletRequest request) {
		super(request);
//		request.getParameter(name);
//		request.getParameterValues(name);
//		request.getParameterMap();
//		request.getParameterNames();
		
		//기존 request객체의 파라미터 map을 복사
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		//defComp 파라미터가 null혹은 whiteSpace인 경우 기본값으로 설정
		String[] locale = map.get("locale");
		if(locale==null||locale.equals("")){
			map.put("locale", new String[]{"ja"});
		}
		
	}

	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		return values!=null ? values[0] : null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return map;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(map.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return map.get(name);
	}
}
