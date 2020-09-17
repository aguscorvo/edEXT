package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import excepciones.CategoriaRepetidaException;
import interfaces.IControladorAltaCategoria;

public class IngresarCategoria extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorAltaCategoria iConAltCat;
	
	private JTextField textFieldIngresarNombre;
	private JButton btnConfirmar;

		
	public IngresarCategoria(IControladorAltaCategoria iConAltCat) throws PropertyVetoException {
		this.iConAltCat = iConAltCat;
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ingresar Categoria");
		setBounds(100, 100, 503, 234);
		getContentPane().setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarCategoriaConfirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(106, 139, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarCategoriaCancelarActionPerformed(e);
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

	

	
	protected void ingresarCategoriaConfirmarActionPerformed(ActionEvent e) {
		String nombre = this.textFieldIngresarNombre.getText();
		if(checkNombre(nombre)){
			try {
				
				this.iConAltCat.ingresarCategoria(nombre);
				JOptionPane.showMessageDialog(this, "La categoría '" + nombre + "' se ha creado con éxito", "Ingresar Categoría",
                        JOptionPane.INFORMATION_MESSAGE);
				
				
			} catch (CategoriaRepetidaException ie) {
				
                JOptionPane.showMessageDialog(this, ie.getMessage(), "Ingresar Instituto", JOptionPane.ERROR_MESSAGE);

			}
				
			
		}
		limpiarFormulario();
		btnConfirmar.setEnabled(false);
		setVisible(false);
		
	}
	
	protected void ingresarCategoriaCancelarActionPerformed(ActionEvent e) {
		
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

