import java.util.ArrayList;

public class Key extends Item {


    // ett nummer för en eller flera nycklar, vilket styr vilken eller vilka dörrar de kan låsa upp
private int keyId;

    @Override
     void use(ArrayList<Room> rooms, Player newPlayer) {


        // om dörren är låst och matchar nyckelns nummer, låser nyckeln upp den
        for(Room room : rooms){
            for (Door door : room.getDoors()) {
                if(door.isLocked() && door.getDoorId() == keyId){
                    door.setLocked(false);
                    return;
                }
            }
        }


            }




    public Key(String name, String itemDesc, int keyId) {
        super(name, itemDesc);
        this.keyId = keyId;
    }



}
