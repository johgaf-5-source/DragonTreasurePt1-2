public class Player {
    // spelarens namn
    private String name;

    //konstruktor som skapar en spelare med namn
    public Player (String name) {
        this.name = name;
    }

    //setter metod för att ändra spelarens namn
    //används när spelaren skriver sitt namn i början av spelet med hjälp av scanner
    public void setName (String name) {
        this.name = name;
    }

    //getter metod för att hämta spelarens namn
    public String getName() {
        return name;
    }

}