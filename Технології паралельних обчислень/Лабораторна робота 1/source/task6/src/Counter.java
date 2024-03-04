public class Counter
{
    private final static Object lock = new Object();
    private static int i = 0;

    public static int getI()
    {
        return Counter.i;
    }

    public static void increment()
    {
        Counter.i++;
    }

    public static void decrement()
    {
        Counter.i--;
    }

    public static synchronized void incrementSync()
    {
        Counter.i++;
    }

    public static synchronized void decrementSync()
    {
        Counter.i--;
    }

    public static void incrementSyncBlock()
    {
        synchronized (Counter.class) {
            Counter.i++;
        }
    }

    public static void decrementSyncBlock()
    {
        synchronized (Counter.class) {
            Counter.i--;
        }
    }

    public static void incrementLock()
    {
        synchronized (lock) {
            Counter.i++;
        }
    }

    public static void decrementLock()
    {
        synchronized (lock) {
            Counter.i--;
        }
    }

    public static void reset()
    {
        Counter.i = 0;
    }
}
