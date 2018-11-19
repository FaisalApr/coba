package com.example.msi.cloneig;

/**
 * Created by MSI on 23/10/2018.
 */

public class userModel {
    String email, nama, username, password;
    public userModel() {

    }

    public userModel(String email, String nama, String username, String password) {
        this.email= email;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nama) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
