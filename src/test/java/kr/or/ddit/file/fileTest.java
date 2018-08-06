package kr.or.ddit.file;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class fileTest {
	private String fileName;
	
	@Before
	public void setup(){
		fileName = "form-data; name=\"uploadFile\"; filename=\"sally.png\"";
	}
	
	@Test
	public void FileUtiltest() {
		String ContentDisposition = FileUtil.getFileName(fileName);
		
		assertEquals("sally.png", ContentDisposition);
		
	}

}
