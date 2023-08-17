package org.moyu.nocode.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class User {

    public User() {
    }

    public User(long a) {
        this.userName = String.valueOf(a);
    }

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String passWord;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
