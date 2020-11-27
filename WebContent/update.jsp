<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css"/>
</head>
<body>
<c:if test="${check==1 }"><script>alert("빠짐없이 입력하세요");</script></c:if>
<jsp:include page="header.html"/>
<%@include file="nav.jsp" %>
<article>
<h1 class="text-align">쇼핑몰 회원 업뎃</h1>
<form method="get" action="Update">
<table>
<tr><td class="text-align">회원번호(선택번호)</td><td><input type="text" name="custno" value="<%=request.getAttribute("custno") %>"/></td></tr>
<tr><td class="text-align">회원성명</td><td><input type="text" name="custname"/></td></tr>
<tr><td class="text-align">회원전화</td><td><input type="text" name="phone"/></td></tr>
<tr><td class="text-align">회원주소</td><td><input type="text" name="address"/></td></tr>
<tr><td class="text-align">가입일자(8자리을 입력하세요)</td><td><input type="text" name="joindate"/></td></tr>
<tr><td class="text-align">고객등급[a:vip,b:일반,c:직원]</td><td><input type="text" name="grade"/></td></tr>
<tr><td class="text-align">도시코드</td><td><input type="text" name="city"/></td></tr>
<tr><td class="text-align" colspan="2"><input type="submit" value="수정"/>&nbsp;&nbsp;<input type="button" onclick="location.href='Select'" value="조회"/></td></tr>
</table>
</form>
<!-- <form method="get" action="Select"> -->
<!-- <table class="text-align"> -->
<!-- <tr><td colspan="2"><input type="submit" value="조회"/></td></tr> -->
<!-- </table> -->
<!-- </form> -->
<jsp:include page="footer.html"/>
</article>
</body>
</html>