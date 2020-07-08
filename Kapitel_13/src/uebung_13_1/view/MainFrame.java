package uebung_13_1.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import uebung_13_1.controller.Controller;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel tablePanel;
	private JPanel controllPanel;
	private JButton addButton, printButton, printAllButton, removeButton;
	private JTable table;
	private Controller controller;

	public MainFrame(Controller controller) {
		this.controller = controller;

		//Set what happens on close and set the layout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		tablePanel = new JPanel(new BorderLayout());
		controllPanel = new JPanel(new FlowLayout());

		//Setting up the table with column names, no rows and disable editing
		String[] columnNames = { "Name", "Firstname", "MatriculationNumber", "E-Mail" };
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, columnNames) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.setRowSelectionAllowed(true);

		//Setting up the buttons
		addButton = new JButton("Add Student");
		printButton = new JButton("Print Selected Student");
		printAllButton = new JButton("Print all Students");
		removeButton = new JButton("Remove Selected Student");
		addButton.addActionListener(this);
		printButton.addActionListener(this);
		printAllButton.addActionListener(this);
		removeButton.addActionListener(this);

		//adding the table with a scrollpane and the buttons
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		controllPanel.add(addButton);
		controllPanel.add(printButton);
		controllPanel.add(printAllButton);
		controllPanel.add(removeButton);

		//adding everything to the frame with Borderlayout, size the frame properly(pack()) and set the frame visible.
		this.add(tablePanel, BorderLayout.CENTER);
		this.add(controllPanel, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}

	//Creates and shows a Dialog, that is blocking until the user closes it
	public void showAddDialog() {
		//Setting up the contents of the Dialog and their size
		Dimension dimension = new Dimension(200, 20);

		JTextField field1 = new JTextField();
		field1.setPreferredSize(dimension);
		JTextField field2 = new JTextField();
		field2.setPreferredSize(dimension);
		JTextField field3 = new JTextField();
		field3.setPreferredSize(dimension);
		JTextField field4 = new JTextField();
		field4.setPreferredSize(dimension);

		JLabel label1 = new JLabel("Name");
		JLabel label2 = new JLabel("First Name");
		JLabel label3 = new JLabel("MatriculationNumber");
		JLabel label4 = new JLabel("E-Mail");

		//adding all of them to a JPanel
		JPanel dialogPanel = new JPanel(new FlowLayout());
		dialogPanel.add(label1);
		dialogPanel.add(field1);
		dialogPanel.add(label2);
		dialogPanel.add(field2);
		dialogPanel.add(label3);
		dialogPanel.add(field3);
		dialogPanel.add(label4);
		dialogPanel.add(field4);

		//Showing the dialog, that contains the panel, with Yes/No Buttons and no Icon(null) 
		int option = JOptionPane.showConfirmDialog(this, dialogPanel, "Enter the new Students Data", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
		//if the user clicked OK, we add a new student
		if (option == JOptionPane.OK_OPTION) {
			try {
				controller.addStudent(field2.getText(), field1.getText(), Integer.parseInt(field3.getText()), field4.getText());
			}
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "No valid input for matriculationNumber");
			}
		}
	}

	//updated the contents of the JTable with the passed values
	public void updateTable(List<Object[]> entries) {
		String[] columnNames = { "Name", "Firstname", "MatriculationNumber", "E-Mail" };
		Object[][] data = {};

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (int i = 0; i < entries.size(); i++) {
			model.addRow(entries.get(i));
		}
		
		this.table.setModel(model);
	}

	//This method is called whenever a ActionEvent occurs, such as a button click
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addButton)) {
			showAddDialog();
		}
		if (e.getSource().equals(printButton)) {
			if (table.getSelectedRow() != -1) {
				controller.printStudent(Integer.valueOf(this.table.getValueAt(table.getSelectedRow(), 2).toString()));
			}
		}
		if (e.getSource().equals(printAllButton)) {
			controller.printAllStudents();
		}
		if (e.getSource().equals(removeButton)) {
			if (table.getSelectedRow() != -1) {
				int option = JOptionPane.showConfirmDialog(this, "Remove this Student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					controller.removeStudent(Integer.valueOf(this.table.getValueAt(table.getSelectedRow(), 2).toString()));
				}
				
			}
		}
	}

}
