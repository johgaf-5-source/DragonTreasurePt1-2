public class Door {

    // dörrens riktning
    private char position;
    // true om dörrens visas som låst, false om dörren visas som öppen
    private boolean locked;
// ett nummer för varje dörr, bestämmer vilken eller vilka nycklar som kan låsa upp den
    private int doorId;

    // konstruktor som skapar en dörr med position och låst-status
    public Door(char position, boolean locked, int doorId) {
        this.position = position;
        this.locked = locked;
        this.doorId = doorId;
    }

    public int getDoorId() {
        return doorId;
    }


// getter om man ska skriva ut positionen som tecken
    public char getPositionChar() {
        return position;
    }

    // returnerar en beskrivning av dörren beroende på riktning och om den är låst, olåst, utgång, eller låst utgång

    public String getPositionDesc() {
        return switch (position) {
            case 'n' -> locked
                    ? "Du ser en låst dörr norr om dig [n]" //om dörren är låst
                    : "Du kan gå norrut [n]"; //om dörren är öppen
            case 's' -> locked
                    ? "Du ser en låst dörr i söder [s]"
                    : "Du kan gå söderut [s]";
            case 'ö' -> locked
                    ? "Du ser en låst dörr i öster [ö]"
                    : "Du kan gå österut [ö]";
            case 'v' -> locked
                    ? "Du ser en låst dörr i väster [v]"
                    : "Du kan gå västerut [v]";

//inte jätte nödvändigt egentligen, men det finns ifall man skulle vilja ändra hur dörrarna läggs ut
            case 'N' -> locked
                    ? "Du ser en låst utgång norrut [n]"
                    : "Du ser en utgång norrut [n]";
            case 'S' -> locked
                    ? "Du ser en låst utgång söderut [s]"
                    : "Du ser en utgång söderut [s]";
            case 'Ö' -> locked
                    ? "Du ser en låst utgång österut [ö]"
                    : "Du ser en utgång österut [ö]";
            case 'V' -> locked
                    ? "Du ser en låst utgång västerut [v]"
                    : "Du ser en utgång västerut [v]";

            default -> throw new IllegalStateException("Unexpected position: " + position);


        };

    }
//setter för låst status
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

//returnerar true om dörren är låst, false om den går att passera
    public boolean isLocked() {
        return locked;
    }
}
