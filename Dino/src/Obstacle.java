import java.awt.*;

public abstract class Obstacle {
    public abstract void draw(Graphics g);
    public abstract void update();
    public abstract boolean isoutofscreen();
    public abstract int getX();
    public abstract int getY();
}
