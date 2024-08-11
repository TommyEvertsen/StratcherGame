
import java.util.Random;

public class DiceRolls {

    public void roll() {
        Random rand = new Random();
        int random = rand.nextInt(1, 13);

        switch (random) {
            case 1 ->
                System.out.println(DiceRoll.ONE.diceRollText);
            case 2 ->
                System.out.println(DiceRoll.TWO.diceRollText);
            case 3 ->
                System.out.println(DiceRoll.THREE.diceRollText);
            case 4 ->
                System.out.println(DiceRoll.FOUR.diceRollText);
            case 5 ->
                System.out.println(DiceRoll.FIVE.diceRollText);
            case 6 ->
                System.out.println(DiceRoll.SIX.diceRollText);
            case 7 ->
                System.out.println(DiceRoll.SEVEN.diceRollText);
            case 8 ->
                System.out.println(DiceRoll.EIGHT.diceRollText);
            case 9 ->
                System.out.println(DiceRoll.NINE.diceRollText);
            case 10 ->
                System.out.println(DiceRoll.TEN.diceRollText);
            case 11 ->
                System.out.println(DiceRoll.ELEVEN.diceRollText);
            case 12 ->
                System.out.println(DiceRoll.TWELVE.diceRollText);
            default ->
                throw new AssertionError();
        }

    }

}
