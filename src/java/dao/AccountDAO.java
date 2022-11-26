/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author bunny
 */
public class AccountDAO extends DBContext {

    public Account Login(String email, String password) {
        try {
            String sql = "select * from account where email = ? and password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString("username"), rs.getString("password"), rs.getString("phone"), rs.getString("role"), rs.getString("email"));
                return a;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Account> listAcc() {
        ArrayList acc = new ArrayList();

        try {
            String sql = "select * from account ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getString("username"), rs.getString("password"), rs.getString("phone"), rs.getString("role"), rs.getString("email"));
                acc.add(a);
            }
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertAccount(String username, String email, String password, String phone) {
        String role = "user";
        try {
            String sql = "INSERT [dbo].[account] ([username], [email], [password], [phone], [role]) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phone);
            statement.setString(5, role);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccountByUsername(String author) {

        try {
            String query = "delete * from image where author= ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, author);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String query = "delete from account where username= ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, author);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.insertAccount("Hello anh em 2", "duypdhe1414212@fpt.edu.vn", "123", "0365614999");
    }
}
