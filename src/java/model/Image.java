/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bunny
 */
public class Image {

    private String name;
    private String description;
    private String author;
    private String category;
    private String comment;
    private int approved;
    private Date uploaddate;
    private String base64Image;

    public Image() {
    }

    public Image(String name, String description, String author, String category, String comment, int approved, Date uploaddate, String base64Image) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.category = category;
        this.comment = comment;
        this.approved = approved;
        this.uploaddate = uploaddate;
        this.base64Image = base64Image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public String getUploaddate() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = dateFormat1.format(uploaddate);
        return date1;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "Image{" + "name=" + name + ", description=" + description + ", author=" + author + ", category=" + category + ", comment=" + comment + ", approved=" + approved + ", uploaddate=" + uploaddate + ", base64Image=" + base64Image + '}';
    }

}
