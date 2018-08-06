package kr.or.ddit.jstl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class JstlForeachServlet
 */
@WebServlet("/jstlForeachServlet")
public class JstlForeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.studentService.selectAllStudents()
		//2.request객체에 list데이터 저장(studentList)
		//3.foreach.jsp로 forward
		StudentServiceInf stdService = new StudentService();
		List<StudentVo> stdList = stdService.selectAllStudents();
		request.setAttribute("studentList", stdList);
		
		//forEach를 이용한 map 데이터 조회
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "sally");
		map.put("alias", "line");
		map.put("id", "sally1234");
		request.setAttribute("map", map);
		
		//forToken를 이용한 데이터 조회
		request.setAttribute("lineRangers", "sally, brown, cony, brown, james");
		
		request.getRequestDispatcher("/jsp/jstl/foreach.jsp").forward(request, response);
	}


}
