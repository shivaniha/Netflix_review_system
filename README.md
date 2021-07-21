# Netflix_Review_System

This project allows you to select your best netflix movies and rate them as per your opinion. 
Many people just go by the imdb score but this project takes the viewers and critics opinion to judge the movie and rate them out of 10. This program sort the movies according to the average rating given by the viewer and crictic. Also we can get the info about the latest movies coming up next.

## Project details: 
netflix package - movie.java
p1 package - Subscription.java

## ---Movie.java file---
Classes used
Netflix class - super class
*Takes the movie name,genre, release year,count also has displayMovies() method to display the details entered.

prevBest- inherited class from Netflix
*Displays prev months best movies by displayMovies () method.

reviews-Abstract class 
*Has two methods
Abstract method- showImdbRating()
Normal Method- falseComments()

imdb- inherited from reviews
*Takes the imdb rating and displays thats rating by showImdbRating() method.

info- interface
*Has a method show().

info1- implements info interface
*Has the  body of method show()- Displays personal information.

release - extends Thread class
*Takes a list of new releasing movies and displays it one by one whenever the movie releases.

user class- Takes the name of new user.

Sorting of the movies in descending order is done in the public static void main() and then displayed as per rank.

Also a package p1 which has a Subscription class which is used in the netflix package- movie.java file to show the subscription price of netflix by calling its message() method.


Repository link- https://github.com/shivaniha/Netflix_review_system
Name - Shivani L H
