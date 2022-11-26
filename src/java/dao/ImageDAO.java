/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import model.Image;

public class ImageDAO extends DBContext {

    public ArrayList<Image> getAllImage() {
        ArrayList ArrayImage = new ArrayList();

        try {
            String sql = "SELECT * FROM image";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String comment = rs.getString("comment");
                int approved = rs.getInt("approved");
                Date uploaddate = rs.getDate("uploaddate");
                Blob blob = rs.getBlob("image");

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                image.setName(name);
                image.setAuthor(author);
                image.setDescription(description);
                image.setCategory(category);
                image.setComment(comment);
                image.setUploaddate(uploaddate);
                image.setApproved(approved);
                image.setBase64Image(base64Image);
                ArrayImage.add(image);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return ArrayImage;
    }

    public ArrayList<Image> getAllImageByUser(String username) {
        ArrayList ArrayImage = new ArrayList();
        try {
            String sql = "SELECT * FROM image where author = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String comment = rs.getString("comment");
                int approved = rs.getInt("approved");
                Date uploaddate = rs.getDate("uploaddate");
                Blob blob = rs.getBlob("image");

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                image.setName(name);
                image.setAuthor(author);
                image.setDescription(description);
                image.setCategory(category);
                image.setComment(comment);
                image.setUploaddate(uploaddate);
                image.setApproved(approved);
                image.setBase64Image(base64Image);
                ArrayImage.add(image);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return ArrayImage;
    }

    public Image getAllImageByName(String name) {
        Image image = null;
        try {
            String sql = "SELECT * FROM image where name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                image = new Image();
                String name2 = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String comment = rs.getString("comment");
                int approved = rs.getInt("approved");
                Date uploaddate = rs.getDate("uploaddate");
                Blob blob = rs.getBlob("image");

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                image.setName(name);
                image.setAuthor(author);
                image.setDescription(description);
                image.setCategory(category);
                image.setComment(comment);
                image.setUploaddate(uploaddate);
                image.setApproved(approved);
                image.setBase64Image(base64Image);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }

    public ArrayList<Image> getAllImageByApproved() {
        ArrayList ArrayImage = new ArrayList();

        try {
            String sql = "SELECT * FROM image where approved = 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String comment = rs.getString("comment");
                int approved = rs.getInt("approved");
                Date uploaddate = rs.getDate("uploaddate");
                Blob blob = rs.getBlob("image");

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                image.setName(name);
                image.setAuthor(author);
                image.setDescription(description);
                image.setCategory(category);
                image.setComment(comment);
                image.setUploaddate(uploaddate);
                image.setApproved(approved);
                image.setBase64Image(base64Image);
                ArrayImage.add(image);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return ArrayImage;
    }

    public ArrayList<Image> searchImages(String keyword) {
        ArrayList ArrayImage = new ArrayList();
        try {
            String sql = "SELECT * FROM image where name like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                String category = rs.getString("category");
                String comment = rs.getString("comment");
                int approved = rs.getInt("approved");
                Date uploaddate = rs.getDate("uploaddate");
                Blob blob = rs.getBlob("image");

                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                image.setName(name);
                image.setAuthor(author);
                image.setDescription(description);
                image.setCategory(category);
                image.setComment(comment);
                image.setUploaddate(uploaddate);
                image.setApproved(approved);
                image.setBase64Image(base64Image);
                ArrayImage.add(image);
            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return ArrayImage;
    }

    public void postImage(String name, String description, String author, String category, String comment, String approved, InputStream image, String uploaddate) {
        try {
            String sql = "INSERT INTO project.dbo.image values (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setBlob(2, image);
            statement.setString(3, description);
            statement.setString(4, author);
            statement.setString(5, category);
            statement.setString(6, comment);
            statement.setString(7, approved);
            statement.setString(8, uploaddate);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);;
        }
    }

    public void deleteImageByUsername(String author) {
        try {
            String query = "delete from image where name= ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, author);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ImageDAO dao = new ImageDAO();
        ArrayList<Image> images = new ArrayList<>();
        images = dao.searchImages("he");
        for (Image image : images) {
            System.out.println(image.getName());
        }
    }
}

//public ArrayList<Image> searchImages(String keyword) {
//        ArrayList ArrayImage = new ArrayList();
//        try {
//            String sql = "SELECT * FROM image where name Like %?%\n"
//                    + "                    or description Like %?%\n"
//                    + "                    or author Like %?%\n"
//                    + "                    or category Like %?%\n"
//                    + "                    or comment Like %?%\n"
//                    + "                    or uploaddate Like %?%";
//
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, keyword);
//            statement.setString(2, keyword);
//            statement.setString(3, keyword);
//            statement.setString(4, keyword);
//            statement.setString(5, keyword);
//            statement.setString(6, keyword);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Image image = new Image();
//                String name = rs.getString("name");
//                String author = rs.getString("author");
//                String description = rs.getString("description");
//                String category = rs.getString("category");
//                String comment = rs.getString("comment");
//                int approved = rs.getInt("approved");
//                Date uploaddate = rs.getDate("uploaddate");
//                Blob blob = rs.getBlob("image");
//
//                InputStream inputStream = blob.getBinaryStream();
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                byte[] buffer = new byte[4096];
//                int bytesRead = -1;
//
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//
//                byte[] imageBytes = outputStream.toByteArray();
//                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//                inputStream.close();
//                outputStream.close();
//
//                image.setName(name);
//                image.setAuthor(author);
//                image.setDescription(description);
//                image.setCategory(category);
//                image.setComment(comment);
//                image.setUploaddate(uploaddate);
//                image.setApproved(approved);
//                image.setBase64Image(base64Image);
//            }
//
//        } catch (SQLException | IOException ex) {
//            ex.printStackTrace();
//        }
//        return ArrayImage;
//    }
