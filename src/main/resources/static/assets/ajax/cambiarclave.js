

function listartabla() {

	$.ajax({
		data: {},
		url: "../ajax/listusuarios",

		success: function(response) {
			//		$("#mitabla").html("");
			for (i = 0; i < response.length; i++) {
				var user = response[i].username.trim();
				var btnmodal = "<button  type='button' class='btn btn-info btn-lg'  onClick='updateusuario(\"" + user + "\");'>  <span class='glyphicon glyphicon-pencil'</button>";

				var nuevafila = "<tr><td>" + response[i].dni + "</td>";
				nuevafila += "<td>" + response[i].username + "</td>";
				nuevafila += "<td>" + response[i].acronimoGrado + "</td>";
				nuevafila += "<td>" + response[i].nombre + "</td>";
				nuevafila += "<td>" + response[i].acronimoUnidad + "</td>";
				nuevafila += "<td>" + btnmodal + "</td></tr>";


				$("#mitabla").append(nuevafila);

			}
		},



	})
}

function updateusuario(username) {
	$("#modalblas").modal('show');
	$("#txtusername").val(username);
}

function actualizarcontrasena() {


	var usuario = {
		username: $("#txtusername").val(),
		password: $("#txtpassword").val()
	};
	$.ajax({
		url: "../ajax/modificarclave",

		type: 'GET',
		data: usuario,
		headers: {
			'Content-Type': 'application/json'
		},
		success: function(data) {
			$("#txtpassword").val('');
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


setTimeout(listartabla, 0000);