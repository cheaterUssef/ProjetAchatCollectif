package com.websystique.springsecurity.model;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="APP_USER")
public class User implements Serializable{
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @NotEmpty
    @Column(name="SSO_ID", unique=true, nullable=false)
    private String ssoId;
     
    @NotEmpty
    @Column(name="PASSWORD", nullable=false)
    private String password;
         
    @NotEmpty
    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;
 
    @NotEmpty
    @Column(name="LAST_NAME", nullable=false)
    private String lastName;
 
    @NotEmpty
    @Column(name="EMAIL", nullable=false)
    private String email;
 
//    @NotEmpty
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "APP_USER_USER_PROFILE", 
//             joinColumns = { @JoinColumn(name = "USER_ID") },
//             inverseJoinColumns = { @JoinColumn(name = "userProfiles_id") })
//    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
    
    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
    
    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private List<Sujet> sujets = new ArrayList<Sujet>();
    
    @ManyToMany(mappedBy="adherents", fetch = FetchType.EAGER)
    private Set<Sujet> sujets_adheres = new HashSet<Sujet>();
 
    public Set<Sujet> getSujets_adheres() {
		return sujets_adheres;
	}

	public void setSujets_adheres(Set<Sujet> sujets_adheres) {
		this.sujets_adheres = sujets_adheres;
	}

	public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getSsoId() {
        return ssoId;
    }
 
    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
//    public Set<UserProfile> getUserProfiles() {
//        return userProfiles;
//    }
// 
//    public void setUserProfiles(Set<UserProfile> userProfiles) {
//        this.userProfiles = userProfiles;
//    }

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public void setSujets(List<Sujet> sujets) {
		this.sujets = sujets;
	}
	
	public List<Sujet> getSujets() {
		return sujets;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ssoId == null) {
            if (other.ssoId != null)
                return false;
        } else if (!ssoId.equals(other.ssoId))
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userProfiles=" + userProfiles + "]";
	}


    /*
     * DO-NOT-INCLUDE passwords in toString function.
     * It is done here just for convenience purpose.
     */
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", ssoId=" + ssoId + ", firstName=" + firstName + ", lastName=" + lastName
//				+ ", email=" + email + ", userProfiles=" + userProfiles + ", sujets=" + sujets + "]";
//	}
    
    
}