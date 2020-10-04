import javax.swing.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class main {	
	public static void main(String[] args) {
		editor launchEditor = new editor ();
		
		JFrame frame = new JFrame();
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField input = new JTextField("Enter the full file path of the file you want to open");
        JButton search = new JButton("Open");
        frame.getContentPane().add(input);
        frame.getContentPane().add(search);
        
		search.setBounds(600, 1, 100, 15);
		input.setBounds(1, 1, 600, 15);
		
	    search.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					editor.openFile(input.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			//The syntaxinput.requestFocusInWindow();
	    	}          
	     });
		
        frame.setSize(700, 15);
		frame.setLayout(null);
        
        //Display the window.
        frame.setVisible(true);

	}

}
