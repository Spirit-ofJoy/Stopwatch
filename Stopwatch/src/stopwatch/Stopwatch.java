package stopwatch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame {

    private JPanel mainPanel;
    private JTextField Seconds;
    private JTextField Hour;
    private JTextField Minutes;
    private JButton start_button;
    private JButton pause_button;
    private JButton lap_button;
    private JButton stop_button;
    private JButton reset_button;
    private JTextArea lapRecord;
    public static boolean timerStop = false;
    public static boolean pauseState = false;



    public Stopwatch(String title){
        super((title));
        final Thread[] t = new Thread[1];
        Seconds.setEditable(false);
        Minutes.setEditable(false);
        Hour.setEditable(false);
        lapRecord.setEditable(false);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        start_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerStop = false;
                pauseState=false;
                System.out.println("Start Invoked");
                Timer timer = new Timer(Stopwatch.this);
                t[0] = new Thread(timer);
                t[0].start();
            }
        });

        pause_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pause Invoked");
                if(pauseState){
                    t[0].resume();
                    pauseState=false;
                }
                else{
                    t[0].suspend();
                    pauseState=true;
                }
            }
        });

        lap_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Lap Recording");
                lapRecord.append("Lap- " +Timer.hour +":" +Timer.min +":" +Timer.sec +"\n");
            }
        });

        stop_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stop Invoked");
                Timer.sec=0;
                Timer.min=0;
                Timer.hour=0;
                timerStop = true;
            }
        });

        reset_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Watch reset");
                Timer.sec=0;
                Timer.min=0;
                Timer.hour=0;
                setTime(0,0,0);
            }
        });
    }

    public void setTime(int a, int b, int c){
        Hour.setText(String.valueOf(a));
        Minutes.setText(String.valueOf(b));
        Seconds.setText(String.valueOf(c));
    }




}
