package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaInstituto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.InstitucionRepetidaException;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class IngresarInstituto extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaInstituto iConAltInst;
	
	private JTextField textFieldIngresarNombre;

		
	public IngresarInstituto(IControladorAltaInstituto iConAltInst) throws PropertyVetoException {
		this.iConAltInst = iConAltInst;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Instituto");
		setBounds(100, 100, 610, 385);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(199, 167, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldIngresarNombre= new JTextField();
		textFieldIngresarNombre.setBounds(287, 165, 114, 19);
		getContentPane().add(textFieldIngresarNombre);
		textFieldIngresarNombre.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarInstitutoConfirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(149, 235, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarInstitutoCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(336, 235, 117, 25);
		getContentPane().add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(131, 122, 342, 95);
		getContentPane().add(panel);
	}

	

	
	protected void ingresarInstitutoConfirmarActionPerformed(ActionEvent e) {
		String nombre = this.textFieldIngresarNombre.getText();
		if(checkNombre(nombre)){
			try {
				
				this.iConAltInst.ingresarInstituto(nombre);
				this.iConAltInst.confirmarAltaInstituto(); 
				JOptionPane.showMessageDialog(this, "El instituto se ha creado con éxito", "Ingresar Instituto",
                        JOptionPane.INFORMATION_MESSAGE);
				
				
			} catch (InstitucionRepetidaException ie) {
				
                JOptionPane.showMessageDialog(this, ie.getMessage(), "Ingresar Instituto", JOptionPane.ERROR_MESSAGE);

			}
				
			
		}
		limpiarFormulario();
		setVisible(false);
		
	}
	
	protected void ingresarInstitutoCancelarActionPerformed(ActionEvent e) {
		
		limpiarFormulario();
		setVisible(false);
	
	}
	
	private boolean checkNombre(String nombre) {
		
		if(nombre.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo no puede quedar vacío.", "Ingresar Instituto",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;			
		
	}
	
	private void limpiarFormulario() {
        textFieldIngresarNombre.setText("");
	}
	
	
 

}
