
import java.awt.Color;

import javax.swing.*;

public class App {
    
    public App(){

        JFrame frame= new JFrame();

        JPanel panelMain= new JPanel();
        panelMain.setBounds(0, 0, 600, 600);
        panelMain.setBackground(Color.PINK);

        
        JLabel inputLb= new JLabel("Enter Decimal Number:");
        inputLb.setBounds(40, 0, 200, 100);

        JTextField inputTf= new JTextField();
        inputTf.setBounds(40, 80, 140, 20);

        JButton covertBtn= new JButton("CONVERT");
        covertBtn.setBounds(40, 120, 120, 20);


        JTextArea resultTa= new JTextArea();
        resultTa.setBounds(40, 280, 500, 240);
        resultTa.setEditable(false);                                //Remove if Enable doesn't prevent text from being generated in TEXTAREA
        resultTa.setEnabled(false);
        

        //FRAME REQUIREMENTS
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Turning Machine");
        

        //ADDED COMPONENTS
        frame.add(panelMain);
        panelMain.add(inputLb);
        panelMain.add(inputTf);
        panelMain.add(covertBtn);
        panelMain.add(resultTa);
        panelMain.setLayout(null);
        



        //ACTION LISTENER FOR BTN
        covertBtn.addActionListener();


    }



    public static void main(String[] args){
        new App();
    }
}
