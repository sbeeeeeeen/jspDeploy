package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_Test {
	private Logger logger = LoggerFactory.getLogger(KISA_SHA256_Test.class);

	/**
	* Method : encryptTest
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC16
	* 변경이력 :
	* Method 설명 : sha256 hash 암호화 테스트
	*/
	@Test
	public void encryptTest() {
		/***Given***/
		String plainText = "1234";
		String plainText2 = "12345";

		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		String encryptText2 = KISA_SHA256.encrypt(plainText2);
		logger.debug("encryptText : " + encryptText);
		logger.debug("encryptText2 : " + encryptText2);

		/***Then***/
		assertEquals("ss", encryptText);

	}

}
