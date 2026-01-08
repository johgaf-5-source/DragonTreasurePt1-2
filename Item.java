import java.util.ArrayList;

public abstract class Item {
    private String name;
    private String itemDesc;

    // kommer antagligen tas bort, då den inte fyller någon funktion än så länge
   // private boolean exists;

    public Item(String name, String itemDesc) {//, boolean exists) {
        this.name = name;
        this.itemDesc = itemDesc;
      //  this.exists = exists;

    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemDesc() {
        return switch (name) {
            case "key" -> "Du ser en nyckel som ligger på golvet, du kan ta upp den [p]";


            case "potion" -> "Du ser en hälsodryck på golvet, du kan plocka upp den [p]";


            case "sword" -> "Du ser ett svärd på golvet, du kan ta upp det [p]";

            case "treasure" -> "Du samlar skatten";



            default -> "";

        };
    }
/*
    public void setExisting(boolean exists) {
        this.exists = exists;
    }

    public boolean isExisting() {
        return exists;
    }
*/
    abstract void use(ArrayList<Room> rooms, Player newPlayer);


}
