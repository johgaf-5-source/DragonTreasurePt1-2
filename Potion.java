import java.util.ArrayList;
import java.util.Scanner;

public class Potion extends Item {
    private int healing;
Scanner scanner = new Scanner(System.in);




@Override
void use(ArrayList<Room> rooms, Player newPlayer) {
    System.out.println("Du tog upp hälsodrycken.");
    if ((newPlayer.getHealthPoints()) < 10 ){
        System.out.println("Du har "+ newPlayer.getHealthPoints() +" hälsopoäng kvar. Kan vara en bra idé att dricka den där hälsodrycken [d]");
        char heal = scanner.next().charAt(0);
        if (heal == 'd'){
            newPlayer.setHealthPoints(newPlayer.getHealthPoints() + healing);
            System.out.println("Du dricker hälsodrycken och återfår "+ healing +" hälsopoäng.");
            }

        }
    }




    public Potion(String name, String itemDesc, boolean exists, int healing) {
        super(name, itemDesc, exists);
        this.healing = healing;



    }

    public void setHealing(int healing){
        this.healing = healing;
    }

    public int getHealing(){
        return healing;
    }



}

