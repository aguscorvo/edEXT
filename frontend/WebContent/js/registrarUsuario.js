//se verifica si existe un usuario registrado con el nick ingresado

$(document).ready(function() {
	    $('#nick').blur(function(event) {
	            var nick = $('#nick').val();
				var email = "";

	            $.get('RegistrarUsuario', {
	                    nick : nick,
						email: email
	            }, function(responseText) {
	                    $('#nickServletResponse').text(responseText);
	                                                                      
	            });
	    });
	    
});

//se verifica si existe un usuario registrado con el correo electrónico ingresado

$(document).ready(function() {
	    $('#email').blur(function(event) {
			    var nick = "";
	            var email = $('#email').val();
	            $.get('RegistrarUsuario', {
						nick : nick,
	                    email : email
	            }, function(responseText) {
	                    $('#emailServletResponse').text(responseText);
	                                                                      
	            });
	    });
	    
});