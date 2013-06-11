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
 * @author tomaszbrymora
 */
@Entity
@javax.persistence.SequenceGenerator(
	name="image_id_seq",
	sequenceName="image_id_seq"
)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE )
@Table( name = "image" )
public class Image implements Serializable, DomainObject  {

private static final long serialVersionUID = -5323335702067723307L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "image_id_seq")
	@Column(name = "id", insertable = false)
	private int id = 0;
	private String src = "image_name";
	private String alt = "alternative text";
	private String description = "Image description";

    private static final int INT_DEFAULT_100 = 100;
    private int width = INT_DEFAULT_100;
	private int height = INT_DEFAULT_100;

	@ManyToMany(mappedBy="images")
	private List <Album> albums;

//    @ManyToOne( cascade = CascadeType.ALL)
//    private ContentPage contentPage;
//    public void setContentPage( ContentPage contentPage){
//        this.contentPage = contentPage;
//    }
//    public ContentPage getContentPage(){
//        return this.contentPage;
//    }

	/** * @return the id */
	public int getId() {
		return id;
	}

	/** * @param id the id to set */
	public void setId(int id) {
		this.id = id;
	}

	/** * @return the src */
	public String getSrc() {
		return src;
	}

	/** * @param src the src to set */
	public void setSrc(String src) {
		this.src = src;
	}

	/** * @return the alt */
	public String getAlt() {
		return alt;
	}

	/** * @param alt the alt to set */
	public void setAlt(String alt) {
		this.alt = alt;
	}

	/** * @return the description */
	public String getDescription() {
		return description;
	}

	/** * @param description the description to set */
	public void setDescription(String description) {
		this.description = description;
	}

	/** * @return the width */
	public int getWidth() {
		return width;
	}

	/** * @param width the width to set */
	public void setWidth(int width) {
		this.width = width;
	}

	/** * @return the height */
	public int getHeight() {
		return height;
	}

	/** * @param height the height to set */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the albums
	 */
	public List<Album> getAlbums() {
		return albums;
	}

	/**
	 * @param albums the albums to set
	 */
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}


}
