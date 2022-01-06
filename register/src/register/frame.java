package register;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
public class frame extends JFrame{
	frame(){
    this.setLayout(null);
	this.setSize(1650,1080);
	this.setTitle("Jobam Armand shamberlin");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon Image=new ImageIcon("logo-50.jpg");
    Container ControlHost=getContentPane();
	this.getContentPane().setBackground(new Color(250,255,255));
    ControlHost.setLayout(new BorderLayout()); 
	this.setVisible(true);

}
}
