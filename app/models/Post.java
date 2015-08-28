package models;

import play.db.jpa.*;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Post extends Model {

	public String title;
	public Date postedAt;
	
	@Lob
	public String content;
	
	/**
	 * @ManyToOne
	 * 
	 * means that each Post is authored by a single User, 
	 * 
	 * and that each User can author several Post instances.
	 */
	@ManyToOne
	public User author;

	public Post(User author, String title, String content) {
		this.author = author;
		this.title = title;
		this.content = content;
		this.postedAt = new Date();
	}	
}
