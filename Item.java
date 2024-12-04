public class Item {
  private String name;
  private String type;
  private String description;

  public Item(String pName, String pType, String pDescription) {
    name = pName;
    type = pType;
    description = pDescription;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public void setName(String pName) {
    name = pName;
  }

  public void setType(String pType) {
    type = pType;
  }

  public void setDescripton(String pDescription) {
    description = pDescription;
  }

  public String toString() {
    return name + " [" + type + "]: " + description;
  }
}