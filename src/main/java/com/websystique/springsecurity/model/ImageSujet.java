package com.websystique.springsecurity.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="IMAGE_SUJET")
public class ImageSujet implements Serializable{
 
	  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id; 
	     
	    @Column(name="name", length=100, nullable=false)
	    private String name;
	     	
	    @Column(name="type", length=100, nullable=false)
	    private String type;
	     
	    @Lob @Basic(fetch = FetchType.LAZY)
	    @Column(name="content", nullable=false)
	    private byte[] content;
	    
		@ManyToOne(optional = false)
	    @JoinColumn(name = "Sujet")
	    private Sujet sujet;

	public Sujet getSujet() {
			return sujet;
		}

		public void setSujet(Sujet sujet) {
			this.sujet = sujet;
		}

	public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public byte[] getContent() {
			return content;
		}

		public void setContent(byte[] content) {
			this.content = content;
		}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        ImageSujet other = (ImageSujet) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "ImageSujet [id=" + id + ", name=" + name + "]";
	}
}
