import javax.swing.*;

public class main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        frame.setSize(800, 500);
        
        //Display the window.
        frame.setVisible(true);

	}

}
