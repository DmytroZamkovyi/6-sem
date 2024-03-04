public class BallThread extends Thread
{
    private final Ball b;
    private final int time = 100;

    // Конструктор класса
    public BallThread(Ball ball)
    {
        b = ball;
    }

    @Override
    public void run()
    {
        try {
            for (int i = 0; i < this.time; i++) {
                b.move();
                System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch (InterruptedException ignored) {}
    }
}
