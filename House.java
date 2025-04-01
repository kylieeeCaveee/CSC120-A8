import java.util.ArrayList; 
/* This is a stub for the House class */
public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom; 

  /**
   * This is the constructor for the house class.
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors the house has
   * @param diningRoom T/F the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean diningRoom) {
    super(name, address, nFloors ); 
    this.residents= new ArrayList<Student>(); 
    this.hasDiningRoom= diningRoom; 
    System.out.println("You have built a house: 🏠");
  }
  /**
   * This is an acessor method for wether the house has a dining room
   * @return T/F wether the house has a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom; 
  }
  /** 
   * This is an acessor for the number of residents that a house contains.
   * @return the number of residents a house has.
  */
  public int nResidents(){
    return this.residents.size(); 
  }

  /**
   * This method moves a student in to the respective house if they do not already live there.
   * @param s the student to be moved in
   */
  public void moveIn(Student s){
    if(! residents.contains(s)){
      residents.add(s); 
    }else{
      throw new RuntimeException("The student already lives in this house. Please try again."); 
    }
  }
  /**
   * This method moves out a student from the respective house if they live there.
   * @param s the student to be moved out
   * @return the student that has been moved out.
   */
  public Student moveOut(Student s){
    if(residents.contains(s)){
      residents.remove(s); 
      return s; 
    }else{
      throw new RuntimeException("This student does not live in this house. Please try again."); 
    }
  }
  /**
   * This method tells you if the given student lives in the respective house.
   * @param s the student in question
   * @return T/F wether the student lives in the house
   */
  public boolean isResident(Student s){
    return residents.contains(s); 
  }

  public static void main(String[] args) {
    House wilson= new House("Wilson", "made up street", 4, false);
    Student kylie= new Student("Kylie", "1", 2028); 
    Student alice= new Student("Alice", "12345", 2027); 
    wilson.moveIn(kylie); 
    System.out.println(wilson.isResident(kylie));
    System.out.println(wilson.moveOut(kylie)); 
    wilson.moveIn(alice); 
    System.out.println(wilson.isResident(alice));
    try{
      wilson.moveIn(alice); 
    }catch(RuntimeException e){
      System.out.println(e.getLocalizedMessage()); 
    }
    System.out.println(wilson.moveOut(alice)); 
    try{
      wilson.moveOut(alice); 
    }catch(RuntimeException e){
      System.out.println(e.getLocalizedMessage()); 
    }


  }

}