package Exercise;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UIController implements ActionListener{
	JFrame frame;
	
	JButton button;
	
	JLabel nameLabel;
	JLabel DOBLabel;
	JLabel IDLabel;
	
	JTextField IDText;
	JTextField nameText;
	JTextField DOBText;
	
	Student a;
	public UIController() {
		frame = new JFrame();
		frame.setSize(350,200);
		
		button = new JButton("Submit");
		button.addActionListener(this);
		button.setBounds(10, 110, 255, 40);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 20, 80, 25);
		nameText = new JTextField();
		nameText.setBounds(100, 20, 165, 25);
		
		IDLabel = new JLabel("ID");
		IDLabel.setBounds(10, 50, 80, 25);
		IDText = new JTextField();
		IDText.setBounds(100, 50, 165, 25);
		
		DOBLabel = new JLabel("Date of birth");
		DOBLabel.setBounds(10, 80, 80, 25);
		DOBText = new JTextField();
		DOBText.setBounds(100, 80, 165, 25);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(DOBLabel);
		panel.add(DOBText);
		panel.add(IDLabel);
		panel.add(IDText);
		panel.add(button);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Student");
		frame.setVisible(true);
	}
	
	public static void main (String[] args) {
		new UIController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameText.getText();
		String ID = IDText.getText();
		String DOB = DOBText.getText();
		a = new Student(name,ID,DOB);
		System.out.println("Name: " + a.getName() + "\nID: " + a.getID() + "\nDate of birth: " + a.getDOB());
		frame.dispose();
	}
}