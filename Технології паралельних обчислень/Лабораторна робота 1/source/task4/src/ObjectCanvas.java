import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ObjectCanvas extends JPanel
{
    private final ArrayList<Ball> balls = new ArrayList<>();

    public void addBall(Ball b)
    {
        this.balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            if (b != null) b.draw(g2);
//            b.draw(g2, Color.RED);
        }
    }
}
