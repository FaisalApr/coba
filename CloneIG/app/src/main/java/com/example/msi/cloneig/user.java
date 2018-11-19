package com.example.msi.cloneig;

/**
 * Created by MSI on 29/10/2018.
 */

public class user {
    private String nama,username,imgProfil,imgPost;

    public user(String nama, String username, String imgProfil, String impPost) {
        this.nama = nama;
        this.imgPost = impPost;
        this.username = username;
        this.imgProfil = imgProfil;
    }

    public String getImgPost() {
        return imgPost;
    }

    public void setImgPost(String imgPost) {
        this.imgPost = imgPost;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgProfil() {
        return imgProfil;
    }

    public void setImgProfil(String imgProfil) {
        this.imgProfil = imgProfil;
    }
}
