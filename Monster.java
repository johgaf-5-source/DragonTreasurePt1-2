public class Monster {
    private String name;
    private int healthPoints;
    private int damage;
    private String monsterDesc;

    public Monster(String name, int healthPoints, int damage, String monsterDesc) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.monsterDesc = monsterDesc;
    }
    public void setName(String name) {
        this.name = name;

    }
public String getName() {
        return name;
}

public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
}
public int getHealthPoints() {
        return healthPoints;
}

public void setDamage(int damage) {
        this.damage = damage;
}
public int getDamage() {
        return damage;
}

public void setMonsterDesc(String monsterDesc) {
        this.monsterDesc = monsterDesc;
}
public String getMonsterDesc() {
        return monsterDesc;
}

}
