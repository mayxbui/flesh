import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private String name;
    private String description;
    private ArrayList<Item> items;
    private HashMap<String, Location> connections;

    public Location(String pName, String pDescription) {
        name = pName;
        description = pDescription;
        items = new ArrayList<>();
        connections = new HashMap<String, Location>();
    }

    public void connect(String direction, Location place) {
        connections.put(direction.toLowerCase(), place);
    }

    public Boolean canMove(String direction) {
        if (connections.get(direction.toLowerCase()) != null) {
            return true;
        }
        return false;
    }

    public Location getLocation(String direction) {
        if (canMove(direction))
            return connections.get(direction.toLowerCase());
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String pName) {
        name = pName;
    }

    public void setDescription(String pDescription) {
        description = pDescription;
    }

    public void addItem(Item pItem) {
        items.add(pItem);
    }

    public boolean hasItem(String pName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().toLowerCase().equals(pName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(String pName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().toLowerCase().equals(pName.toLowerCase())) {
                return items.get(i);
            }
        }
        return null;
    }

    public Item getItem(int index) {
        if (index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public int numItems() {
        return items.size();
    }

    public Item removeItem(String pName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().toLowerCase().equals(pName.toLowerCase())) {
                return items.remove(i);
            }
        }
        return null;
    }
}