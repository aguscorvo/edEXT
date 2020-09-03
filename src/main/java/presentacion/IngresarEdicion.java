package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import interfaces.IControladorAltaEdicion;
import logica.Curso;
import logica.Instituto;

import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.NoExisteInstitutoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;;

public class IngresarEdicion extends JInternalFrame {
	
	private IControladorAltaEdicion iConAltEd;
	private List<String> CursosInstituto;
	private JTextField textFieldInstituto;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JComboBox <String>comboBoxCursos;

	
	
	
	public IngresarEdicion(IControladorAltaEdicion iConAltEd) {
		this.iConAltEd = iConAltEd;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Edición");
		setBounds(100, 100, 455, 350);
		getContentPane().setLayout(null);
		
		JLabel lblInstituto = new JLabel("INSTITUTO");
		lblInstituto.setBounds(87, 111, 80, 15);
		getContentPane().add(lblInstituto);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();				
				iniciarlizarComboBoxes();
			}
		});
		textFieldInstituto.setBounds(201, 109, 159, 19);
		getContentPane().add(textFieldInstituto);
		textFieldInstituto.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarEdicionConfirmarActionPerformed(e);
			
			}
		});
		btnConfirmar.setBounds(74, 194, 117, 25);
		getContentPane().add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarEdicionCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(234, 194, 117, 25);
		getContentPane().add(btnCancelar);
		
		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.setBounds(201, 137, 159, 24);
		getContentPane().add(comboBoxCursos);
	}
	
	
	protected void ingresarEdicionConfirmarActionPerformed(ActionEvent e) {
		String instituto = this.textFieldInstituto.getText();
		if(checkTextField(instituto)) {
			try {
				this.CursosInstituto = iConAltEd.ingresarInstituto(instituto);

				
			}catch (NoExisteInstitutoException neie) {
				
                JOptionPane.showMessageDialog(this, neie.getMessage(), "Ingresar Edicion", JOptionPane.ERROR_MESSAGE);

				
			}
			
		}
		
		limpiarFormulario();
		setVisible(false); 
		//vamos a hacer un internal frame para los demas datos y set visible (true)
		
		
	}
	
	protected void ingresarEdicionCancelarActionPerformed(ActionEvent e) {
		
		limpiarFormulario();
		setVisible(false); 
	}
	
	
	
	
	private boolean checkTextField(String string) {
		
		if(string.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ningún campo puede quedar vacío.", "Ingresar Curso",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;			
		
	}
	
	
	
	private void limpiarFormulario() {
		textFieldInstituto.setText("");
		
	}
	
	public void habilitarBotonConfirmar() {
		if (!textFieldInstituto.getText().isEmpty()) {
			btnConfirmar.setEnabled(true);
		}
		else {
			btnConfirmar.setEnabled(false);
		}
	}
	
	public void iniciarlizarComboBoxes() {
		if (!textFieldInstituto.getText().isEmpty()) {
			if(iConAltEd.existeInstituto(textFieldInstituto.getText())){
				Instituto inst = iConAltEd.getInstituto(textFieldInstituto.getText());
				DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>(iConAltEd.getCursos(inst));		
				comboBoxCursos.setModel(modelcursos);
				comboBoxCursos.setEnabled(true);

			}
			else {
				DefaultComboBoxModel<String> modelcursos = new DefaultComboBoxModel<String>();		
				comboBoxCursos.setModel(modelcursos);
				comboBoxCursos.setEnabled(false);
			}
		}
		
	}	
}
