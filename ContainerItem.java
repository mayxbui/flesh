import java.util.ArrayList;

public class ContainerItem extends Item {
    private ArrayList<Item> items;

    public ContainerItem(String pName, String pType, String pDescription) {
        super(pName, pType, pDescription);
        items = new ArrayList<>();
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

    public Item removeItem(String pName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().toLowerCase().equals(pName.toLowerCase())) {
                return items.remove(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        // String s = String.format("%s [%s]: %s", getName(), getType(),
        // getDescription());
        String s = "";
        for (int i = 0; i < items.size(); i++) {
            String s2 = "\n+ " + items.get(i).getName();
            s += s2;
        }
        return s;
    }
}