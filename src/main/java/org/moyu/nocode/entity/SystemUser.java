package org.moyu.nocode.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "system_user")
public class SystemUser {

    public SystemUser() {
    }

    public SystemUser(long a) {
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
