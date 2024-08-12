
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {
        Enter input = new Enter();
        DiceRolls roll = new DiceRolls();
        Enemies enemy = new Enemies();
        Enemies stratcher = new Stratcher();
        Hero hero = new Hero();
        Story story = new Story();
        Clean clean = new Clean();
        Continue pressTContinue = new Continue();
        GUI gui = new GUI();

        //Game
        gui.window();
        clean.clearScreen();
        TimeUnit.SECONDS.sleep(1);
        story.intro();
        TimeUnit.SECONDS.sleep(3);

        input.setHeroName(hero);
        input.setHeroAge(hero);

        clean.clearScreen();
        System.out.println("This is the current version of yourself:");
        hero.heroStats();
        pressTContinue.enterToContinue();

        clean.clearScreen();
        story.introduction();
        pressTContinue.enterToContinue();

        clean.clearScreen();
        story.locations();
        input.setDestination(story);

        if (story.getLocation() == 1) {
            System.out.println("yo");
        }

    }

}
