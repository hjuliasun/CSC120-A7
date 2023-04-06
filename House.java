
// /* This is a stub for the House class */
// import java.util.ArrayList;

// public class House extends Building {


// /** Checks if house has a dining hall 
//      * @return True or False 
//     */
//     private boolean hasDiningRoom;

    
//     private ArrayList<String> residents; 
//   // The <String> tells Java what kind of data we plan to store IN the ArrayList
  
//   public boolean hasDiningRoom(){
//     return this.hasDiningRoom;
//   }
//   public ArrayList<String> residents(){
//     return this.residents;
//   }

//   public int nResidents(){
//     return residents.size();
//   }

// public void moveIn(String name){
//   residents.add(name);


// }
 
// public String moveOut(String name){
//   for (String resident: residents) {
//     if (resident.equals(name)) {
//       return resident;
//     }
//   }
//   residents.remove(name);
//   return null;
// }

// // return the name of the person who moved out

// /** Check if person is on the house's resident list
//  * @param name 
//  * @return True or False - not the list of the names of residents!
//  */

//   public House(boolean DiningRoom, ArrayList<String> residents, String name, String address, int nFloors) {
//     super(name,  address,  nFloors);
//     this.hasDiningRoom = DiningRoom;
//     this.residents = residents;

    

//     System.out.println("You have built a house: 🏠");
//   }

//   public static void main(String[] args) {
//     House Talbot = new House(True, "hannah", "priya", "reilly");
//     System.out.println(Talbot);
//   }

// }

import java.util.ArrayList;
import java.util.Arrays;

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;


/**Default constructor*/
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, true, true);
  }

/**Overload constructor for house
 * @param name,address,nFloors,hasDiningRoom,hasElevator
 */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for hasElevator */
  public boolean hasElevator(){
    return this.hasElevator;}

/** inherited goToFloor method */
  public void goToFloor(int floorNum){
    if (this.hasElevator == false) {
      throw new RuntimeException("this building does not have an elevator");
    }
    super.goToFloor(floorNum);
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }


  /** Original Method for moving in residents
   * @param name
   */
  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    // if we're good to go, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
  }

/** Overload Method for moving in multiple residents
   * @param nameofResidents
   */
  public void moveIn(ArrayList<String> nameofResidents){
    for (String i:nameofResidents){
      this.moveIn(i);
    }

  }


  public String moveOut(String name){
    // check if this.residents contains name
    if (!this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is not a resident of " + this.name);
    }
    // if we're good to go, add to roster
    this.residents.remove(name);
    System.out.println(name + " has just moved out from " + this.name + "! Go say bye :-(");
    return name;
  }

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }


  public void showOptions(){
    super.showOptions();
    System.out.println("\n + hasDiningRoom() + \n + nResidents() + \n + moveIn() + \n + moveOut()");


}

  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false, true);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    morrow.moveOut("Jordan");
    System.out.println(morrow);
    House king = new House("King", "The Quad", 3, true, true);
    king.showOptions();
    king.enter();
    king.goToFloor(3);
    ArrayList<String> residentNames = new ArrayList<String>(Arrays.asList("hannah", "reilly", "priya", "sam"));
    king.moveIn(residentNames);
    System.out.println(king);
  }

}