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
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
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
        myMap.addBuilding(new Library("Neilson Library", "main campus", 5, true));
        myMap.addBuilding(new House("King","Green St.",3, true, true));
        myMap.addBuilding(new House("Morrow", "Mandelle Rd.",4, true, true));
        myMap.addBuilding(new House("Comstock", "Mandelle Rd.", 5, true, true));
        myMap.addBuilding(new House("Wilder", "Mandelle Rd", 5, true, true));
        myMap.addBuilding(new Building("Paradise Pond Boathouse", "main campus", 1));
        myMap.addBuilding(new Building("Ainsworth Gym", "main campus", 4));
        myMap.addBuilding(new Building("DTI", "don't know(behind Cutter)", 2));
        myMap.addBuilding(new Building("Mwangi Cultural Center","near Cutter", 2));
        myMap.addBuilding(new Building("Unity House", "next to Mwangi",1));
        myMap.addBuilding(new Cafe("Woodstar", "next to Mwangi",1));
        System.out.println(myMap);
    }
    
}
