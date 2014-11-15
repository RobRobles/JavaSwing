import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class JBox extends JFrame implements ActionListener {

	private JTextField input;
	private JButton button;
	private JTextArea area; 


	public JBox() {
		// Create the components.
		area = new JTextArea(4, 15);
		input = new JTextField(10);
		button = new JButton("Add ==>");

		area.setPreferredSize(new Dimension(25, 100));
		area.setEditable(false); 
		JScrollPane scrollPane = new JScrollPane(area);


		// Add components to the frame's content pane.
		Container c = getContentPane();
		c.add(input);
		c.add(button);
		//c.add(area);
		c.add(scrollPane);
		c.add(scrollPane, BorderLayout.CENTER);

		// Layout the components.
		layoutFlow();

		// Have this frame respond to button clicks.
		button.addActionListener(this);
	}

	public void layoutFlow() {
		setLayout( new FlowLayout() );
		pack();
	}

	public void layoutFixed() {
		input.setBounds(110, 5, 100, 50);
		button.setBounds(220, 5, 100, 50);
		this.setBounds(5, 5, 650, 100);
	}

	public static void main(String[] args) {
		JBox frame = new JBox();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	String Message = "";

	@Override
	public void actionPerformed(ActionEvent evt) {

		try{


			Message = input.getText();

			if(Message.equals(""))
			{
				area.append("");
			}
			else
			{
				area.append(Message);
				area.append("\n");
				input.setText("");
			}


		}
		catch (Exception e) {

		}


	}

}

