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
    public void playGame(ArrayList<Room> rooms, Player newPlayer, ArrayList<Item> items) {
        DragonTreasure show = new DragonTreasure();

// ett objekt av Room för att kunna styra när och hur ett narrativ skrivs ut
        Room narrateRoom = new Room(" ", false);

// spelet tar emot inmatning från spelaren för att kunna navigera mellan rum, eller plocka upp föremål
        Scanner scanner = new Scanner(System.in);


        System.out.println("När du går in i grottan kollapsar ingången bakom dig.");
        //visar beskrivning av det aktuella rummet och vilka dörrar som finns
        narrateRoom.doNarrative(currentRoom, newPlayer);


//loop som körs tills spelet avslutas
        while (true) {
            char action = scanner.next().charAt(0);
            Door door;

            door = currentRoom.getDoor(action);

            // kollar om ett rum har en dörr, och om dörren är låst
            // om dörren är låst skrivs ett meddelande ut att det inte går att passera dörren, istället för att byta rum till ett nytt rum
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
                        show.endGame(newPlayer, items);
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


            // för varje föremål i ett rum (förutom skatten) kan spelaren plocka upp med 'p' vilket tar bort föremålet från rummet och läggs till i spelaren
            for (Item i : new ArrayList<>(currentRoom.getItems())) {
                if (action == 'p') {
                    switch (i.getName()) {
                        case "key" -> System.out.println("Du tog upp nyckeln.");
                        case "sword" -> System.out.println("Du tog upp svärdet.");
                        case "potion" -> System.out.println("Du tog upp hälsodrycken");
                    }
                    if (i.getName().equals("potion") && newPlayer.getHealthPoints() < 10) {
                        System.out.println("Du har " + newPlayer.getHealthPoints() + " hälsopoäng kvar. Kan vara en bra idé att dricka den där hälsodrycken [d]");
                        action = scanner.next().charAt(0);
                    }

                    currentRoom.removeItem(i);
                    newPlayer.addItem(i);
                    // alla föremål förutom hälsodryck och skatten används direkt
                    if (!i.getName().equals("potion") && !i.getName().equals("treasure")) {
                        i.use(rooms, newPlayer);
                    } // om rummet innehåller en skatt plockas den upp automatiskt, och läggs in i spelaren
                } else if (i.getName().equals("treasure")) {

                        newPlayer.addItem(i);
                        // så länge rummet inte är i strid tas föremålet bort, för att kunna visa att spelaren plockar upp skatten i narrativet
                       if (!currentRoom.inBattle()) {
                           currentRoom.removeItem(i);
                       }
                }
                break;
            }

            // för att använda hälsodryckens effekt måste spelaren mata in 'd' på tangentbordet
            if (action == 'd') {
                Item potion = newPlayer.getItemByName("potion");
                if (potion != null) {
                    potion.use(rooms, newPlayer);
                } else {
                    System.out.println("Du har ingen hälsodryck");
                }
            }

            for (Monster m : currentRoom.getMonsters()) {
// liten if-sats för att bestämma meddelande beroende på hur mycket skada spelaren gör, en skada i singular och flera skador i plural
                if (newPlayer.getDamage() > 1) {
                    newPlayer.setPlayerDesc("Du attacerar " + m.getName() + " och gör " + newPlayer.getDamage() + " skador");
                } else {
                    newPlayer.setPlayerDesc("Du attacerar " + m.getName() + " och gör " + newPlayer.getDamage() + " skada");
                }

                narrateRoom.doNarrative(currentRoom, newPlayer);
                while (newPlayer.getHealthPoints() > 0 || m.getHealthPoints() > 0) {
// loopar igenom strids narrativet tills spelaren eller monstret är besegrat
                    narrateRoom.doBattle(currentRoom, newPlayer);

                    newPlayer.setHealthPoints(newPlayer.getHealthPoints() - m.getDamage());
                    m.setHealthPoints(m.getHealthPoints() - newPlayer.getDamage());
                    if (m.getHealthPoints() == 0) {
// monstret tas bort från rummet
                        currentRoom.removeMonster(m);
// rummet är inte längre i slagsmål
                        currentRoom.setBattle(false);
// meddelande om spelaren besegrar monstret
                        newPlayer.setPlayerDesc("Du besegrar " + m.getName().toLowerCase());
                        System.out.println(newPlayer.getPlayerDesc());


// beskrivningen av själva rummet tas bort, för att få narrativet låta lite mer "naturligt"
                        narrateRoom.doBattle(currentRoom, newPlayer);
                        currentRoom.setRoomDesc("");
                        // while-loopen avslutas
                        break;

                    } else if (newPlayer.getHealthPoints() == 0) {
                        // while-loopen avslutas
                        break;
                    }


                }
                narrateRoom.doBattle(currentRoom, newPlayer);
                // for-loopen avslutas
                break;
            }


            if (newPlayer.getHealthPoints() == 0) {
                // når spelaren 0 hälso-poäng skrivs ett slut-meddelande ut, och while (true)-loopen avslutas, vilket avslutar playgame, vilket avslutar spelet
                show.endGame(newPlayer, items);
                break;
            }

            narrateRoom.doNarrative(currentRoom, newPlayer);
           
        }

    }
}

