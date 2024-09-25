package spring.model2.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class DispatcherServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//=> controller : client �䱸���� �Ǵ� :: URL/URI �̿�
		String actionPage = this.getURI(req.getRequestURI());
		System.out.println("::URI ? => : "+req.getRequestURI());
		System.out.println("::Client�� �䱸����? => : "+ actionPage);
		
		//=> controller : ��ó��/����ó�� ������ �ִٸ�
		//=> �� ���� : �ѱ�ó��
		req.setCharacterEncoding("euc-kr");
		
		//=> controller : client �䱸���� ó�� B/L ����
		
		//B/L ó���ϴ� Controller
		Controller controller = null;
		
		//client�� req�� �����ϴ� Controller instance ����
		//ControllerMapping�� ���� client req�� ó���� Controller instance ����
		ControllerMapping cf = ControllerMapping.getInstance();
		controller = cf.getController(actionPage);
		
		//Controller.execute() ȣ��
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
