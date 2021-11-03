<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="medical.m2i.model.*" %>
<%@ page import="medical.m2i.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des patients</title>
</head>
<body>
<%@ include file="../fragments/header.jsp" %>
<main class="container">
<h3>Ici on affiche la liste des Villes</h3>

<table class="table table-striped">
<thead>
	<th>ID</th>
	<th>Pays</th>
	<th>Ville</th>
	<th>Code Postale</th>
	<th>Action</th>
</thead>
<tbody>
<% ArrayList<Ville> lvpl = new ArrayList<Ville>();
%>

	<%
		lvpl = ( ArrayList ) request.getAttribute("listeville"); 
		for(Ville v :  lvpl ) {
			%>
			
			<tr>
				<td><%= v.getId() %></td>
				<td><%= v.getPays() %></td>
				<td><%= v.getNom() %></td>
				<td><%= v.getCode_postal() %></td>
				<td>
					<button class="btn btn-secondary btn-sm"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
					<button class="btn btn-danger btn-sm" onclick="supprimer(<%= v.getId() %>)"><i class="fa fa-trash-o" aria-hidden="true"></i></button> 
				</td>
			</tr>
			<%
		}
	%>
</tbody>
</table>

<a href="patientregister.jsp" class="btn btn-primary">Ajouter une ville</a>

</main>
<%@ include file="../fragments/footer.jsp" %>


<script>
	function supprimer(id) {
		if(confirm("Etes-vous sur ?")){
			console.log('delete?id='+id);
			window.location = 'delete?id='+id;
		}
	}
</script>

</body>
</html>