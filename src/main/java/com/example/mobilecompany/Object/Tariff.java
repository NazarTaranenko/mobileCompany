package com.example.mobilecompany.Object;

public class Tariff {
    protected int idTariff;
    protected String name;
    protected int price;
    protected String minute;
    protected String network;

    public Tariff(String name, String network,String minute, int  price) {

        this.name = name;
        this.price = price;
        this.minute = minute;
        this.network = network;
    }
    public Tariff(int idTariff,String name, String network,String minute, int  price) {
        this.idTariff=idTariff;
        this.name = name;
        this.price = price;
        this.minute = minute;
        this.network = network;
    }
    public Tariff(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public int getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(int idTariff) {
        this.idTariff = idTariff;
    }

    @Override
    public String toString() {
        return "Назва: " + name + " Ціна: " + price +" грн. "  +  " Інтернет: " + network + " Гб."
                + " Хвилини:" + minute + " хв.";
    }
}
