package cz.cvut.fit.shiftify.data;

import android.provider.ContactsContract;

/**
 * Created by lukas on 11.11.2016.
 */

public class User {
    public User() { }
    public User(String firstName, String surname) {
        this(firstName, surname, null, null, null);
    }
    public User(String firstName, String surname, String phoneNumber) {
        this(firstName, surname, phoneNumber, null, null);
    }
    public User(String firstName, String surname, String phoneNumber, String email) {
        this(firstName, surname, phoneNumber, email, null);
    }
    public User(String firstName, String surname, String phoneNumber, String email, String nickname) {
        this.firstName = firstName;
        this.surname = surname;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    protected Integer id;
    protected String firstName;
    protected String surname;
    protected String nickname;
    protected String phoneNumber;
    protected String email;

    // getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}