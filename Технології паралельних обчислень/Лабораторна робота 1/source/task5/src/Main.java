public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Without synchronization");
        Thread T1 = new Thread(new MyThread("-"));
        Thread T2 = new Thread(new MyThread("|"));

        T1.start();
        T2.start();

        T1.join();
        T2.join();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("With synchronization");

        MySync sync = new MySync();
        Thread T3 = new Thread(new MyThreadSync("-", true, sync));
        Thread T4 = new Thread(new MyThreadSync("|", false, sync));

        T3.start();
        T4.start();

        T3.join();
        T4.join();
    }
}
