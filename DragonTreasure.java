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

// här skapas alla rum och lagras i lista de kan refereras till
        ArrayList<Room> rooms = new ArrayList<>();
        Room room1 = new Room("Rummet är upplyst av några ljus som sitter på ett bord framför dig.", false);
        Room room2 = new Room("Du ser en död kropp på golvet.", false);
        Room room3 = new Room("Du ser en brinnande fackla i rummets ena hörn och känner en motbjudande stank.", true);
        Room room4 = new Room("Du kommer in i ett fuktigt rum med vatten sipprandes längs den västra väggen.", false);
        Room room5 = new Room("Du kommer in i ett rymligt bergrum med en ljusstrimma sipprandes genom en spricka i den östra väggen.", false);
        Room room6 = new Room("En arg drake dyker upp", true);



        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);



        Door east = new Door('ö', false, 0);
        Door west = new Door('v', false, 0);
        Door north = new Door('n', false, 0);
        Door south = new Door('s', false, 0);

        Door lockedEast = new Door('ö', true, 1);
     /* Door lockedWest = new Door('v', true, 2);
        Door lockedNorth = new Door('n', true, 3);
        Door lockedSouth = new Door('s', true, 4); */

        Door eastExit = new Door('Ö', false, 0);
     /* Door westExit = new Door('V', false, 0);
        Door northExit = new Door('N', false, 0);
        Door southExit = new Door('S', false, 0);

        Door lockedEastExit = new Door('Ö', true, 0);
        Door lockedWestExit = new Door('V', true, 0);
        Door lockedNorthExit = new Door('N', true, 0);
        Door lockedSouthExit = new Door('S', true, 0); */


        room1.addDoor(north);
        room1.addDoor(south);

        room2.addDoor(east);
        room2.addDoor(south);

        room3.addDoor(eastExit);
        room3.addDoor(west);
        room3.addDoor(south);

        room4.addDoor(lockedEast);
        room4.addDoor(north);
        room4.addDoor(west);

        room5.addDoor(north);
        room5.addDoor(east);

room6.addDoor(west);

        ArrayList<Item> items = new ArrayList<>();
        Item sword = new Weapon("sword", " ",  1);
        Item potion = new Potion("potion", " ",  6);
        Item key = new Key("key", " ",  1);
        Item treasure = new Treasure("treasure", "",  1);

        items.add(sword);
        items.add(potion);
        items.add(key);
        items.add(treasure);

        room2.addItem(sword);
        room4.addItem(potion);
        room5.addItem(key);
        room6.addItem(treasure);

        ArrayList<Monster> monsters = new ArrayList<>();

        Monster monster = new Monster("Odjuret", 8, 1, "");
        Monster dragon = new Monster("Draken", 18, 1, "");

        monster.setMonsterDesc(monster.getName() + " attackerar dig och gör " + monster.getDamage() + " skada");
        dragon.setMonsterDesc(dragon.getName() + " attackerar dig och gör " + dragon.getDamage() + " skada");

        monsters.add(monster);
        monsters.add(dragon);


        room3.addMonster(monster);

        room6.addMonster(dragon);

        Player newPlayer = new Player("", 10, 1, new ArrayList<>(), "");



        Dungeon intro = new Dungeon("", rooms.get(0));
        Monster a = new Monster("", 9, 1, "");



        intro.setWelcomeMessage("Välkommen till Dragon Treasure \n" +
                "Skriv ditt namn och tryck på [Enter] för att starta ett nytt spel...");


        System.out.println(intro.getWelcomeMessage());


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
                    intro.playGame(rooms, newPlayer);
                    break; // Avslutar loopen när spelet startar

                } else {
                    System.out.println("Du står kvar utanför grottan, skriv \"ö\" och tryck [Enter] för att gå vidare.");
                }
            }
            transition = scanner.nextLine();

        }


    }

    public void endGame(Player newPlayer) {
        // skriver ett slutmeddellande när spelet avslutas

        if (newPlayer.getHealthPoints() <= 0) {
            System.out.println("Du dog");
        } else if (newPlayer.getInventory().size() > 3){
            System.out.println("Du lämnar grottan med skatten. Grattis, du vann!");
     /*       Test
            System.out.println(newPlayer.getInventory().size()); */

        }else {
            System.out.println("Du lämnar grottan med livet i behåll. Grattis, du förlorade inte!");
            System.out.println(newPlayer.getInventory().size());
        }
    }

    public void doorLocked() {
        System.out.println("Du har ingen nyckel som passar");
    }

    public void chest() {


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

