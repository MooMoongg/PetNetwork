package jw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUser extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		req.setCharacterEncoding("EUC_KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		//Form Data ó��
		System.out.println("From Data ó��");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("year") + "/"+ req.getParameter("month")+"/"+req.getParameter("day");
		String cpNum =req.getParameter("cpNum1") + "-"+req.getParameter("cpNum2")+"-"+req.getParameter("cpNum3"); 
		String address = req.getParameter("address");
		System.out.println("From Data ó���Ϸ�");
		
		HttpSession session = req.getSession(true);
		
		//�� login�� ȸ�� :: session�� ����� ���� get
		//�� login�� ȸ�� :: session�� ����� ���� �����Ƿ� null
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		System.out.println("session�� ����� UserVO ���� Ȯ�� : "+userVO);
		
		if (!(name==null || name.equals(""))) {
			//VO ���� �� FomData ����(Binding)
			userVO = new UserVO();
			userVO.setName(name);
			userVO.setGender(gender);
			userVO.setBirth(birth);
			userVO.setCpNum(cpNum);
			userVO.setAddress(address);
			
			//db����
			UserDAO userDAO = new UserDAO();
			userDAO.addUser(userVO);
		}
		
		
		System.out.println("servlet ����");
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>ȸ������ ȭ��</h2>");
		
		if(userVO.isActive() == true) {
			out.println(name + "�� ������ ȯ���մϴ�:)");		
			
			out.println("<p><p><a href = './findUser.html'>����������</a>");
		}else {
			out.println("������ ���� ������� �ʾҽ��ϴ� :(");	
		}
					
		
		
		out.println("<p><p><a href = './addUser.html'>�ڷ�</a>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("servlet ����Ϸ�");
		
	}

}
