package jw.services.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jw.services.user.dao.UserDAO;
import jw.services.user.vo.UserVO;

public class AddUser extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
			
			//Form Data 처리
			//VO 생성 및 FomData 전달(Binding)
		UserVO userVO = new UserVO();
		userVO = new UserVO();
		userVO.setName(req.getParameter("name"));
		userVO.setGender(req.getParameter("gender"));
		userVO.setBirth(req.getParameter("year") + "/"+ req.getParameter("month")+"/"+req.getParameter("day"));
		userVO.setCpNum(req.getParameter("cpNum1") + "-"+req.getParameter("cpNum2")+"-"+req.getParameter("cpNum3"));
		userVO.setAddress(req.getParameter("address"));
			
			//db접근
			UserDAO userDAO = new UserDAO();
			userDAO.addUser(userVO);
		
		
		System.out.println("servlet 실행");
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>회원가입 화면</h2>");
		
		if(userVO.isActive()) {
			out.println(userVO.getName() + "님 가입을 환영합니다:)");
			
			req.getSession(true).setAttribute("userVO", userVO);			
			
			out.println("<p><p><a href = './findUser.html'>내정보보기(id 입력)</a>");
			out.println("<p><p><a href = './FindUser'>내정보보기2(session)</a>");
		}else {
			out.println("가입이 정상 진행되지 않았습니다 :(<br/>");	
		}
					
		
		
		out.println("<p><p><a href = './addUser.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("servlet 실행완료");
		
	}

}
