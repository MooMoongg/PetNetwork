package jw;

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

public class FindUser extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		//Form Data ó��
		System.out.println("From Data ó��");
		String name = req.getParameter("name");
		System.out.println("From Data ó���Ϸ�");
		HttpSession session = req.getSession(true);
		
		UserVO userVO = null;
			
			//db����
		UserDAO userDAO = new UserDAO();
		userVO = userDAO.findUser(name);
				
		
		
		System.out.println("servlet ����");
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>������ ����</h2>");
		
		if(name != null)
		{
			out.println("<li> �̸� :"+userVO.getName());
			out.println("<li> ���� :"+userVO.getGender());
			out.println("<li> ������� :"+userVO.getBirth());
			out.println("<li> H.P :"+userVO.getCpNum());
			out.println("<li> �ּ� :"+userVO.getAddress());
		}else {
			out.println("ã���÷��� �̸��� ���� ������ �������� �ʽ��ϴ�.");
		}
			
			
		out.println("<p><p><a href = './findUser.html'>�ڷ�</a>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("servlet ����Ϸ�");
		
	}

}

