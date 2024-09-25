<%@ page contentType="text/html;EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@ page import="jw.services.user.dao.UserDAO" %>
 <%@ page import="jw.services.user.vo.UserVO" %>
 
 <%
	request.setCharacterEncoding("EUC_KR");
	
	//Form Data 처리
	String name = request.getParameter("name");
	
	if(name==null) {
		//session이 내장객체로 존재한다..!
		name = ((UserVO)session.getAttribute("userVO")).getName();
	}
		
		//db접근
	UserDAO userDAO = new UserDAO();
	UserVO userVO = userDAO.findUser(name);
 
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>내정보 보기</h2>
	
	<%if(userVO != null)	{ %>
		 이름 : <%=userVO.getName() %> <br/>
		 성별 : <%=userVO.getGender() %><br/>
		 생년월일 : <%=userVO.getBirth() %><br/>
		 H.P : <%= userVO.getCpNum() %><br/>
		 주소 : <%= userVO.getAddress() %><br/>
		<% request.getSession(true).setAttribute("userVO", userVO);%>
	<%}else { %>
		<%= name%> 대한 정보가 존재하지 않습니다.<br/>
	<% } %>
	
	<p><p><a href='./updateUserView.jsp'>내정보수정(session사용)</a>

</body>
</html>