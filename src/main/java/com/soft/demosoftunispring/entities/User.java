package com.soft.demosoftunispring.entities;

import com.soft.demosoftunispring.utils.Password;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

   // private String username;
    private String usernamae;
    private String password;
    private String email;
    private LocalDate registeredOn;
    private LocalDate lastLogin;
    private int age;
    private Boolean isDeleted;
    private Town bornTown;
    private Town currentlyLiving;

    private String firstName;
    private String lastName;
    private Set<User> friends =  new HashSet<>();
    private Set<Album> albums = new HashSet<>();

    public User(){}

    public User(String usernamae, String password, String email,
                LocalDate registeredOn, LocalDate lastLogin, int age, Boolean isDeleted) {
        this.usernamae = usernamae;
        this.password = password;
        this.email = email;
        this.registeredOn = registeredOn;
        this.lastLogin = lastLogin;
        this.age = age;
        this.isDeleted = isDeleted;
    }

/* @Column(name = "username")
    @Length(min = 4,max = 30)
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }*/

    @Column(name = "usernamae")
    @Length(min = 4,max = 30)
    @NotNull
    public String getUsernamae() {
        return usernamae;
    }

    public void setUsernamae(String usernamae) {
        this.usernamae = usernamae;
    }

   /* @Column(name = "password")
    @Length(min = 6,max = 50,message = "length dont match")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\\s).{8,15}$",message = "invalid password")
    */
    @Column(name = "password")
    @Password(maxValue = 12 , minValue = 5)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "username")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name= "registered_on")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in")
    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Column(name = "age")
    @Min(value = 1)
    @Max(value = 120)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }


    @Transient
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Transient
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String fullName(){
        return (this.firstName.concat(" ").concat(this.lastName));
    }



    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Transient
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }


    @Transient
    public Town getCurrentlyLiving() {
        return currentlyLiving;
    }

    public void setCurrentlyLiving(Town currentlyLiving) {
        this.currentlyLiving = currentlyLiving;
    }
}
