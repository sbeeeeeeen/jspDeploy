package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf{
	private StudentDaoInf stdDao = new StudentDao();
	
	@Override
	public List<StudentVo> selectAllStudents() {
		return stdDao.selectAllStudents();
	}

	@Override
	public StudentVo getStudent(int id) {
		return stdDao.getStudent(id);
	}

	@Override
	public StudentVo getStudent(StudentVo studentVo) {
		return stdDao.getStudent(studentVo);
	}

	@Override
	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<StudentVo> pageList = stdDao.getStudentPageList(map);
		resultMap.put("pageList", pageList);
		
		int totCnt = stdDao.getStudentTotCnt();
		resultMap.put("totCnt", totCnt);
		
		//페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC16
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 :
	*/
	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt%pageSize>0?totCnt/pageSize+1:totCnt/pageSize;
		
		StringBuffer pageNaviStr = new StringBuffer();
		int prevPage = page==1?1:page-1;
		int nextPage = page==cnt?page:page+1;
		
		pageNaviStr.append("<li data-page=\""+prevPage + "\" data-pageSize=\""+pageSize+"\"><a href=\"/studentList?"
				+ "page="+prevPage+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">"
						+ "&laquo;</span></a></li>");
		
		for(int i=1; i<=cnt; i++){
			pageNaviStr.append((i==page?"<li data-page=\""+prevPage + "\" data-pageSize=\""+pageSize+"\" "
					+ "class=\"active\">":"<li data-page=\""+prevPage + "\" data-pageSize=\""+pageSize+"\">")
					+"<a href=/studentList?page="
					+i+"&pageSize="+pageSize+">"+i+"</a></li>");
		}
		
		pageNaviStr.append("<li data-page=\""+prevPage + "\" data-pageSize=\""+pageSize+"\"><a href=\""
				+ "/studentList?page="+nextPage+"&pageSize="+pageSize+"\" aria-label=\"Next\"><span aria-hidden=\"tr"
						+ "ue\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}

	@Override
	public int updateStudent(StudentVo std) {
		return stdDao.updateStudent(std);
	}

}
