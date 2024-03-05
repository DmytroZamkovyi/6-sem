public class MySync
{
    private boolean isRun = true;
    private boolean finish = false;
    private int count = 0;

    public synchronized void wait(boolean isRun, String s)
    {
        while (this.isRun != isRun) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }

        System.out.print(s);
        this.isRun = !isRun;
        this.count++;

        if (this.count % 100 == 0) System.out.println();
        if (count + 1 == 10000) finish = true;

        notifyAll();
    }

    public synchronized boolean getFinish()
    {
        return finish;
    }
}
