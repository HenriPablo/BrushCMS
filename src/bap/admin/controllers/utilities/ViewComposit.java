/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.utilities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tomaszbrymora
 */
public class ViewComposit {

	private Viewable adminViewBase;
	private String section;
	private String page;
	private String element;

	/**
	 * Get the value of element
	 *
	 * @return the value of element
	 */
	public String getElement() {
		return element;
	}

	/**
	 * Set the value of element
	 *
	 * @param element new value of element
	 */
	public void setElement(String element) {
		this.element = element;
	}

	private Map<String, String> vp = new HashMap<String, String>();

	public Map getViewProperties(ViewComposit v, String action ) {
		vp.put("js_lib", adminViewBase.getJsLib() );
		vp.put("page", this.getPage() );
		vp.put("section", this.getSection() );
		vp.put("element", this.getElement() );
		vp.put("action", action );
		return this.getVp() ;
	}
	
	public Map<String, String> getVp() {
		return vp;
	}
	public void setVp(Map<String, String> vp) {
		this.vp = vp;
	}

	/**
	 * Get the value of page
	 *
	 * @return the value of page
	 */
	public final String getPage() {
		return page;
	}

	/**
	 * Set the value of page
	 *
	 * @param page new value of page
	 */
	public final void setPage(String page) {
		this.page = page;
	}

	/**
	 * Get the value of section
	 *
	 * @return the value of section
	 */
	public final String getSection() {
		return section;
	}

	/**
	 * Set the value of section
	 *
	 * @param section new value of section
	 */
	public final void setSection(String section) {
		this.section = section;
	}

	/**
	 * Get the value of adminViewBase
	 *
	 * @return the value of adminViewBase
	 */
	public final Viewable getAdminViewBase() {
		return adminViewBase;
	}

	/**
	 * Set the value of adminViewBase
	 *
	 * @param adminViewBase new value of adminViewBase
	 */
	public final void setAdminViewBase(Viewable adminViewBase) {
		this.adminViewBase = adminViewBase;
	}



}
