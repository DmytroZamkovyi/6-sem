public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("No sync ");
        Thread threadInc = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.increment();
            }
        });

        Thread threadDec = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.decrement();
            }
        });

        threadInc.start();
        threadDec.start();

        threadInc.join();
        threadDec.join();

        System.out.println("Counter: " + Counter.getI());

        Counter.reset();

        System.out.println("Sync by method");

        Thread threadIncSync = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.incrementSync();
            }
        });

        Thread threadDecSync = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.decrementSync();
            }
        });

        threadIncSync.start();
        threadDecSync.start();

        threadIncSync.join();
        threadDecSync.join();

        System.out.println("Counter: " + Counter.getI());

        Counter.reset();

        System.out.println("Sync by block");

        Thread threadIncSyncBlock = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.incrementSyncBlock();
            }
        });

        Thread threadDecSyncBlock = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.decrementSyncBlock();
            }
        });

        threadIncSyncBlock.start();
        threadDecSyncBlock.start();

        threadIncSyncBlock.join();
        threadDecSyncBlock.join();

        System.out.println("Counter: " + Counter.getI());

        Counter.reset();

        System.out.println("Sync by lock");

        Thread threadIncLock = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.incrementLock();
            }
        });

        Thread threadDecLock = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                Counter.decrementLock();
            }
        });

        threadIncLock.start();
        threadDecLock.start();

        threadIncLock.join();
        threadDecLock.join();

        System.out.println("Counter: " + Counter.getI());

        Counter.reset();
    }
}
