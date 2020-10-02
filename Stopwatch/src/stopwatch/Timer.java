package stopwatch;

public class Timer implements Runnable{
    Stopwatch mysw;

    public Timer(Stopwatch sw){
        mysw = sw;
    }

    public static int hour =0;
    public static int min =0;
    public static int sec =0;

    @Override
    public void run() {

        try {
            while(true){
                Thread.sleep(1000);
                sec++;
                if(sec==60){
                    min++;
                    sec=0;
                }
                if(min==60){
                    hour++;
                    min=0;
                }
                //UI display
                mysw.setTime(hour, min, sec);

                if(mysw.timerStop){ break; }

                }
    } catch (Exception e){
            System.out.println((e.getMessage()));
        }


    }
}
