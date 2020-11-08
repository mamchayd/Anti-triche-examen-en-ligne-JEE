<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link rel="stylesheet" href="css/Login.css">
    </head>
    <body>
    
    <div class="login-page">
  		<div class="form">
        <form method="post" action="ServletLogin" class="login-form">
        
        		<p class="erruer" style="color:#ff6633 ">${form.resultat}</p>
                <input type="text" id="username" name="username" placeholder="nom d'utilisateur" size="20" maxlength="60" />
             	
                <input type="password" id="motdepasse" name="motdepasse" placeholder="mot de passe" size="20" maxlength="20" />
                
      			<button>Connecter</button>
                <br /> 
                <span class="erreur">${form.erreurs['username']}</span><br />
                <span class="erreur">${form.erreurs['motdepasse']}</span><br />
               
        </form>
        </div>
  </div>
  
  	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="js/index.js"></script>
  
    </body>
</html>