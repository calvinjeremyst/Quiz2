/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class MainMenu implements ActionListener {
    JFrame frame = new JFrame("Quiz 2");
    JLabel judul;
    JButton tombol,tombol2,tombol3,tombol4;
    
    public MainMenu() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Main Menu");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(600,20,500,100);
        
        tombol = new JButton("Insert Data Jurusan Baru");
        tombol.setBounds(550, 120, 400, 30);
        tombol.addActionListener(this);
     
        tombol2 = new JButton("Lihat Data Semua Jurusan");
        tombol2.setBounds(525, 180, 400, 30);
        tombol2.setEnabled(true);
        tombol2.addActionListener(this);
        
        tombol3 = new JButton("Insert Data Mahasiswa Baru");
        tombol3.setBounds(480, 240, 400, 30);
        tombol3.setEnabled(true);
        tombol3.addActionListener(this);
        
        tombol4 = new JButton("Lihat Data Mahasiswa Per Jurusan");
        tombol4.setBounds(525, 300, 250, 30);
        tombol4.setEnabled(true);
        tombol4.addActionListener(this);
        
        frame.add(judul);
        frame.add(tombol);
        frame.add(tombol2);
        frame.add(tombol3);
        frame.add(tombol4);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Insert Data Jurusan Baru")){
            new InsertJurusanMhs();
            frame.dispose();
        } else if(e.getActionCommand().equals("Lihat Data Semua Jurusan")){
            new LihatJurusanSemua();
            frame.dispose();
        } else if(e.getActionCommand().equals("Insert Data Mahasiswa Baru")){
            new InsertMhs();
            frame.dispose();
        } else if(e.getActionCommand().equals("Lihat Data Mahasiswa Per Jurusan")){
            new LihatMahasiswaKode();
            frame.dispose();
        }
        
    }
    
}
