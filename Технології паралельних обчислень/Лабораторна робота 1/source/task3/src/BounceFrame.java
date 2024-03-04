import javax.swing.*;
import java.awt.*;


public class BounceFrame extends JFrame
{
    private final ObjectCanvas canvas;

    public static final int blueCount = 50;
    public static final int redCount = 1;

    public static final int WIDTH = 1600;
    public static final int HEIGHT = 800;

    public BounceFrame()
    {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        this.canvas = new ObjectCanvas();

//        System.out.println("In Frame Thread name = " + Thread.currentThread().getName());

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
            for (int i = 0; i < redCount; i++) {
                Ball b = new Ball(canvas);
                canvas.addRedBall(b);

                BallThread thread = new BallThread(b);
                thread.start();
                thread.setPriority(Thread.MAX_PRIORITY);

//                System.out.println("Thread name = " + thread.getName());
            }

            for (int i = 0; i < blueCount; i++) {
                Ball b = new Ball(canvas);
                canvas.addBlueBall(b);

                BallThread thread = new BallThread(b);
                thread.start();
                thread.setPriority(Thread.MIN_PRIORITY);

//                System.out.println("Thread name = " + thread.getName());
            }
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(labelScoreCounter);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
