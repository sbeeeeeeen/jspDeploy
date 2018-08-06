package kr.or.ddit.student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/studentDetail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentServiceInf stdService = new StudentService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentVo std = stdService.getStudent(id);
		
		request.setAttribute("student", std);
		request.getRequestDispatcher("/student/studentDetail.jsp").forward(request, response);
		
	}

}
