package com.esraa.hp.booksapp;


public class BookDetails {

    private String title;
    private String author;
    private int imageId;
    private float ratingBar;

    public BookDetails(String title,String author,int imageId,float ratingBar){
        this.title=title;
        this.author=author;
        this.imageId=imageId;
        this.ratingBar=ratingBar;
    }
    public String getTitle(){
        return  title;
    }
   public String getAuthor(){
        return author;
   }
   public int getImageId(){
       return imageId;
   }
   public float getRatingBar(){
       return ratingBar;
   }

}
