import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ObjectCanvas extends JPanel
{
    private final ArrayList<Ball> balls = new ArrayList<>();
    private final Pool[] pools = new Pool[6];

    public void addBall(Ball b)
    {
        this.balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        pools[0] = new Pool(0, 0, g2);
        pools[1] = new Pool(super.getWidth() / 2, 0, g2);
        pools[2] = new Pool(super.getWidth(), 0, g2);
        pools[3] = new Pool(0, super.getHeight(), g2);
        pools[4] = new Pool(super.getWidth() / 2, super.getHeight(), g2);
        pools[5] = new Pool(super.getWidth(), super.getHeight(), g2);

        for (Ball b : balls) {
            b.draw(g2);
        }
    }

    public int[][] getPoolsCoordinates()
    {
        int[][] coordinates = new int[pools.length][2];

        for (int i = 0; i < pools.length; i++) {
            coordinates[i][0] = pools[i].getX();
            coordinates[i][1] = pools[i].getY();
        }

        return coordinates;
    }

    public int[] getPoolSize()
    {
        int[] size = new int[2];
        size[0] = Pool.getXSIZE();
        size[1] = Pool.getYSIZE();
        return size;
    }

    public void removeBall(Ball b)
    {
        Score.incrementScore();
        balls.remove(b);
    }
}
