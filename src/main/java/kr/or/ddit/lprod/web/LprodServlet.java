package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceInf;

/**
 * Servlet implementation class lprodServlet
 */
@WebServlet("/lprod")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LprodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LprodServiceInf lService = new LprodService();
		
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int pageSize = request.getParameter("pageSize")==null?5:Integer.parseInt(request.getParameter("pageSize"));
		
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("page", page);
		pageMap.put("pageSize", pageSize);
		
		Map<String, Object> resultMap = lService.getLprodPageList(pageMap);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("pageList");
		String pageNavi = (String) resultMap.get("pageNavi");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lprod/lprodList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
