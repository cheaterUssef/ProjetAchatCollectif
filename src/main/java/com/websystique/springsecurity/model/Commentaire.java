package com.websystique.springsecurity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="commentaire")
public class Commentaire implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@NotEmpty
    @Column(name="contenu", nullable=false)
    private String contenu;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Sujet sujet;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	@Column(name="date_creation", nullable=false)
	private Date date_creation;

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", contenu=" + contenu + ", user=" + user + ", sujet=" + sujet
				+ ", date_creation=" + date_creation + "]";
	}
}
