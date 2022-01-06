package register;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class age extends textfield {
	age(){
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
