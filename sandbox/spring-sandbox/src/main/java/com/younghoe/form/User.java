package com.younghoe.form;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by tony on 2016. 1. 26..
 */
public class User {

    private Long id;

    @NotEmpty
    private String firstName;

    private String lastName;

    private String nickName;

    private String emailAddress;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
