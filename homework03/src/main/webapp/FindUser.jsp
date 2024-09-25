<%@ page contentType="text/html;EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@ page import="jw.services.user.dao.UserDAO" %>
 <%@ page import="jw.services.user.vo.UserVO" %>
 
 <%
	request.setCharacterEncoding("EUC_KR");
	
	//Form Data ó��
	String name = request.getParameter("name");
	
	if(name==null) {
		//session�� ���尴ü�� �����Ѵ�..!
		name = ((UserVO)session.getAttribute("userVO")).getName();
	}
		
		//db����
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

	<h2>������ ����</h2>
	
	<%if(userVO != null)	{ %>
		 �̸� : <%=userVO.getName() %> <br/>
		 ���� : <%=userVO.getGender() %><br/>
		 ������� : <%=userVO.getBirth() %><br/>
		 H.P : <%= userVO.getCpNum() %><br/>
		 �ּ� : <%= userVO.getAddress() %><br/>
		<% request.getSession(true).setAttribute("userVO", userVO);%>
	<%}else { %>
		<%= name%> ���� ������ �������� �ʽ��ϴ�.<br/>
	<% } %>
	
	<p><p><a href='./updateUserView.jsp'>����������(session���)</a>

</body>
</html>