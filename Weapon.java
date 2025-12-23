public class Weapon extends Item{
    private int increaseDamage;

    public Weapon(String name, String itemDesc, int increaseDamage){
        super(name, itemDesc);
        this.increaseDamage = increaseDamage;
    }

    public void setIncreaseDamage(int increaseDamage){
        this.increaseDamage = increaseDamage;
    }

    public int getIncreaseDamage(){
        return increaseDamage;
    }
    
    @Override
    public void use() {

    }

}
