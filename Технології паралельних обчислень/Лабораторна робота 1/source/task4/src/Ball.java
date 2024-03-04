import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Ball
{
    private final Component canvas;

    // Розміри кулі
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;

    // Позиція кулі
    private int x;
    private int y;

    // Вектор кулі
    private int dx;
    private int dy;

    // Конструктор кулі
    public Ball(Component c)
    {
        this.canvas = c;

        x = new Random().nextInt(this.canvas.getWidth());
        y = new Random().nextInt(this.canvas.getHeight());

        if (Math.random() < 0.5) {
            if (Math.random() < 0.5) {
                dx = 10;
                dy = 10;
            } else {
                dx = 10;
                dy = -10;
            }
        } else {
            if (Math.random() < 0.5) {
                dx = -10;
                dy = 10;
            } else {
                dx = -10;
                dy = -10;
            }
        }
    }

    // Малювання кулі
    public void draw (Graphics2D g2)
    {
        g2.setColor(Color.BLUE);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
        this.canvas.repaint();
    }

    // Переміщення кулі
    public void move()
    {
        x += dx;
        y += dy;

        if (x < 0){
            x = 0;
            dx = -dx;
        }

        if (x + XSIZE >= this.canvas.getWidth()){
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }

        if (y < 0){
            y = 0;
            dy = -dy;
        }

        if (y + YSIZE >= this.canvas.getHeight()){
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }

        this.canvas.repaint();
    }
}
