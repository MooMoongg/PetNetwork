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
		
		//Form Data ó��
		String name = req.getParameter("name");
		
		if(name==null) {
			HttpSession session = req.getSession(true);
			name = ((UserVO)session.getAttribute("userVO")).getName();
		}
			
			//db����
		UserDAO userDAO = new UserDAO();
		UserVO userVO = userDAO.findUser(name);
				
		
		
		System.out.println("servlet ����");
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>������ ����</h2>");
		
		if(userVO != null)
		{
			out.println("<li> �̸� :"+userVO.getName());
			out.println("<li> ���� :"+userVO.getGender());
			out.println("<li> ������� :"+userVO.getBirth());
			out.println("<li> H.P :"+userVO.getCpNum());
			out.println("<li> �ּ� :"+userVO.getAddress());
		}else {
			out.println("ã���÷��� �̸��� ���� ������ �������� �ʽ��ϴ�.");
		}
			
			
		out.println("</body>");
		out.println("</html>");
	
		
	}

}

