package spring.model2.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.model2.service.user.vo.UserVO;

public class LogonController implements Controller {
	
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[ LogonController.execute() start......]");
		
		HttpSession session = req.getSession(true);
		
		//=>controller : ����/����ó��
		//=> session ObjectScope ����� UserVO ��ü �̿� ����
		//=> case1: session ObjectScope�� userVO �ν��Ͻ� ���� �� ����
				if (session.isNew() || session.getAttribute("userVO") == null) {
					session.setAttribute("userVO", new UserVO());
				}
				
				//=> case2: session ObjectScope userVO ����
				UserVO userVO = (UserVO)session.getAttribute("userVO");
				
				//=> controller : navigation page ����
				//navigation ����Ʈ ������
				String requestPage = "/user/logon.jsp";
				
				//userVO.active �̿� �α��� �����Ǵ�
				if (userVO.isActive()) {
					requestPage = "/user/home.jsp";
				}
				
				System.out.println("[ LogonController.execute() end ....... ]");
				
				return new ModelAndView(requestPage, "info", "[LogonController Message] :: Welcome");

	}

}
