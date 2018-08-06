package kr.or.ddit.student.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	private StudentServiceInf stdService;
	
	@Before
	public void setup(){
		stdService = new StudentService();
	}

	/**
	* Method : selectAllStudentsTest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC16
	* 변경이력 :
	* Method 설명 : 전체 학생 정보 조회 테스트
	*/
	@Test
	public void selectAllStudentsTest() {
		/***When***/
		List<StudentVo> stdList = stdService.selectAllStudents();
		for(StudentVo std : stdList){
			System.out.println(std);
		}
		
		/***Then***/
		assertEquals(25, stdList.size());
	}
	
	@Test
	public void getStudentTest(){
		/***When***/
		StudentVo std = stdService.getStudent(20);

		/***Then***/
		assertEquals(20, std.getId());
	}
	
	@Test
	public void getStudentTest2(){
		/***When***/
		StudentVo test = new StudentVo();
		test.setId(20);
		test.setName("임수빈");
		test.setCall_cnt(0);
		StudentVo std = stdService.getStudent(test);

		/***Then***/
		assertEquals(20, std.getId());
	}
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC16
	* 변경이력 :
	* Method 설명 : 학생 페이지 리스트 조회 테스트
	*/
	@Test
	public void getStudentPageList(){
		/***Given***/
		
		/***When***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		
		Map<String, Object> resultMap = stdService.getStudentPageList(map);
		List<StudentVo> stdList = (List<StudentVo>) resultMap.get("pageList");
		int totCnt = (int)resultMap.get("totCnt");		
		for(int i=0; i<stdList.size(); i++){
			System.out.println(i+1 + " " + stdList.get(i).getName());
		}

		/***Then***/
		assertEquals(10, stdList.size());
		assertEquals(25, totCnt);
	}
	
	/**
	* Method : calculatePageNavi
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC16
	* 변경이력 :
	* Method 설명 : 전체 건수를 인자로 페이지 네비게이션 사이즈를 구한다
	*/
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;
		
		int cnt = totCnt%pageSize>0?totCnt/pageSize+1:totCnt/pageSize;
		
		/***When***/
		System.out.println(Math.round((double)totCnt / (double)pageSize));

		/***Then***/
		assertEquals(3, cnt);

	}
	
	@Test
	public void studentUpdateTest(){
		/***Given***/
		StudentVo std = new StudentVo();
		std.setId(2);
		std.setName("강병관");
		std.setAddr1("대전광역시 중구 중앙로 76");
		std.setAddr2("영민빌딩 2층");
		std.setPic("sally.png");
		std.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");
		std.setPicname("e1fd83e6-c615-454e-a53f-d5019c183e39");
		std.setZipcd("34940");

		/***When***/
		int cnt = stdService.updateStudent(std);

		/***Then***/
		assertEquals(1, cnt);
	}
	
}
