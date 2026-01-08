import java.util.ArrayList;

public class Potion extends Item {
    private int healing;

    @Override
    void use(ArrayList<Room> rooms, Player newPlayer) {


        newPlayer.setHealthPoints(newPlayer.getHealthPoints() + healing);
        System.out.println("Du dricker hälsodrycken och återfår "+ healing +" hälsopoäng.");
        newPlayer.getInventory().remove(this);

    }


    public Potion(String name, String itemDesc, int healing) {
        super(name, itemDesc);
        this.healing = healing;


    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }


}
