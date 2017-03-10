package com.itmuch.cloud.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author bjxiaojian
 * @Date 2017/3/10
 * @Description
 */
@Entity
public class User
{

  public User(Long id, String username) {
    super();
    this.id = id;
    this.username = username;
  }

  public User() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String username;

  @Column
  private String name;

  @Column
  private Short age;

  @Column
  private BigDecimal balance;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Short getAge() {
    return this.age;
  }

  public void setAge(Short age) {
    this.age = age;
  }

  public BigDecimal getBalance() {
    return this.balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}
