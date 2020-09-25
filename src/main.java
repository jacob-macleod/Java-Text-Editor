import javax.swing.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class main {
	
	public static String readFile (String fileName) throws IOException{
		String everything = "";
	    try {
	        File myObj = new File(fileName);
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          everything = everything + data + "\n";
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	        return "Error occured when reading " + fileName;
	      }
	    return everything;
	}
	
	
	public static void openFile(String fileName) {
		JFrame file = new JFrame();
		
        file.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
        	JTextArea text_body = new JTextArea(readFile(fileName));
            file.getContentPane().add(text_body);
        } catch (Exception e) {
            JTextArea text_body = new JTextArea("Could not read file");
            file.getContentPane().add(text_body);
            e.printStackTrace();
        }

        file.setSize(800, 500);
        
        //Display the window.
        file.setVisible(true);
	}

	public static void main(String[] args) {
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
	    		openFile(input.getText());
	    	}          
	     });
		
        frame.setSize(700, 15);
		frame.setLayout(null);
        
        //Display the window.
        frame.setVisible(true);

	}

}
