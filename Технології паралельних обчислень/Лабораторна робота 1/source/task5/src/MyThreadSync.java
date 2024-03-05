public class MyThreadSync implements Runnable
{
    private final String s;
    private final boolean isRun;
    private final MySync sync;

    public MyThreadSync(String character, boolean isRunning, MySync synchronize)
    {
        this.s = character;
        this.isRun = isRunning;
        this.sync = synchronize;
    }

    @Override
    public void run()
    {
        while (!sync.getFinish()) {
            sync.wait(this.isRun, this.s);
        }
    }
}
