import java.util.ArrayList;

public class Weapon extends Item{
    private int increaseDamage;

    public Weapon(String name, String itemDesc, boolean exists, int increaseDamage){
        super(name, itemDesc, exists);
        this.increaseDamage = increaseDamage;
    }

    public void setIncreaseDamage(int increaseDamage){
        this.increaseDamage = increaseDamage;
    }

    public int getIncreaseDamage(){
        return increaseDamage;
    }

    @Override
    void use(ArrayList<Room> rooms, Player newPlayer) {
System.out.println("Du tog upp svärdet.");
newPlayer.setDamage(newPlayer.getDamage() + increaseDamage);


    }

}
