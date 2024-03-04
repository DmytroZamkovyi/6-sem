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
    private int dx = 5;
    private int dy = 5;

    // Чи була куля забита в лузу
    private boolean isInPool = false;

    // Конструктор кулі
    public Ball(Component c)
    {
        this.canvas = c;

        x = new Random().nextInt(this.canvas.getWidth());
        y = new Random().nextInt(this.canvas.getHeight());
    }

    // Малювання кулі
    public void draw (Graphics2D g2)
    {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
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

        int[][] poolsCoordinates = ((ObjectCanvas)this.canvas).getPoolsCoordinates();
        int[] poolSize = ((ObjectCanvas)this.canvas).getPoolSize();

        for (int[] poolsCoordinate : poolsCoordinates) {
            if (x + XSIZE >= poolsCoordinate[0] && x <= poolsCoordinate[0] + poolSize[0] && y + YSIZE >= poolsCoordinate[1] && y <= poolsCoordinate[1] + poolSize[1]) {
                this.isInPool = true;
                break;
            }
        }

        this.canvas.repaint();
    }

    // Чи була куля забита в лузу
    public boolean getIsInPool()
    {
        return this.isInPool;
    }

    // Видалення кулі
    public void delete()
    {
        ((ObjectCanvas)this.canvas).removeBall(this);
    }
}
