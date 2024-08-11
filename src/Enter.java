
import java.util.Scanner;

public class Enter {

    Scanner enterText = new Scanner(System.in);

    public void whatToDo() {
        System.out.println("What do you want to do?");

    }

    public void setHeroName(Hero hero) {
        System.out.println("Whats your name?");
        hero.setName(enterText.nextLine());
    }

    public void setHeroAge(Hero hero) {
        System.out.println("Hello" + " " + hero.getName() + " " + "Nice to meet you. Now please tell me your age");
        while (true) {
            try {
                hero.setAge(enterText.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("You have to enter a number. Please try again.");
                enterText.next();
            }
        }
    }

    public void setDestination(Story story) {
        System.out.println("Where do you want to go? Enter the number");
        while (true) {
            try {
                story.setLocation(enterText.nextInt());
                break;
            } catch (Exception e) {
                System.out.println("You have to enter one of the possible numbers");
                enterText.next();
            }
        }

    }
}
