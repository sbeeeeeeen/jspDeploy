package kr.or.ddit.student.dao;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	private StudentDaoInf studentDao;
	@Before
	public void setup(){
		studentDao = new StudentDao();
	}
	
	/**
	* Method : selectAllStudentsTest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC16
	* 변경이력 :
	* Method 설명 : 전체 학생 정보를 조회한다.
	*/
	@Test
	public void selectAllStudentsTest() {
		/***When***/
		List<StudentVo> stdList = studentDao.selectAllStudents();
		for(StudentVo vo : stdList)
			System.out.println(vo);
		
		/***Then***/
		assertEquals(25, stdList.size());
	}
	
	@Test
	public void getStudentTest(){
		/***When***/
		StudentVo std = studentDao.getStudent(20);

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
		StudentVo std = studentDao.getStudent(test);

		/***Then***/
		assertEquals(20, std.getId());
	}
	
	@Test
	public void getStudentPageListTest(){
		/***Given***/
		

		/***When***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		
		List<StudentVo> stdList = studentDao.getStudentPageList(map);
		for(int i=0; i<stdList.size(); i++){
			System.out.println(i+1 + " " + stdList.get(i).getName());
		}

		/***Then***/
		assertEquals(10, stdList.size());
	}
	
	@Test
	public void getStudentTotCntTest() {
		/***Given***/
		

		/***When***/
		int cnt = studentDao.getStudentTotCnt();
		
		/***Then***/
		assertEquals(25, cnt);
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
		int cnt = studentDao.updateStudent(std);

		/***Then***/
		assertEquals(1, cnt);
	}
}
