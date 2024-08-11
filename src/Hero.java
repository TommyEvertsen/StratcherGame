
import java.util.Random;

public class Hero {

    private int hp = 10;
    private int attackPower = 5;
    private int age;
    private String name;

    //Getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    //Functions
    public void levelUp() {
        Random rand = new Random();
        int bonusHp = rand.nextInt(1, 3);
        int bonusAttackPower = rand.nextInt(1, 3);

        this.hp = hp + bonusHp;
        this.attackPower = attackPower + bonusAttackPower;

        System.out.println("Level up!");
        System.out.println("Your new stats are");
        System.out.println("HP:" + " " + getHp());
        System.out.println("Attackpower:" + " " + getAttackPower());
    }

    public void heroStats() {
        System.out.println("Your name is:" + " " + this.getName());
        System.out.println("Your age is:" + " " + this.getAge());
        System.out.println("Your HP is:" + " " + this.getHp());
        System.out.println("Your age Attackpower is:" + " " + this.getAttackPower());
    }
}
