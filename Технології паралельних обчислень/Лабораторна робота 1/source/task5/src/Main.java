public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        MyThread thread1 = new MyThread("-");
        thread1.start();
        thread1.join();

        MyThread thread2 = new MyThread("|");
        thread2.start();
        thread2.join();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                thread1.print();
                thread1.join();

                thread2.print();
                thread2.join();
            }
            System.out.println();
        }
    }
}
