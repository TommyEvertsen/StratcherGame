
import java.util.Random;

public class Boss extends Enemies {

    public void createEnemy(String name) {

        Random rand = new Random();

        this.setAttackPower(rand.nextInt(1, 10));
        this.setHp(rand.nextInt(2, 10));
        this.setName(name);
    }

}
