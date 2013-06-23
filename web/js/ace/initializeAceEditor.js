/**
 * Created with IntelliJ IDEA.
 * User: tbrymora
 * Date: 2/12/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 *
 * Let's initialize Ace editor only for browsers that can handle it properly:
 * IE9+, FF, Chrome
 */

editor = ace.edit("editor");
ace.config.set( "workerPath", "js/source-editor/src-min-noconflict");
editor.setTheme("ace/theme/cobalt");
editor.getSession().setMode("ace/mode/css");
