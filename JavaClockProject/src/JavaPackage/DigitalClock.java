package JavaPackage;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;


class NewClock extends JFrame{

    private JLabel heading;
    private JLabel ClockLocation;
    Font font = new Font("",Font.BOLD,40);

    //In main class Constructor direct call when user create object.
    NewClock(){

         // Creating main Frame in Constructor
        setTitle("Project Clock");
        setSize(500,500);
        setLocation(400,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(225, 219, 11));
        //Constructor direct call them after creating Object.
        GetGUI();
        ClockStart();

    }

    public void GetGUI(){

        heading = new JLabel("Digital Clock");
        ClockLocation = new JLabel("Time Location");

        //to handle the size of Fonts
        heading.setFont(font);

        ClockLocation.setFont(font);
        ClockLocation.setBounds(50, 10, 120, 120);
         //Creating two rows and one columns
        setLayout(new GridLayout(2,1));

        //background image
        //setBounds


        add(heading);
        add(ClockLocation);


    }

    public void ClockStart(){

        Thread thread = new Thread(){

            public void run(){
                try {while(true){

                    SimpleDateFormat SDF = new SimpleDateFormat("mm :  : ss a");
                    Date  d = new Date();

                    String datetime = SDF.format(d);
                    ClockLocation.setText(datetime);


                    Thread.sleep(5000);
                }

                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();

                }

            }

        };
        thread.start();

    }


}



public class DigitalClock{

    public static void main(String[] args) {

        NewClock N1 = new NewClock();
    }
}

