function flat(){
  $("#btnguardar").removeAttr("disabled");

}

function enviarCopiaInformativa(){
  var queryString = window.location.search;
  var urlParams = new URLSearchParams(queryString);
  var cod_documento = urlParams.get('id');




    var copiainfo = $('[name="cpinf[]"]:checked').map(function(){
      return this.value;
    }).get();

    for (var i = 0; i < copiainfo.length; i++) {
       $.ajax({
        url: "../ajax/copia-informativa",
        data: {
          cod_doc: cod_documento,cod_copi_info:copiainfo[i]
        },
        success: function( dt ) {

        }
      });
    }


      //alert('Datos registrados Coreectamente.');

      Swal.fire({
        //position: 'top-end',
        icon: 'success',
        title: 'Copia Informativa Guardada Correctamente',
        showConfirmButton: false,
        timer: 1500
      })
      location.href='../inicio/dashboard';


  //alert('Datos registrados Coreectamente.');
}
