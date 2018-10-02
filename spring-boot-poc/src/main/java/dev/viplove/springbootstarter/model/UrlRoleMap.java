package dev.viplove.springbootstarter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlRoleMap {

	@Id
	@Column(name="URL_ROLE_ID")
	public int urlRoleId;
	
	@Column(name="URL")
	public String url;
	
	@Column(name="ROLE")
	public String role;

	public int getUrlRoleId() {
		return urlRoleId;
	}

	public void setUrlRoleId(int urlRoleId) {
		this.urlRoleId = urlRoleId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
