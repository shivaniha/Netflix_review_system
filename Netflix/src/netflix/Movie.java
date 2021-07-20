package netflix;

import java.util.*;
import p1.*; //Importing package

class user
{
   String name;
   
  
    user(String name) // Within the Constructor User and parameter is name of string type
    {
        this.name=name; // 'This' keyword
        
    }
  
    
    String giveName(user o)
    {
        return o.name;
    }
}

class Netflix{ //Super class
    String MovieName;
    String genre;
    int releaseYear;
    int count;
  
    
    public Netflix(){ // Default constructor 
        MovieName=null;
        genre=null;
        releaseYear=0;
        count=0;
        
        
    }
   
    public Netflix(String MovieName,String genre,int releaseYear,int count){ // Parameterized constructor
        this.MovieName=MovieName; 
        this.genre=genre;
        this.releaseYear=releaseYear;
        this.count=count;
        
    }
     public String returnName(){
        return MovieName;
    }
    public void displayMovies(){  
        System.out.println("Nothing has been entered as no response from the user");
    }
    public void displayMovies(String MovieName){    // Method overloading
        System.out.println("Name of movie "+count+" : "+MovieName);
     
    }
    
}

class prevBest extends Netflix{ // Single-level inheritance (pervBest is the child class of Super class Netflix)
	
	double imdbScore;
	public prevBest(String MovieName,String genre,int releaseYear,int count,double imdbScore) { // Parameter as constructor
		super(MovieName, genre,releaseYear,count); // 'Super' keyword to inherit parent constructor
		this.imdbScore=imdbScore;
	}
	public void displayMovies(String MovieName,String genre,int releaseYear,int count,double imdbScore) {  // Method overriding
		System.out.println(count+". Previous month's best Movie was : "+MovieName+" ("+genre+") released in the year "+releaseYear+" having imdb score : "+imdbScore) ;

	}
}



abstract class reviews {  // Abstract classes
 
  public abstract void showImdbRating(); //Abstract method
  String review;
  public void falseComments(String review) { //Regular Method
    System.out.println(review);
  }
}

class imdb extends reviews { // Inherited from abstract class
    float rating;
    
    public imdb(){ //Default constructor
        rating=(float) 0;
    }
    public imdb(float rating){ // Parameterized constructor
        this.rating=rating;
    }
    public void showImdbRating() {
  
    System.out.println(rating);
     
  }
}


interface info{   // Interface info
	public void show();
}

class info1 implements info{ // info1 implements info interface
	public void show() {
		System.out.println("\n********************************************************");
		System.out.println("\n\nProgram done by Shivani L H ; 4NI19IS089 ; A Section");
	}
}


class release  extends Thread{ // Creation of Thread
	
	String[] newmovies = {"Tomorrow_War","Joker","Monster_Hunter"};
	
	public void run() { // The run function starts the thread
		try {
			for(int i=0;i<3;i++) {
				System.out.println(newmovies[i]+ " is releasing soon\n");
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

public class Movie // Main class
{
	public static void main(String[] args) throws InterruptedException {
	    Scanner sc=new Scanner(System.in);
	    
	    String yourname;
	    System.out.println("Your name is : ");
	    
	    yourname=sc.next();
	    user ob1 = new user(yourname); 
	    System.out.println("\n********************************************************");
	    System.out.println("Welcome "+ob1.giveName(ob1)); // Object ob1, object as parameter 
	   
	    
        
  
	    String[] name=new String[5];
	    float [] ratingv=new float[5];
	    float [] ratingc=new float[5];
	    String[] genre=new String[5];
	    int[] releaseYear=new int[5];
	   
	   

	    float[] avgRating=new float[5];
	    
	    
	    
	    Netflix n[]=new Netflix[5]; // Declaring objects
	    imdb im[]=new imdb[5];
	    
	    float imdbRating;
        
	    
		System.out.println("\nEnter your 3 best movies of this month:\n");
		
		for(int i=0;i<3;i++){
		     float avg=0;
		    System.out.println("\n********************************************************\n");
		    System.out.println("Enter the name of Movie "+(i+1));
		    name[i]=sc.next();
		    System.out.println("Enter the genre of the Movie "+(i+1));
		    genre[i]=sc.next();
		    System.out.println("Enter the release year of the Movie "+(i+1));
		    
		    //Exception Handling (Input mismatch exception)
		    // If a user enters a string value in place of an integer value, so the input mismatch is thrown
		    try{
		    releaseYear[i]=sc.nextInt();
		    }
		    catch(InputMismatchException e){
		        System.out.println(e);
		    }
		    n[i]=new Netflix(name[i],genre[i],releaseYear[i],i+1);
		    
		       
		    System.out.println("Enter the rating by the viewers (Out of 10) : ");
		    ratingv[i]=sc.nextFloat();
		    avg=avg+ratingv[i];
		    System.out.println("Enter the rating by the critics (Out of 10) : ");
		    ratingc[i]=sc.nextFloat();
		    avg=avg+ratingc[i];
		    System.out.println("Enter the imdb score: ");
		    imdbRating=sc.nextFloat();
		    im[i]=new imdb(imdbRating);
		    
		    avgRating[i]=avg/2;
		    
		}

			System.out.println("\n");
			
		for(int i=0;i<3;i++){
		    System.out.println("Details of movie "+(i+1)+"\n");
		    n[i].displayMovies(name[i]);
		    System.out.print("Imdb Score: ");
		    im[i].showImdbRating();
		    System.out.println("Final rating : "+avgRating[i]+"\n");
		}
		System.out.println("\n********************************************************\n");
		System.out.println("\nRank of this month's movies are ");
		

		float tempNum;
		String tempName;
		
        // Sorting the movies in decreasing order according to their average rating
		for (int i = 0; i < 3; i++){
		            for (int j = i + 1; j < 3; j++) 
		            {
		                if (avgRating[i] > avgRating[j]) 
		                {
		                    tempNum = avgRating[i];
		                    tempName=name[i];

		                    avgRating[i] = avgRating[j];
		                    name[i] = name[j];

		                    avgRating[j] = tempNum;
		                    name[j] = tempName;
		                }
		            }

		        }
		
		for(int i=2;i>=0;i--){
		    System.out.println((3-i)+". "+name[i]);
		}
		
		System.out.println("\n********************************************************\n");
		System.out.println("\nPrevious month's best movies: \n");
		
		prevBest p1=new prevBest(" Spiderverse","Action",2018,1,8.4);
		p1.displayMovies("Spiderverse","Action",2018,1,8.4);
		
		prevBest p2=new prevBest(" Two_Brothers","Adventure",2004,2,7);
		p2.displayMovies("Two_Brothers","Adventure",2004,2,7);
		
		//Thread Part
		System.out.println("\n********************************************************");
		System.out.println("\n\nWatch out for new movies here :\n");
		release r=new release();
		r.start();
		r.join();
		
		System.out.println("\n********************************************************");
		String[] releasedmovies={"Tomorrow_War","Joker","Monster_Huntet"};
		try {
			for(int i=0;i<3;i++) {
				System.out.println("\n********************************************************\n");
				System.out.println(releasedmovies[i]+" is released. Make sure to watch it!\n");
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		Subscription sb= new Subscription();
		sb.message(); // Subscription package imported
		
		// Display my info
	    // object of implements class 
        info1 i=new info1();
        i.show();
        
	}
}