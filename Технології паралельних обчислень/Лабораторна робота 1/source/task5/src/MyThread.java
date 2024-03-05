public class MyThread extends Thread
{
    private final String s;

    public MyThread (String s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(this.s);
            }
            System.out.println();
        }
    }
}
