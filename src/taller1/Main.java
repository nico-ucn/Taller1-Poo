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
            
            String input = sc.nextLine();
            int opcion = -1;
            
            try {
                
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                
            }

            
            switch (opcion) {
                case 1:
                    cargarArchivos();
                    break;
                case 2:
                    procesarSolicitudes();
                    break;
                case 3:
                    inscripcionManual(sc);
                    break;
                case 4:
                    administracionCurso(sc);
                    break;
                case 5:
                    generarReportes();
                    break;
                case 6:
                    analisisEstadistico();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    
                    System.out.println("[Error] Opcion invalida. Por favor, ingrese un numero del 1 al 7.");
            }
        }
		
	}







	private static void analisisEstadistico() {
		// TODO Auto-generated method stub
		
	}







	private static void generarReportes() {
		// TODO Auto-generated method stub
		
	}







	private static void administracionCurso(Scanner sc) {
		// TODO Auto-generated method stub
		
	}







	private static void inscripcionManual(Scanner sc) {
		// TODO Auto-generated method stub
		
	}







	private static void procesarSolicitudes() {
		// TODO Auto-generated method stub
		
	}







	private static void cargarArchivos() {
		// TODO Auto-generated method stub
		
	}

}
