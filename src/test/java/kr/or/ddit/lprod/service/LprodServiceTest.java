package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceTest {
	private LprodServiceInf lService;
	
	@Before
	public void setup(){
		lService = new LprodService();
	}

	@Test
	public void getAllLprodListTest() {
		/***Given***/
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("page", 2);
		page.put("pageSize", 5);
		
		/***When***/
		Map<String, Object> resultMap = lService.getLprodPageList(page);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("pageList");

		/***Then***/
		assertEquals(5, lprodList.size());
	}

}
