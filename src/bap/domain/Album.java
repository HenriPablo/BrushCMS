/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tomek
 */
@Entity
@javax.persistence.SequenceGenerator(
	name="album_id_seq",
	sequenceName="album_id_seq"
)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="album")
public class Album implements Serializable, DomainObject {

	private static final long serialVersionUID = -6707019705303579311L;

	private int id;
	
	private String name;
	private String description;

	private Set<Image> images = new HashSet<Image>(0);

	/**
	 * @return the id
	 */@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="album_id_seq")
	@Column(name="id", insertable=false)
 public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */ public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */ public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */ public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */ public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */ public void setDescription(String description) {
		this.description = description;
	}


	 @ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable( name="album_image", joinColumns={ @JoinColumn(name="album_id")},  inverseJoinColumns={ @JoinColumn( name="image_id")})
	 public Set<Image> getImages(){
		 return images;
	 }
	 
	 public void setImages( Set<Image> images ) { this.images = images; }

}
