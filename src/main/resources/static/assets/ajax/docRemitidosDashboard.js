totalDocRemitidos();
function totalDocRemitidos(){

  $.ajax({
    url: "../ajax/totalDocRemitidos",
    data: {
      code: '0'
    },
    success: function( result ) {
      var car = '';

      for (var i = 0; i < result.length; i++) {
        car += '<div class="widget_summary">'
				  car += '<div class="w_left w_55">'
					  car += '<span>'+result[i].acronimo+'</span>'
				  car += '</div>'
					  car += '<div class="w_center w_25">'
						  car += '<div class="progress">'
						  car += '<div class="progress-bar bg-green" role="progressbar"'
												  car += 'aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"'
											  car += '	style="width:'+result[i].total+'%;">'
												  car += '<span class="sr-only">60% Complete</span>'
											  car += '</div>'
										  car += '</div>'
								  car += '	</div>'
									  car += '<div class="w_right w_20">'
										  car += '<span>'+result[i].total+'</span>'
									  car += '</div>'
									  car += '<div class="clearfix"></div>'
								  car += '</div>';
                  //console.log(car);
      }

      $("#idremit").html(car);

    }
  });
}
