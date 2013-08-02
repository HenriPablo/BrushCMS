/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 6/2/13
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */


$(document).ready(function () {
    /* text area content could have been uri encoded during incremental save by ajax call */
    $('#content').html(decodeURIComponent($('#content').html()));


    brushAce = ace.edit("aceEditor");

    ace.config.set("workerPath", location.hostname + "/js/ace/src-min-noconflict");
    brushAce.setTheme("ace/theme/cobalt");
    brushAce.getSession().setMode("ace/mode/html");

    $('#content').jqte();


    /* PIX ALBUM DISPLAY */
    $('.controlTab').on('click', function () {


        if ($('.contentPanel').is(':visible')) {
            $('#pixControlPanel').removeClass('flatBottom').addClass('roundBottom')
        }
        if ($('.contentPanel').is(':hidden')) {
            $('#pixControlPanel').removeClass('roundBottom').addClass('flatBottom');
        }
        $('.contentPanel').slideToggle('slow', function () {
            //alert('in toggle done');
            if ($("#pixes").outerHeight() > $("#mainPix").outerHeight()) {
                // $("#mainPix").css('border-left', '0');
                $("#mainPix").outerHeight($("#pixes").outerHeight()).css('min-height', $("#mainPix").outerHeight() + 'px');

                //$("#pixes").css('border-right', '1px solid #BBB');

                //alert( $("#pixes").outerHeight() );

            } else {
                //alert( "pixes height in ELSE: " + $("#pixes").outerHeight() );
                //$("#pixes").css('border-right', '0');
                //$("#mainPix").css('border-left', '1px solid #BBB');
            }
        });


        /* handle main pix selection */

        //if (v1.attr('id') === 'mainPix') {

        $('img, #thumbsToChooseFrom').draggable({
            // appendTo: '.draggableTarget',
            revert: true
        });

        $('#draggableTarget').droppable({
            activeClass: 'pixDropped',
            drop: pixDropped


        });
        $('.jqte_editor').droppable({
            activeClass: 'pixDropped',
            drop: addPixToEditor


        });
        //pasteHtmlAtCaret


    });
    /* control tab */




    function pixDropped(event, ui) {
        //alert('pix dropped: ' + ui.draggable.at<tr('src') );
        var p = ui.draggable;
        $('#draggableTarget').empty()
            .append('<img src="' + p.attr('src') + '" />');

        $('#mainPixId').val(p.attr('id'));
        $("#mainPixStatus").empty().text( "Main Pix Id: " + p.attr('id') );

        /* save pix selection */
        contentPage.assignMainPix({
            endMethod: "save",
            payload: {
                'pixId': p.attr('id'),
                'pageId': $('#id').val()
            },
            url: '/brush/image/mainPix/save.html',
            messageBoard: '#messageBoardMainPix'
        });


    }

    /* handle drop of pix */


    /* remove - disassociate main image from page */
    $('#removeMainPix').on('click', function () {
        contentPage.unAssignMainPix({
            url: '/brush/image/mainPix/save.html',
            payload: {
                pixId: 'x',
                pageId: $('#id').val()
            },
            messageBoard: '#messageBoardMainPix',
            message: "Main Pix unassigned from this content page"
        });

    });


});


/* handle drop of pix */
function addPixToEditor( event, ui ){
    var p = ui.draggable;
    pasteHtmlAtCaret(  '<img src="'+ p.attr('src') + '" />' )
}



var contentPage = {

    init: function () {
        // display button to unassign main pix from page if one is assigned
        if ($("#draggableTarget img").length > 0) {
            $("#removeMainPix").css('display', 'block');
        }

        /* show images from albums in colorbos */
        $("a", "#pixes").colorbox();

        /* center message board for main pix assignment */
        var bar = $("#pixControlPanel");
        var tab = $("#albumsTab");
        var w = bar.width() - tab.outerWidth();


        $("#messageBoardMainPix").width(w).height(bar.height() - 10)
    }(),

    callServer: function (data) {
        var callType = data.callType || 'POST';
        var destination = data.url || '/brush/contentPage/' + data.endMethod + '.html';
        var payload = data.payload;
        /* if nothing else, there better be payload */
        var payloadType = data.payloadType || 'html';
        var messageBoard = data.messageBoard || '#aceEditMsgBoard';
        var message = " " + data.message || "";
        var returnToken = "OK";


        console.log("data in callServer")
        console.log(data);

        var ajaxCall = $.ajax({
            type: callType,
            url: destination,
            /*contentType: "application/json; charset=utf-8", */
            data: payload  /*JSON.stringify( payload )*/,
            dataType: payloadType
        });

        /* EVERYTHING OK */
        ajaxCall.done(function (msg) {
            console.log("message in done ajax call")
            console.log(msg);
            contentPage.fadeMessage($(messageBoard), msg + message, returnToken);
        });

        /* FAIL */
        ajaxCall.fail(function (jqXHR, textStatus) {
            returnToken = "NotOK"
            contentPage.fadeMessage(
                $(messageBoard),
                "Could not save content because: STATUS: " + jqXHR.status + " STATUS TEXT: " + jqXHR.statusText,
                returnToken);
        });

        ajaxCall.always(function () {
            return "something from always";
        });

        return returnToken;
    }, /* end serverCall */


    /* body of article to save */
    saveContent: function (data) {
        data.payload = {
            'contentToSave': encodeURIComponent(data.contentToSAve).replace(/\-/g, "%2D").replace(/\_/g, "%5F").replace(/\./g, "%2E").replace(/\!/g, "%21").replace(/\~/g, "%7E").replace(/\*/g, "%2A").replace(/\'/g, "%27").replace(/\(/g, "%28").replace(/\)/g, "%29"),

            'pageId': $('#id').val()
        };

        contentPage.callServer(data);
    },


    /* articles main image */
    assignMainPix: function (data) {
        if (contentPage.callServer(data) === "OK") {
            $("#removeMainPix").show('slow');
        }

    },
    unAssignMainPix: function (data) {
        var x = contentPage.callServer(data);
        if (x === "OK") {
            $("#mainPixStatus").empty().text("No Main Pix");
            $("#draggableTarget").empty().text("To assign Main Pix to this page, drag and drop one here.");
            $("#removeMainPix").hide('slow');
        }

    },


    fadeMessage: function (destinationBoard, msg, okOrNot) {

        var msgBoardTheme = "msgBoard" + okOrNot || "msgBoardNeutral";
        var fadeInDuration = 1000;
        var fadeOutDuration = 1000;
        var delayDuration = 1500;

        if (msgBoardTheme === "msgBoardnotOK") {
            fadeInDuration = 3000;
            delayDuration = 3000;
        }

        destinationBoard
            .empty().hide()
            .addClass(msgBoardTheme)
            .html(msg)
            .fadeIn(fadeInDuration, function () {
            })
            .delay(delayDuration)
            .fadeOut(fadeOutDuration, function () {
                $(this).empty().removeClass(msgBoardTheme);
            });

    }

};
