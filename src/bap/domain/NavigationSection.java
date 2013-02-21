/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tomaszbrymora
 */
@Entity
@javax.persistence.SequenceGenerator(name="navigation_section_id_seq", sequenceName="navigation_section_id_seq")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="navigation_section")

public class NavigationSection implements Serializable, DomainObject {
	private static final long serialVersionUID = -4115000340081866526L;

	private int id;

	private String label;
	private String href;
	private Navigation navigation;

	/*
	 * reference about swapping array elements for ordering navigation elements display order
	 * http://www.java-examples.com/swap-elements-java-arraylist-example
	 *
	 */
	private Set<ContentPage> contentPages = new HashSet<ContentPage>();

	/**
	 * @return the contentPages
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="navigationSection")
	@Cascade( value={ CascadeType.SAVE_UPDATE })
	public Set<ContentPage> getContentPages() {
		return this.contentPages;
	}

	/**
	 * @param contentPages the contentPages to set
	 */
	public void setContentPages(Set<ContentPage> contentPages) {
		this.contentPages = contentPages;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="navigation_section_id_seq")
	@Column(name="id", insertable=false)
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	@Column(name="label")
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the href
	 */
	@Column( name="href")
	public String getHref() {
		return href;
	}

	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the navigation
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="navigation_id")
	public Navigation getNavigation() {
		return navigation;
	}

	/**
	 * @param navigation the navigation to set
	 */
	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}




}
