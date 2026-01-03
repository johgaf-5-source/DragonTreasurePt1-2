import java.util.ArrayList;
import java.util.Scanner;

public class DragonTreasure {


    public static void main(String[] args) {
// skapar och startar spelet
        DragonTreasure dragonTreasure = new DragonTreasure();
        dragonTreasure.setupGame();


    }


    public void setupGame() {
        Scanner scanner = new Scanner(System.in);

// här skapas alla rum och lagras i lista de kan refereras till senare
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Rummet är upplyst av några ljus som sitter på ett bord framför dig."));

        rooms.add(new Room("Du ser en död kropp på golvet."));

        rooms.add(new Room("Du ser en brinnande fackla i rummets ena hörn och känner en motbjudande stank."));

        rooms.add(new Room("Du kommer in i ett fuktigt rum med vatten sipprandes längs den västra väggen."));

        rooms.add(new Room("Du kommer in i ett rymligt bergrum med en ljusstrimma sipprandes genom en spricka i " +
                "den östra väggen."));
        rooms.add(new Room("En arg drake dyker upp"));



// här skapas en instans av spelaren
        Player newPlayer = new Player("", 100, 100);

        // ger alla rummen en tillhörande dörr
      //  Door roomDoors = new Door(' ', false);


        Room room1 = rooms.get(0);
        Room room2 = rooms.get(1);
        Room room3 = rooms.get(2);
        Room room4 = rooms.get(3);
        Room room5 = rooms.get(4);
        Room room6 = rooms.get(5);


        room1.addDoor(new Door('n', false, 0));
        room1.addDoor(new Door('s', false,0));

        room2.addDoor(new Door('s', false,0));
        room2.addDoor(new Door('ö', false,0));

        room3.addDoor(new Door(' ', false,0));
        room3.addDoor(new Door('v', false,0));
        room3.addDoor(new Door('s', false,0));

        room4.addDoor(new Door('ö', true,1));
        room4.addDoor(new Door('n', false,0));
        room4.addDoor(new Door('v', false, 0));

        room5.addDoor(new Door('n', false, 0));
        room5.addDoor(new Door('ö', false, 0));

        room6.addDoor(new Door('v', false, 0));

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Weapon("sword", " ", true, 2));
        items.add(new Potion("potion", " ", true, 6));
        items.add(new Key("key", " ", true, 1));

room2.addItem(items.get(0));
room4.addItem(items.get(1));
room5.addItem(items.get(2));

       /* room2.addItem(new Weapon("sword", " ", true, 2));

        room4.addItem(new Potion("potion", " ", true, 6));

        room5.addItem(new Key("key", " ", true));*/









// ett välkommstmeddellande
        Dungeon intro = new Dungeon("", rooms.get(0));

        intro.setWelcomeMessage("Välkommen till Dragon Treasure \n" +
                "Skriv ditt namn och tryck på [Enter] för att starta ett nytt spel...");


        System.out.println(intro.getWelcomeMessage());
     //   roomDoors.setPosition('n');


        String playerName = scanner.nextLine();
        newPlayer.setName(playerName);




                intro.setWelcomeMessage("Välkommen " + newPlayer.getName() + " till din skattjakt.\nDu står utanför en grotta. Det luktar svavel från öppningen \n" +
                        "Grottöppningen är österut. Skriv \"ö\" och tryck på [Enter] för att komma in i grottan");

        System.out.println(intro.getWelcomeMessage());


        String transition = scanner.nextLine();


        while (true) {

            // kontrollerar att spelaren bara skriver ett tecken
            if (transition.length() != 1) {
                System.out.println("Inget hände.");
            } else {

                // Om användaren skriver 'ö' startar spelet
                char transitionChar = transition.charAt(0);
                if (transitionChar == 'ö' || transitionChar == 'Ö') {
                    intro.playGame(rooms);
                    break; // Avslutar loopen när spelet startar

                } else {
                    System.out.println("Du står kvar utanför grottan, skriv \"ö\" och tryck [Enter] för att gå vidare.");
                }
            }
            transition = scanner.nextLine();

        }


    }

    public void endGame() {
        // skriver ett slutmeddellande när spelet avslutas
        System.out.println("Du lämnar grottan med livet i behåll. Grattis, du förlorade inte!");

    }

    public void chest() {

        System.out.println("Du har ingen nyckel som passar");
        System.out.println("Du kikar genom nyckelhålet och ser en skattkista full med guld.");

        // skriver ut en bild på en kista
        /*
        System.out.println(
                " _.--.\n" +
                        " _.-'_:-'||\n" +
                        " _.-'_.-::::'||\n" +
                        " _.-:'_.-::::::' ||\n" +
                        " .'`-.-:::::::' ||\n" +
                        " /.'`;|:::::::' ||_\n" +
                        " || ||::::::' _.;._'-._\n" +
                        " || ||:::::' _.-!oo @.!-._'-.\n" +
                        " \'. ||:::::.-!() oo @!()@.-'_.||\n" +
                        " '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n" +
                        " `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
                        " ||-._'-.@.-'_.-' _.-o |'||\n" +
                        " ||=[ '-._.-\\U/.-' o |'||\n" +
                        " || '-.]=|| |'| o |'||\n" +
                        " || || |'| _| ';\n" +
                        " || || |'| _.-'_.-'\n" +
                        " |'-._ || |'|_.-'_.-'\n" +
                        " '-._'-.|| |' `_.-'\n" +
                        " '-.||_/.-'\n"); */
    }
}

