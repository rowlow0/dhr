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
<h1 class="text-align">회원목록조회/수정</h1>
<table>
<tr><th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th></tr>
<c:forEach var="list" items="${list}">
<tr>
<%-- <td><form method="get" action="GetNumber"><input type="submit" name="custno" value="${list.custno }"/></form></td> --%>
<td><a href="GetNumber?custno=${list.custno }">${list.custno }</a></td>
<td>${list.custname }</td>
<td>${list.phone }</td>
<td>${list.address }</td>
<td>${list.joindate }</td>
<td><c:if test="${list.grade eq 'a' }"><c:out value="VIP"/></c:if>
<c:if test="${list.grade eq 'b' }"><c:out value="일반"/></c:if>
<c:if test="${list.grade eq 'c' }"><c:out value="직원"/></c:if>
</td>
<td>${list.city }</td>
</tr>
</c:forEach>
</table>
</article>
<jsp:include page="footer.html"/>
</body>
</html>