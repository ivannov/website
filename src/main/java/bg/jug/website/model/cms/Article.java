package bg.jug.website.model.cms;

import java.util.Date;

import bg.jug.website.model.user.User;

import javax.persistence.*;

@Entity
public class Article extends Page {

    @Temporal(TemporalType.DATE)
	private Date createdDate;

	@ManyToOne
	private User author;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
}
