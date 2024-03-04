public class BallThread extends Thread
{
    private final Ball b;

    // Конструктор класса
    public BallThread(Ball ball)
    {
        b = ball;
    }

    @Override
    public void run()
    {
        try {
            while (!Thread.interrupted()) {
                b.move();
                System.out.println("Thread name = " + Thread.currentThread().getName());
                if (b.getIsInPool()) {
                    System.out.println("Thread name ended = " + Thread.currentThread().getName());
                    b.delete();
                    Thread.currentThread().interrupt();
                }
                Thread.sleep(5);
            }
        } catch(InterruptedException ignored) {}
    }
}
