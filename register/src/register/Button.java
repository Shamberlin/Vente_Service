package register;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton {
	Button(){
		this.setBounds(500,400,100,30);
	//this.setText("nouveaux");
	//this.setHorizontalAlignment(JButton.CENTER);
	//this.setVerticalAlignment(JButton.CENTER);
	this.setFont(new Font("bold sans",Font.ITALIC,25));
	this.setVerticalTextPosition(JButton.CENTER);
	this.setBackground(Color.white);

}
}