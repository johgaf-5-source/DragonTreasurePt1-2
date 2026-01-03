import java.util.ArrayList;                                                               
                                                                                          
public class Key extends Item {                                                            
                                                                                          
private int keyId;                                                                         
                                                                                          
    @Override                                                                              
     void use(ArrayList<Room> rooms) {                                                    
                                                                                          
        System.out.println("Du plockar upp nyckeln");                                     
                                                                                          
        for(Room room : rooms){                                                           
            for (Door door : room.getDoors()) {                                           
                if(door.isLocked() && door.getDoorId() == keyId){                         
                    door.setLocked(false);                                                
                    return;                                                               
                }                                                                         
            }                                                                             
        }                                                                                 
                                                                                          
                                                                                          
            }                                                                             
                                                                                          
                                                                                          
                                                                                          
                                                                                          
    public Key(String name, String itemDesc, boolean exists, int keyId) {                  
        super(name, itemDesc, exists);                                                    
        this.keyId = keyId;                                                               
    }                                                                                     
                                                                                          
                                                                                          
                                                                                          
}                                                                                         
                                                                                          
