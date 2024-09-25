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
		
		//Form Data 처리
		System.out.println("From Data 처리");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("year") + "/"+ req.getParameter("month")+"/"+req.getParameter("day");
		String cpNum =req.getParameter("cpNum1") + "-"+req.getParameter("cpNum2")+"-"+req.getParameter("cpNum3"); 
		String address = req.getParameter("address");
		System.out.println("From Data 처리완료");
		
		HttpSession session = req.getSession(true);
		
		//기 login한 회원 :: session에 저장된 정보 get
		//미 login한 회원 :: session에 저장된 정보 없으므로 null
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		System.out.println("session에 저장된 UserVO 유무 확인 : "+userVO);
		
		if (!(name==null || name.equals(""))) {
			//VO 생성 및 FomData 전달(Binding)
			userVO = new UserVO();
			userVO.setName(name);
			userVO.setGender(gender);
			userVO.setBirth(birth);
			userVO.setCpNum(cpNum);
			userVO.setAddress(address);
			
			//db접근
			UserDAO userDAO = new UserDAO();
			userDAO.addUser(userVO);
		}
		
		
		System.out.println("servlet 실행");
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>회원가입 화면</h2>");
		
		if(userVO.isActive() == true) {
			out.println(name + "님 가입을 환영합니다:)");		
			
			out.println("<p><p><a href = './findUser.html'>내정보보기</a>");
		}else {
			out.println("가입이 정상 진행되지 않았습니다 :(");	
		}
					
		
		
		out.println("<p><p><a href = './addUser.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("servlet 실행완료");
		
	}

}
