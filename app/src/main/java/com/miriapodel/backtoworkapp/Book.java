package com.miriapodel.backtoworkapp;

public class Book {

    private int id;

    private int pages;

    private String bookCoverURL;

    private String bookTitle;

    private String authorName;

    private String shortDescription;

    private String longDescription;

    private Boolean isExpanded;

    public Book(int id, int pages,  String bookCoverURL, String bookTitle, String authorName, String shortDescription, String longDescription) {
        this.id = id;
        this.pages = pages;
        this.bookCoverURL = bookCoverURL;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;

        isExpanded= false;
    }

    public Boolean getExpanded() {
        return isExpanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setExpanded(Boolean expanded) {
        isExpanded = expanded;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getBookCoverURL() {
        return bookCoverURL;
    }

    public void setBookCoverURL(String bookCoverURL) {
        this.bookCoverURL = bookCoverURL;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
