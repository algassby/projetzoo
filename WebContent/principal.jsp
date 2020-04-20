<%@page import="org.formation.zoo.controleur.Manager"%>
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

</head>
<body>
<header>
<img class="logoGauche" alt="" src="images/logo.png"/>
<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
</header>
<form name="fzoo" action="servlet.html" method="GET">
<nav>
<ul class="m">
	<li class="m"><a href="#">TOUT le monde mange (defaut)</a></li>
	<li class="m"><a href="#" onClick="fzoo.submit();">FAIRE manger les animaux selectionnes</a></li>
	<li class="m"><a href="#">Ajouter un animal</a></li>
	<li class="m"><a href="#">Supprimer un animal</a></li>
</ul>
</nav>
<article class="">
<%
 List<CagePOJO> zanimaux = null;
 zanimaux = Manager.getInstance().getAnimaux();
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
	texte = String.join("","<div class=\"afficheAnimal\" >",zanimaux.get(i).getPancarte(),"</div></div>");
	out.print(texte);
}
%>
<!-- <div id="animal2" style="position:absolute;top:240px;left:200px">
<img alt="" src="images/gazelle.gif" class="animal"/>

<div class="afficheAnimal" >GagaZeleZele 3 ans 48.3 kg</div>
</div> -->
<br>

</article>
<footer>
Etat en temps reel...
</footer>
</form>
</body>
</html>
