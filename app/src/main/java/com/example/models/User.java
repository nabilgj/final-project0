package com.example.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String type;

    private boolean approved;

    private Set<User> following;
    private Set<User> followers;
    private List<Post> posts;

    public User() {
    }

    public User(int userid, String firstname, String lastname, String email, String password, String type, Boolean approved, Set<User> following, Set<User> follower, List<Post> posts) {
        this.userId = userid;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.type = type;
        this.approved = approved;
        this.following = following;
        this.followers = follower;
        this.posts = posts;
    }

    // a special contructor for use in the dao

    public User(int user_id, String firstname, String lastname, String email, String password, String type, Boolean approved) {
        this.userId = user_id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.type = type;
        this.approved = approved;

        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    // getters and setters

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int user_id) {
        this.userId = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getApproved() { return approved; }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    // toString

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", approved='" + approved + '\'' +
                ", following=" + following +
                ", followers=" + followers +
                ", posts=" + posts +
                '}';
    }
}
