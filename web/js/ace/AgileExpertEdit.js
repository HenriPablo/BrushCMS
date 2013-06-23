$(window).load( function(){
    agileExpertEdit.init();
});


/**
 * @namespace Holds all of agileEditPro functionality
 */
var agileExpertEdit = {

    init : function(){
        $('#editForm').each(function() { this.reset() });

        agileExpertEdit.state.setAceEditorFriendly( agileExpertEdit.compatibleBrowser() );

        if(  agileExpertEdit.state.getAceEditorFriendly() === true ){
            $("#contentSelection").change( agileExpertEdit.changeEditorContent );
            $("#editorThemeSelection").change( agileExpertEdit.changeEditorTheme );
            $(document.getElementsByName("editorMode")).on('click', agileExpertEdit.changeEditorMode );
        } else {
            agileExpertEdit.prepareBareBones();
            $("#contentSelection").change( agileExpertEdit.useBareBones );
        }
        $(".testSaveBtn").on( 'click', agileExpertEdit.saveEditorContent );

    },

    /**
     * We can keep track of application state if need be
     */
    state : {
        aceFriendly : false,
        contentType : "",
        browser : "",

        setAceEditorFriendly : function( tf  ){
            this.aceFriendly = tf;
        },
        getAceEditorFriendly : function(){
            return this.aceFriendly;
        },

        setContentType : function( contentType ){
            this.contentType = contentType;
        },
        getContentType : function(){
            return this.contentType;
        },

        setBrowser : function( browser ){
            this.browser = browser;
        },
        getBrowser : function(){
            return this.browser;
        }
    },

    /**
     * Manually set Ace editor's mode
     * for example when creating a new content block
     */
    changeEditorMode : function(){
        var newEditorMode = this.value;
        editor.getSession().setMode("ace/mode/" + newEditorMode );
        //console.log( newEditorMode )
    },

    /**
     * changes Ace's color scheme
     */
    changeEditorTheme : function(){
        var themeValue = this.value;
        editor.setTheme( "ace/theme/" + themeValue );
    },


    /**
     *  Change contents in Ace editor
     *  set editor's mode appropriate for the new content
     *  check radio button on control panel to reflect the new content type
     *  set cursor on 1st line of code
     *      IE9: expose Ace editor right or control panel
     *      otherwise load it into Colorbox
     *
     */
    changeEditorContent : function(  ){
        var blockIdToEdit = this.value;
        var lbl = $("#contentSelection option:selected").text();
        var contentType = $(document.getElementById( blockIdToEdit )).attr( 'data-contenttype' );

        // see what type of content we got and set the editor's mode accordingly
        editor.getSession().setMode( "ace/mode/" + contentType );
        editor.setValue( agileExpertEdit.getContent( blockIdToEdit ) );
        editor.gotoLine(1);

        // change content type radio buttons to reflect content mode
        $('input[data-mode="' + contentType + '"]').prop('checked', true );

        // un-hide editor and control panel options
        agileExpertEdit.exposeElements( "#controlPanelOptions,  #save" );

        // load into colorbox
        if( agileExpertEdit.state.getBrowser() === 'ie9'){
            agileExpertEdit.exposeElements( "#editorWrapper" );
        } else {
            $.colorbox({ inline: true, href:"#editor", width : '90%', height:'90%', title: contentType.toUpperCase() + ": " + lbl });
        }
    },

    /**
     * Feb. 13, 13: at the moment we're getting DEMO CONTENT from the page
     * This get content from ajax as well
     * TODO: might have to be prepared to parse the param for data required to make an AJAX call
     * TODO: do we load minified content?
     * @param blockIdToEdit
     * @return {*|jQuery}
     */
    getContent : function( blockIdToEdit ){
      var content = $( document.getElementById( blockIdToEdit ) ).text();
      return content;
    },

    /**
     * Feb. 14, 13: for demo we're just showing content (minified if it's CSS) at the bottom of the page.
     * TODO: do we save 2 VERSIONS? -> one minified for production display, one for future editing only?
     * TODO: for PRODUCTION we want to make an AJAX call or populate form for old timey 'submit'.
     *
     * We extract content from either Ace div or BARE BONES textarea
     */
    saveEditorContent : function () {
        /*
         DEMO: displayed minified CSS in div at bottom of window.
         In PROD this could as well make an AJAX
         */
        var contentToSave = "";
        var currentEditorMode = "";

        if( agileExpertEdit.state.getAceEditorFriendly() === true ){
            contentToSave = editor.getValue();
            currentEditorMode = editor.getSession().getMode().$id;
        } else {
            contentToSave = $("#editor").val();
            currentEditorMode = agileExpertEdit.state.getContentType();
        }

        /* Minify before saving only if we have CSS  */
        if( currentEditorMode.indexOf("css" ) > -1 ){
            contentToSave = YAHOO.compressor.cssmin( contentToSave );
        }

        /* DEMO SAVE DUMP */
        $("#outputCode").text( contentToSave )
        $("#output").show();

        /* TODO: prep ajax call */

        //console.log(contentToSave)
    },

    /**
     * @param stringOfElements:
     * String containing ID or CLASS identifiers or elements to have 'hidden' class removed from
     * For example: "#controlPanelOptions, #editorWrapper, #save"
     */
    exposeElements : function (stringOfElements){
        // un-hide editor and control panel options
        if( $( stringOfElements ).hasClass("hidden")  ){
            $( stringOfElements ).removeClass("hidden");
        }
    },

    /**
     * Replace DIV required by Ace with TEXTAREA
     */
    prepareBareBones : function(){
        $("#editor").replaceWith("<textarea id='editor' cols='45' rows='20' class='bareBones' wrap='hard' ></textarea> ")
    },

    /**
     * Option to use a bare bones textarea instead of Ace editor div
     */
    useBareBones: function () {
        var blockIdToEdit = this.value;
        var contentType = $(document.getElementById( blockIdToEdit )).attr( 'data-contenttype' );
        agileExpertEdit.state.setContentType( contentType );
        $("#editor").text( agileExpertEdit.getContent( blockIdToEdit ) );
        agileExpertEdit.exposeElements( "#editorWrapper, #save" )
    },

    /**
     * Ace editor requires IE9 or greater
     * @return {boolean}
     */
    compatibleBrowser : function(){
        var compatible = true;
        // when Ace is loaded and initialized on the page, we check for IE less then 9
        // It's supposed to load fine in IE9, FF and Chrome. As of 2/14/13 no testing has been done in Safari
        if( typeof ace === 'undefined'){
            compatible = false;
        }
        // we need to know if we're dealing with IE9 as it will run Ace editor, but not in Colorbox overlay, it's sketchy
        // so we won't go 'bare bones' on it, but show it right of control panel.
        else if( window.ActiveXObject && document.addEventListener  ){
            agileExpertEdit.state.setBrowser('ie9');
        }
        return compatible;
    }
}