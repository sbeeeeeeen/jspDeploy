package kr.or.ddit.cookie.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CookieUtilTest {
	private String cookie;
	@Before
	public void setup(){
		cookie = "userId=id; rememberMe=y; checkYn=n";
	}

	@Test
	public void getCookieTest() {
		//userId=brown; rememberMe=y
//		fail("Not yet implemented");
		
		/***Given***/
		CookieUtil cookieUtil = new CookieUtil();

		/***When***/
		//userId ==> id
//		String cookieValue = cookieUtil.getCookie("cookie전체값","우리가 확인하고자하는 cookie");
		String cookieValue = cookieUtil.getCookie(cookie,"userId");
		String cookieValue2 = cookieUtil.getCookie(cookie, "rememberMe");

		/***Then***/
		assertEquals("id", cookieValue);
		assertEquals("y", cookieValue2);
	}
	
	@Test
	public void cookieSplitTest(){
		/***Given***/
		String[] cookies = cookie.split("; ");

		/***When***/

		/***Then***/
		assertEquals(3, cookies.length);
		assertEquals("userId=id", cookies[0]);
		assertEquals("rememberMe=y", cookies[1]);
		assertEquals("checkYn=n", cookies[2]);
		
	}
	
	/**
	* Method : cookieNameValueSplitTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC16
	* 변경이력 :
	* Method 설명 : cookie의 이름과 값을 분리 테스트
	*/
	@Test
	public void cookieNameValueSplitTest(){
		/***Given***/
		String cookie = "userId=id";

		/***When***/
		//[0]>userId
		//[1]>id
		String[] cookieArr = cookie.split("=");

		/***Then***/
		assertEquals("userId", cookieArr[0]);
		assertEquals("id", cookieArr[1]);
	}
}