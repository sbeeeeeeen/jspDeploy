package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.spi.http.HttpContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */
//bytes 단위
//1kb > 1024
//1MB > 1kb * 1000
//5MB > 1MB * 5 == 1KB * 1000 * 5 = 1024 * 1000 *5
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=1024 * 1000 *5, maxRequestSize=1024 * 1000 * 16)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//parameter : userId, uploadFile
    	//일반 텍스트 파라미터는 request.getParameter를 통해서 얻을 수 있고
    	//파일의 경우 request.getPart를 통해서 얻을 수 있다
    	logger.debug("contentType : " + request.getContentType());
    	logger.debug("userId : " + request.getParameter("userId"));
//		logger.debug("uploadFile : " + request.getParameter("uploadFile"));
		
    	//getPart
		Part uploadFilePart = request.getPart("uploadFile");
		logger.debug("part getPart : " + uploadFilePart);
		
		//file이름에 대한 정보를 획득 : getHeader("Content-Disposition");
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("contentDisposition : " + contentDisposition);
		String fileName = FileUtil.getFileName(contentDisposition);
		logger.debug("fileName : " + fileName);
		
		//파일 저장 경로 설정
		//실무 : 별도 storage
		//개발환경 : 임의 영역(서버 변경, 재기동시 업로드 파일 삭제됨)
		// /fileUpload 디렉토리에 임의로 작성
		
		//url >> realpath : application 객체에서 제공해주는 메소드
		//doPost메소드 안에서 application(servletContext)
		//1.request.getServletContext()
		//2.getServletContext() (서블릿에서 제공해주는 메소드)
		
		
		//임의의 배포 경로
//		ServletContext servletContext = getServletContext();
//		String path = servletContext.getRealPath("/fileUpload");
		
		//고정된 영역으로 배포
		String path = FileUtil.fileUploadPath;
		
		//fileSize가 정상적인 경우에만 수행하게한다...
		if(uploadFilePart.getSize()>0){
//			uploadFilePart.write(path + File.separator + fileName);
			uploadFilePart.write(path + File.separator + UUID.randomUUID().toString());
			// path : D:\A_TeachingMaterial\7.JspSpring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\fileUpload
			uploadFilePart.delete();//업로드했으니 이제 노필요
		}
		
    }

}
