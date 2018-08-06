package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumCalculation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
//		PrintWriter pw = response.getWriter();
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int sum = 0;
		
		for (int i = end-1; i > start; i--) {
			sum+=i;
		}
		
		//System.out.println(end + " - " + start + " 사이의 값 = " + sum);
		request.setAttribute("sumResult", sum); //야악간 맵같은 늑힘
		
		//session에 sumResult를 저장한다~
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum); //쓰는 방법은 동일허다
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumResult.jsp"); //forward
		rd.forward(request, response);
		
//		pw.write(end + " - " + start + " 사이의 값 = " + sum);
//		pw.close();
	}

}
