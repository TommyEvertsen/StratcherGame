
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    String[] storyParts;
    int currentPartIndex;

    public IntroStory(App app, Font mainTextAreaFont, Font normalFont, Container container, JPanel choicButtonPanel) {
        this.app = app;
        this.mainTextAreaFont = mainTextAreaFont;
        this.normalFont = normalFont;
        this.container = container;
        this.hero = new Hero();
        this.choiceButtoPanel = choicButtonPanel;
        this.caveStory = new CaveStory(app, mainTextAreaFont, normalFont, container, hero);

        storyParts = new String[]{
            "Well well puny human so you have survived " + hero.getAge() + " Winters. Now I promised to tell you what a Stratcher is.",
            "A Stratcher is a very dangerous creature indeed.",
            "She is witty."
        };
        currentPartIndex = 0;

    }

    public void introStoryText() {

        app.setMainTextArea("First tell me your name human!.");

        choiceButtoPanel.setVisible(false);

        //UserInput
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

        app.setMainTextArea("Greetings" + " " + hero.getName() + " " + "Next tell me how many winters old are you?");
        submitButton.removeActionListener(submitButton.getActionListeners()[0]);
        submitButton.addActionListener(new SubmitAgeListener(userInputArea));

    }

    public void introStoryText3() {

        userInputArea.setVisible(false);
        submitButton.setVisible(false);

        continueButton = new JButton("Continue");
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);
        continueButton.setFocusPainted(false);

        continueButton.addActionListener(new Press());

        userInputPanel.add(continueButton);

        app.setMainTextArea(storyParts[currentPartIndex]);

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

            submitButton.addActionListener(new SubmitAgeListener(userInputArea));

            introStoryText3();
        }

    }

    public class Press implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentPartIndex++;
            if (currentPartIndex < storyParts.length) {
                app.setMainTextArea(storyParts[currentPartIndex]);
            } else {

                continueButton.setVisible(false);
                caveStory.caveStoryText();
            }
        }

    }
}
