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
 public final class ViewBuilder {

    private static final String ADMIN_LAYOUT = "admin/layout";
    private String layout = ADMIN_LAYOUT;
		private String section = "";

	private static Map<String, Object> viewParts = new HashMap<String, Object>();

	/**
	 * @return the layout
	 */ public String getLayout() {
		return layout;
	}

	/**
	 * @param layout the layout to set
	 */ public void setLayout(String layout) {
		this.layout = layout;
	}

	/**
	 * @return the section
	 */ public String getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */ public void setSection(String section) {
		this.section = section;
	}

	public static class Builder{
		
		// required params
		private String layout;
		private String section;

		// optional params
		private Map<String, Object > viewParts = new HashMap<String, Object >();

		public Builder(){

				this.layout = ADMIN_LAYOUT;
				viewParts.put("layout", ADMIN_LAYOUT);

		}
		public Builder( String layout ){

			if( layout != null ){
				this.layout = layout;
				viewParts.put("layout", layout );
			} else {
				this.layout = ADMIN_LAYOUT;
				viewParts.put("layout", ADMIN_LAYOUT);
			}

		}// constructor
		public Builder modelPart( String val, Object o ){
			this.viewParts.put(val, o );
			return this;
		}

		public Builder action( String val ){
			this.viewParts.put("action", val);
			return this;
		}
		public Builder element( String val ){
			this.viewParts.put("element", val);
			return this;
		}
		public Builder section( String val ){
			this.section = val;
			this.viewParts.put("section", val);
			return this;
		}
		public Builder page( String val ){
			this.viewParts.put("page", val);
			return this;
		}
		public Builder layout( String val ){
			this.layout = val;
			return this;
		}

		public ViewBuilder build( ){
			return new ViewBuilder( this );
		}


	}// Builder

		private ViewBuilder(Builder builder){
			this.section = builder.section;
			this.layout = builder.layout;

			viewParts = builder.viewParts;
		}

	/**
	 * Get the value of viewParts
	 *
	 * @return the value of viewParts
	 */
	public static Map<String, Object> getViewParts() { return viewParts; }

	/**
	 * Set the value of viewParts
	 *
	 * @param viewParts new value of viewParts
	 */
	public void setViewParts(Map<String, Object> viewParts) { this.viewParts = viewParts; }
}
