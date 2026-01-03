
public class Treasure extends Item{

    private int goldValue;


    public Treasure(String name, String itemDesc, boolean exists, int goldValue){
      super(name, itemDesc, exists);
      this.goldValue = goldValue;
    }

    public void setGoldValue(int goldValue){
        this.goldValue = goldValue;
    }

    public int getGoldValue(){
        return goldValue;
    }
    @Override
    void use(){

    }
}
