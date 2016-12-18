import java.util.HashSet;
import java.util.Random;

/**
 * Created by innopolis on 12.12.2016.
 */
public class ThreadRandom extends Thread {

    Integer time;
    int[] numbersCount;
    static final Object monitor = new Object();

    ThreadRandom(Integer time, int[] numbersCount) {
        this.time = time;
        this.numbersCount = numbersCount;
    }

    @Override
    public void run() {
        while (!isInterrupted() && !ThreadMain.flag) {
                try {
                    Thread.sleep(1000);
                    if(!ThreadMain.flag) {
                        Random random = new Random();
                        int random_int = random.nextInt(99);
                        System.out.println("Thread1 " + random_int);

                        synchronized (numbersCount) {
                            time++;
                            numbersCount[random_int]++;
                        }
                    }
                    else{
                        break;
                        //interrupt();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}
