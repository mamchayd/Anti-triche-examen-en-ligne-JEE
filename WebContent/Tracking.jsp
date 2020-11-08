<%@ page language="java" contentType="text/html; "
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ">
<META HTTP-EQUIV="Refresh" Content = "5">
<title>Admin</title>
<link rel="stylesheet" href="css/ProfileProfesseur.css">
<script type="text/javascript" src="js/webSocketProf.js"></script>
</head>
<body>
<c:if test="${ empty sessionScope.sessionUtilisateur}">
        <c:redirect url="Login.jsp"/>
</c:if>
<div id="wrapper">
	<%@ include file="/includes/header.jsp" %>
	<div id="content">
		  <table>
		  <caption>Les listes des etudiants  </caption>
		  <thead>
		    <tr>
		      <th scope="col">IP</th>
		      <th scope="col">cne </th>
		      <th scope="col">nom de l'etudiant </th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${ liste }" var="e">
		    <tr>
		      <td data-label="Amount">${ e.etudiant.adresseIP} </td>
		      <td data-label="Amount">${ e.etudiant.cne} </td>
		      <td data-label="Period">${ e.etudiant.nom} ${ e.etudiant.prenom} </td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<br><br><hr><br><br>
		<table>
		  <caption>Les listes des etudiants qu'ils trichent  </caption>
		  <thead>
		    <tr>
		      <th scope="col">IP</th>
		      <th scope="col">cne </th>
		      <th scope="col">nom de l'etudiant </th>
		      <th scope="col">logiciel </th>
		      <th scope="col">Operation </th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${ listeTricheurs }" var="t">
		    <tr>
		      <td data-label="Amount">${ t.adresseIP} </td>
		      <td data-label="Amount">${ t.cne} </td>
		      <td data-label="Period">${ t.nom} ${ t.prenom} </td>
		      <td data-label="Period">${ t.lognicielNonAutoriser} </td>
		      <c:choose>
			    <c:when test="${t.sessionFermer == true}">
			      <td> <span />Session Fermé</span></td>
			    </c:when>
			    <c:when test="${t.sessionFermer == false}">
		      <td> <a  href="ServletStopExam?ip_etud=${ t.adresseIP}" onclick="closeSession()" >Fermer Session</a></td>
			    </c:when>
				</c:choose>
		      
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
<%@ include file="/includes/footer.jsp" %>
</div>
</body>
</html>