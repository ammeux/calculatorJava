import javax.swing.JButton;

public class Button extends JButton {

    public String text;
    public Integer xPosition;
    public Integer yPosition;

    public Button(String text, Integer xPosition, Integer yPosition){
        this.text = text;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getText(){
        return text;
    }

    public Integer getxPosition(){
        return xPosition;
    }

    public Integer getyPosition(){
        return yPosition;
    }
}
