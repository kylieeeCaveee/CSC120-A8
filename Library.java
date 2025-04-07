/* This is a stub for the Library class */
import java.util.Hashtable; 
public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection; 

    /**
     * This is the constructor for a Library
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the number of floors the library has
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors); 
      this.collection= new Hashtable<String,Boolean>(); 
      System.out.println("You have built a library: 📖");
    }

    /**
     * This is the constructor for a library with all default values
     */
    public Library(){
      super("Unkown Library Name", "Unkown Library Address", 1); 
      this.collection= new Hashtable<String, Boolean>(); 
      System.out.println("You have built a library: 📖");
    }

    /**
     * This is the constructor for a library with all default values, except the values that impact function use like nFloors.
     * @param nFloors the number of floors the library will have when created.
     */
    public Library(int nFloors){
      super("Unkown Library Name", "Unkown Library Address", nFloors); 
      this.collection=new Hashtable<String,Boolean>(); 
      System.out.println("You have built a library: 📖");
    }
    
    /**
     * This adds a book to the libraries collection
     * @param title this is the title of the book to be added
     */
    public void addTitle(String title){
      collection.put(title, true); 
    }
    /**
     * This method removes a book from the respective libraries collection if the book is in the libraries collection.
     * @param title this is the title of the book to be removed
     * @return the title that has been removed
     */
    public String removeTitle(String title){
      if (collection.get(title)==true){
        collection.remove(title); 
        return title; 
      }else{
        throw new RuntimeException("This book is currently checked out it cannot be removed from the library"); 
      }
    }
    /**
     * This method sets the respective books value to false, hence checking it out, if the book is not checked out alread.
     * @param title the title of the book to be checked out
     */
    public void checkOut( String title){
      if(collection.get(title)==true){
        collection.replace(title, false); 
      }else{
        throw new RuntimeException("This book is currently checked out. Please try again later."); 
      }
    }
    /**
     * This tells you wether the library has the title you are looking for
     * @param title the title of the book you are looking for
     * @return T/F wether the library has the book you are looking for in it's collection
     */
    public boolean containsTitle(String title){
      return collection.containsKey(title); 
    }
    /**
     * This tells you wether the book you have is currently avalible to check out
     * @param title the title of the book in question
     * @return T/F wether the book is present to be checked out
     */
    public boolean isAvailable(String title){
      return collection.get(title); 
    }
    /**
     * This method prints out all the titles in the libraries collection and wether they are checked out or not.
     */
    public void printCollection(){
      System.out.println("The library contains the following books:");
      System.out.println(collection.entrySet());
    }
    /**
     * This method retruns a book back to the Library if the book was checked out. Aka it sets the value back to true.
     * @param title the title of the book to be returned 
     */
    public void returnBook(String title){
      if(collection.get(title)==false){
        collection.replace(title, true); 
      }else{
        throw new RuntimeException("This book is not currently checked out.");
      }
    }

    /** 
     * This method shows the options of activities to do in the library avalible through the builiding parent class and avalible through the library subclass.
     */
    public void showOptions(){
      super.showOptions();
      System.out.println(" + goToFLoor(n)");
      System.out.println("Library Specfic Options Include:"+ "\n + addTitle(String title) \n + removeTitle(String title) \n + checkOut(String title) \n + returnBook( String title) \n + containsTitle(String title) \n + isAvalible(String title) \n + printCollection()");
    }
  
    public static void main(String[] args) {
      Library testLib= new Library("lib", "idk address", 4);
      testLib.addTitle("testBook1"); 
      testLib.checkOut("testBook1");
      testLib.returnBook("testBook1"); 
      try{
        testLib.returnBook("testBook1"); 
      }catch(RuntimeException e){
        System.out.println(e.getLocalizedMessage());
      }
      testLib.showOptions();
      testLib.enter(); 
      testLib.goToFloor(3); 
    }

  }
      
  
  