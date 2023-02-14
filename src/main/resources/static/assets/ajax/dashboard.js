function init(){

  dashboard();
}

function dashboard(){
  var sumtotal=0;
  $.ajax({
    url: "../ajax/dashboard",
    data: {
      tipUnidad: 'RESPONSABLE'
    },
    success: function( result ) {

      var totalresponsable =parseInt(result[0].pendientes) + parseInt(result[0].archivado);
      sumtotal = parseInt(totalresponsable);
      $("#idremitidos").html(result[0].remitidos);
      $("#idresponsable").html(totalresponsable);

      $.ajax({
        url: "../ajax/dashboard",
        data: {
          tipUnidad: 'REMITENTE'
        },
        success: function( result ) {
          var totalremitente =parseInt(result[0].remitidos) + parseInt(result[0].respondido);
          sumtotal = (parseInt(sumtotal) + (totalremitente));
          $("#idremitidos").html(result[0].remitidos);
          $("#idrespondidos").html(result[0].respondido);

            $("#idtotal").html(sumtotal);
        //  $("#idresponsable").html(totalresponsable);
        }
      });

    }
  });
}

init();
