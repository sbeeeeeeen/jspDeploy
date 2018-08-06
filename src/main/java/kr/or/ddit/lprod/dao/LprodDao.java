package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class LprodDao implements LprodDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<LprodVo> getLprodPageList(Map<String, Integer> pageMap) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.getLprodPageList", pageMap);
		session.close();
		return lprodList;
	}

	@Override
	public int getLprodCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = (int)session.selectOne("lprod.getLprodCnt");
		return cnt;
	}

}
