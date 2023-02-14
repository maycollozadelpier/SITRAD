function init(){
  mostrarTablaCopiaInformativa();
}



  function mostrarTablaCopiaInformativa(){
    var tbody="";

    $.ajax({
      url: "../ajax/listacopiainformativa",
      data: {
        code: ''
      },
      success: function( response ) {
        console.log(response);
        if(response.length > 0){
          var documento = [];
          var dependencias = [];

          for (var i = 0; i < response.length; i++) {
            documento.push(response[i].idDocumento);
          }

          for (var i = 0; i < response.length; i++) {
            dependencias.push(response[i].unidadResponsable);
          }

          let dtdocument = documento.filter((item, index) => {
					       return documento.indexOf(item) === index;
				    });

            let dtdependencias = dependencias.filter((item, index) => {
                   return dependencias.indexOf(item) === index;
              });

            console.log(dtdocument);
            console.log(dtdependencias);



              for (var z = 0; z < dtdependencias.length; z++) {
                for (var x = 0; x < dtdocument.length; x++) {
                  var numerox = "";
                  var prioridadx="";
                  var comentariox="";
                  var responsable="";
                  var decretos = "";
                  tbody +="<tr>"

                   decretos += "<ul>";
                  for (var i = 0; i < response.length; i++) {

                    if(dtdocument[x] == response[i].idDocumento & dtdependencias[z] == response[i].unidadResponsable){

                      decretos += "<li>"+ response[i].decreto + "</li>";
                      numerox = response[i].numDoc;
                      prioridadx = response[i].prioridad;
                      comentariox = response[i].comentario;
                      responsable = dtdependencias[z];

                    }
                  }
                  decretos += "</ul>"
              }




              tbody +="<td>"+numerox+"</td>"
              tbody +="<td>"+prioridadx+"</td>"
              tbody +="<td>"+decretos+"</td>"
              tbody +="<td>"+comentariox+"</td>"
              tbody +="<td>"+responsable+"</td>"
              tbody +="</tr>";
            }

          $("#tablaCopiaInformativa").html(tbody);

        }
      }
    });



  	}

    init();
