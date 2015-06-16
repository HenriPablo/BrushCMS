/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tomek
 */
@Entity
@javax.persistence.SequenceGenerator(name = "content_page_id_seq",
sequenceName = "content_page_id_seq")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "content_page")
@Indexed

public class ContentPage implements Serializable, DomainObject {

	private static final long serialVersionUID = -2165847155266648763L;
	private int id;
    // limit to 70 characters
	private String metaDescription = "default description";
	private String metaKeywords = "default meta tags";



	private NavigationSection navigationSection;
	private String title = "temp title";
	private String subTitle = "default subtitle";
	private String content = "default content";

    private Image mainPix;

	private Set<Album> albums = new HashSet<Album>(0);
	private Set<Tag> tags = new HashSet<Tag>(0);
	private boolean allowComments;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Timestamp modified = new Timestamp(System.currentTimeMillis());
	private String linkHref = "some_link_href";
	private String linkLabel = "default link label";
	private boolean completion = false;
	private int contentPageDisplayOrder;

	/**
	 * Get the value of navigationSection
	 *
	 * @return the value of navigationSection
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "navigation_section_id", nullable = true)
	public NavigationSection getNavigationSection() {
		return this.navigationSection;
	}

	/**
	 * Set the value of navigationSection
	 *
	 * @param navigationSection new value of navigationSection
	 */
	public void setNavigationSection(NavigationSection navigationSection) {
		this.navigationSection = navigationSection;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "content_page_id_seq")
	@Column(name = "id", insertable = false)
	/** @return the id */
	public int getId() {
		return id;
	}

	/** @param id the id to set */
	public void setId(int id) {
		this.id = id;
	}

	/** @return the title */
	@Column(name = "title")
    @Field(store = Store.YES)
	public String getTitle() {
		return title;
	}

	/** @param title the title to set */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setSubTitle(String subtitle) {
		this.subTitle = subtitle;
	}

	@Column(name = "sub_title")
	public String getSubTitle() {
		return this.subTitle;
	}

	/** @return the metaDescription */
	@Column(name = "meta_description")
	@Basic(fetch = FetchType.LAZY, optional = true)
	public String getMetaDescription() {
		return metaDescription;
	}

	/** @param metaDescription the metaDescription to set */
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	/** @return the metaKeywords */
	@Column(name = "meta_keywords")
	@Basic(fetch = FetchType.LAZY)
	public String getMetaKeywords() {
		return metaKeywords;
	}

	/** @param metaTags the metaKeywords to set */
	public void setMetaKeywords(String metaTags) {
		this.metaKeywords = metaTags;
	}

	/** @return the content */
	@Column(name = "content")
	@Basic(fetch = FetchType.LAZY)
    @Field(store = Store.YES)
	public String getContent() {
		return content;
	}

	/** @param content the content to set */
	public void setContent(String content) {
		this.content = content;
	}


    public  void setMainPix( Image mainPix ){
        this.mainPix = mainPix;
    }
    @ManyToOne( cascade =  CascadeType.ALL)
    @JoinTable( name = "content_page_main_pix", joinColumns = {
            @JoinColumn( name = "content_page_id")}, inverseJoinColumns = {
            @JoinColumn( name = "main_pix_id")
    })
    public Image getMainPix(){
        return this.mainPix;
    }

	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable( name= "content_page_album", joinColumns = {
		@JoinColumn( name="content_page_id")}, inverseJoinColumns ={
		@JoinColumn( name="album_id" ) } )
	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums( Set<Album> albums ) {
		this.albums = albums;
	}

	/**
	 * Get the value of tags
	 * @return the value of tags
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "content_page_tag", joinColumns = {
	@JoinColumn(name = "content_page_id")}, inverseJoinColumns = {
	@JoinColumn(name = "tag_id")})
	public Set<Tag> getTags() {
		return tags;
	}

	/**
	 * Set the value of tags
	 *
	 * @param tags new value of tags
	 */
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void setAllowComments(boolean set) {
		this.allowComments = set;
	}

	@Column(name = "allow_comments")
	@Basic(fetch = FetchType.LAZY)
	public boolean getAllowComments() {
		return this.allowComments;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "content_page_comment", joinColumns = {
	@JoinColumn(name = "content_page_id")}, inverseJoinColumns = {
	@JoinColumn(name = "comment_id")})
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void setCompletion(boolean completion) {
		this.completion = completion;
	}

	@Column(name = "completion")
	@Basic(fetch = FetchType.LAZY)
	public boolean getCompletion() {
		return this.completion;
	}

	/**  @return the modified*/
	@Column(name = "modified")
	@Basic(fetch = FetchType.LAZY)
	public Timestamp getModified() {
		return modified;
	}

	/**  @param modified the modified to set*/
	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	/**  @return the linkHref */
	@Column(name = "link_href", nullable = true)
	public String getLinkHref() {
		return linkHref;
	}

	/**  @param linkHref the linkHref to set */
	public void setLinkHref(String linkHref) {
		this.linkHref = linkHref;
	}

	/** @return the linkLabel */
	@Column(name = "link_label")
	public String getLinkLabel() {
		return linkLabel;
	}

	/**  @param linkLabel the linkLabel to set */
	public void setLinkLabel(String linkLabel) {
		this.linkLabel = linkLabel;
	}

	/**  @return the positionOrder */
	@Column(name = "content_page_display_order", insertable = true, updatable = true)
	@Basic(fetch = FetchType.LAZY)
	public int getContentPageDisplayOrder() {
		return contentPageDisplayOrder;
	}

	/**
	 * @param contentPageDisplayOrder the positionOrder to set
	 */
	public void setContentPageDisplayOrder(int contentPageDisplayOrder) {
		this.contentPageDisplayOrder = contentPageDisplayOrder;
	}
}
