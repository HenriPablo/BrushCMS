/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author tomek
 */
@Entity
@javax.persistence.SequenceGenerator(name = "comment_id_seq",
sequenceName = "comment_id_seq")

//@javax.persistence.SequenceGenerator(name="content_page_display_order_seq", sequenceName="content_page_display_order_seq")

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "comment")
public class Comment implements Serializable, DomainObject {

	private static final long serialVersionUID = 6368154294449788860L;
	private int id;
	private String commenter;
	private String email;
	private String website;
	private String body;
	private ContentPage contentPage;
	private Date enteredOn;

	/**
	 * Get the value of id
	 *
	 * @return the value of id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "comment_id_seq")
	@Column(name = "id", insertable = false)
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

	/**
	 * Get the value of website
	 *
	 * @return the value of website
	 */
	public String getWebsite() {
		return this.website;
	}

	/**
	 * Set the value of website
	 *
	 * @param newwebsite new value of website
	 */
	public void setWebsite(String newwebsite) {
		this.website = newwebsite;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getCommenter() {
		return this.commenter;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return this.body;
	}

	public void setContentPage(ContentPage contentPage) {
		this.contentPage = contentPage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "content_page_id", nullable = false)
	public ContentPage getContentPage() {
		return this.contentPage;
	}

	public void setEnteredOn(Date enteredOn) {
		this.enteredOn = enteredOn;
	}

	@Column(name = "entered_on")
	public Date getEnteredOn() {
		return this.enteredOn;
	}
}
