
public class IntroStory {

    final App app;
    final Hero hero;

    public IntroStory(App app, Hero hero) {
        this.app = app;
        this.hero = hero;

    }

    public void introStoryText() {

        app.setMainTextArea("Greeting tiny human. I see you name is" + " " + hero.getName() + " " + "How many winters are you?");

    }
}
