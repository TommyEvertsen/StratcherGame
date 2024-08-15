
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

    final App app;
    JPanel userInputPanel, choiceButtoPanel;
    JTextField userInputArea;
    JButton submitButton;
    Font mainTextAreaFont;
    Font normalFont;
    Container container;
    Hero hero;

    public IntroStory(App app, Font mainTextAreaFont, Font normalFont, Container container, JPanel choicButtonPanel) {
        this.app = app;
        this.mainTextAreaFont = mainTextAreaFont;
        this.normalFont = normalFont;
        this.container = container;
        this.hero = new Hero();
        this.choiceButtoPanel = choicButtonPanel;
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
            System.out.println("Hero's name is: " + hero.getName());
        }
    }
}
