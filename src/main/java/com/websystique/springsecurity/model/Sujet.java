package com.websystique.springsecurity.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SUJET")
public class Sujet implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@NotEmpty
	@Column(name="name", length=30, nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="description", length=300, nullable=false)
	private String description;

	@NotNull
    @Column(name="prix_original", nullable=false)
	private Double prix_original;
	
//	@NotNull
    @Column(name="prix_diminue", nullable=false)
	private Double prix_diminue;
	
	@NotNull
    @Column(name="nombre_adherent", nullable=false)
	private Integer nombre_adherent;
	
	@NotNull
    @Column(name="nombre_max_adherent", nullable=false)
	private Integer nombre_max_adherent;
	
	@NotNull
    @Column(name="taux_reduction", nullable=false)
	private Integer taux_reduction;
	
//	@NotEmpty
	@ManyToOne
	private User user;
	
	@NotNull
    @Column(name="duree_validite", nullable=false)
	private Integer duree_validite;
	
//	@NotEmpty
//    @Column(name="isVisible", nullable=false)
//	private Boolean isVisible;
	
//	@NotEmpty
	@ManyToOne(fetch = FetchType.EAGER)
	private SujetType sujet_type;
    
//    @NotEmpty
//    @ManyToMany(fetch = FetchType.LAZY)
//    private Set<SujetType> sujetTypes = new HashSet<SujetType>();
	
//	@NotEmpty
//	@OneToOne
//	private ImageSujet image;
	
	@Column(name="date_creation", nullable=false)
	private Date date_creation;
	
	@OneToMany(mappedBy="sujet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Commentaire> Commentaires = new HashSet<Commentaire>();

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
	public Set<Commentaire> getCommentaires() {
		return Commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		Commentaires = commentaires;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public SujetType getType() {
//		return type;
//	}
//
//	public void setType(SujetType type) {
//		this.type = type;
//	}

	public SujetType getSujet_type() {
		return sujet_type;
	}

	public void setSujet_type(SujetType sujet_type) {
		this.sujet_type = sujet_type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Set<SujetType> getSujetTypes() {
//		return sujetTypes;
//	}
//
//	public void setSujetTypes(Set<SujetType> sujetTypes) {
//		this.sujetTypes = sujetTypes;
//	}

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

	public Double getPrix_original() {
		return prix_original;
	}

	public void setPrix_original(Double prix_original) {
		this.prix_original = prix_original;
	}

	public Double getPrix_diminue() {
		return prix_diminue;
	}

	public void setPrix_diminue(Double prix_diminue) {
		this.prix_diminue = prix_diminue;
	}

	public Integer getNombre_adherent() {
		return nombre_adherent;
	}

	public void setNombre_adherent(Integer nombre_adherent) {
		this.nombre_adherent = nombre_adherent;
	}

	public Integer getNombre_max_adherent() {
		return nombre_max_adherent;
	}

	public void setNombre_max_adherent(Integer nombre_max_adherent) {
		this.nombre_max_adherent = nombre_max_adherent;
	}

	public Integer getTaux_reduction() {
		return taux_reduction;
	}

	public void setTaux_reduction(Integer taux_reduction) {
		this.taux_reduction = taux_reduction;
	}

//	public Date getDate_expiration() {
//		return date_expiration;
//	}
//
//	public void setDate_expiration(Date date_expiration) {
//		this.date_expiration = date_expiration;
//	}

//	public Boolean getIsVisible() {
//		return isVisible;
//	}
//
//	public void setIsVisible(Boolean isVisible) {
//		this.isVisible = isVisible;
//	}
//
//	public ImageSujet getImage() {
//		return image;
//	}
//
//	public void setImage(ImageSujet image) {
//		this.image = image;
//	}

	public Integer getDuree_validite() {
		return duree_validite;
	}

	public void setDuree_validite(Integer duree_validite) {
		this.duree_validite = duree_validite;
	}

	@Override
	public String toString() {
		return "Sujet [id=" + id + ", name=" + name + ", description=" + description + ", prix_original="
				+ prix_original + ", prix_diminue=" + prix_diminue + ", nombre_adherent=" + nombre_adherent
				+ ", nombre_max_adherent=" + nombre_max_adherent + ", taux_reduction=" + taux_reduction + ", user="
				+ user + ", duree_validite=" + duree_validite + ", sujet_type=" + sujet_type + ", date_creation="
				+ date_creation + "]";
	}
}
