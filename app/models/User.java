package models;

import javax.persistence.Entity;
import java.util.*;

import play.db.jpa.*;

@Entity
public class User extends Model {

	public String email;
	public String password;
	public String fullname;
	public boolean isAdmin;

	public User(String email, String password, String fullname) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}
	
	// Check if a user with a specified username and password exists.
	public static User connect(String email, String password) {
		return find("byEmailAndPassword", email, password).first();
	}
	
}
