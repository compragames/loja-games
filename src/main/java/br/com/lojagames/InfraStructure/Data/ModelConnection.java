/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.InfraStructure.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class ModelConnection {

    private static final String SERVER = "localhost:3306";
    private static final String DATABASE = "LOJAGAMES";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection conectorProd() {

        //prod
        String url = "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_026278d55fe820e?reconnect=true";
        String user = "b86fa231ebd27f";
        String password = "99b523ce";

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static Connection conectorDev() {

        //dev
        String url = "jdbc:mysql://" + SERVER + "/" + DATABASE + "?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
