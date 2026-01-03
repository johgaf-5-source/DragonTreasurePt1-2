import java.util.ArrayList;

public class Room {


    private String roomDesc;

    private ArrayList<Door> doors = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();



    public Room(String roomDesc) {
        this.roomDesc = roomDesc;

    }

/*
    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }*/

    public String getRoomDesc() {

        return this.roomDesc;
    }

    public Door getDoor(char position){
        for (Door door : doors) {
            if (door.getPositionChar() == position) {
                return door;
            }
        }
        return null;
    }


    public void addDoor(Door door) {
        doors.add(door);
    }


    public ArrayList<Door> getDoors() {
        return doors;
    }

    public Item getItem(String name){
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public ArrayList<Item> getItems() {
        return items;
    }



    public void doNarrative(Room currentRoom) {



        System.out.println(currentRoom.getRoomDesc());

        for (Item i : currentRoom.getItems()){
            if(i.getExistance()){
            System.out.println(i.getItemDesc());
            }

            }

        for (Door d : currentRoom.getDoors()) {
            System.out.println(d.getPositionDesc());
        }
    }
}
