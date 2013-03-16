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
            "viewHtml",
            {
                name: "customTool",
                tooltip: "Custom Tool",
                exec: function(e) {
                    var editor = $(this).data("kendoEditor");
                    //console.log( editor );
                    var p =  editor.getSelection();
                    console.dir( p )
                    // ...
                }
            }
        ] ,
        encoded: false,

        select : function( e ){

            //console.log( e );
            //console.log(e.sender.getSelection() );
            var n =   $( e.sender.getSelection() );
            console.log(n.innerHTML);

            $( 'img', n ).each( function (){
                console.log( $(this) );
            })

        },

        imageBrowser: {
            transport: {
                read: {
                    url: "/brush/imagebrowser/read.html" ,
//                    contentType: "application/json"
                    dataType: "json"
                },


                destroy: "/brush/imagebrowser/destroy.html",
                create: "/brush/imagebrowser/createDirectory.html",
                uploadUrl: "/brush/imagebrowser/upload.html",
                thumbnailUrl: "/brush/imagebrowser/thumbnail.html",
                //imageUrl: "/art/upload/thm/{0}"

                imageUrl: "/brush/{0}"
            },
            path: "/art/upload/thm/",

            fileTypes : ".png,.gif,.jpg,.jpeg, .JPG"
        }

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
