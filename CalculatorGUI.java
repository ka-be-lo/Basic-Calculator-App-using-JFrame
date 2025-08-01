/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculatorapp.ac.za.tut.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sepit
 */
public class CalculatorGUI extends JFrame{
    
    //Panels
    private JPanel num1Pnl;
    private JPanel num2Pnl;
    private JPanel headinPnl;
    private JPanel sumPnl;
    private JPanel bodyPnl;
    private JPanel mainPnl;
    private JPanel btnsPnl;
    
    //Labels
    private JLabel num1Lbl;
    private JLabel num2Lbl;
    private JLabel sumLbl;
    private JLabel headingLbl;
    
    
    //TextFields
    private JTextField num1TxtFld;
    private JTextField num2TxtFld;
    private JTextField sumTxtFld;
    
    
    //Buttons
    private JButton calcBtn;
    private JButton clearBtn;
    private JButton exitBtn;
    
    
    
    
    
    public CalculatorGUI(){
    
      
        
        
        this.setTitle("Addition Calculator App");
        this.setSize(450,450);
        this.setBackground(Color.RED);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        //create the panels
        mainPnl = new JPanel(new BorderLayout());
        btnsPnl = new JPanel(new FlowLayout());
        bodyPnl = new JPanel(new GridLayout(3,1));
       
        
        //num1 section
        num1Pnl = new JPanel(new FlowLayout());
        num1Lbl = new JLabel("Please enter num1: ");
        num1TxtFld = new JTextField(15);
        
        
        num1Pnl.add(num1Lbl,FlowLayout.LEFT);
        num1Pnl.add(num1TxtFld);
        
        //num2 section
        num2Pnl = new JPanel(new FlowLayout());
        num2Lbl = new JLabel("Please enter num2: ");
        num2TxtFld = new JTextField(15);
        
        
        num2Pnl.add(num2Lbl,FlowLayout.LEFT);
        num2Pnl.add(num2TxtFld);
        
     
        //sum section
        sumPnl = new JPanel(new FlowLayout());
        sumLbl = new JLabel("sum: ");
        sumTxtFld = new JTextField(15);
        
        sumPnl.add(sumLbl,FlowLayout.LEFT);
        sumPnl.add(sumTxtFld);
        
        
        //Adding user inputs panels to the body section
        bodyPnl.add(num1Pnl);
        bodyPnl.add(num2Pnl);
        bodyPnl.add(sumPnl);
        
        
        //button section
        calcBtn = new JButton("Calculate");
        clearBtn = new JButton("Clear");
        exitBtn = new JButton("Exit");
        
        //Enabling action listenerd for interactivity
        calcBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                
                String num1Str = num1TxtFld.getText();
                String num2Str = num2TxtFld.getText();
                
                if(!(num1Str.isEmpty() || num2Str.isEmpty())){
                
                    try{
                    
                        int num1 = Integer.parseInt(num1Str);
                        int num2 = Integer.parseInt(num2Str);
                    
                        int sum = calculateSum(num1,num2);
                        
                        sumTxtFld.setText(sum + "");
                        sumTxtFld.setForeground(Color.BLACK);
                    }
                    catch(NumberFormatException ex){
                    
                        sumTxtFld.setText("Empy field detected!");
                        sumTxtFld.setForeground(Color.RED);
                    }
               
                }
                else{
                
                    sumTxtFld.setText("Empy field detected!");
                    sumTxtFld.setForeground(Color.RED);
                }
            }

        });
        
        //adding functionality to the clear button
        clearBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                
              
              num1TxtFld.setText("");
              num2TxtFld.setText("");
              sumTxtFld.setText("");
             
            }  
        });
        //adding functionality to the exit button
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
               dispose();
            }
        
            
        });
        
        
        
        
        
        btnsPnl.add(calcBtn);
        btnsPnl.add(clearBtn);
        btnsPnl.add(exitBtn);
        
        mainPnl.add(bodyPnl,BorderLayout.WEST);
        mainPnl.add(btnsPnl,BorderLayout.SOUTH);
        
        
        
        this.add(mainPnl);
        this.setVisible(true);
    }
    public static int calculateSum(int num1,int num2){
    
        return num1 + num2;
    }
    
}
