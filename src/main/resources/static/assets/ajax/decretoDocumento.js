function init(){
  mostrarTabla();
}

function ver(codigo){
		$.ajax({
			  url: "../ajax/decretoAjax",
			  data: {
				  id: codigo
			  },
			  success: function( result ) {

				$("#filecontent").attr("src","../archivo/" + result[0].archivo);

			  }
			});

	}

  function mostrarTabla(){
    var tbody="";

    $.ajax({
      url: "../ajax/listadecretonative",
      data: {
        code: ''
      },
      success: function( response ) {
        console.log(response);
        if(response.length > 0){
          var documento = [];

          for (var i = 0; i < response.length; i++) {
            documento.push(response[i].cod_documento);
          }

          let dtdocument = documento.filter((item, index) => {
					       return documento.indexOf(item) === index;
				    });

            console.log(dtdocument);

            for (var x = 0; x < dtdocument.length; x++) {
              var numerox = "";
              var prioridadx="";
              var comentariox="";
              var decretos = "";
              tbody +="<tr>"
              tbody +='<td role="presentation" class="dropdown"><a id="drop4"'
    												+'	href="#" class="btn btn-success dropdown-toggle btn-xs"'
    												+'	data-toggle="dropdown" aria-haspopup="true" role="button"'
    												+'	aria-expanded="false"> Documents <span class="caret"></span>'
    											+'	</a>'
    													+'<ul id="menu6" class="dropdown-menu animated fadeInDown"'
    													+'	role="menu">'
    														+'<li role="presentation"><a role="menuitem"'
    														+'	tabindex="-1" data-toggle="modal"'
    														+'	data-target=".bs-example-modal-sm" onclick="ver('+dtdocument[x]+')" >VER</a></li>'
    													+'	<li role="presentation"><a role="menuitem"'
    														+'	tabindex="-1"'
    														+'	href="/documents/archivar-documento?id='+dtdocument[x]+'">ARCHIVAR</a></li>'
    													+'</ul></td>'
               decretos += "<ul>";
              for (var i = 0; i < response.length; i++) {
                if(dtdocument[x] == response[i].cod_documento){
                  decretos += "<li>"+ response[i].decreto + "</li>";
                  numerox = response[i].num_documento;
                  prioridadx = response[i].prioridad;
                  comentariox = response[i].comentario
                }
              }
              decretos += "</ul>"

              tbody +="<td>"+numerox+"</td>"
              tbody +="<td>"+prioridadx+"</td>"
              tbody +="<td>"+decretos+"</td>"
              tbody +="<td>"+comentariox+"</td>"
              tbody +="</tr>";
            }

          $("#tablaDecreto").html(tbody);

        }
      }
    });



  	}

    init();
