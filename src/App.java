
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

public class App {

    JFrame frame;
    Container container;
    JPanel titleNamePanel, startButtonPanel, storyTextPanel, choiceButtonPanel;
    JLabel titleNameLabel, startButtonLabel;
    JButton startButton, option1, option2, option3;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times new Roman", Font.PLAIN, 30);
    Font mainTextAreaFont = new Font("Times new Roman", Font.PLAIN, 28);
    JTextArea mainTextArea;

    titleScreenRenderer tsRenderer = new titleScreenRenderer();

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
        frame.getContentPane().setBackground(Color.BLACK);
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

        mainTextArea = new JTextArea("This is the story");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(mainTextAreaFont);
        mainTextArea.setLineWrap(true);

        storyTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(3, 1));

        container.add(choiceButtonPanel);

        option1 = new JButton("Test");
        option1.setBackground(Color.BLACK);
        option1.setForeground(Color.white);
        option1.setFont(normalFont);

        option2 = new JButton("Test");
        option2.setForeground(Color.white);
        option2.setFont(normalFont);
        option2.setBackground(Color.BLACK);

        option3 = new JButton("Test");
        option3.setBackground(Color.BLACK);
        option3.setForeground(Color.white);
        option3.setFont(normalFont);

        choiceButtonPanel.add(option1);
        choiceButtonPanel.add(option2);
        choiceButtonPanel.add(option3);

    }

    public class titleScreenRenderer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

}
