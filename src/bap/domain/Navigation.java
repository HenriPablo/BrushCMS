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
import java.util.Set;

/**
 *
 * @author tomaszbrymora
 */
@Entity
@javax.persistence.SequenceGenerator(
	name="navigation_id_seq",
	sequenceName="navigation_id_seq"
)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="navigation")
public class Navigation implements Serializable, DomainObject {
	public Navigation(){}
	private static final long serialVersionUID = 3938577804803201035L;

	private int id;
    private String label;
    private String code;
	/*
	 * reference about swapping array elements for ordering navigation elements display order
	 * http://www.java-examples.com/swap-elements-java-arraylist-example
	 */

	private Set<NavigationSection> navigationSections;

	/**
	 * @return the navigationSections
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="navigation", targetEntity=NavigationSection.class)
	@Cascade( value={ CascadeType.SAVE_UPDATE, CascadeType.DELETE_ORPHAN })
	public Set<NavigationSection> getNavigationSections() {
		return navigationSections;
	}

	/**
	 * @param navigationSections the navigationSections to set
	 */
	public void setNavigationSections(Set<NavigationSection> navigationSections) {
		this.navigationSections = navigationSections;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO, generator="navigation_id_seq")
	@Column(name="id", insertable=false)
	public int getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
