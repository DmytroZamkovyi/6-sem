import javax.swing.*;
import java.awt.*;


public class BounceFrame extends JFrame
{
    private final ObjectCanvas canvas;

    public static final int count = 10;

    public static final int WIDTH = 1600;
    public static final int HEIGHT = 800;

    public BounceFrame()
    {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        this.canvas = new ObjectCanvas();

        System.out.println("In Frame Thread name = " + Thread.currentThread().getName());

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        JLabel labelScoreCounter = new JLabel("Score: " + Score.getScore());

        Score.addListener(() -> {
            labelScoreCounter.setText("Score: " + Score.getScore());
            labelScoreCounter.repaint();
        });



        buttonStart.addActionListener(e -> {
            for (int i = 0; i < count; i++) {
                Ball b = new Ball(canvas);
                canvas.addBall(b);

                BallThread thread = new BallThread(b);
                thread.start();

                System.out.println("Thread name = " + thread.getName());
            }
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(labelScoreCounter);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
