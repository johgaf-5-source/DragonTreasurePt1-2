import java.util.ArrayList;

public class Player {
    // spelarens namn
    private String name;
    private int healthPoints;
    private int damage;
    private final ArrayList<Item> inventory;


    public Player(String name, int healthPoints, int damage, ArrayList<Item> inventory) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    //setter metod för att ändra spelarens namn
    //används när spelaren skriver sitt namn i början av spelet med hjälp av scanner
    public void setName(String name) {
        this.name = name;
    }

    //getter metod för att hämta spelarens namn
    public String getName() {
        return name;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;

    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }


    public void addItem(Item item) {
        inventory.add(item);
    }
    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item getItemByName(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }




}
