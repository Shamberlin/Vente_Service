//package register;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class visiteur extends frame implements ActionListener {
	JButton s;
	JButton t;
	panel p;
	visiteur(){
		p=new panel();
	    s=new JButton();
	    t=new JButton();
	    t.setText("VENDEUR");
	    s.setText("CLIENT");
	    t.setBounds(200,400,100,30);
	    s.setBounds(500,400,100,30);
		s.addActionListener(this);
		t.addActionListener(this);
		p.add(s);
		p.add(t);
		this.add(p);
		this.setVisible(true);
		//bonjour ma cherie
		}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==s) {
		this.dispose();
		buttonclient b=new buttonclient();
		}
		else if(e.getSource()==t) {
			this.dispose();
			tester x=new tester();
			
		}
		
	    }
	
			}