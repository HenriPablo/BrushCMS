/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tomekpilot
 */
@Entity
@javax.persistence.SequenceGenerator(
	name="tags_id_seq",
	sequenceName="tags_id_seq"
)
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="tag")

public class Tag implements Serializable, DomainObject {

private static final long serialVersionUID = -5546321964365028472L;
	@ManyToMany(mappedBy = "tags")
	private List<ContentPage> contentPages;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="tags_id_seq")
	@Column(name="id", insertable=false)
	private int id;
	
	private String description = "some description";

	/**
	 * Get the value of description
	 *
	 * @return the value of description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the value of description
	 *
	 * @param description new value of description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the value of id
	 *
	 * @return the value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the value of id
	 *
	 * @param id new value of id
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString(){
		return "\n\nID: " + this.getId() + " DESCRIPTION: " + this.getDescription() + "\n\n";

	}

    public List<ContentPage> getContentPages() {
        return contentPages;
    }

    public void setContentPages(List<ContentPage> contentPages) {
        this.contentPages = contentPages;
    }
}
