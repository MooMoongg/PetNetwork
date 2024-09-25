<%@ page contentType="text/html; charset=EUC-KR"
  pageEncoding="EUC-KR"%>
  
  <%@ page import="jw.services.user.vo.UserVO" %>
  <%@ page import="jw.services.user.dao.UserDAO" %>
  
  <%
	request.setCharacterEncoding("EUC_KR");
		
		//Form Data 처리
		//VO 생성 및 FomData 전달(Binding)
	UserVO userVO = new UserVO();
	userVO = new UserVO();
	userVO.setName(request.getParameter("name"));
	userVO.setGender(request.getParameter("gender"));
	userVO.setBirth(request.getParameter("year") + "/"+ request.getParameter("month")+"/"+request.getParameter("day"));
	userVO.setCpNum(request.getParameter("cpNum1") + "-"+request.getParameter("cpNum2")+"-"+request.getParameter("cpNum3"));
	userVO.setAddress(request.getParameter("address"));
		
		//db접근
		UserDAO userDAO = new UserDAO();
		userDAO.addUser(userVO);
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2>회원가입 화면</h2>

<%if(userVO.isActive()){  %>
	<%=userVO.getName()  %>님 가입을 환영합니다:)<br/>
	<%request.getSession(true).setAttribute("userVO", userVO); %>
	<%}else{ %>
		가입이 정상 진행되지 않았습니다 :( <br/>
<%} %>

<p><p><a href = './findUser.html'>내정보보기(id 입력)</a>
<p><p><a href = './FindUser.jsp'>내정보보기2(session)</a>

</body>
</html>