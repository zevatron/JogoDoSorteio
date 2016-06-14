import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SortingFocusTraversalPolicy;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela {

	private JFrame frame;
	private JTextField textField;
	private JButton btnIniciarJogo;
	private JButton btnJogar;
	private JLabel lblChances;
	private JLabel lblStatus;
	Sorteio sorteio = new Sorteio();
	private int chances;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblChances.setText("");
				lblStatus.setText("");
				btnIniciarJogo.setEnabled(true);
				

			}
		});
		mnArquivo.add(mntmNovo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Objeto de estudo da disciplina POO"
						+ "\nDesenvolvido por José Pacola"
						+ "\njose.pacola@ifpb.edu.br"
						+ "\nEsse código pode ser distribuido para estudo.");
			}
		});
		mnAjuda.add(mntmSobre);
		
		JLabel lblJogoDoSorteio = new JLabel("JOGO DO SORTEIO");
		lblJogoDoSorteio.setFont(new Font("Dialog", Font.BOLD, 23));
		lblJogoDoSorteio.setBounds(117, 33, 251, 28);
		frame.getContentPane().add(lblJogoDoSorteio);
		
		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(12, 231, 426, 21);
		frame.getContentPane().add(lblStatus);
		
		btnIniciarJogo = new JButton("Iniciar Jogo");
		btnIniciarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarJogo();
				btnIniciarJogo.setEnabled(false);
				
			}
		});
		btnIniciarJogo.setBounds(164, 73, 117, 25);
		frame.getContentPane().add(btnIniciarJogo);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 65));
		textField.setBounds(72, 150, 126, 54);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblDigiteValoresDe = new JLabel("Digite valores de 1 a 100 e tente adivinhar!");
		lblDigiteValoresDe.setBounds(74, 110, 310, 15);
		frame.getContentPane().add(lblDigiteValoresDe);
		
		btnJogar = new JButton("Jogar");
		btnJogar.setEnabled(false);
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tentativa = Integer.parseInt(textField.getText());
				chances--;
				lblChances.setText(""+chances);
				textField.setText("");
				
				if(sorteio.comparar(tentativa) && chances>=0){
					lblStatus.setText("VOCÊ ACERTOU!!! O NÚMERO ERA "+sorteio.getNumerosorteado());
					btnJogar.setEnabled(false);
				}
				else if(chances==0 && !sorteio.comparar(tentativa)){
					lblStatus.setText("GAME OVER - O NÚMERO ERA "+sorteio.getNumerosorteado());
					btnJogar.setEnabled(false);
				}
					
				else{
					lblStatus.setText(sorteio.posicao(tentativa)+tentativa+" - "+ sorteio.dica(tentativa));
				}
				
			}
		});
		btnJogar.setBounds(214, 150, 87, 54);
		frame.getContentPane().add(btnJogar);
		
		JLabel lblTentativas = new JLabel("tentativas");
		lblTentativas.setBounds(333, 204, 87, 15);
		frame.getContentPane().add(lblTentativas);
		
		lblChances = new JLabel("");
		lblChances.setHorizontalAlignment(SwingConstants.CENTER);
		lblChances.setFont(new Font("Dialog", Font.BOLD, 60));
		lblChances.setBounds(333, 150, 73, 51);
		frame.getContentPane().add(lblChances);
	}

	private void inicializarJogo() {
		chances=5;
		sorteio.sortear();
		textField.setEditable(true);
		btnJogar.setEnabled(true);
		lblChances.setText(""+chances);
		lblStatus.setText("O JOGO COMEÇOU - TENTE ADIVINHAR.");
	}
}
