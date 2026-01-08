import java.util.ArrayList;

public class Room {


    private String roomDesc;
    private ArrayList<Door> doors = new ArrayList<>();
    private final ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private boolean battle;


    public Room(String roomDesc, boolean battle) {
        this.roomDesc = roomDesc;
        this.battle = battle;
    }

    public boolean inBattle() {
        return battle;
    }

    public void setBattle(boolean battle) {
        this.battle = battle;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomDesc() {

        return this.roomDesc;
    }

    public Door getDoor(char position) {
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


    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }


    public void doNarrative(Room currentRoom) {

        if (!currentRoom.getRoomDesc().equals("")) {
            System.out.println(currentRoom.getRoomDesc());
        }

        for (Item i : currentRoom.getItems()) {

            if (!currentRoom.inBattle() && i != null) {
                System.out.println(i.getItemDesc());

        }

        }

        for (Door d : currentRoom.getDoors()) {

            if (!currentRoom.inBattle()) {
                System.out.println(d.getPositionDesc());
            }

        }

    }

    public void doBattle(Room currentRoom, Player newPlayer) {
        for (Monster monster : currentRoom.getMonsters()) {

            System.out.println(monster.getMonsterDesc());
            System.out.println(newPlayer.getPlayerDesc());

            if (!currentRoom.getMonsters().contains(monster)) {

                System.out.println(newPlayer.getPlayerDesc());
            }
             // test System.out.println(newPlayer.getHealthPoints() + " " + monster.getHealthPoints());


        }
    }
}
