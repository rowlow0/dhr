<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css"/>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.html"/>
<%@include file="nav.jsp" %>
<article>
<h1 class="text-align">회원매출조회</h1>
<table>
<tr><th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th></tr>
<c:forEach var="list" items="${list}">
<tr>
<td>${list.custno }</td>
<td>${list.custname }</td>
<td><c:if test="${list.grade eq 'a' }"><c:out value="VIP"/></c:if>
<c:if test="${list.grade eq 'b' }"><c:out value="일반"/></c:if>
</td>
<td>${list.price }</td>
</tr>
</c:forEach>
</table>
</article>
<jsp:include page="footer.html"/>
</body>
</html>