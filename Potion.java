public class Potion extends Item {
    private int healing;



@Override
void use() {

}


    public Potion(String name, String itemDesc, int healing){
        super(name, itemDesc);
        this.healing = healing;
    }

    public void setHealing(int healing){
        this.healing = healing;
    }

    public int getHealing(){
        return healing;
    }



}
