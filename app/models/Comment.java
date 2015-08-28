package models;

import play.db.jpa.Model;

import java.util.Date;
import javax.persistence.*;


@Entity
public class Comment extends Model {
	
	public String author;
	public Date postedAt;
	
	@Lob
	public String content;
	
	@ManyToOne
	public Post post;

	public Comment(Post post, String author, String content) {
		this.post = post;
		this.author = author;
		this.content = content;
		this.postedAt = new Date();
	}
}
