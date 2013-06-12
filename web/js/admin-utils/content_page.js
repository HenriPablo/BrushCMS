/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 6/2/13
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */


$(document).ready(function () {

    var brushAce = ace.edit("aceEditor");
    ace.config.set("workerPath", "${pageContext.servletContext.contextPath}/js/ace/src-min-noconflict");
    brushAce.setTheme("ace/theme/cobalt");
    brushAce.getSession().setMode("ace/mode/html");


    $('#content').jqte();


// simple accordion for pix albums


    /* PIX ALBUM DISPLAY */
    $('.controlTab').on('click', function () {


        if ($(this).hasClass('show')) {
            $('.contentPanel').each(function () {
                $(this).hide('slow');
            });
            var v1 = $('#' + $(this).attr('data-show-or-hide'));

            /* handle main pix selection */
            if (v1.attr('id') === 'mainPix') {
                $('.pixThumbImg').clone().prependTo('#thumbsToChooseFrom');

                $('img, #thumbsToChooseFrom').draggable({
//                            appendTo: '.draggableTarget',
                    revert: true
                });

                $('#draggableTarget').droppable({
                    activeClass: 'pixDropped',
                    drop: pixDropped


                });
            }
            /* end main pix selection */

            v1.show('slow');

            $(this).removeClass('show').addClass('hide');
            $('#pixControlPanel').removeClass('roundBottom').addClass('flatBottom');
        }

        else if ($(this).hasClass('hide')) {
            var v = $('#' + $(this).attr('data-show-or-hide'));
            v.hide('slow');
            $('.contentPanel').each(function () {
                $(this).hide('slow');
            });


            if (v.attr('id') === 'mainPix') {
                $('#thumbsToChooseFrom').html('')
            }


            $('.controlTab').each(function () {
                $(this).removeClass('hide').addClass('show')
            });
            $('#pixControlPanel').removeClass('flatBottom').addClass('roundBottom')


        }


    });
    /* control tab */

    /* handle drop of pix */
    function pixDropped(event, ui) {
        //alert('pix dropped: ' + ui.draggable.at<tr('src') );
        var p = ui.draggable;
        $('#draggableTarget').empty()
            .append('<img src="' + p.attr('src') + '" />');

        $('#mainPixId').val(p.attr('id'));

        /* save pix selection */

        var ajaxOp = $.ajax({
            type:'POST',
            url:'/brush/image/mainPix/save.html',
            data : {
                'pixId': p.attr('id'),
                'pageId' : $('span#pageId').text()
            },
            dataType: "html"
        });
        ajaxOp.done( function( msg ){
            console.log( msg );
            $('#mainPixAjaxResponse').empty().html('<b>pix dropped, msg: ' + msg +'</b>');
        });
        ajaxOp.fail(function(jqXHR, textStatus) {
            console.dir( jqXHR );
            alert( "Request failed: " + textStatus );
        });


    } /* handle drop of pix */

    /* show thumbnails */
    $('.pixThumbsAlbumName').on('click', function () {
        $('.pixThumbsAlbumName').each(function () {
            $(this).next().hide('slow');
        });
        $(this).next().show('slow');
    });

    /* remove - disassociate main image from page */
    $('#removeMainPix').on('click', function(){
       var ajaxOpRemovePix = $.ajax({
           type : 'POST',
           url : '/brush/image/mainPix/save.html',
           data : {
               'pixId': 'x',
               'pageId' : $('span#pageId').text()
           },
           dataType : "html"
       });
       ajaxOpRemovePix.done( function( msg ){
           console.log( 'pix removal attempted: ' + msg );
           $('#mainPixAjaxResponse').empty().html('<b>main pix removed: ' + msg + '</b>');
       });
       ajaxOpRemovePix.fail( function( jqXHR, textStatus ){
           console.dir( jqXHR );
           alert( "Request failed: " + textStatus );
       })
    });

//        if( parseInt(  $('.pixThumbAlbumCount').text(), 10 ) > 0 ){
//
//            $('.pixThumbsTitle').on('click', function(){
//                $('.pixThumbsAlbumName').toggle( function(){
//                    $('.thumbs', $(this) /* $('#pixThumbs') */ ).each( function(){
//                        if ( $(this).css('display') === 'block' ){
//                            $(this).hide( 'slow' );//css('display', 'none')
//                        }
//                    });
//                })
//                .on( 'click', function(){
//                    $(this).next( '.thumbs').toggle( 'slow' );
//                });
//            })
//
//        }

})
