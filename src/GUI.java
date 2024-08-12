
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {

    public void window() {

        JFrame frame = new JFrame();
        Container container = new Container();

        JPanel titleNamePanel = new JPanel();
        JPanel startButtonPanel = new JPanel();

        JLabel titleNameLabel = new JLabel("Stratcher game");
        JLabel startButtonLabel = new JLabel("START");

        Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);

        JButton startButton = new JButton();

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
        startButtonPanel.setBackground(Color.BLUE);
        startButtonPanel.add(startButton);

        //StartButton
        startButton.setBounds(300, 400, 200, 100);
        startButton.setBackground(Color.BLACK);

        //StartButtonText
        startButtonLabel.setForeground(Color.white);
        startButton.add(startButtonLabel);

        container.add(titleNamePanel);
        container.add(startButtonPanel);

    }

}
