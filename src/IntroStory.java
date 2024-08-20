
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroStory {

    App app;
    JPanel userInputPanel, choiceButtoPanel;
    JTextField userInputArea;
    JButton submitButton, continueButton;
    Font mainTextAreaFont;
    Font normalFont;
    Container container;
    Hero hero;
    CaveStory caveStory;

    int currentPartIndex;
    ArrayList<String> storyParts;

    Boolean introStoryCompleted = false;

    public IntroStory(App app, Font mainTextAreaFont, Font normalFont, Container container, JPanel choicButtonPanel) {
        this.app = app;
        this.mainTextAreaFont = mainTextAreaFont;
        this.normalFont = normalFont;
        this.container = container;
        this.hero = new Hero();
        this.choiceButtoPanel = choicButtonPanel;
        this.caveStory = new CaveStory(app, mainTextAreaFont, normalFont, container, hero);
    }

    public void introStoryText() {
        app.setMainTextArea("First tell me your name human!.");
        choiceButtoPanel.setVisible(false);

        userInputPanel = new JPanel();
        userInputPanel.setLayout(new GridLayout(2, 1));
        userInputPanel.setBounds(100, 600, 600, 100);
        userInputPanel.setBackground(Color.black);
        container.add(userInputPanel);

        userInputArea = new JTextField("");
        userInputArea.setBounds(100, 600, 600, 80);
        userInputArea.setBackground(Color.white);
        userInputArea.setForeground(Color.black);
        userInputArea.setFont(mainTextAreaFont);
        userInputPanel.add(userInputArea);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.setFont(normalFont);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new SubmitNameListener(userInputArea));
        userInputPanel.add(submitButton);
    }

    public void introStoryText2() {
        app.setMainTextArea("Greetings " + hero.getName() + ". Next, tell me how many winters old are you?");
        submitButton.removeActionListener(submitButton.getActionListeners()[0]);
        submitButton.addActionListener(new SubmitAgeListener(userInputArea));
    }

    public void introStoryText3() {

        currentPartIndex = 0;

        userInputArea.setVisible(false);
        submitButton.setVisible(false);

        continueButton = new JButton("Continue");
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);
        continueButton.setFocusPainted(false);

        continueButton.addActionListener(new Press());
        userInputPanel.add(continueButton);

        storyParts = new ArrayList<>();

        storyParts.add("Well well puny human so you have already survived " + hero.getAge() + " Winters. I bet this will be your last. Now I promised to tell you what a Stratcher is.");
        storyParts.add("A Stratcher is a very dangerous creature indeed.");
        storyParts.add("She is witty, she has long razor-sharp claws, she may look cute but don't be fooled.");
        storyParts.add("Many adventurers have been fooled into thinking she is harmless");
        storyParts.add("Some even went as far as to try petting her to great avail");
        storyParts.add("I tell you this" + " " + hero.getName() + " " + "Whatever you do, never approach her.");
        storyParts.add("There are three possible locations where the Stratcher might recide.");
        storyParts.add("- 1 The cave of roses");
        storyParts.add("- 2 The island of the dead");
        storyParts.add("- 3 The Mountain of fire and flesh");
        storyParts.add("You must choose you first destination wisely");
        storyParts.add("Where would you like to explore first?");

        app.setMainTextArea(storyParts.get(currentPartIndex));

    }

    public void whereToGo() {
        app.setMainTextArea("Where would you like to go?");
        choiceButtoPanel.setVisible(true);
    }

    public class SubmitNameListener implements ActionListener {

        JTextField userInputArea;

        public SubmitNameListener(JTextField userInputArea) {
            this.userInputArea = userInputArea;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = userInputArea.getText();
            hero.setName(name);
            userInputArea.setText("");
            introStoryText2();
        }
    }

    public class SubmitAgeListener implements ActionListener {

        JTextField userInputArea;

        public SubmitAgeListener(JTextField userInputArea) {
            this.userInputArea = userInputArea;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int age = Integer.parseInt(userInputArea.getText());
            hero.setAge(age);
            userInputArea.setText("");
            introStoryText3();
        }
    }

    public class Press implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentPartIndex++;
            if (currentPartIndex < storyParts.size()) {
                app.setMainTextArea(storyParts.get(currentPartIndex));
            } else {
                continueButton.setVisible(false);
                whereToGo();
            }
        }
    }
}
