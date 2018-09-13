import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class Window extends JFrame{

    private String previousOperation = "0";
    private String textToDisplay = "";
    private Calculator calculator = new Calculator();

    public Window(String title, Integer height, Integer width){

        ArrayList<Button> buttons = new ArrayList<>();
        ButtonsLoader buttonsLoader = new ButtonsLoader();
        OperationsMaker operationsMaker = new OperationsMaker();

        // JFrame and Panel initialization //
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(5,4));
        this.add(panel, BorderLayout.CENTER);

        // Screen initialization //
        JLabel screen = new JLabel("0", JLabel.CENTER);
        screen.setHorizontalTextPosition(JLabel.CENTER);
        screen.setPreferredSize(new Dimension(300,100));
        screen.setFont(new Font("Arial", Font.PLAIN, 50));
        this.add(screen, BorderLayout.NORTH);

        // Key pad initialization
        buttons = buttonsLoader.loadButtons();
        buttons.sort(Comparator.comparing(Button::getyPosition).reversed());

        for (Button button: buttons){

            // set buttons format
            button.setBorder(new RoundedBorder(50));
            button.setContentAreaFilled(false);
            button.setOpaque(true);
            button.setText(button.text);

            // set buttons listener
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        switch (button.text) {
                            case "R":
                                textToDisplay = "0";
                                break;
                            case "C":
                                if (screen.getText().length() == 1)
                                    textToDisplay = previousOperation;
                                else
                                    textToDisplay = screen.getText().substring(0, screen.getText().length() - 1);
                                break;
                            case "=":
                                String operations = screen.getText();
                                if(!Character.isDigit(operations.charAt(operations.length()-1)))
                                    throw new CalcException("operation seems not complete");
                                else {
                                    textToDisplay = operationsMaker.makeOperations(operations);
                                    previousOperation = screen.getText();
                                }
                                break;
                            case "!":
                                if(!screen.getText().matches("^[0-9]+$"))
                                    throw new CalcException("Please enter numerical value only");
                                else if(Integer.parseInt((screen.getText())) <= 0)
                                    throw new CalcException("Please enter a factorable number");
                                else
                                    textToDisplay = calculator.factorial(Integer.parseInt(screen.getText())).toString();
                                break;
                            default:
                                if (screen.getText().equals("0"))
                                    textToDisplay = button.text;
                                else
                                    textToDisplay += button.text;
                                break;
                        }
                        screen.setText(textToDisplay);
                    }
                    catch (CalcException exc){
                        JOptionPane.showMessageDialog(null, exc, "INFO",JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            panel.add(button);
        }
        this.setVisible(true);
    }
}
