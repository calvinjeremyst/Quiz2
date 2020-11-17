/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.DateLabelFormatter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author user
 */
public class View implements ActionListener {
    JFrame frame = new JFrame("Quiz 2");
    JLabel judul,label, pathLabel,labelTanggal;
    JTextField textfield;
    JButton tombol,insert;
    String path;
    
    Properties p;
    UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    
    public View() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Judul");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(0,0,250,30);
        
        label = new JLabel("Label");
        label.setFont(new Font("Consolas", Font.PLAIN, 32));
        label.setBounds(0,0,250,30);
        
        labelTanggal.setBounds(10, 160, 100, 50);
        model = new UtilDateModel();
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model,p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(140, 170, 350, 30);
        
        tombol = new JButton("Tombol");
        tombol.setBounds(680,240,150,30);
        tombol.addActionListener(this);
        pathLabel.setBounds(0,0,150,30);       
        
        //Jika Menampilkan Hasil Pencarian, Maka
        pathLabel.setText("Dari User");
        //
        
        insert = new JButton("Next");
        insert.setBounds(610, 510, 150, 30);
        insert.setEnabled(true);
        insert.addActionListener(this);
        
        frame.add(judul);
        frame.add(label);
        frame.add(tombol);
        frame.add(pathLabel);
        frame.add(insert);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tombol){    
            JFileChooser fc = new JFileChooser();    
            int i = fc.showOpenDialog(null);    
            if(i == JFileChooser.APPROVE_OPTION){    
                File f = fc.getSelectedFile(); 
                path = f.getAbsolutePath();
                pathLabel.setText(path);
            }    
        }
        
        else if(e.getActionCommand().equals("Next")){
            
        }
        
    }
    
}
