import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import java.io.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class editor {	
	public static void writeFile (String fileName, String content) throws IOException {
	      FileWriter myWriter = new FileWriter(fileName);
	      myWriter.write(content);
	      myWriter.close();
	}
	
	
	public static String readFile (String fileName) throws IOException {
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
	
	public static void openFile(String fileName) throws IOException {
		
		JFrame file = new JFrame();
	    
        file.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the save button
        JButton save = new JButton("Save");
        
        file.getContentPane().add(save);
        save.setBounds(1, 1, 80, 20);
        
        //Add the text body
        JTextArea text_body = new JTextArea(readFile(fileName));
        //X, y, width, height
        text_body.setBounds(1, 25, 750, 500);
        //Add a key listener to text_body
        keyListener KeyListener = new keyListener();
        text_body.addKeyListener(KeyListener);    	
        //Add a scrollpane to text_body
        JScrollPane scroll = new JScrollPane (text_body);
        scroll.setBounds(1, 25, 750, 500);
        file.add(scroll); 
        
        
        
        //Make the save button save the file
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		writeFile("/home/jacob/eclipse-workspace/Java-Text-Editor/src/file_to_read.txt", text_body.getText());
            	} catch (IOException IoError) {
            		IoError.printStackTrace();
            	}
            }
         });
        
        //Width, height
        file.setSize(755, 550);
        file.setLayout(null);
        
        //Display the window.
        file.setVisible(true);	
}		
	
	//Open a demo file for me to debug
	public static void main(String[] args) {
		try {
			openFile("/home/jacob/eclipse-workspace/Java-Text-Editor/src/file_to_read.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


