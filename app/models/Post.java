package models;

import play.db.jpa.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL)
	public List<Comment> comments;

	public Post(User author, String title, String content) {
		this.author = author;
		this.title = title;
		this.content = content;
		this.postedAt = new Date();
		this.comments = new ArrayList<Comment>();
	}
	
	public Post addComment(String author, String content) {
		Comment newComment = new Comment(this, author, content).save();
		this.comments.add(newComment);
		this.save();
		return this;
	}
}
