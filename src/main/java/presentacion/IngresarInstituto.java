package presentacion;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaInstituto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.InstitutoRepetidaException;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class IngresarInstituto extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaInstituto iConAltInst;
	
	private JTextField textFieldIngresarNombre;
	private JButton btnConfirmar;

		
	public IngresarInstituto(IControladorAltaInstituto iConAltInst) throws PropertyVetoException {
		this.iConAltInst = iConAltInst;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Instituto");
		setBounds(100, 100, 503, 234);
		getContentPane().setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarInstitutoConfirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(106, 139, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarInstitutoCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(278, 139, 117, 25);
		getContentPane().add(btnCancelar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(52, 26, 384, 79);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textFieldIngresarNombre= new JTextField();
		textFieldIngresarNombre.setBounds(126, 31, 228, 19);
		panel.add(textFieldIngresarNombre);
		textFieldIngresarNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBotonConfirmar();
			}
		});
		textFieldIngresarNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 33, 59, 15);
		panel.add(lblNombre);
	}

	

	
	protected void ingresarInstitutoConfirmarActionPerformed(ActionEvent e) {
		String nombre = this.textFieldIngresarNombre.getText();
		if(checkNombre(nombre)){
			try {
				
				this.iConAltInst.ingresarInstituto(nombre);
				this.iConAltInst.confirmarAltaInstituto(); 
				JOptionPane.showMessageDialog(this, "El instituto se ha creado con éxito", "Ingresar Instituto",
                        JOptionPane.INFORMATION_MESSAGE);
				
				
			} catch (InstitutoRepetidaException ie) {
				
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
	
	public void habilitarBotonConfirmar() {
		if (!textFieldIngresarNombre.getText().isEmpty())
				btnConfirmar.setEnabled(true);
		
		else 
			btnConfirmar.setEnabled(false);
		
	}
 

}
