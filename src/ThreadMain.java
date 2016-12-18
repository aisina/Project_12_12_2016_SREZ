import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by innopolis on 12.12.2016.
 */
public class ThreadMain {

    public static Integer time = 0;
    public static volatile Boolean flag = false;
    public static int[] numbersCount = new int[100];

    public static void main(String[] args) {

        Thread tRandom = new ThreadRandom(time, numbersCount);
        Thread tPrint = new Thread_5(time, numbersCount);

        tRandom.start();
        tPrint.start();

    }
}
