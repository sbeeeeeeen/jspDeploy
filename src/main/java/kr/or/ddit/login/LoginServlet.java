package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식일때 인코딩 
		System.out.println(request.getMethod());
		
		//파라미터를 받아서 sysout으로 console창에 출력
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		
		//로그인 프로세스
		//가짜(fake) service, dao객체를 생성
		UserServiceInf service = new UserService();
		UserVo userVo = service.getUser(userId);
		
		response.setContentType("text/html; charset=utf-8");
//		PrintWriter pw = response.getWriter();
		
		//로그인 성공시 : /main.jsp
		//userVo객체를 저장하여(적당한 영역에) main.jsp에서 사용자 아이디를 화면에 출력
		//단 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야한다
		if(userVo.validateUser(userId, password)){
//			request.getServletContext().setAttribute(name, object);
			HttpSession session = request.getSession();
			session.setAttribute("userVo", userVo);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else{
			//response.sendRedirect("/login/login.jsp");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		
//		pw.close();
	}

}
