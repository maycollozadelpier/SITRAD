


function cambiarcontraxusu(){

	var usuario = {
		username: $("#usu").val(),
		password: $("#pass").val()
	};
	
	$.ajax({
		url: "../ajax/modificarclave",

		type: 'GET',
		data: usuario,
		headers: {
			'Content-Type': 'application/json'
		},
		success: function(data) {
			$("#pass").val('');	
			Swal.fire(
				'Buen trabajo!',
				'Se actualizo la contraseña!',
				'Gracias'
			);
			
			var body;
			if (data === 'OK')
				body = "Actualizado";
			else
				body = "Error: " + data;
			$("#resultado").modal(body);
		},

	});

	
}

