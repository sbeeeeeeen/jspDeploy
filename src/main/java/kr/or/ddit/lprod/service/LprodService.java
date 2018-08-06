package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodService implements LprodServiceInf {
	private LprodDaoInf lDao = new LprodDao();

	@Override
	public Map<String, Object> getLprodPageList(Map<String, Integer> pageMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<LprodVo> lprodPageList = lDao.getLprodPageList(pageMap);
		resultMap.put("pageList", lprodPageList);
		resultMap.put("pageNavi", makePageNavi(pageMap.get("page"), pageMap.get("pageSize")));
		
		return resultMap;
	}
	
	private String makePageNavi(int page, int pageSize){
		StringBuffer pageNaviStr = new StringBuffer();
		pageNaviStr.append("<li><a href=\"lprod?page="+(page==1?1:page-1)+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		int count=1;
		int pageCnt = lDao.getLprodCnt();
		int temp = pageCnt;
		
		while(true){
			if(temp>0){
				temp-=pageSize;
				pageNaviStr.append((count==page?"<li class=\"active\">":"<li>")+"<a href=/lprod?page="+count+"&pageSize="+pageSize+">"+count+++"</a></li>");
				continue;
			}
			pageNaviStr.append("<li><a href=\"/lprod?page="+(page==count-1?page:page+1)+"&pageSize="+pageSize+"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
			return pageNaviStr.toString();
		}
	}

}
