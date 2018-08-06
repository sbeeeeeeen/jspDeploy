package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/elServlet")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//각 영역에 임의 값을 저장 --> jsp에서 el을 사용하여 해당 속성을 확인한다.
		
		//request
		request.setAttribute("requestScop", "requestValue");
//		request.setAttribute("sameName", "requestValue");
		
		//session
		HttpSession session = request.getSession();
		session.setAttribute("sessionScop", "sessionValue");
		session.setAttribute("sameName", "sessionValue");
		
		//application
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("applicationScop", "applicationValue");
		servletContext.setAttribute("sameName", "applicationValue");
		
		//학생 전체 리스트 조회
		StudentServiceInf stdService = new StudentService();
		request.setAttribute("studentList", stdService.selectAllStudents());
		
		//jsp로 위임(/jsp/el.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/el.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
