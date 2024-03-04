import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Pool
{
    private static final int XSIZE = 40;
    private static final int YSIZE = 40;

    private int x;
    private int y;

    public Pool(int x, int y, Graphics2D g2)
    {


        this.x = x - XSIZE;
        this.y = y - YSIZE;

        if (this.x < 0) this.x = 0;
        if (this.y < 0) this.y = 0;

        this.draw(g2);
    }

    public void draw (Graphics2D g2)
    {
        g2.setColor(Color.green);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public static int getXSIZE()
    {
        return XSIZE;
    }

    public static int getYSIZE()
    {
        return YSIZE;
    }
}
