package com.run.authentication.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username")
})
public class User implements Serializable {
	private static final long serialVersionUID = -402325494944926497L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String username;
	private String password;
	private Boolean enabled;
	private Boolean accountExpired;
	private Boolean accountLocked;
	private Boolean credentialsExpired;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private UserDetails details;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Role> roles; 
}
