import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    private String welcomeMessage; //text som visas när spelet startas
    private Room currentRoom; // refererar till rummet spelaren befinner sig i

    //setter för välkomstmeddellande
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    //getter för välkomstmeddelande
    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    // setter för aktuellt rum
   /* public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;

    } */

    //getter för aktuellt rum
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    //konstruktor för dungeon
    public Dungeon(String welcomeMessage, Room currentRoom) {
        this.welcomeMessage = welcomeMessage;
        this.currentRoom = currentRoom;

    }

    // Huvudmetod som styr när spelaren är inne i grottan
    public void playGame(ArrayList<Room> rooms, Player newPlayer) {
        DragonTreasure show = new DragonTreasure();


        Room narrateRoom = new Room(" ");

        Scanner scanner = new Scanner(System.in);


        System.out.println("När du går in i grottan kollapsar ingången bakom dig.");
        //visar beskrivning av det aktuella rummet och vilka dörrar som finns
        narrateRoom.doNarrative(currentRoom);

//loop som körs tills spelet avslutas
        while (true) {
            char action = scanner.next().charAt(0);
            Door door;

            door = currentRoom.getDoor(action);

            if (door != null && door.isLocked()) {
                show.doorLocked();
                continue;

            }


            // kollar vilket rum spelaren befinner sig i och hanterar rörelser från spelaren
            if (currentRoom == rooms.get(0)) {
                switch (action) {
                    case 'n' -> currentRoom = rooms.get(1);
                    case 's' -> currentRoom = rooms.get(4);
                }


            } else if (currentRoom == rooms.get(1)) {
                switch (action) {
                    case 'ö' -> currentRoom = rooms.get(2);
                    case 's' -> currentRoom = rooms.get(0);
                }


            } else if (currentRoom == rooms.get(2)) {
                switch (action) {
                    case 's' -> currentRoom = rooms.get(3);
                    case 'v' -> currentRoom = rooms.get(1);
                    case 'ö' -> {
                        show.endGame();
                        return;
                    }

                }

            } else if (currentRoom == rooms.get(3)) {
                switch (action) {
                    case 'v' -> currentRoom = rooms.get(4);
                    case 'n' -> currentRoom = rooms.get(2);
                    case 'ö' -> currentRoom = rooms.get(5);
                }


            } else if (currentRoom == rooms.get(4)) {
                switch (action) {
                    case 'n' -> currentRoom = rooms.get(0);
                    case 'ö' -> currentRoom = rooms.get(3);

                }
            } else if (currentRoom == rooms.get(5)) {
                switch (action) {
                    case 'v' -> currentRoom = rooms.get(3);
                }
            }

            for (Item i : new ArrayList<>(currentRoom.getItems())) {
                if (action == 'p') {
                    switch (i.getName()) {
                        case "key" -> System.out.println("Du tog upp nyckeln.");
                        case "sword" -> System.out.println("Du tog upp svärdet.");
                        case "potion" -> System.out.println("Du tog upp hälsodrycken");
                    }


                    currentRoom.removeItem(i);
                    newPlayer.addItem(i);
                    if (!i.getName().equals("potion")) {
                        i.use(rooms, newPlayer);

                    }
                }
                    break;
                }
                switch (action) {
                    case 'd' -> {
                        Item potion = newPlayer.getItemByName("potion");
                        if (potion != null) {
                            potion.use(rooms, newPlayer);
                        } else {
                            System.out.println("Du har ingen hälsodryck");
                        }
                    }
                }


                narrateRoom.doNarrative(currentRoom);
            }

        }
    }

                                                                                               
