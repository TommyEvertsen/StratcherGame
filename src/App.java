
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App {

    JFrame frame;
    Container container;
    JPanel titleNamePanel, startButtonPanel, storyTextPanel, choiceButtonPanel, userInputPanel;
    JLabel titleNameLabel, startButtonLabel;
    JButton startButton, option1, option2, option3, showStats, submitButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times new Roman", Font.PLAIN, 30);
    Font mainTextAreaFont = new Font("Times new Roman", Font.PLAIN, 28);
    JTextArea mainTextArea;
    JTextField userInputArea;

    titleScreenRenderer tsRenderer = new titleScreenRenderer();
    caveStoryRenderer caveStoryRenderer = new caveStoryRenderer();

    IntroStory introStory;
    CaveStory caveStory;

    Hero hero = new Hero();

    public static void main(String[] args) throws Exception {
        new App();

    }

    public JTextArea getMainTextArea() {
        return mainTextArea;
    }

    public JPanel getUserInputPanel() {
        return userInputPanel;
    }

    public JPanel getChoiceButtonPanel() {
        return choiceButtonPanel;
    }

    public JButton getOption1() {
        return option1;
    }

    public JButton getOption2() {
        return option2;
    }

    public JButton getOption3() {
        return option3;
    }

    public void setMainTextArea(String text) {
        this.mainTextArea.setText(text);
    }

    public void UserInputPanel(boolean visible) {
        this.userInputPanel.setVisible(visible);
    }

    public void setTitleNameLabel(String text) {
        this.titleNameLabel.setText(text);
    }

    public void setOption1Text(String text) {
        this.option1.setText(text);
    }

    public void setOption2Text(String text) {
        this.option2.setText(text);
    }

    public void setOption3Text(String text) {
        this.option3.setText(text);
    }

    public App() {

        frame = new JFrame();
        container = new Container();

        titleNamePanel = new JPanel();
        startButtonPanel = new JPanel();

        titleNameLabel = new JLabel("Stratcher game");
        startButtonLabel = new JLabel("START");

        startButton = new JButton();

        //Main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stratcher game");
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(800, 800);
        frame.setLayout(null);

        container = frame.getContentPane();

        //Titlepanel
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);

        //Titletext
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        //Startbutton panel
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButtonPanel.add(startButton);

        //StartButton
        startButton.setBounds(300, 400, 200, 100);
        startButton.setBackground(Color.BLACK);
        startButton.addActionListener(tsRenderer);
        startButton.setFocusPainted(false);

        //StartButtonText
        startButtonLabel.setForeground(Color.white);
        startButtonLabel.setFont(normalFont);
        startButton.add(startButtonLabel);

        container.add(titleNamePanel);
        container.add(startButtonPanel);

    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        storyTextPanel = new JPanel();
        storyTextPanel.setBounds(100, 100, 600, 250);
        storyTextPanel.setBackground(Color.black);

        container.add(storyTextPanel);

        mainTextArea = new JTextArea("This is a story of a chuppy hero and a Stratcher. If you dont know what a Stratcher is i will tell you. But first tell me about yourself. What is your name hero?");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(mainTextAreaFont);
        mainTextArea.setLineWrap(true);

        storyTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setVisible(false);
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));

        container.add(choiceButtonPanel);

        option1 = new JButton("Test");
        option1.setBackground(Color.BLACK);
        option1.setForeground(Color.white);
        option1.setFont(normalFont);
        option1.setFocusPainted(false);
        option1.addActionListener(caveStoryRenderer);

        option2 = new JButton("Test");
        option2.setForeground(Color.white);
        option2.setFont(normalFont);
        option2.setBackground(Color.BLACK);
        option2.setFocusPainted(false);

        option3 = new JButton("Test");
        option3.setBackground(Color.BLACK);
        option3.setForeground(Color.white);
        option3.setFont(normalFont);
        option3.setFocusPainted(false);

        showStats = new JButton("Show stats");
        showStats.setBackground(Color.BLACK);
        showStats.setForeground(Color.white);
        showStats.setFont(normalFont);
        showStats.setFocusPainted(false);

        choiceButtonPanel.add(option1);
        choiceButtonPanel.add(option2);
        choiceButtonPanel.add(option3);
        choiceButtonPanel.add(showStats);

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
        submitButton.addActionListener(new SubmitNameListener());

        userInputPanel.add(submitButton);

    }

    public class titleScreenRenderer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

    public class caveStoryRenderer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            caveStory = new CaveStory(App.this);

            caveStory.caveStoryText();
        }

    }

    public class SubmitNameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String userInput = userInputArea.getText();

            try {
                hero.setName(userInput);
                userInputPanel.setVisible(false);
                introStory = new IntroStory(App.this, hero);

                introStory.introStoryText();

                userInputArea.setText("");
                System.out.println(hero.getName());
            } catch (Exception ex) {
                mainTextArea.setText("Write a name silly human.");

            }

        }

    }
}
