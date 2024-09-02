package juegoahorcado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.Scanner;

public class Palabras {
	
	private ArrayList<String> palabras;
	
	// Longitud mínima y máxima de las palabras cargadas en el array;
	private  int palMaxLong  = 0;
	private  int palMinLong = Integer.MAX_VALUE;

	public Palabras() {
		
		cargaPalabras(true,"/palabras.txt");

	}

	public Palabras(String fichero) {
		cargaPalabras(false, fichero);

	}

	/**
	 * Carga la lista de palabras desde un fichero de recurso o del file system
	 * @param esRecurso true si el fichero es de recurso; false si no lo es
	 * @param nombre Ruta completa del fichero si es del file system; nombre fichero 
	 * recurso con: ejemplo: "/palabras.txt"
	 * @param max_min 
	 */
	void cargaPalabras(boolean esRecurso, String nombre) {
		Scanner sc = null;

		if (esRecurso) {
			InputStream is = JuegoAhorcado.class.getResourceAsStream(nombre);

			if (is != null) {
				sc = new Scanner(is);
			} else {
				throw new MissingResourceException("Fichero de recurso no encontrado", "JuegoAhorcado", nombre);
			}
		} else {
			try {
				sc = new Scanner(new File(nombre));
			} catch (FileNotFoundException e) {
				System.out.println("Fichero no encontrado " + nombre);
				System.out.println("Programa finalizdo.");
				System.exit(0);
			}
		}
		
		palabras = new ArrayList<>(); // Crea el arrayList para almacenar las parlabras

		while (sc.hasNextLine()) { // Mientras haya líneas que leer.
			String pal = sc.nextLine();
			int l;
			palabras.add(pal); // Cada palabra está en una línea del fichero
			palMinLong = (l = pal.length()) < palMinLong ? l : palMinLong;
			palMaxLong = (l = pal.length()) > palMaxLong ? l : palMaxLong;
		}

		sc.close();  // Cierra el Scanner y este el descriptor de fichero asociado.	
	}


	/**
	 * Devuelve una palabra del ArrayList palabras. La palabra corresponede a una
	 * posición aleatoria en el rango 0 - (n-1), donde n es el número de palabras
	 * almacenadas en el array PALABRAS
	 * 
	 * @return La palabra seleccionada aleatoriamente.
	 */
	public String damePalabra() {
		int n = palabras.size();

		// Genero entero aleatorio entre 0 y n - 1;

		n = (int) (Math.random() * n);

		return palabras.get(n);

	}

	/**
	 * Devuelve la palabra de la posición posicion de la lista de palabras
	 * 
	 * @param posicion Posición de la palabra a devolver
	 * @return La palabra de la posición posición
	 * @throws IllegalArgumentException
	 */
	public String damePalabra(int posicion) throws IllegalArgumentException {
		if (posicion < 0 || posicion >= palabras.size()) {
			throw new IllegalArgumentException("Argumento fuera del rango" );
		}
		return palabras.get(posicion);
	}
	
	/**
	 * Devuelve de la lista una palabra de longintud determinada.
	 * @param longitud Longitud de la palabra
	 * @return Palabra de longitud longitud o null si no hay ninguna palabra
	 *         con dicha longitud en la lista
	 */
	public String damePalabraL(int longitud) {
		if(longitud > palMaxLong || longitud < palMinLong)
			throw new IllegalArgumentException("Logitud fuera de rango: " + palMinLong + "-" + palMaxLong);
		
		String palabra = null;
		int s = palabras.size();

		// Genero entero aleatorio entre 0 y n - 1;

		int n = (int) (Math.random() * s);
		
		// Busca a partir de posición aleatoria
		for(int i= n; i < s; i++) {
			palabra = palabras.get(i);
			if((palabra.length()) == longitud)
				return palabra;
		}
		
		// Si no ha encontradao palabra y no comenzó a buscarla 
		// desde el principio, ahora la busca desde el principio
		// hasta la posición anterior del comienzo del la busqueda
		// anterior
		
		if (n != 0){
			for (int i=0; i < n; i++) {
				palabra = palabras.get(i);
				if((palabra.length()) == longitud)
					return palabra;
			}
		}	
		
		return null;	
		
	}
	
	public int getPalMaxLong() {
		return palMaxLong;
	}

	public int getPalMinLong() {
		return palMinLong;
	}

}
