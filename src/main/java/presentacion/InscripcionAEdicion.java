package presentacion;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;

import interfaces.IControladorInscripcionAEdicion;

public class InscripcionAEdicion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IControladorInscripcionAEdicion iConInsEd;
	
	public InscripcionAEdicion(IControladorInscripcionAEdicion iConsInsEd) {
		this.iConInsEd=iConsInsEd;
		setBounds(100, 100, 450, 300);

	}

	/*public void iniciarlizarComboBoxEdicion() {
		
		DefaultComboBoxModel<String> modelEdicion = new DefaultComboBoxModel<String>(iConConEdi.getEdiciones(this.cursoSeleccionado));		
		comboBoxEdicion.setModel(modelEdicion);
	}*/
}
