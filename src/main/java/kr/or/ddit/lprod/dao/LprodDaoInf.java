package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodDaoInf {
	public List<LprodVo> getLprodPageList(Map<String, Integer> pageMap);
	
	public int getLprodCnt();
}
