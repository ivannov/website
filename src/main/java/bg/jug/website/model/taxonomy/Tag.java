package bg.jug.website.model.taxonomy;

import java.util.HashSet;
import java.util.Set;

import bg.jug.website.model.cms.Page;
import bg.jug.website.model.core.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Tag extends AbstractEntity {
	private String name;

	@ManyToMany(mappedBy = "tags")
	private Set<Page> pages = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}
}
