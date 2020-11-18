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
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Jurusan;
import model.Mahasiswa;

/**
 *
 * @author user
 */
public class LihatMahasiswaKode implements ActionListener {
    JFrame frame = new JFrame("Quiz 2");
    JLabel judul, lpilih;
    JButton tombol,tombol2;
    JTable jt;
    JComboBox pilihKode;
    String[] array = {"IF","SI","AK"};
     
    public LihatMahasiswaKode(){
        ArrayList<Jurusan> jurusan = Controller.getKode();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        judul = new JLabel("Lihat Jurusan");
        judul.setFont(new Font("Consolas", Font.PLAIN, 32));
        judul.setBounds(600,20,500,100);
        
        lpilih = new JLabel("Pilihan");
        lpilih.setFont(new Font("Consolas", Font.PLAIN, 20));
        lpilih.setBounds(20, 160, 250, 50);
        pilihKode = new JComboBox(array);
        pilihKode.setBounds(270, 170, 150, 30);
        
        tombol = new JButton("Table");
        tombol.setBounds(400, 360, 250, 30);
        tombol.setEnabled(true);
        tombol.addActionListener(this);
     
        tombol2 = new JButton("Main Menu");
        tombol2.setBounds(700, 360, 250, 30);
        tombol2.setEnabled(true);
        tombol2.addActionListener(this);
        
        frame.add(lpilih);
        frame.add(pilihKode);
        frame.add(judul);
        frame.add(tombol);
        frame.add(tombol2);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String pilihan = (String) this.pilihKode.getSelectedItem();
        if(e.getActionCommand().equals("Table")){
            ArrayList<Mahasiswa> mahasiswa = Controller.getMahasiswa(pilihan);
            jt = new JTable();
            jt.setBounds(270,150,500,300);
            DefaultTableModel model = new DefaultTableModel();
            Object[] namaKolom = new Object[4];
            namaKolom[0] = "NIM";
            namaKolom[1] = "Nama";
            namaKolom[2] = "Angkatan";
            namaKolom[3] = "Kode Jurusan";
            model.setColumnIdentifiers(namaKolom);
            Object[] dataKolom = new Object[4];
            for (int i = 0; i < mahasiswa.size(); i++) {
                dataKolom[0] = mahasiswa.get(i).getNim();
                dataKolom[1] = mahasiswa.get(i).getNama();
                dataKolom[2] = mahasiswa.get(i).getAngkatan();
                dataKolom[3] = mahasiswa.get(i).getKode_jurusan();
                model.addRow(dataKolom);
            }
            jt.setModel(model);
            frame.add(jt);
        }else if(e.getActionCommand().equals("Main Menu")){
            new MainMenu();
            frame.dispose();
        }
    }
    
}
