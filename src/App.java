
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
    introStoryRenderer introStoryRenderer = new introStoryRenderer();
    caveStoryRenderer caveStoryRenderer = new caveStoryRenderer();

    IntroStory introStory;
    CaveStory caveStory;

    Hero hero = new Hero();

    public static void main(String[] args) throws Exception {
        new App();

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

        mainTextArea = new JTextArea("This is a story of a chuppy hero and a Stratcher. If you dont know what a Stratcher is i will tell you. But first tell me about yourself.");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(mainTextAreaFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);

        storyTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setVisible(true);
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));

        container.add(choiceButtonPanel);

        option1 = new JButton("Continue");
        option1.setBackground(Color.BLACK);
        option1.setForeground(Color.white);
        option1.setFont(normalFont);
        option1.setFocusPainted(false);
        option1.addActionListener(introStoryRenderer);

        option2 = new JButton("Test");
        option2.setForeground(Color.white);
        option2.setFont(normalFont);
        option2.setBackground(Color.BLACK);
        option2.setFocusPainted(false);
        option2.setVisible(false);

        option3 = new JButton("Test");
        option3.setBackground(Color.BLACK);
        option3.setForeground(Color.white);
        option3.setFont(normalFont);
        option3.setFocusPainted(false);
        option3.setVisible(false);

        showStats = new JButton("Show stats");
        showStats.setBackground(Color.BLACK);
        showStats.setForeground(Color.white);
        showStats.setFont(normalFont);
        showStats.setFocusPainted(false);
        showStats.setVisible(false);

        choiceButtonPanel.add(option1);
        choiceButtonPanel.add(option2);
        choiceButtonPanel.add(option3);
        choiceButtonPanel.add(showStats);

    }

    public class titleScreenRenderer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

    public class introStoryRenderer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            introStory = new IntroStory(App.this, mainTextAreaFont, normalFont, container, choiceButtonPanel);

            introStory.introStoryText();
        }

    }

    public class caveStoryRenderer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            caveStory = new CaveStory(App.this, mainTextAreaFont, normalFont, container, hero);

            caveStory.caveStoryText();
        }

    }

    public JTextField getUserInputArea() {
        return userInputArea;
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

    public void SetUserInputPanelVisibilty(boolean visible) {
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
}
