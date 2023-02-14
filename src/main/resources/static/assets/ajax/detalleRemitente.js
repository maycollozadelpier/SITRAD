detalleremitente();
function detalleremitente(){
  $.ajax({
    url: "../ajax/detalleremitente",
    data: {
      code: '0'
    },
    success: function( result ) {
      var card = '';
      var total =0;


      for (var i = 0; i < result.length; i++) {
         total =parseInt(result[i].pendientes) + parseInt(result[i].remitidos) + parseInt(result[i].decretado) + parseInt(result[i].archivado);


        card +=' 	<div class="x_content">'

            card +='	<div class="widget_summary">'
              card +='	<div class="w_left w_25">'
              card +='		<span>Total</span>'
                card +='</div>'
                card +='<div class="w_center w_55">'
                  card +='<div class="progress">'
                  card +='	<div class="progress-bar bg-green" role="progressbar"'
                  card +='		aria-valuenow="20" aria-valuemin="0"'
                  card +='		aria-valuemax="'+total+'" style="width: 100%;" >'
                  card +='		<span class="sr-only"></span>'
                  card +='	</div>'
                card +='	</div>'
              card +='	</div>'
              card +='	<div class="w_right w_20">'
                card +='	<span>'+total+'</span>'
              card +='	</div>'
              card +='	<div class="clearfix"></div>'
            card +='	</div>'

              card +='<div class="widget_summary">'
              card +='	<div class="w_left w_25">'
                card +='	<span>Remitidos</span>'
              card +='	</div>'
              card +='	<div class="w_center w_55">'
                card +='	<div class="progress">'
                card +='		<div class="progress-bar bg-DeepSkyBlue"'
                card +='			role="progressbar" aria-valuenow="60"'
                card +='			aria-valuemin="0" aria-valuemax="'+total+'"'
                card +='			style="width: '+result[i].remitidos+'%;">'
                card +='			<span class="sr-only">60% Complete</span>'
                card +='		</div>'
                card +='	</div>'
              card +='	</div>'
              card +='	<div class="w_right w_20">'
              card +='		<span>'+result[i].remitidos+'</span>'
              card +='	</div>'
            card +='		<div class="clearfix"></div>'
            card +='	</div>'
            card +='	<div class="widget_summary">'
            card +='		<div class="w_left w_25">'
            card +='			<span>Archivados</span>'
            card +='		</div>'
            card +='		<div class="w_center w_55">'
              card +='		<div class="progress">'
              card +='			<div class="progress-bar bg-blue" role="progressbar"'
              card +='				aria-valuenow="60" aria-valuemin="0"'
              card +='				aria-valuemax="'+total+'" style="width: '+result[i].archivado+'%;">'
              card +='				<span class="sr-only">60% Complete</span>'
                card +='		</div>'
                card +='	</div>'
              card +='	</div>'
              card +='	<div class="w_right w_20">'
                card +='	<span>'+result[i].archivado+'</span>'
                card +='</div>'
                card +='<div class="clearfix"></div>'
            card +='	</div>'
            card +='	<div class="widget_summary">'
            card +='		<div class="w_left w_25">'
            card +='			<span>Decreto</span>'
            card +='		</div>'
            card +='		<div class="w_center w_55">'
              card +='		<div class="progress">'
              card +='			<div class="progress-bar bg-blue" role="progressbar"'
              card +='				aria-valuenow="60" aria-valuemin="0"'
              card +='				aria-valuemax="'+total+'" style="width: '+result[i].decretado+'%;">'
              card +='				<span class="sr-only">60% Complete</span>'
                card +='		</div>'
                card +='	</div>'
              card +='	</div>'
              card +='	<div class="w_right w_20">'
                card +='	<span>'+result[i].decretado+'</span>'
                card +='</div>'
                card +='<div class="clearfix"></div>'
            card +='	</div>'
              card +='<div class="widget_summary">'
              card +='	<div class="w_left w_25">'
              card +='		<span>Pendientes</span>'
              card +='	</div>'
              card +='	<div class="w_center w_55">'
              card +='		<div class="progress">'
                card +='		<div class="progress-bar bg-red" role="progressbar"'
                card +='			aria-valuenow="60" aria-valuemin="0"'
                card +='			aria-valuemax="'+total+'" style="width: '+result[i].pendientes+'%;">'
                card +='			<span class="sr-only">60% Complete</span>'
                card +='		</div>'
                card +='	</div>'
              card +='	</div>'
              card +='	<div class="w_right w_20">'
                card +='	<span>'+result[i].pendientes+'</span>'
              card +='	</div>'
              card +='	<div class="clearfix"></div>'
              card +='</div>'
          card +='	</div>'
        card +='	</div>'
        card +='</div>'
      card +='	<div class="col-xs-12 bottom text-center">'
        card +='	<div class="col-xs-12 col-sm-6 emphasis">'
        card +='		<p class="ratings">'
        card +='			<a>4.0</a> <a href="#"><span class="fa fa-star"></span></a>'
        card +='			<a href="#"><span class="fa fa-star"></span></a> <a'
        card +='				href="#"><span class="fa fa-star"></span></a> <a'
        card +='				href="#"><span class="fa fa-star"></span></a> <a'
        card +='				href="#"><span class="fa fa-star-o"></span></a>'
        card +='		</p>'
        card +='	</div>'
        card +='	<div class="col-xs-12 col-sm-6 emphasis">'
        card +='		<button type="button" class="btn btn-success btn-xs">'
          card +='		<i class="fa fa-user"> </i> <i class="fa fa-comments-o"></i>'
          card +='	</button>'
          card +='	<button type="button" class="btn btn-primary btn-xs">'
          card +='		<i class="fa fa-user"> </i> View Profile'
        card +='		</button>'
        card +='	</div>';



                  x++;


                  total =0;
      }
      $("#card").html(card);
    }
  });
}
