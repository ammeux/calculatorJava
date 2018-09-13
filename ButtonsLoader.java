import java.util.ArrayList;
import java.util.Arrays;

public class ButtonsLoader {

    private ArrayList<Button> buttons = new ArrayList<>();

    public ArrayList<Button> loadButtons(){

        Button oneButton = new Button("1", 0, 3);
        Button twoButton = new Button("2", 1, 3);
        Button threeButton = new Button("3", 2, 3);
        Button fourButton = new Button("4", 0, 2);
        Button fiveButton = new Button("5", 1, 2);
        Button sixButton = new Button("6", 2, 2);
        Button sevenButton = new Button("7", 0, 1);
        Button heightButton = new Button("8", 1, 1);
        Button nineButton = new Button("9", 2, 1);
        Button resetButton = new Button("R", 0, 0);
        Button zeroButton = new Button("0", 1, 0);
        Button equalButton = new Button("=", 2, 0);
        Button plusButton = new Button("+", 3, 3);
        Button minusButton = new Button("-", 3, 2);
        Button multiplyButton = new Button("*", 3, 1);
        Button divideButton = new Button("/", 3, 0);
        Button factorialButton = new Button("!", 2,0);
        Button moduloButton = new Button("%", 1, 0);
        Button clearButton = new Button("C", 0, 4);

        this.buttons.addAll(Arrays.asList(zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton,
                sevenButton, heightButton, nineButton, resetButton, equalButton, plusButton, minusButton, multiplyButton,
                divideButton, moduloButton, factorialButton, clearButton));

        return this.buttons;
    }
}
