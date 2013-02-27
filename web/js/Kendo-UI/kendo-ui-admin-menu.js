$(document).ready(function() {
    $("#menu").kendoMenu();



    // create ComboBox from select HTML element
    $("#navigationSection").kendoComboBox();


    $("#content").kendoEditor({
        tools: [
            "bold",
            "italic",
            "underline",
            "strikethrough",
            "fontName",
            "fontSize",
            "foreColor",
            "backColor",
            "justifyLeft",
            "justifyCenter",
            "justifyRight",
            "justifyFull",
            "insertUnorderedList",
            "insertOrderedList",
            "indent",
            "outdent",
            "formatBlock",
            "createLink",
            "unlink",
            "insertImage",
            "subscript",
            "superscript",
            "viewHtml"
        ]
    });

    $(".grid").kendoGrid({
        height: 250
    });

    var adminH = $(".admin-body").height();
    var adminLeftColH = $(".admin-col-left").height();
    var adminRightColH = $(".admin-col-right").height();

    /* image album  panel bar */
    $("#panelBar").kendoPanelBar();

    /* end image album panel bar */




    $(".admin-body").height(function() {

        if( $(".admin-col-left").length > 0 ){


            if (adminLeftColH > adminRightColH) {
                return (adminLeftColH * 1.08);
            } else {
                return (adminRightColH * 1.08);
            }
        }

        if( $('.admin-col-single').length > 0 ){

            return ( ($('.admin-col-single').outerHeight())  );
        }

    });

});
