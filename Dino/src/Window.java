import javax.swing.*;

public class Window extends JFrame {
    private Image image;
    public Window(){
        super("Dino");
        setSize(600,175);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image = new Image();
        add(image);
        addKeyListener(image);

    }
    public void startGame(){
        image.startGame();
    }
    public static void main(String[] args){
        Window window = new Window();
        window.setVisible(true);
        window.startGame();
    }
}
