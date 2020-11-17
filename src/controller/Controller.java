/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Model;

/**
 *
 * @author user
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT ALL from table users
    public static ArrayList<Model> select() {
        ArrayList<Model> models = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM ?";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Model model = new Model();
                model(rs.getInt(""));
                model(rs.getString(""));
                model(rs.getString(""));
                model(rs.getString(""));
                model(rs.getInt(""));
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (models);
    }
    
    // SELECT WHERE
    public static Model where(String x, String y) {
        conn.connect();
        String query = "SELECT * FROM ? WHERE x='" + x + "'&&y='" + y + "'";
        Model model = new Model();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                model(rs.getInt("ID"));
                model(rs.getString("Name"));
                model(rs.getString("Address"));
                model(rs.getString("Phone"));
                model(rs.getInt("Age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (model);
    }
    
    // INSERT
    public static boolean insert(Model model) {
        conn.connect();
        String query = "INSERT INTO x VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, model);
            stmt.setString(2, model);
            stmt.setString(3, model);
            stmt.setString(4, model);
            stmt.setString(5, model);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    // UPDATE
    public static boolean update(Model model) {
        conn.connect();
        String query = "UPDATE ? SET x='" + model + "', "
                + "Address='" + model + "', "
                + "Phone='" + model + "' "
                + " WHERE ID='" + model + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // DELETE
    public static boolean delete(String x) {
        conn.connect();
        String query = "DELETE FROM ? WHERE x='" + x + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
}
