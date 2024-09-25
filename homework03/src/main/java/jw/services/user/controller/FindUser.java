package jw.services.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jw.services.user.dao.UserDAO;
import jw.services.user.vo.UserVO;

public class FindUser extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		//Form Data 처리
		String name = req.getParameter("name");
		
		if(name==null) {
			HttpSession session = req.getSession(true);
			name = ((UserVO)session.getAttribute("userVO")).getName();
		}
			
			//db접근
		UserDAO userDAO = new UserDAO();
		UserVO userVO = userDAO.findUser(name);
				
		
		
		System.out.println("servlet 실행");
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>내정보 보기</h2>");
		
		if(userVO != null)
		{
			out.println("<li> 이름 :"+userVO.getName());
			out.println("<li> 성별 :"+userVO.getGender());
			out.println("<li> 생년월일 :"+userVO.getBirth());
			out.println("<li> H.P :"+userVO.getCpNum());
			out.println("<li> 주소 :"+userVO.getAddress());
		}else {
			out.println("찾으시려는 이름에 대한 정보가 존재하지 않습니다.");
		}
			
			
		out.println("</body>");
		out.println("</html>");
	
		
	}

}

