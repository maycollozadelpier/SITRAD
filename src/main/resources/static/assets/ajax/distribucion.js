function enviar(){
  var queryString = window.location.search;
  var urlParams = new URLSearchParams(queryString);
  var cod_documento = urlParams.get('id');




    var copiainfo = $('[name="cpinf[]"]:checked').map(function(){
      return this.value;
    }).get();

    var dist = $('[name="distri[]"]:checked').map(function(){
      return this.value;
    }).get();

    for (var i = 0; i < copiainfo.length; i++) {
       $.ajax({
        url: "../ajax/copia-informativa",
        data: {
          cod_doc: cod_documento,cod_copi_info:copiainfo[i]
        },
        success: function( dt ) {
	  location.href='../inicio/dashboard';

        }
      });
    }

    for (var i = 0; i < dist.length; i++) {
      console.log(dist[i]);
       $.ajax({
        url: "../ajax/distribucion",
        data: {
          cod_doc: cod_documento, cod_dist:dist[i]
        },
        success: function( dt ) {
	     location.href='../inicio/dashboard';

        }
      });
    }

    var prio =$('input:radio[name=prioridad]:checked').val();
    var obs =$("#comentario").val();

       $.ajax({
        url: "../ajax/comentario",

        data: {
          cod_doc: cod_documento, prioridad:prio, observacion:obs
        },
        success: function( dt ) {
          if(dt == true){
            alert('Datos registrados Coreectamente.');
            location.href='../inicio/dashboard';
          }
        }
      });



  //alert('Datos registrados Coreectamente.');
}

function registrounidadremite(){
	var usuario = {
		codunidaddocregistra: $("#uniremite").val(),
		estado: $("#unirespondable").val(),
		iddocumento: $("#id").val()
	};
	
	$.ajax({
		
		url: "../ajax/insertarunidadregistra",

		type: 'GET',
		data: usuario,
		headers: {
			'Content-Type': 'application/json'
		},
		success: function(data) {
     location.href='../inicio/dashboard';
			var body;
			if (data === 'OK')
				body = "Actualizado";
			else
				body = "Error: " + data;
			$("#resultado").modal(body);
		},

	});

	
}
