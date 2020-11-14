package com.cenfotec.crud.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.text.ParseException;

@Entity
public class Antology {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;	

	@Column(name = "name")
	private String name;
	
	
	@Column(name = "description")
	private String description;
	

	@Column(name = "date")
	private Date date;
	
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="anthology")
	private Set<Article> articles;

	
	
	
	
	
	public String getCreatedAsShort() {
		return format.format(date);
	}

	public Antology(String name, String description, String date) throws ParseException {
		this.name = name;
		this.description = description;
		this.date = format.parse(date);
	}
	
	
	public Antology(){
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}


	public SimpleDateFormat getFormat() {
		return format;
	}

	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "Antology [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", format="
				+ format + ", articles=" + articles + "]";
	}
	
	
	
}
