<%@page import="org.formation.zoo.controleur.MangerServlet"%>
<%@page import="java.util.Vector"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.formation.zoo.controleur.Manager"%>
<%@page import="org.formation.zoo.controleur.InitServlet" %>
<%@page import="org.formation.zoo.service.CagePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="WEB-INF/tld/c.tld" prefix="c" %>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue DANS le ZOO</title>
<link rel="stylesheet" type="text/css" href="style.css"></link>
 <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
</head>
<body>
<header>
<img class="logoGauche" alt="" src="images/logo.png"/>
<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>
<div class = "container">
	<div class= "jumbotron text-center">
		  <form style="text-align:center;" action="${pageContext.request.contextPath}/supprimer" method="POST">
		  	<div class="form-group">
		  		<h4 class="card">Veuillez entrer la clé de l'animal</h4>
			    <label for="cle">la clé de l'animal</label>
			    <input type="number" name="cle" value="<%-- <% request.getAttribute("cle"); %> --%>" class="form-control" id="cle" placeholder="entrer la clé">
			    <button class="btn btn-success mt-5 mb-3" type="submit">Valider</button>
			    <button class="btn btn-danger mt-5 mb-3 ml-3" type="reset" value="reset" id="reset">Annuler</button>
			    <p> Si vous chager d'avis cliquez <span><a href="${pageContext.request.contextPath}/init" style="color:blue;">ici</a></span> pour revenir à l'index</p>
			 </div>
		</form>
		<p><c:out value="${msgCle}"></c:out></p>
		<p><c:out value="${msg }"></c:out></p>
	</div>
</div>





<script type="text/javascript" src="code.js"></script>
	

</body>

</html>
