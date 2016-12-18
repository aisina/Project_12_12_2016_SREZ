import java.sql.Time;

/**
 * Created by innopolis on 12.12.2016.
 */
public class Thread_5 extends Thread {

    Integer time;
    int[] numbersCount;
    static final Object monitor = new Object();

    Thread_5(Integer time, int[] numbersCount) {
        this.time = time;
        this.numbersCount = numbersCount;
    }

    @Override
    public void run() {
        while (!isInterrupted() && !ThreadMain.flag) {
            //if (!flag) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (numbersCount) {

                    for (int i = 0; i < numbersCount.length; i++) {
                        System.out.print(numbersCount[i] + " ");
                        if (numbersCount[i] > 5) {
                            ThreadMain.flag = true;
                        }
                    }
                    System.out.println();
                    if(ThreadMain.flag){
                        break;
                    }
                }
            /*} else {
                //interrupt();
                break;
            }*/

        }
    }
}
