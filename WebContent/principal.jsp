<%@page import="org.formation.zoo.controleur.MangerServlet"%>
<%@page import="java.util.Vector"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.formation.zoo.controleur.Manager"%>
<%@page import="org.formation.zoo.controleur.InitServlet" %>
<%@page import="org.formation.zoo.service.CagePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="WEB-INF/jstl/c.tld" prefix="c" %>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue DANS le ZOO</title>
<link rel="stylesheet" type="text/css" href="style.css"></link>
<!-- <link rel="stylesheet" type="text/css" href="bootstrap.min.css"></link> -->
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  



</head>
<body>
<header>
<img class="logoGauche" alt="" src="images/logo.png"/>
<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>
<%-- <%	

	List<CagePOJO> zanimaux = null;
	//zanimaux = new Vector<>();
	zanimaux =  (Vector<CagePOJO>) request.getAttribute("ListAnimal");

	//CagePOJO tmp = (CagePOJO) zanimaux.get(0);
	String texte = null;

%> --%>



<%--ajouter un animal --%>
<div id="modal">
	<div id="dialog" title="Dialog box">
		  <form style="text-align:center;" action="${pageContext.request.contextPath}/ajouter" method="POST">
		  <h5>remplir ce formulaire pour ajouter un animal</h5>
		  <label for="lname">sa cl�</label><br>
		  <input type="number" id="lname" name="cle" placeholder="cle"><br><br>	
		  <!-- <label for="fname"> Son code Animal</label><br>
		  <input type="text" placeholder="CodeAnimal" name="codeAnimal"><br> -->
		  <select name="animal">
		  	<option value="lion">Lion</option>
		  	<option value="gazelle">Gazelle</option>
		  	<option value="singe">Singe</option>
		  </select><br>
		 <%--  <label for="lname">son abscisse</label><br>
		  <input type="number" id="lname" name="x" value="<% %>" placeholder="X"><br>
		  <label for="lname">son ordonn�e</label><br>
		  <input type="number" id="lname" name="y" placeholder="Y"><br> --%>
		  <label for="lname">son Nom</label><br>
		  <input type="text" id="lname" name="nom" placeholder="nom"><br>
		  <label for="lname">son poids</label><br>
		  <input type="number" id="lname" name="poids" placeholder="poids"><br>
		  <label for="lname">son age</label><br>
		  <input type="number" id="lname" name="age" placeholder="age"><br>
		  <label for="cleGaz">la seconde cl� si c'est une gazelle</label><br>
		  
		  <input type="number" id="cleGaz" name="cleGaz" placeholder="cle gazelle"><br>
		  <label for="lname">longueur de cornes pour gazelle</label><br>
		  <input type="number" id="lname" name="lgCorne" placeholder="longeur cornes"><br><br>
		  <button type="submit">valider</button>
		  <button type="reset" value="reset" id="reset">Annuler</button>
		 
		</form>
	</div>
</div>
<%--supprimer un animal --%>

	
<form name="fzoo"action="${pageContext.request.contextPath}/devorer" method="POST">
<nav>
<ul class="m">
<%-- <jsp:useBean id="DevorerServlet" class="org.formation.zoo.controleur.DevorerServlet"></jsp:useBean> --%>
	<li class="m"><a href="${pageContext.request.contextPath}/manger">TOUT le monde mange (defaut)</a></li>
	<li class="m"><a href="#" Onclick="fzoo.submit()">FAIRE manger les animaux selectionnes</a></li>
	<li class="m"><a href="#" id = "bajouter">Ajouter un animal</a></li>
	<li class="m"><a href="supprimer.jsp" id="bsupprimer">Supprimer un animal</a></li>
</ul>

</nav>
<article class="">


<img  alt="mon zoo" src="images/plan.gif">

<%--affichage des animaux --%>
<c:forEach var="zanimaux" items="${ListAnimal}">
	
	<div id ="animal" style="position:absolute;top:${zanimaux.getY()}px; left: ${zanimaux.getX()}px;">
		<img alt="" src="${zanimaux.getImage() }" class="animal">
		<div class="afficheAnimal">
			${zanimaux.getPancarte()}
			
		</div><br>
		
			<input type="radio" name="mangeur" id="mangeur" value="${zanimaux.getCle()-1 }" >
			<label for="mangeur">Mangeur</label><br>
			
			<input type="radio" name="mange" id="mange" value="${zanimaux.getCle()-1 }" >
			<label for="mange">Mange</label>
	</div>

</c:forEach>


<%-- <%
  for(int i = 0; i < zanimaux.size(); i++){
	texte = String.join("","<div id=\"animal", Integer.toString(i),"\" style=\"position:absolute;top:",
	Integer.toString(zanimaux.get(i).getY()), "px;left:", Integer.toString(zanimaux.get(i).getX()),"px\">");
	out.print(texte);
	texte = String.join("","<img alt=\"\" src=\"",zanimaux.get(i).getImage(),"\" class=\"animal\"/>");
	out.print(texte);
	texte = String.join("","<div class=\"afficheAnimal\" >",zanimaux.get(i).getPancarte(),"</div><br><input type=\"radio\" id=\"mangeur\" name=\"mangeur\" value=",Integer.toString(zanimaux.get(i).getCle()-1),">",
	"<label>Mangeur</label><br><input type=\"radio\" id=\"mange\" name=\"mange\" value=", Integer.toString(zanimaux.get(i).getCle()-1), "><label>Mange</label></div>");
	out.print(texte);
	
	
} --%>
  


<br>
</article>

<footer>
<p style="float: right; color: red;"><c:out value="${ burkException }"></c:out> </p>
 
Etat en temps reel...

</footer>
</form>
	<script type="text/javascript" src="code.js"></script>
	

</body>

</html>
