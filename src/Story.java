
public class Story {

    private int location;

    public int getLocation() {
        return this.location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void intro() {
        System.out.println("This is a story of a chuppy hero and a Stratcher. If you dont know what a Stratcher is i will tell you. But first tell me about yourself");
    }

    public void introduction() {
        System.out.println("I promised to tell you what a Stratcher is and now i will");
        System.out.println("A Stratcher is a very dangerous creature");
        System.out.println("It has long razor sharp claws and is very witty");
        System.out.println("Many adventurers have tried to catch it but none have succeeded");
        System.out.println("Now its up to you to take on the challenge");
    }

    public void locations() {
        System.out.println("There are three possible locations that the Stratcher may be located");
        System.out.println("");
        System.out.println("-1 The cave of roses");
        System.out.println("-2 The island of the dead");
        System.out.println("-3 Mountain of fire and flesh");
        System.out.println("");
    }

}
