import java.util.ArrayList;

public class Potion extends Item {
    private int healing;



@Override
void use(ArrayList<Room> rooms) {

}


    public Potion(String name, String itemDesc, boolean exists, int healing){
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
