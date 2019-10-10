package es.navas.oposiciones.datosEstaticos.cadenas;

public class ValidacionContrasenya {

	public static Validacion validar(String password) {
		Validacion validacion = new Validacion();
		validacion.setPassword(password);
		String error = "";
		boolean tieneMinuscula = false;
		boolean tieneMayuscula = false;
		boolean tienePuntuacion = false;
		boolean tieneNumero = false;
		if (password.length() < 8) {
			error += "La cadena debe tener 8 o mas caracteres\n";
		} else {
			for (int i = 0; i < password.length(); i++) {
				
				if (Character.isLowerCase(password.charAt(i))) {
					tieneMinuscula = true;
				}
				if (Character.isUpperCase(password.charAt(i))) {
					tieneMayuscula = true;
				}
				if (Character.isDigit(password.charAt(i))) {
					tieneNumero = true;
				}
				if (password.charAt(i) == '.' ||password.charAt(i) == '-' ||password.charAt(i) == '_' ) {
					tienePuntuacion = true;
				}
			}
		}
		if (!tieneMinuscula) error += "Falta minuscula en el pass\n";
		if (!tieneMayuscula) error += "Falta mayuscula en el pass\n";
		if (!tieneNumero) error += "Falta numero en el pass\n";
		if (!tienePuntuacion) error += "Falta puntuacion en el pass\n";
		System.out.println(error);
		validacion.setValido(error=="");
		validacion.setErrorValidacion(error);
		return validacion;
		
	} 
	
	public static class Validacion{
		private String password;
		private boolean valido;
		private String errorValidacion;
			
		public Validacion() {
			super();
		}
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isValido() {
			return valido;
		}
		public void setValido(boolean valido) {
			this.valido = valido;
		}
		public String getErrorValidacion() {
			return errorValidacion;
		}
		public void setErrorValidacion(String errorValidacion) {
			this.errorValidacion = errorValidacion;
		}
	} 
	
}
