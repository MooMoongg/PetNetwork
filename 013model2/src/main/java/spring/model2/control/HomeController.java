package spring.model2.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.model2.service.user.vo.UserVO;

public class HomeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[ HomeController.execute() start......]");
		
		HttpSession session = req.getSession(true);
		
		//=>controller : 권한/인증처리
		//=> session ObjectScope 저장된 UserVO 객체 이용 인증
		//=> case1: session ObjectScope에 userVO 인스턴스 생성 및 저장
				if (session.isNew() || session.getAttribute("userVO") == null) {
					session.setAttribute("userVO", new UserVO());
				}
				
				//=> case2: session ObjectScope userVO 추출
				UserVO userVO = (UserVO)session.getAttribute("userVO");
				
				//=> controller : navigation page 결정
				//navigation 디폴트 페이지
				String requestPage = "/user/logon.jsp";
				
				//userVO.active 이용 로그인 유무판단
				if (userVO.isActive()) {
					requestPage = "/user/home.jsp";
				}
				
				//navigation(최종 결정된 page forward)
//				RequestDispatcher rd = req.getRequestDispatcher(requestPage);
//				rd.forward(req, res);
				System.out.println("[ HomeController.execute() end ....... ]");
				
				return new ModelAndView(requestPage, "info", "[HomeController Message] :: Welcome");
	}

}
