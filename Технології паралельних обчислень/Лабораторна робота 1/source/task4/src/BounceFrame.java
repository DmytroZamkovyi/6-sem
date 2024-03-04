import javax.swing.*;
import java.awt.*;


public class BounceFrame extends JFrame
{
    private final ObjectCanvas canvas;

    public static final int ballsCount = 50;

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

        buttonStart.addActionListener(e -> {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < ballsCount; i++) {
                        Ball b = new Ball(canvas);
                        canvas.addBall(b);

                        BallThread thread = new BallThread(b);
                        thread.start();

                        System.out.println("Thread name = " + thread.getName());

                        try {
                            thread.join();
                        } catch (InterruptedException ignored) { }
                    }
                }
            });
            t.start();
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
