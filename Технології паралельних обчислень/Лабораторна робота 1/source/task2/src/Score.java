public class Score
{
    private static int score = 0;
    private static ScoreListener listener = null;

    public static int getScore()
    {
        return score;
    }

    public static void incrementScore()
    {
        Score.score++;
        listener.actionPerformed();
    }

    public static void addListener(ScoreListener listener)
    {
        Score.listener = listener;
    }
}
