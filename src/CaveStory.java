
public class CaveStory {

    final App app;

    public CaveStory(App app) {
        this.app = app;
    }

    public void caveStoryText() {

        app.setMainTextArea("You enter a dark cave. The air is thick and damp.");
        app.setOption1Text("text");
    }
}
