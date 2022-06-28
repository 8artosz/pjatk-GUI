import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Image extends JPanel implements Runnable, KeyListener {
    public static final float groundY = 110;
    public static final int gf = 0;
    public static final int gp = 1;
    public static final int go = 2;
    private String highScore="0";
    private Thread thread;
    private Person person;
    private Grass grass;
    private Clouds clouds;
    private Obstacles obstacles;
    private int gameState = gf;
    private BufferedImage imageGameOver;
    private int score = 0;
    public Image(){
        thread = new Thread(this);
        person = new Person();
        person.setX(50);
        person.setY(60);
        grass = new Grass();
        clouds = new Clouds();
        obstacles = new Obstacles(person);
        imageGameOver = Images.getImage("data/gameover_text.png");
    }

    public void startGame(){
        thread.start();
    }

    @Override
    public void run() {
        cleanTxt();
        while(true){
            update();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        switch(gameState){
            case gp:
                person.update();
                grass.update();
                clouds.update();
                obstacles.update();
                score++;
                if(person.getAlive()== false)
                    gameState = go;
                break;
        }
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);
        g.drawLine(0,(int)groundY,getWidth(),(int)groundY);
        switch(gameState){
            case gf:
                person.draw(g);
                break;
            case gp:
                String sb1 = "";
                try{
                    FileInputStream fis = new FileInputStream("high_score.txt");
                    int b=0;
                    while ((b = fis.read()) != -1){
                        sb1+=((char)b);
                    }
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
                int foo1 = Integer.parseInt(highScore);
                int foo2 = Integer.parseInt(sb1);
                if(foo2>foo1){
                    foo1 = foo2;
                    highScore = sb1;
                }

                g.drawString("High Score: " + foo1,300 ,20);
                grass.draw(g);
                clouds.draw(g);
                person.draw(g);
                obstacles.draw(g);
                g.drawString("Score: " + String.valueOf(score),500,20);
                break;
            case go:
                grass.draw(g);
                clouds.draw(g);
                person.draw(g);
                obstacles.draw(g);
                StringBuilder sb = new StringBuilder();
                sb.append(score);
                try {
                    FileOutputStream fos = new FileOutputStream("high_score.txt");
                    PrintWriter pw = new PrintWriter(fos);
                    pw.print(sb);
                    pw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                g.drawImage(imageGameOver,200,50,null);
                break;
        }
    }

    private void resetGame(){
        person.setAlive(true);
        score = 0;
        person.setX(50);
        person.setY(60);
        obstacles.reset();
    }
    private void cleanTxt(){
        try {
            FileOutputStream fos = new FileOutputStream("high_score.txt");
            PrintWriter pw = new PrintWriter(fos);
            pw.print("0");
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if(gameState==gf)
                    gameState=gp;
                else if(gameState==gp){
                    person.jump();
                }
                else if(gameState==go) {
                    resetGame();
                    gameState = gp;
                }
                break;
        }
    }
}
