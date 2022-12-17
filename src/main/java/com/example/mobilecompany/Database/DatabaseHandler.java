package com.example.mobilecompany.Database;


import com.example.mobilecompany.Object.Tariff;
import com.example.mobilecompany.Object.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler  {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString ="jdbc:mysql://localhost:3306/mobilecompany?serverTimezone=Europe/Kiev&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "root", "2502");

        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert =  "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_PHONE + "," + Const.USER_EMEIL
                + "," + Const.USER_PASSWORD+")"  + "VALUES(?,?,?)";

        try {
            PreparedStatement prt = getDbConnection().prepareStatement(insert);
            prt.setString(1, user.getPhoneNumber());
            prt.setString(2, user.getEmeil());
            prt.setString(3, user.getPassword());
            prt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ResultSet getUser(User user){
        ResultSet resSet=null;
        String select ="SELECT * FROM "+ Const.USER_TABLE + " WHERE "+ Const.USER_PHONE +"=? AND "
                +Const.USER_PASSWORD +"=?";
        try {
            PreparedStatement prt = getDbConnection().prepareStatement(select);
            prt.setString(1, user.getPhoneNumber());
            prt.setString(2, user.getPassword());
            resSet= prt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }

    public ResultSet checkTariff(User user){
        ResultSet resSet=null;
        String select ="SELECT * FROM "+ Const.TARIFF_TABLE + " WHERE "+ Const.TARIFF_ID +" =? ";
        try {
            PreparedStatement prt = getDbConnection().prepareStatement(select);
            prt.setInt(1, user.getIdTariff());
            resSet= prt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }
    public int countUser() {
        ResultSet resSet = null;
        String select = "SELECT *  FROM " + Const.USER_TABLE;
        try {
            Statement prt = getDbConnection().createStatement();
            resSet = prt.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        int counter = 0;

        try {
            while (resSet.next()) {

                counter++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return counter;
    }

    public void setMoney(int money, User user){

        String alter ="UPDATE " + Const.USER_TABLE + " SET " + Const.USER_MONEY  +" =+ ? "
                + " WHERE  " + Const.USER_ID + "=?";
        try {
            PreparedStatement prt = getDbConnection().prepareStatement(alter);
            prt.setInt(1, money);
            prt.setInt(2,  user.getIdUser());
            prt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        user.setMoney(user.getMoney()+money);
    }


    public List<Tariff> checkAllTariff(){
        List<Tariff>tariffs= new ArrayList<>();
        ResultSet resSet=null;
        String select ="SELECT * FROM "+ Const.TARIFF_TABLE ;
        try {

            Statement prt = getDbConnection().createStatement();
            resSet= prt.executeQuery(select);
            while(resSet.next()){
                tariffs.add(new Tariff(resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getInt(5)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tariffs;
    }

    public Tariff checkTariffByName(String name) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.TARIFF_TABLE + " WHERE " + Const.TARIFF_NAME + "=?";
        Tariff tariff;
        try {
            tariff = null;
            PreparedStatement prt = getDbConnection().prepareStatement(select);
            prt.setString(1 ,name);
            resSet = prt.executeQuery();
            while (resSet.next()) {
                tariff = new Tariff(resSet.getInt(1),resSet.getString(2), resSet.getString(3), resSet.getString(4), resSet.getInt(5));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tariff;
    }
    public void addTariff( Tariff tar){
        String insert =  "INSERT INTO " + Const.TARIFF_NAME + "("+ Const.TARIFF_NAME   + "," + Const.TARIFF_INTERNET + "," + Const.TARIFF_MINUT
                + "," + Const.USER_PASSWORD+")"  + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prt = getDbConnection().prepareStatement(insert);
            prt.setString(1,tar.getName()) ;
            prt.setString(2, tar.getNetwork());
            prt.setString(3,tar.getMinute() );
            prt.setInt(4, tar.getPrice());
            prt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Tariff> findlTariff(String select,String value){
        List<Tariff>tariffs= new ArrayList<>();
        ResultSet resSet=null;
        try {

            PreparedStatement prt = getDbConnection().prepareStatement(select);
            prt.setString(1, value);
            resSet= prt.executeQuery();
            while(resSet.next()){

                tariffs.add(new Tariff(resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getInt(5)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tariffs;
    }
    public List<Tariff> findlTariffAllPar(String select,String name,String internet, String minute, String price){
        List<Tariff>tariffs= new ArrayList<>();
        ResultSet resSet=null;
        try {

            PreparedStatement prt = getDbConnection().prepareStatement(select);
            prt.setString(1, name);
            prt.setString(2, internet);
            prt.setString(3, minute);
            prt.setString(4, price);
            resSet= prt.executeQuery();

            while(resSet.next()){
                tariffs.add(new Tariff(resSet.getString(2), resSet.getString(3),resSet.getString(4),resSet.getInt(5)));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tariffs;
    }
}