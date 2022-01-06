package register;

import javax.swing.*;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Number extends textfield {
	
	Number(){

this.addKeyListener((KeyListener) new KeyAdapter(){
	public void keyTyped(KeyEvent e) {
		char c=e.getKeyChar();
		if((!(Character.isDigit(c))&&(c!='\b'))){
				e.consume();
		}
	}
});
	}
}		
	


