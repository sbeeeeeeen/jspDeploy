package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StudentDao implements StudentDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC16
	 * 변경이력 : 
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> stdList = session.selectList("student.selectAllStudents");
		session.close();
		return stdList;
	}
	
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC16
	 * 변경이력 : 
	 * @return
	 * Method 설명 : 특정 학생 정보 조회
	 */
	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo std = session.selectOne("student.getStudent", id);
		session.close();
		return std;
	}
	
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC16
	 * 변경이력 : 
	 * @return
	 * Method 설명 : 특정 학생 정보 조회
	 */
	@Override
	public StudentVo getStudent(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo std = session.selectOne("student.getStudent", studentVo.getId());
		session.close();
		return std;
	}

	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC16
	 * 변경이력 : 
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> stdList = session.selectList("student.getStudentPageList", map);
		session.close();
		return stdList;
	}

	/**
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC16
	 * 변경이력 : 
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("student.getStudentTotCnt");
		session.close();
		return cnt;
	}

	@Override
	public int updateStudent(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("student.updateStudent", studentVo);
		session.commit();
		session.close();
		return cnt;
	}
}
