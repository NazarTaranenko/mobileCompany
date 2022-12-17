package com.example.mobilecompany.Object;

public class User {
    private int idUser;
    private  String phoneNumber;
    private  String emeil;
    private String password;

    private int money;
    private  int idTariff;

    public User(String phoneNumber, String emeil, String password) {
        this.phoneNumber = phoneNumber;
        this.emeil = emeil;
        this.password = password;
    }

    public User() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmeil() {
        return emeil;
    }

    public void setEmeil(String emeil) {
        this.emeil = emeil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(int idTariff) {
        this.idTariff = idTariff;
    }

}
