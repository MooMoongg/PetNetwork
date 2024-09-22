package jw.services.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jw.services.user.dao.UserDAO;
import jw.services.user.vo.UserVO;

public class AddUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
	
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		int no = Integer.parseInt(req.getParameter("no"));
		
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		userVO.setNo(no);
		
		
		UserDAO bean = new UserDAO();
		bean.addUser(userVO);

		out.println("<html>");
		out.println("<body>");
		
		out.println("<h2>회원가입</h2>");
        
		if( userVO.isActive() ){
            out.println(userVO.getId()+"님 환영합니다.<br/>");
        }else{
            out.println("다시가입해 주세요.<br/>");
        }

		out.println("<p><p><a href='/homework01/servlet/findUser.html'>내정보보기(id 입력)</a>");

		out.println("</boyd>");
		out.println("</html>");
	}
}