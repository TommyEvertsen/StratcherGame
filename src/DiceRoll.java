public enum DiceRoll {

ONE("You rolled 1"),
TWO("You rolled 2"),
THREE("You rolled 3"),
FOUR("You rolled 4r"),
FIVE("You rolled 5"),
SIX("You rolled 6 "),
SEVEN("You rolled 7"),
EIGHT("You rolled 8"),
NINE("You rolled 9"),
TEN("You rolled 10"),
ELEVEN("You rolled 11"),
TWELVE("You rolled 12 CRITICAL!");

final String diceRollText;

DiceRoll(String diceRollText){
    this.diceRollText = diceRollText;
}



}
