package kr.or.ddit.student.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentUpdateView
 */
@WebServlet("/studentUpdate")
@MultipartConfig(maxFileSize=1024 * 1000 *5, maxRequestSize=1024 * 1000 * 16)
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//학생 정보 수정 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 학생 id 파라미터
		// 학생 정보 조회
		// request객체에 학생 정보를 설정
		// student/studentUpdate.jsp로 위임
		StudentServiceInf stdService = new StudentService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentVo std = stdService.getStudent(id);
		
		request.setAttribute("student", std);
		request.getRequestDispatcher("/student/studentUpdate.jsp").forward(request, response);
	}
	
	//학생 정보 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 확인
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		
		Part picPart = request.getPart("pic");
		StudentServiceInf stdService = new StudentService();

		StudentVo std = stdService.getStudent(id);

		std.setName(name);
		std.setAddr1(addr1);
		std.setAddr2(addr2);
		std.setZipcd(zipcd);
		
		if(picPart.getSize() > 0){
			String contentDisposition = picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picpath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();
			
			std.setPic(pic);
			std.setPicpath(picpath);
			std.setPicname(picname);
			
			picPart.write(picpath + File.separator + picname);
			picPart.delete();
		}
		
		stdService.updateStudent(std);
		
		//프로필 이미지를 안올린경우 : 기존 이미지 사용
		//안올린경우 : 신규 업로드한 이미지 사용
		//service.updateStudent()
		//redirect : /student/studentDetail.jsp
		
		response.sendRedirect("/student/studentDetail.jsp?id="+id);
		
	}

}
