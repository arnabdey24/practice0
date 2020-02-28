package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class New extends JFrame implements ActionListener {

    JButton button;
    JLabel label;
    JTextField textField;

    public New(String title) throws HeadlessException {
        super(title);
        button=new JButton("Find IP");
        button.setBounds(10,150,100,50);
        button.addActionListener(this);

        label=new JLabel();
        label.setBounds(10,80,300,50);

        textField=new JTextField();
        textField.setBounds(10,10,100,50);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,500,200,220);
        setLayout(null);

        add(button);
        add(label);
        add(textField);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String host=textField.getText();
        try {
            String ip=java.net.InetAddress.getByName(host).getHostAddress();
            label.setText("IP of "+host+" is: "+ip);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}

