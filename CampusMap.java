import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public Building addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
        return b; 
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * The toString for printing out a map of the building. It prints a directory with all of the names and addresses of all the buildings located on the map.
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("CC Cafe", "1 Chapin Way", 1));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive", 1)); 
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive", 4)); 
        myMap.addBuilding(new Library("Alumnae Gym", "83 Green St", 3)); 
        myMap.addBuilding(new Library("Josten Library", "122 Green St", 2 )); 
        myMap.addBuilding(new House("Wilson", "1 Paradise Rd", 4, false, false)); 
        myMap.addBuilding(new House("Tyler", "164 Green St", 4, true, true));
        myMap.addBuilding(new House("Hubbard", "3 Green St", 3, false, false)); 
        myMap.addBuilding(new Cafe());
        myMap.addBuilding(new Library(2));
        myMap.addBuilding(new Library());
        myMap.addBuilding(new House()); 
        myMap.addBuilding(new House(3, true, false));
         
        
        System.out.println(myMap);
    }
    
}
