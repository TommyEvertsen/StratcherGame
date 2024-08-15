
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaveStory {

    final App app;
    JPanel userInputPanel;
    JTextField userInputArea;
    JButton submitButton;
    Font mainTextAreaFont;
    Font normalFont;

    Container container;

    public CaveStory(App app, Font mainTextAreaFont, Font normalFont, Container container) {
        this.app = app;
        this.mainTextAreaFont = mainTextAreaFont;
        this.normalFont = normalFont;

        this.container = container;
    }

    public void caveStoryText() {

        app.setMainTextArea("You enter a dark cave. The air is thick and damp.");
        app.setOption1Text("text");

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

        userInputPanel.add(submitButton);
    }
}
