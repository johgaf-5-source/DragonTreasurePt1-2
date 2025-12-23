import java.util.ArrayList;

public class Room {

// text som beskriver rummet
    private String roomDesc;
    //lista med dörrarna som finns i rummet
    private ArrayList<Door> doors = new ArrayList<>();
// konstruktor som skapar ett rum med en beskrivning
    public Room(String roomDesc) {
        this.roomDesc = roomDesc;

    }

    //setter för rumsbeskrivningen, kan användas om man vill ändra på beskrivningen under spelets gång
    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }
//getter för rumsbeskrivningen, returnerar beskrivningen när spelaren går in i rummet
    public String getRoomDesc() {

        return this.roomDesc;
    }
// lägger till en ny dörr till rummet
    public void addDoor(Door door) {
        doors.add(door);
    }

//returnerar listan med dörrarna till rummet
    public ArrayList<Door> getDoors() {
        return doors;
    }

//skriver ut tillhörande beskrivningar till nuvarande rum med tillhörande dörrar
    public void doNarrative(Room currentRoom) {

        System.out.println(currentRoom.getRoomDesc());

//loopar igenom alla dörrar i rummet och skriver ut deras beskrivningar
        for (Door d : currentRoom.getDoors()) {
            System.out.println(d.getPositionDesc());
        }


    }


}
