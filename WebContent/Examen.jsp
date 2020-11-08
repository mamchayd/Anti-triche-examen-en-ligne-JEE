<%@page import="est.pfe.dao.ServiceEtudiant"%>
<%@page import="est.pfe.metier.SessionUtil"%>
<%@ page language="java" contentType="text/html; " pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Examen</title>
  <link rel="stylesheet" href="css/Examen.css">
  <script type="text/javascript" src="js/webSocketEtud.js"></script>
</head>
<body>
<c:if test="${ empty sessionScope.sessionUtilisateur}">
        <c:redirect url="Login.jsp"/>
</c:if>
<%@ include file="/includes/header.jsp" %>
  <div id="quiz">
  <h1 id="quiz-name"></h1>
  <button id="submit-button">Enregistrer les repenses</button>
  <button id="next-question-button">suivant</button>
  <button id="prev-question-button">précédent</button>
  <div id="quiz-results">
    <p id="quiz-results-message"></p>
    <p id="quiz-results-score"></p>
  </div>
</div>
<%
/*
new Thread()
{
    public void run() {
    	try {
    	    while (true) {
    	    	if(!ServiceEtudiant.checkIfTrich())
    	    		{%>
    	    		
    	    		<%}
    	        Thread.sleep(5 * 1000);
    	    }
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
    }
}.start();

*/

%>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/php.js"></script>
<%@ include file="/includes/footer.jsp" %>
</body>
</html>