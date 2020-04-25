package main;

public class Config {
	private static boolean metadatos = true;
	private static boolean memoria = false;
	private static boolean generacion = false;

	static public boolean mostrarMetadatos() {
		return metadatos;
	}

	static public boolean mostrarMemoryAllocation() {
		return memoria;
	}

	static public boolean mostrarGeneracionDeCodigo() {
		return generacion;
	}

}
