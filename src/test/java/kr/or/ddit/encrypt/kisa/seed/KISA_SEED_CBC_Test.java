package kr.or.ddit.encrypt.kisa.seed;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SEED_CBC_Test {
	private Logger logger = LoggerFactory.getLogger(KISA_SEED_CBC_Test.class);

	/**
	* Method : encryTest
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC16
	* 변경이력 :
	* Method 설명 : kisa seed 블록 암호화 테스트
	*/
	@Test
	public void encryTest() {
		/***Given***/
		String plainText = "1234";

		/***When***/
		String encryptText = KISA_SEED_CBC.Encrypt(plainText);
		String decryptText = KISA_SEED_CBC.Decrypt(encryptText);
		
		logger.debug("encryptText : " + encryptText);
		logger.debug("decryptText : " + decryptText);

		/***Then***/
		assertEquals(plainText, decryptText);
		
	}

}
