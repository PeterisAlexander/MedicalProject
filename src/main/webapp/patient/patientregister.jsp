<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Formulaire inscription</title>
    <link href="style.css" rel="stylesheet">
</head>

<body>
	<%@ include file="../fragments/header.jsp" %>
    <main class="container">
        <h1>Formulaire d'inscription</h1>
        <hr>
        <div id="msgErr" style="display:none">
			<div class="alert alert-danger">L'ajout du nouveau patient non effectué</div>
		</div>
        <form name="monForm" action="" method="post" onsubmit="return addPatient()">
            <div class="form-line mb-4">
                <label class="form-label">Nom *</label>
                <input class="form-control" type="text" name="nom" id="nom" placeholder="Votre nom" required>
            </div>
            <div class="form-line mb-4">
                <label>Prénom *</label>
                <input class="form-control" type="text" name="prenom" id="prenom" placeholder="Votre prénom" required>
            </div>

            <div class="form-line mb-4">
                <label class="form-label">Date de naissance *</label>
                <input class="form-control" type="date" name="naissance" id="naissance" placeholder="dd/mm/yyyy" required>
            </div>

            <div class="form-line mb-4">
                <label class="form-label">Adresse *</label>
                <input class="form-control" type="text" name="adresse" id="adresse" placeholder="Votre adresse" required>
            </div>

            <div class="form-line mb-4">
                <label class="form-label">Pays *</label>
                <select class="form-select" name="pays" required id="pays" onchange="load()">
                    <option value="">Sélectionner pays</option>
                    <option>FRANCE</option>
                    <option>ESPAGNE</option>
                    <option>ALLEMAGNE</option>
                </select>
            </div>

            <div class="form-line mb-4">
                <label class="form-label">Ville *</label>
                <div id="cities-content" style="width: 59%;float: right">
                    <select class="form-select" name="ville" id="ville">
                    	
                    </select>
                </div>
            </div>

            <div class="form-line mb-4">
                <button type="submit" id="submitbtn" class="btn btn-primary">Envoyer</button>
            </div>

        </form>
    </main>
    <%@ include file="../fragments/footer.jsp" %>
</body>

<script>
function addPatient(nom, prenom, naissance, adresse, pays, ville) {
	
	document.getElementById("submitbtn").innerHTML = '<div class="spinner-border" role="status"><span class="sr-only"></span></div>'; 
	
	nom = document.getElementById('nom').value
	prenom = document.getElementById('prenom').value
	naissance = document.getElementById('naissance').value
	adresse = document.getElementById('adresse').value
	pays = document.getElementById('pays').value
	ville = document.getElementById('ville').value
	
	var details = {
	    'nom': nom,
	    'prenom': prenom,
	    'naissance': naissance,
	    'adresse': adresse,
	    'pays': pays,
	    'ville': ville,
	};
	// préparation des paramètres 
	var formBody = [];
	for (var property in details) {
	  var encodedKey = encodeURIComponent(property);
	  var encodedValue = encodeURIComponent(details[property]);
	  formBody.push(encodedKey + "=" + encodedValue);
	}
	formBody = formBody.join("&");
	fetch("http://localhost:8080/medical7/registerPatient", {
	  method: 'POST',
	  headers: {
	    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
	  },
	  body: formBody
	})
	.then(res => {
        return res.text(); // extraction du texte à partir de l'objet response de fetch API
    })
	.then(function(data){ 
		console.log( data.indexOf("ok") );
		
		if( data.indexOf("ok") >=  0 ){
			window.location = '/ListPatientServlet?success=1'; 
		}else{
			document.getElementById('msgErr').style.display = "block";
		}
		
	})
	
	document.getElementById("submitbtn").innerHTML = 'Envoyer';
	
	return false; 
	
	/* if (  ) { // authentification réussie
		setCookie("username", login, 3)
		// login étant le nom d'utilisateur qui vient de s'authentifier
		window.location = "dashboard.html"
	} else {
		alert("Login ou password est incorrect!")
	} */ 
}
</script>


</html>