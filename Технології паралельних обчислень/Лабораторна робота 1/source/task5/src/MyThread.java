public class MyThread extends Thread
{
    private final String output_str;

    public MyThread (String s)
    {
        this.output_str = s;
    }

    @Override
    public void run()
    {
        System.out.println("START thread - " + Thread.currentThread().getName());
    }

    public void print()
    {
        try {
            System.out.print(this.output_str);
            Thread.sleep(0);
        } catch (InterruptedException ignored) { }
    }
}
