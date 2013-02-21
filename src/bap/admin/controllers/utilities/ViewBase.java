/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.utilities;

/**
 *
 * @author tomaszbrymora
 */
public class ViewBase implements Viewable {

	private String layout;
	private String jsLib;


	//@Override
	public final String getJsLib() {
		return jsLib;
	}


	public final void setJsLib(String jsLib) {
		this.jsLib = jsLib;
	}


	//@Override
	public final String getLayout() {
		return layout;
	}


	public final void setLayout(String layout) {
		this.layout = layout;
	}

}
