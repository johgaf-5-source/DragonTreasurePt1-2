public abstract class Item {
    private String name;
    private String itemDesc;

    public Item(String name, String itemDesc) {
        this.name = name;
        this.itemDesc = itemDesc;

    }





    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    abstract void use();


}
