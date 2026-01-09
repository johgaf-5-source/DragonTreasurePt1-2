import java.util.ArrayList;

public abstract class Item {
    private String name;
    private String itemDesc;


    public Item(String name, String itemDesc) {//, boolean exists) {
        this.name = name;
        this.itemDesc = itemDesc;


    }


    public String getName() {
        return name;
    }

    public String getItemDesc() {
        return switch (name) {

            // beskriver vilka föremål som finns i rummen
            case "key" -> "Du ser en nyckel som ligger på golvet, du kan ta upp den [p]";

            case "potion" -> "Du ser en hälsodryck på golvet, du kan plocka upp den [p]";

            case "sword" -> "Du ser ett svärd på golvet, du kan ta upp det [p]";

// här kunde skatten fungerat på samma sätt som de andra, men tanken här var att spelaren direkt plockar upp skatten automatiskt när den får tillgång till den, vilket i detta fallet sker
            case "treasure" -> "Du samlar skatten";

            default -> "";

        };
    }

    // abstrakt metod för hur föremål kan användas
    abstract void use(ArrayList<Room> rooms, Player newPlayer);


}
