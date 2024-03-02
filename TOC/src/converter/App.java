/*Tutor: Mrs. Khalilah Burrell-Battick

Group Members:
Andre Grant - 1908921
Kyle Parris - 1804904
Rojét Facey- 2006746*/


package converter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

public class App {
	private JTextField inputTf;
	private JTextArea resultTa;
    
    
	public JTextArea getResultTa() {
		return resultTa;
	}

	public void setResultTa(JTextArea resultTa) {
		this.resultTa = resultTa;
	}

	public App(){

        JFrame frame= new JFrame();

        JPanel panelMain= new JPanel();
        panelMain.setBounds(0, 0, 600, 600);
        panelMain.setBackground(Color.PINK);

        
        JLabel inputLb= new JLabel("Enter Decimal Number:");
        inputLb.setBounds(40, 0, 200, 100);

        this.inputTf= new JTextField();
        inputTf.setBounds(40, 80, 140, 20);

        JButton covertBtn= new JButton("CONVERT");
        covertBtn.setBounds(40, 120, 120, 20);
        
        JButton invertBtn= new JButton("INVERT");
        invertBtn.setBounds(170, 120, 120, 20);
        
        JButton addBtn= new JButton("Add");
        addBtn.setBounds(90, 160, 120, 20);

        this.resultTa= new JTextArea();
        resultTa.setBounds(40, 280, 500, 240);
        resultTa.setEditable(false);                                //Remove if Enable doesn't prevent text from being generated in TEXTAREA
        resultTa.setEnabled(false);
        resultTa.setDisabledTextColor(Color.BLACK);
        

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
        panelMain.add(invertBtn);
        panelMain.add(addBtn);
        panelMain.add(resultTa);
        panelMain.setLayout(null);
        

        //ACTION LISTENER FOR BTN
        covertBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		convertDec();
        	}
        });
        
        invertBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		invertBin();
        	}
        });
        
        addBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		addBin();
        	}
        });

    }
    
    public void convertDec() {
    	int num = 0;
    	num = Integer.parseInt(inputTf.getText());
    	
    	registerMachineConverter A = new registerMachineConverter();
    	
    	//System.out.print(num);
    	A.convert(num);
    	
    	resultTa.setText("Binary Convertion: "+ A.toString());
    	
    }
    
    public void invertBin() {
    	    	
    	int num = 0;
    	num = Integer.parseInt(inputTf.getText());
    	
    	registerMachineConverter A = new registerMachineConverter();
    	turingmachine b = new turingmachine();
    	A.convert(num);
    	//System.out.print(num);
    	b.invertion(A.toBin());
    	
    	resultTa.setText("Binary Convertion:\t"+ A.toString());
    	resultTa.append("\nThe Inverse of Binary:\t" + b.toString2());
    }
    
    public void addBin() {
    	
    	int num = 0;
    	num = Integer.parseInt(inputTf.getText());
    	
    	registerMachineConverter A = new registerMachineConverter();
    	turingmachine b = new turingmachine();
    	A.convert(num);
    	//System.out.print(num);
    	b.additionQ0(A.toBin());
    	
    	resultTa.setText("Binary Convertion:             \t   \t" + A.toString());
    	resultTa.append("\nThe Inverse of Binary:      \t     \t" + b.toString2());
    	resultTa.append("\nThe Sum of Adding the two Binary:\t" + b.toString3());
    }
    
    
    public static void main(String[] args){
        new App();
    }
}