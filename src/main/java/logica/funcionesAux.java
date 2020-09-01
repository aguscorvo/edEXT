package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class funcionesAux {

	public static String convertirAString(Date fecha) {
		String aRetornar= null;
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		aRetornar=sdf.format(fecha);
		return aRetornar;
	}
	
	public static Date convertirADate(String stringFecha) {
		Date aRetornar = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		try {
			aRetornar=sdf.parse(stringFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return aRetornar;
	}
}
