/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class InsertMhs implements ActionListener {
    JFrame frame = new JFrame("Quiz 2");
    JLabel judul,lnama,lnim,langkatan,lkode;
    JTextField nim,nama,angkatan;
    JButton tombol,tombol2,tombol3,tombol4;
    JComboBox pilihKode;
    String[] array = {"IF","SI","AK"};
    
    public InsertMhs() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Insert Mahasiswa");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(600,20,500,100);
        
        lnim = new JLabel("NIM : ");
        lnim.setFont(new Font("Consolas", Font.PLAIN, 20));
        lnim.setBounds(20, 160, 250, 50);
        nim = new JTextField();
        nim.setFont(new Font("Consolas", Font.PLAIN, 20));
        nim.setBounds(270, 170, 150, 30);
        
        lnama = new JLabel("Nama : ");
        lnama.setFont(new Font("Consolas", Font.PLAIN, 20));
        lnama.setBounds(20, 210, 250, 50);
        nama = new JTextField();
        nama.setFont(new Font("Consolas", Font.PLAIN, 20));
        nama.setBounds(270, 220, 150, 30);
        
        langkatan = new JLabel("Angkatan : ");
        langkatan.setFont(new Font("Consolas", Font.PLAIN, 20));
        langkatan.setBounds(20, 260, 250, 50);
        angkatan = new JTextField();
        angkatan.setFont(new Font("Consolas", Font.PLAIN, 20));
        angkatan.setBounds(270, 270, 150, 30);
        
        lkode = new JLabel("Kode Jurusan : ");
        lkode.setFont(new Font("Consolas", Font.PLAIN, 20));
        lkode.setBounds(20, 310, 250, 50);
        pilihKode = new JComboBox(array);
        pilihKode.setBounds(170,310,100,50);
        
        tombol = new JButton("Insert");
        tombol.setBounds(400, 360, 250, 30);
        tombol.setEnabled(true);
        tombol.addActionListener(this);
     
        tombol2 = new JButton("Main Menu");
        tombol2.setBounds(700, 360, 250, 30);
        tombol2.setEnabled(true);
        tombol2.addActionListener(this);
        
        frame.add(judul);
        frame.add(tombol);
        frame.add(tombol2);
        frame.add(lnim);
        frame.add(nim);
        frame.add(lnama);
        frame.add(nama);
        frame.add(langkatan);
        frame.add(angkatan);
        frame.add(lkode);
        frame.add(pilihKode);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nim = this.nim.getText();
        String nama = this.nama.getText();
        String angkatan = this.angkatan.getText();
        String kode = (String) this.pilihKode.getSelectedItem();
                
        if(e.getActionCommand().equals("Insert")){
            if(Controller.insertMahasiswa(nim,nama,angkatan,kode)){
                JOptionPane.showMessageDialog(null,"Data Berhasil Insert!");
                new MainMenu();
                frame.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Data Gagal Insert!");
            }
        } else if(e.getActionCommand().equals("Main Menu")){
            new MainMenu();
            frame.dispose();
        } 
    }
}
