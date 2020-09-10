package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCurso extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCurso frame = new ConsultaCurso();
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
	public ConsultaCurso() {
		setMaximizable(true);
		setIconifiable(true);
		setClosed(true);
		setClosable(true);
		setTitle("Consulta de Curso");
		setBounds(100, 100, 623, 318);
		getContentPane().setLayout(null);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(27, 49, 73, 14);
		getContentPane().add(lblInstituto);
		
		JComboBox comboBoxInstituto = new JComboBox();
		comboBoxInstituto.setBounds(110, 46, 106, 20);
		getContentPane().add(comboBoxInstituto);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(27, 93, 46, 14);
		getContentPane().add(lblCurso);
		
		JComboBox comboBoxCurso = new JComboBox();
		comboBoxCurso.setBounds(110, 90, 106, 20);
		getContentPane().add(comboBoxCurso);
		
		JButton btnVerCurso = new JButton("VER");
		btnVerCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerCurso.setBounds(237, 89, 80, 23);
		getContentPane().add(btnVerCurso);
		
		JTextPane textPaneDatos = new JTextPane();
		textPaneDatos.setBounds(354, 28, 225, 238);
		getContentPane().add(textPaneDatos);
		
		JPanel panel = new JPanel();
		panel.setBounds(354, 28, 225, 238);
		getContentPane().add(panel);
		
		JLabel lblEdiciones = new JLabel("EDICIONES");
		lblEdiciones.setBounds(27, 166, 60, 14);
		getContentPane().add(lblEdiciones);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 163, 106, 20);
		getContentPane().add(comboBox);
		
		JLabel lblProgramas = new JLabel("PROGRAMAS");
		lblProgramas.setBounds(27, 209, 73, 14);
		getContentPane().add(lblProgramas);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(110, 206, 106, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnVerEdicion = new JButton("VER");
		btnVerEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerEdicion.setBounds(237, 162, 80, 23);
		getContentPane().add(btnVerEdicion);
		
		JButton btnVerPrograma = new JButton("VER");
		btnVerPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerPrograma.setBounds(237, 205, 80, 23);
		getContentPane().add(btnVerPrograma);

	}
}
