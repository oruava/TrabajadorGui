package org.example.Datos;

import org.example.Gui.FormularioDatos;
import org.example.Modelo.Trabajador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public interface Datos {

	static void guardarDatosEnCSV(Trabajador trabajador) {

		String[] datos = {trabajador.getNombre(), trabajador.getApellido(),trabajador.getRut(), trabajador.getIsapre(), trabajador.getAfp()};
		escribirCSV("datos.csv", datos);



		System.out.println("Datos guardados en datos.csv");
	}

	static void escribirCSV(String nombreArchivo, String[] datos) {
		try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
			for (String dato : datos) {
				writer.append(dato).append(",");
			}
			writer.append("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void buscarTrabajadorPorRut(String rutBuscado) {
		try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length > 2 && datos[2].equals(rutBuscado)) {

					System.out.println("Trabajador encontrado:");
					System.out.println("Nombre: " + datos[0]);
					System.out.println("Apellido: " + datos[1]);
					System.out.println("RUT: " + datos[2]);
					System.out.println("ISAPRE: " + datos[3]);
					System.out.println("AFP: " + datos[4]);
					return;
				}
			}

			System.out.println("Trabajador no encontrado con RUT: " + rutBuscado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}