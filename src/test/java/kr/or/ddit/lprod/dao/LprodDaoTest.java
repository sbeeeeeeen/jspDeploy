package kr.or.ddit.lprod.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodDaoTest {
	private LprodDaoInf lDao;
	
	@Before
	public void setup(){
		lDao = new LprodDao();
	}
	
	@Test
	public void getAllLprodListTest() {
		/***Given***/
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("page", 2);
		page.put("pageSize", 5);
		
		/***When***/
		List<LprodVo> lprodList = lDao.getLprodPageList(page);
		System.out.println(lprodList);

		/***Then***/
		assertEquals(5, lprodList.size());
	}

}
