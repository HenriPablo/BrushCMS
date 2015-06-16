$(document).ready( function(){

    var l = window.location.toString();
    var chrumbs = l.split( '/');

    var chrumbSize = chrumbs.length;

    var sep = '&nbsp;&nbsp; &#9654; ';
    $('#breadcrumbs').empty();



    for( var i = 4; i < chrumbSize; i++ ){

        if( chrumbs[i].indexOf('_') > 0 ){
            chrumbs[i] = chrumbs[i].replace( '_', ' ');
        }

        if( chrumbs[i].indexOf('.html') > 0 ){

            chrumbs[i] = " ID: " +  chrumbs[i].replace( ".html", '' );
            sep = '';

        } else {
            sep = '&nbsp;&nbsp; &#9654; ';
        }

        $('#breadcrumbs').append( '<span class="crumb">' + chrumbs[i] +  sep + '</span>');

    }

});