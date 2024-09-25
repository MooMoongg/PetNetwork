package spring.model2.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class DispatcherServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//=> controller : client 요구사항 판단 :: URL/URI 이용
		String actionPage = this.getURI(req.getRequestURI());
		System.out.println("::URI ? => : "+req.getRequestURI());
		System.out.println("::Client의 요구사항? => : "+ actionPage);
		
		//=> controller : 선처리/공통처리 사항이 있다면
		//=> 본 예제 : 한글처리
		req.setCharacterEncoding("euc-kr");
		
		//=> controller : client 요구사항 처리 B/L 접근
		
		//B/L 처리하는 Controller
		Controller controller = null;
		
		//client의 req에 대응하는 Controller instance 생성
		//ControllerMapping을 통해 client req를 처리할 Controller instance 생성
		ControllerMapping cf = ControllerMapping.getInstance();
		controller = cf.getController(actionPage);
		
		//Controller.execute() 호출
		controller.execute(req, res);
		System.out.println("[ DispatcherServlet.service() end...... ]");
	
	}//end of service
	
	private String getURI(String requestURI) {
		int start= requestURI.lastIndexOf('/')+1;
		int end = requestURI.lastIndexOf(".do");
		String actionPage = requestURI.substring(start,end);
		return actionPage;
	}

}
