package com.careerdevs.restjpahibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue
  public long id; // Could use UUID

  @Column(name = "name")
  public String name;

  @Column(name = "email")
  public String email;

  @Column(name = "favorite_color")
  public String favoriteColor;

  public User strip() {
    User result = new User();
    result.name = name;
    result.favoriteColor = favoriteColor;
    return result;
  }
}
