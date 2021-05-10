<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="${param.language}">
<head>
<meta charset="UTF-8">
<title><fmt:message key="welcome.message" /></title>

</head>
<body>
	<fmt:setLocale value="${param.language}" />
	<h1>
		<fmt:message key="welcome.message" />
	</h1>
	<h3>
		<fmt:message key="today.message" />
		, <span>&ensp;</span> Date : <strong><span id="date"></span></strong>

	</h3>
	<span><fmt:message key="language.change" /></span>:
	<select id="locales">
		<option value=""></option>
		<option value="en"><fmt:message key="language.eng" /></option>
		<option value="it"><fmt:message key="language.it" /></option>
	</select>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment-with-locales.min.js"></script>
	<script src="resources/js/internationalize.js"></script>

</body>
</html>