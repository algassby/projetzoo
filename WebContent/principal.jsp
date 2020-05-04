<%@page import="org.formation.zoo.controleur.MangerServlet"%>
<%@page import="java.util.Vector"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.formation.zoo.controleur.Manager"%>
<%@page import="org.formation.zoo.controleur.InitServlet" %>
<%@page import="org.formation.zoo.service.CagePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue DANS le ZOO</title>
<link rel="stylesheet" type="text/css" href="style.css"></link>
<!-- <link rel="stylesheet" type="text/css" href="bootstrap.min.css"></link> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<header>
<img class="logoGauche" alt="" src="images/logo.png"/>
<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>
<form name="fzoo" action="<%=request.getContextPath()+"/init" %>"  method="GET">
<nav>
<ul class="m">

	<li class="m"><a href="<%=request.getContextPath()+"/manger"%>">TOUT le monde mange (defaut)</a></li>
	<li class="m"><a href="#" onClick="fzoo.submit();" type="submit">FAIRE manger les animaux selectionnes</a></li>
	<li class="m"><a href="#">Ajouter un animal</a></li>
	<li class="m"><a href="#">Supprimer un animal</a></li>
</ul>

</nav>
<article class="">
<%	

	List<CagePOJO> zanimaux = null;
	//zanimaux = new Vector<>();
	zanimaux =  (Vector<CagePOJO>) request.getAttribute("ListAnimal");
	//CagePOJO tmp = (CagePOJO) zanimaux.get(0);
	String texte = null;

%>

<img  alt="mon zoo" src="images/plan.gif">

<%
  for(int i = 0; i < zanimaux.size(); i++){
	texte = String.join("","<div id=\"animal", Integer.toString(i),"\" style=\"position:absolute;top:",
	Integer.toString(zanimaux.get(i).getY()), "px;left:", Integer.toString(zanimaux.get(i).getX()),"px\">");
	out.print(texte);
	texte = String.join("","<img alt=\"\" src=\"",zanimaux.get(i).getImage(),"\" class=\"animal\"/>");
	out.print(texte);
	texte = String.join("","<div class=\"afficheAnimal\" >",zanimaux.get(i).getPancarte(),"</div><br><input type=\"radio\" id=\"mangeur\" name=\"mangeur\" value=",Integer.toString(zanimaux.get(i).getCle()),">",
	"<label>Mangeur</label><br><input type=\"radio\" id=\"mange\" name=\"mange\" value=", Integer.toString(zanimaux.get(i).getCle()), "><label>Mange</label></div>");
	out.print(texte);
	
}
  
%>

<br>
</article>

<footer>
<% out.print(request.getAttribute("devore")); %>
Etat en temps reel...
</footer>
</form>
	<script type="text/javascript" src="code.js"></script>
	

</body>

</html>
