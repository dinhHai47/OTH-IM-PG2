package uebung_13_1.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//A simple Frame that emulates a console. Provides method for appending text
public class Console extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea console;
	private JScrollPane scrollbar;

	public Console() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth(), 0);
		console = new JTextArea();
		console.setEditable(false);
		console.setLineWrap(true);
		console.setWrapStyleWord(true);
		scrollbar = new JScrollPane(console);
		this.add(scrollbar);
		this.setVisible(true);
	}

	public void printLine(String text) {
		console.append(text + "\n");
	}
}
