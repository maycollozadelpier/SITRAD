

function cambiarcontraxusu(){

	var usuario = {
		codunidaddocregistra: $("#usu").val(),
		estado: $("#pass").val(),
		iddocumento: $("#pass").val()
	};
	
	$.ajax({
		url: "../ajax/insertarunidadregistra",

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

