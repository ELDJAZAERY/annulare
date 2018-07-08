package Interface;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Console extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Console frame = new Console();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Console() {
		
		pack(); //redemonsioner dynamique
		setLocationRelativeTo(null); //ouvrire au centre
		setTitle("Console (Fiche)");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(0, 0, 656, 393);
		
		
		textArea.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
		    	textArea.setEditable(true);
		    	//System.out.println(textArea.getText().length() +" ,,,,,,,,, "+textArea.getCaretPosition());
		    	
		    	if(textArea.getText().length()!=textArea.getCaretPosition()){
		    		//textArea.setEditable(false);
		    		textArea.setCaretPosition(textArea.getText().length());
		    	}
		    	
		        if(e.getKeyCode() == KeyEvent.VK_ENTER){
		        System.out.println("action sucssé");
		        String[] lignes = textArea.getText().split("\n");
		        System.out.println(lignes[lignes.length-1]);

		        }
		        if(e.getKeyCode() == KeyEvent.ALT_MASK ){
		        	
		        	textArea.setEditable(false);
		        }
		        
		    }

		    @Override
		    public void keyTyped(KeyEvent e) {
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		    }});
		
			textArea.setCaretColor(Color.green);
			contentPane.add(new JScrollPane(textArea)); // scrol option pour les textes de grandes taille
	}
	
	
			//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			//textPane.setForeground(Color.WHITE); // la colore d'ecriture
		   //textPane.setCaretColor(Color.WHITE); // le colore de caret
		  // fen.texte.append(" Votre impôt se monte à " + impot + " euros " + aLaLigne); ajouter sans efacer les contenu

}
