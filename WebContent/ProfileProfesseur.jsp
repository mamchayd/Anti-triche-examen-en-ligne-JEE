<%@ page language="java" contentType="text/html; " %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Professeur</title>
<link rel="stylesheet" href="css/ProfileProfesseur.css">
</head>
<body>       
<c:if test="${ empty sessionScope.sessionUtilisateur}">
        <c:redirect url="Login.jsp"/>
</c:if>
<div id="wrapper">
	<%@ include file="/includes/header.jsp" %>
	<div id="content">
		  <table>
		  <caption>Les listes des examens </caption>
		  <thead>
		    <tr>
		      <th scope="col">Matière</th>
		      <th scope="col">Date debut </th>
		      <th scope="col">Date fin </th>
		      <th scope="col"> </th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${ liste }" var="examen">
		    <tr>
		      <td data-label="Amount">${ examen.matiere}</td>
		      <td data-label="Period">${ examen.dateDebut}</td>
		      <td data-label="Period">${ examen.dateFin}</td>
		      <td data-label="Period">
		      <form methode ="get" action="ServletAdmin">
					<div class="sub-main">
				      <button class="button-two"><span>Suivant</span></button>
				    </div>
		      </form>
		      </td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
<%@ include file="/includes/footer.jsp" %>
</div>
</body>
</html>