<%@ page contentType="text/html; charset=EUC-KR"
  pageEncoding="EUC-KR"%>
  
  <%@ page import="jw.services.user.vo.UserVO" %>
  <%@ page import="jw.services.user.dao.UserDAO" %>
  
  <%
	request.setCharacterEncoding("EUC_KR");
		
		//Form Data ó��
		//VO ���� �� FomData ����(Binding)
	UserVO userVO = new UserVO();
	userVO = new UserVO();
	userVO.setName(request.getParameter("name"));
	userVO.setGender(request.getParameter("gender"));
	userVO.setBirth(request.getParameter("year") + "/"+ request.getParameter("month")+"/"+request.getParameter("day"));
	userVO.setCpNum(request.getParameter("cpNum1") + "-"+request.getParameter("cpNum2")+"-"+request.getParameter("cpNum3"));
	userVO.setAddress(request.getParameter("address"));
		
		//db����
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

<h2>ȸ������ ȭ��</h2>

<%if(userVO.isActive()){  %>
	<%=userVO.getName()  %>�� ������ ȯ���մϴ�:)<br/>
	<%request.getSession(true).setAttribute("userVO", userVO); %>
	<%}else{ %>
		������ ���� ������� �ʾҽ��ϴ� :( <br/>
<%} %>

<p><p><a href = './findUser.html'>����������(id �Է�)</a>
<p><p><a href = './FindUser.jsp'>����������2(session)</a>

</body>
</html>