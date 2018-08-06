package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionAttributeListnener implements HttpSessionAttributeListener{
	private Logger logger = LoggerFactory.getLogger(SessionAttributeListnener.class);
	private Map<String, UserVo> loginSessionMap = new HashMap<String, UserVo>(); 

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		se.getSession().getServletContext().setAttribute("loginSessionMap", loginSessionMap);
		UserVo uservo = (UserVo)se.getValue();
		loginSessionMap.put(uservo.getUserId(), uservo);
		logger.debug("session attr added : " );
		logger.debug("se.getName() : " + se.getName());
		//login : 사용자가 정상적으로 로그인할 경우 session에 userVo를 설정함
		//listener에서 userVo가 값이 설정되는지를 모니터링하면 현재 접속한 사용자수를 관리할 수 있다...
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		logger.debug("session attr removed : " );
		if(se.getName().equals("userVo")){
			UserVo userVo = (UserVo)se.getValue();
			loginSessionMap.remove(userVo.getUserId(), userVo);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		logger.debug("session attr replaced : " );
	}
	
	

}
