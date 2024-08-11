
import java.util.Random;

public class Enemies {

    private int hp;
    private String name;
    private int attackPower;

    Random rand = new Random();

    //Getters and setters
    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    //Functions
    public void defeated() {
        System.out.println("bye bye");
    }

    public void createRandomEnemy(String name) {
        this.setAttackPower(rand.nextInt(1, 10));
        this.setHp(rand.nextInt(1, 10));
        this.setName(name);
    }

    public void createEnemy(int hp, int attackPower, String name) {
        this.setHp(hp);
        this.setAttackPower(attackPower);
        this.setName(name);
    }

}
