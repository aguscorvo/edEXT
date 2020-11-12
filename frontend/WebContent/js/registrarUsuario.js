//se verifica si existe un usuario registrado con el nick ingresado

$(document).ready(function() {
	    $('#nick').blur(function(event) {
	            var nick = $('#nick').val();
				var email = "";
				var pass1 = "";
	            var pass2= "";

	            $.get('RegistrarUsuario', {
	                    nick : nick,
						email: email,
						pass1 : pass1,
						pass2 : pass2						
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
	            var pass1 = "";
	            var pass2= "";
	            $.get('RegistrarUsuario', {
						nick : nick,
	                    email : email,
	                    pass1 : pass1,
						pass2 : pass2
	            }, function(responseText) {
	                    $('#emailServletResponse').text(responseText);
	                                                                      
	            });
	    });
	    
});

//se verifican las contraseñas

$(document).ready(function() {
	    $('#pass1').change(function(event) {
	    	 $('#pass2').change(function(event) {	    
			    var nick = "";
	            var email = "";
	            var pass1 = $('#pass1').val();
	            var pass2= $('#pass2').val();
	            $.get('RegistrarUsuario', {
						nick : nick,
	                    email : email,
	                    pass1: pass1,
	                    pass2: pass2
	            }, function(responseText) {
	                    $('#passwordServletResponse').text(responseText);
	                                                                      
	            });
	         });
	    });
	    
});

$(document).ready(function() {
	    $('#pass2').change(function(event) {
	    	 $('#pass1').change(function(event) {	    
			    var nick = "";
	            var email = "";
	            var pass1 = $('#pass1').val();
	            var pass2= $('#pass2').val();
	            $.get('RegistrarUsuario', {
						nick : nick,
	                    email : email,
	                    pass1: pass1,
	                    pass2: pass2
	            }, function(responseText) {
	                    $('#passwordServletResponse').text(responseText);
	                                                                      
	            });
	         });
	    });
	    
});

