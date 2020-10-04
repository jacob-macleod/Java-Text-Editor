import java.awt.*;
import java.awt.event.*;

class keyListener extends KeyAdapter {
	  public void keyPressed(KeyEvent evt) {
		  editor textWindow = new editor();
	    System.out.println("Check for key characters: " + evt.getKeyChar());
	  }	  
	}