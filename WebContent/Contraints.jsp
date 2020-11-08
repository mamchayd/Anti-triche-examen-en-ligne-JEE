<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contrainte</title>
<link rel="stylesheet" href="css/Contraints.css">
</head>
<body>
<c:if test="${ empty sessionScope.sessionUtilisateur}">
        <c:redirect url="Login.jsp"/>
</c:if>
<div id="wrapper">
	<%@ include file="/includes/header.jsp" %>
	<div id="content">
		 <p>Lorem ipsum dolor sit amet, consetetur 
		 sadipscing elitr, sed diam nonumy eirmod ubduffffffffffffffffffffffh
		 tempor invidunt ut labore et.
		 Lorem ipsum dolor sit amet, consetetur 
		 sadipscing elitr, sed diam nonumy eirmod ubduffffffffffffffffffffffh
		 tempor invidunt ut labore et
		 Lorem ipsum dolor sit amet, consetetur 
		 sadipscing elitr, sed diam nonumy eirmod ubduffffffffffffffffffffffh
		 tempor invidunt ut labore et
		 Lorem ipsum dolor sit amet, consetetur 
		 sadipscing elitr, sed diam nonumy eirmod ubduffffffffffffffffffffffh
		 tempor invidunt ut labore et
		 </p><br><br><br><br><br><br>
		 <form method="post" action="ServletContrainte">
			  <p>
			    <input type="checkbox" id="test1" name="accepter" value="checkbox"/>
			    <label for="test1">Accepter</label>
			  </p>
		</form>
		<form methode ="get" action="ServletExamen">
			<div class="sub-mains">
				 <button class="button-two" name="button" value="button"><span>Passer l'examen</span></button>
			</div>
		</form>
		<p>
		<span class="erreur"><c:out value="${ sessionScope.resultat }"/></span>
		</p>
	</div>
	<%@ include file="/includes/footer.jsp" %>
</div>
</body>
</html>