/*function init(){
//listartipodocumento();listaDecreto();listarnucleos();listarclasificacion();
listartipodocumento();
listarnucleosEdit();
//  listarbrigadas();
setTimeout(function(){listarbrigadas();}, 1800);
setTimeout(function(){listaDecreto();}, 1900);
}*/

const url_backend = '';
function init(){
  listaDecreto();
  listarnucleosremitente();
  //listarbrigadasremitente();
  listartipodocumentos();
}

function listarnucleosEdit(){
  $.ajax({
    url: "../ajax/listarnucleos",
    data: {
      code: '0'
    },
    success: function( result ) {
      var option = '';
        for (var i = 0; i < result.length; i++) {
          option += '<option value="' + result[i].nucleoCodigo + '">' + result[i].nucleoAbreviatura + '</option>';
        }

    $("#cbonucleos").html(option);

    }
  });
}

function listarnucleos(){
  //internos = I
  // externos = E
  var tiporecepcion = $('input:radio[name=tipoOrganizacion]:checked').val();
   //$("#cbotiporecepcion").val();
  $.ajax({
    url: "../ajax/listarnucleos",
    data: {
      code: '0'
    },
    success: function( result ) {
    var option='<option value="0">Seleccione ...</option>';
     if(tiporecepcion == 'I'){
        option += '<option value="' + result[1].nucleoCodigo + '">' + result[1].nucleoAbreviatura + '</option>';
    	}	else{
        for (var i = 0; i < result.length; i++) {
          option += '<option value="' + result[i].nucleoCodigo + '">' + result[i].nucleoAbreviatura + '</option>';
        }
      }
    $("#cbonucleos").html(option);
//listar brigada 2
    }
  });
}

function listarbrigadas(){
  var codnucleo = $("#cbonucleos").val();

   $.ajax({
    url:  "../ajax/listarbrigadas",
    data: {
      codnucleo: codnucleo
    },
    success: function( result ) {
    var option='';
      for (var i = 0; i < result.length; i++) {
        option += '<option value="' + result[i].brigadaCodigo + '">' + result[i].brigadabreviatura + '</option>';
      }
    $("#cbobrigadas").html(option);
    listarunidades();

    }
  });
}


function listarunidades(){
  var codbrigada = $("#cbobrigadas").val();
  var codnucleo = $("#cbonucleos").val();

   $.ajax({
    url: "../ajax/listarunidades",
    data: {
      codnucleo: codnucleo,codbrigada: codbrigada
    },
    success: function( result ) {
    var option='';
      for (var i = 0; i < result.length; i++) {
        option += '<option value="' + result[i].unidadCodigo + '">' + result[i].unidadAbreviatura + '</option>';
      }
    $("#cbounidades").html(option);
    }
  });
}



//combo nucleo Remitente
function listarnucleosremitente(){
  var tiporecepcion = $('input:radio[name=tipoOrganizacion]:checked').val();
   //$("#cbotiporecepcion").val();
  $.ajax({
    url: "../ajax/listarnucleosremitente",
    data: {
      code: '0'
    },
    success: function( result ) {
    var option='<option value="0">Seleccione ...</option>';

        for (var i = 0; i < result.length; i++) {
          option += '<option value="' + result[i].nucleoCodigo + '">' + result[i].nucleoAbreviatura + '</option>';
        }

    $("#cbonucleosremitente").html(option);
    listarbrigadasremitente();
    }
  });
}

//combo brigadas remitentes
function listarbrigadasremitente(){
  var codnucleo = $("#cbonucleosremitente").val();

   $.ajax({
    url: "../ajax/listarbrigadasremitente",
    data: {
      codnucleo: codnucleo
    },
    success: function( result ) {
    var option='';
      for (var i = 0; i < result.length; i++) {
        option += '<option value="' + result[i].brigadaCodigo + '">' + result[i].brigadabreviatura + '</option>';
      }
    $("#cbobrigadasremitente").html(option);
    listarunidadesremitente();

    }
  });
}

// combo unidaddes remitentes
function listarunidadesremitente(){
  var codbrigada = $("#cbobrigadasremitente").val();
  var codnucleo = $("#cbonucleosremitente").val();

   $.ajax({
    url: "../ajax/listarunidadesremitente",
    data: {
      codnucleo: codnucleo,codbrigada: codbrigada
    },
    success: function( result ) {
    var option='';
      for (var i = 0; i < result.length; i++) {
        option += '<option value="' + result[i].unidadCodigo + '">' + result[i].unidadAbreviatura + '</option>';
      }
    $("#cbounidadesremitente").html(option);
    }
  });
}



function listartipodocumento(){
  $.ajax({
    url: "../ajax/listartipodocumentos",
    data: {
      code: ''
    },
    success: function( result ) {
    var option='<option value="0">Seleccione tipo de docuemnto ...</option>';
//  var option='';
    for (var i = 0; i < result.length; i++) {
        option += '<option value="' + result[i].tipoDocumentoId + '">' + result[i].tipoDocumento + '</option>';
    }

    $("#cbotipodocumento").html(option);
    }
  });
}

function listarclasificacion(){
  $.ajax({
    url: "../ajax/listarclasificacion",
    data: {
      code: ''
    },
    success: function( result ) {
    var option='<option value="0">Seleccione una clasificacion de documento ...</option>';
    for (var i = 0; i < result.length; i++) {
        option += '<option value="' + result[i].tipoClasificacionId + '">' + result[i].descripcion + '</option>';
    }

    $("#cboclasificacion").html(option);
    }
  });
}



function listaDecreto(){
  var id = $("#documentoId").val();
  $.ajax({
    url: "../ajax/decretoview",
    data: {
      id: id
    },
    success: function( result ) {
        console.log(result);
      var organizacion = result[0].organizacion;
      if(organizacion == "I"){
        $("#internos").attr("checked",true);
      }else{
        $("#externos").attr("checked",true);
      }
      $("#cbotipodocumento").html('<option value="' + result[0].idTipoDoc + '">' + result[0].acronimoTipoDoc + '</option>');
      $("#idTipoDoc").val(result[0].numDoc);
      $("#fechaDocumento").val( result[0].fechaDoc);
      $("#fechaRecepcion").val( result[0].fechaRecepcionDoc);
      $("#cbonucleos").html('<option value="' + result[0].idNucRemitente + '">' + result[0].nucleoRemitente + '</option>');
      $("#cbobrigadas").html('<option value="' + result[0].idBrigadaRemitente + '">' + result[0].brigadaRemitente + '</option>');
      $("#cbounidades").html('<option value="' + result[0].idUnidadRemitente + '">' + result[0].unidadRemitente + '</option>');
      $("#asunto").val( result[0].asunto);
      $("#namefile").val(result[0].archivo);
      $("#descripcion").val(result[0].descripcion);
    }
  });
}

init();
//listaDecreto();
