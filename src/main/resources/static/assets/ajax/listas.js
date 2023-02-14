detalleremitentes();
function detalleremitentes(){
  $.ajax({
    url: "../ajax/detalleremitentes",
    data: {
      code: '0'
    },
    success: function( result ) {
      var card = '';
      var total =0;
      var x = 3;

      for (var i = 0; i < result.length; i++) {
         total =parseInt(result[i].remitidos) + parseInt(result[i].decretado) + parseInt(result[i].respondido);

         if(x=3){
           card += '<div clas="row">';
         }
         //if(parseInt(result[i].remitidos) > 0 || parseInt(result[i].decretado) > 0 ||  parseInt(result[i].respondido) > 0){
        card +=' <div class="col-md-4 col-sm-4 col-xs-12 profile_details "> '
											card +='<div class="well profile_view">'
											card +='	<div class="col-sm-12">'
												card +='	<h4 class="brief">'
												card +='		<i>'+result[i].descripcionUnidadRemi+'</i>'
												card +='	</h4>'
												card +='	<div class="left col-xs-12">'

												card +='		<div class="x_content">'

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
                              card +='	<span>Respondido</span>'
                            card +='	</div>'
                            card +='	<div class="w_center w_55">'
                              card +='	<div class="progress">'
                              card +='		<div class="progress-bar bg-DeepSkyBlue"'
                              card +='			role="progressbar" aria-valuenow="60"'
                              card +='			aria-valuemin="0" aria-valuemax="'+total+'"'
                              card +='			style="width: '+result[i].respondido+'%;">'
                              card +='			<span class="sr-only">60% Complete</span>'
                              card +='		</div>'
                              card +='	</div>'
                            card +='	</div>'
                            card +='	<div class="w_right w_20">'
                            card +='		<span>'+result[i].respondido+'</span>'
                            card +='	</div>'
                          card +='		<div class="clearfix"></div>'
                          card +='	</div>'

                          card +='<div class="widget_summary">'
                          card +='	<div class="w_left w_25">'
                            card +='	<span>Pendientes</span>'
                          card +='	</div>'
                          card +='	<div class="w_center w_55">'
                            card +='	<div class="progress">'
                            card +='		<div id="bar'+result[i].codigoUnidadRemi+'" class="progress-bar bg-red"'
                            card +='			role="progressbar" aria-valuenow="60"'
                            card +='			aria-valuemin="0" aria-valuemax="'+total+'"'
                            card +='			 >'
                            card +='			<span class="sr-only">60% Complete</span>'
                            card +='		</div>'
                            card +='	</div>'
                          card +='	</div>'
                          card +='	<div class="w_right w_20">'
                          card +='		<span id="'+result[i].codigoUnidadRemi+'">0</span>'
                          card +='	</div>'
                        card +='		<div class="clearfix"></div>'
                        card +='	</div>'

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
												card +='	</div>'
											card +='	</div>'

										card +='	</div>'
									card +='	</div>';
                //  }
                  if(x == 3){
                    card += "</div>";
                    x=1;
                  }

                  x++;

                  total =0;
      }
      $("#card").html(card);
      pendientes();
    }
  });
}

function pendientes(){
  $.ajax({
    url: "../ajax/detalleresponsable",
    data: {
      code: ''
    },
    success: function( dataset ) {
      var p ="0";
      for (var i = 0; i < dataset.length; i++) {
         //if(parseInt(dataset[i].pendientes) > 0 || parseInt(dataset[i].archivado) > 0){
             $("#"+ dataset[i].codigoUnidad).html(dataset[i].pendientes);
             $("#bar"+ dataset[i].codigoUnidad).css({width: dataset[i].pendientes+'%'});
        // }
      }
    }
  });
}
