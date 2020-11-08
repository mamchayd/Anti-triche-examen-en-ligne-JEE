
<%@ page language="java" contentType="text/html; "%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Etudiant</title>
<link rel="stylesheet" href="css/ProfileEtudiant.css">
</head>
<body>
<c:if test="${ empty sessionScope.sessionUtilisateur}">
        <c:redirect url="Login.jsp"/>
</c:if>
<%@ include file="/includes/header.jsp" %>
<div id="wrapper">
	<div id="content">
		  <div style="position: absolute; left: 9%; top: 10%;" class="sub_content">
				<c:forEach items="${ examens }" var="examen">

				<div class="pic"><a href="ServletContrainte?matiere=${examen.matiere}&idexam=${examen.idExam}">
						<div class="caption">
							<img class="caption__media" width="200" height="200"
								src="${pageContext.request.contextPath}/image/${examen.matiere}.jpg" />
							<div class="caption__overlay">
								<h1 class="caption__overlay__title">${examen.matiere}</h1>
								<p class="caption__overlay__content">
							
										<c:out value="professeur : ${examen.nomPro}"/><br>
										<c:out value="date debut : ${examen.dateDebut}"/><br>
										<c:out value="date fin : ${examen.dateDebut}"/><br>
								
								<%// request.setAttribute("matiere", "CSS"); %>
								</p>
							</div>
						</div>
				</a></div>
			<!-- coller -->
</c:forEach>
	</div>
	</div>

</div>
<%@ include file="/includes/footer.jsp" %>
</body>
</html>