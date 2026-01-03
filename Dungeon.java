import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    private String welcomeMessage; 
    private Room currentRoom; 

    //setter för välkomstmeddellande
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    //getter för välkomstmeddelande
    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    // setter för aktuellt rum
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;

    }

    //getter för aktuellt rum
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    //konstruktor för dungeon
    public Dungeon(String welcomeMessage, Room currentRoom) {
        this.welcomeMessage = welcomeMessage;
        this.currentRoom = currentRoom;

    }

    // Huvudmetod som styr när spelaren in i grottan
    public void playGame(ArrayList<Room> rooms) {
        DragonTreasure close = new DragonTreasure();


        Room narrateRoom = new Room(" ");

        Scanner scanner = new Scanner(System.in);


        System.out.println("När du går in i grottan kollapsar ingången bakom dig.");
        //visar beskrivning av det aktuella rummet och vilka dörrar som finns
        narrateRoom.doNarrative(currentRoom);

//loop som körs tills spelet avslutas
        while (true) {
            char action = scanner.next().charAt(0);

            boolean exists;

            Door door = currentRoom.getDoor(action);

            // bara ett test för att se hur låsta/öppna dörrar fungerar
/*
if (action == '1') {
    rooms.get(3).getDoor('ö').setLocked(false);
} else if (action == '2') {
    rooms.get(3).getDoor('ö').setLocked(true);
}*/


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
                        close.endGame();
                        return;
                    }

                }

            } else if (currentRoom == rooms.get(3)) {
                switch (action) {
                    case 'v' -> currentRoom = rooms.get(4);
                    case 'n' -> currentRoom = rooms.get(2);
                    case 'ö' -> {
                        if (door != null && door.isLocked()) {
                            close.chest();
                        } else {
                            currentRoom = rooms.get(5);
                        }
                    }
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

            for (Item i : currentRoom.getItems()) {
                switch (action) {
                    case 'p' -> {
                        i.setExisting(exists = false);
                        i.use();
                    }
                }
            }



            narrateRoom.doNarrative(currentRoom);

        }

    }
}

