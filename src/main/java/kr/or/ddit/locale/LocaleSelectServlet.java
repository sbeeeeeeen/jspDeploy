package kr.or.ddit.locale;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocaleServlet
 */
@WebServlet("/localeSelect")
public class LocaleSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("userId", "brown");
		request.setAttribute("locale", 
				request.getParameter("locale")==null?"ko":request.getParameter("locale"));
		
		request.getRequestDispatcher("/jsp/jstl/localeSelect.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
