package taller1;
//Nicolás Lucero - 22.221.136-0 - ICCI

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	// Listas y datos globales para guardar los datos
	static String[] nombreAlumnos = new String[100]; 
	static String[] apellidoAlumnos = new String[100]; 
	static String[] rutAlumnos = new String[100]; 
	static String[] paraleloAlumnos = new String[100]; 
	static int cantAlumnos = 0;
	
	
	
	
	static String[] nombreSolicitudes = new String[100];
	static String[] apellidoSolicitudes = new String[100];
	static int cantSolicitudes = 0;
	
	
	
	
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		
		while (salir == false) {
			System.out.println("===== Sistema de Control del Grupo POO =====");
			System.out.println("1) Cargar archivos (Alumnos y Solicitudes)");
			System.out.println("2) Procesar solicitudes (Filtrado automatico)");
			System.out.println("3) Inscripcion manual al grupo");
			System.out.println("4) Administracion del curso");
            System.out.println("5) Generar reportes");
            System.out.println("6) Analisis estadistico");
            System.out.println("7) Salir");
            System.out.print("Ingrese opcion: ");
            
            salir = true;
		}
		
	}

}
