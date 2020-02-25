import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText=txtGuess.getText();
		String message="";
		try {
			int guess=Integer.parseInt(guessText);
			if(guess<theNumber)
				message=guess+" is too low. Try again.";
			else if(guess>theNumber)
				message=guess+" is too high. Try again.";
			else {
				message=guess+" is correct. You win! Let's play again!";
				newGame();
			}
		}
		catch(Exception e) {
			message="Enter a whole number between 1 and 100.";
		}
		finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame(){
		theNumber=(int)(Math.random()*100+1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Pramita's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblPramitasHiloGuessing = new JLabel("Pramita's Hi-Lo Guessing Game");
		lblPramitasHiloGuessing.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPramitasHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblPramitasHiloGuessing.setBounds(34, 12, 381, 25);
		getContentPane().add(lblPramitasHiloGuessing);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1-100:");
		lblGuessANumber.setBounds(70, 76, 230, 15);
		getContentPane().add(lblGuessANumber);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(297, 76, 47, 15);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(168, 130, 114, 25);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setBounds(71, 194, 308, 15);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame=new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
