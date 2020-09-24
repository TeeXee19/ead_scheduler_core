package com.interra.ead_scheduler_core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "other_name")
    @NotEmpty(message = "*Please provide your last name")
    private String otherName;

    @Column(name = "user_name")
    @Length(min = 5, message = "*Your user name must have at least 5 characters")
    @NotEmpty(message = "*Please provide a user name")
    private String userName;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "phone_number")
    @Pattern(regexp = "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$", message="{invalid.phonenumber}")
    private String phoneNumber;

    @Column(name = "skill")
    private String skill;

    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @Column(name = "activation_token")
    private String activationToken;

    @Column(name = "status")
    private Boolean status;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	

	public void setPassword(String password) {
        this.password = password;
	}

	public void setActive(boolean b) {
        this.status = b;
	}

	public void setRoles(HashSet<Role> hashSet) {
        this.roles = hashSet;
	}

    public Set<Role> getRoles() {
            return roles;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public boolean getActive() {
            return false;
        }
}
