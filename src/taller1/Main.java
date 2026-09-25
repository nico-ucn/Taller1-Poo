package taller1;
//Nicolás Lucero - 22.221.136-0 - ICCI

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


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
	
	
	static String[] nAdmitidos = new String[100];
    static String[] apAdmitidos = new String[100];
    static String[] rutAdmitidos = new String[100];
    static String[] parAdmitidos = new String[100];
    static int cantAdmitidos = 0;
    
    
    static String[] lineaRechazados = new String[100];
    static int cantRechazados = 0;
	
	
	

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







	public static void analisisEstadistico() {
        int totalIntentos = cantAdmitidos + cantRechazados;
        
        if (totalIntentos == 0) {
            System.out.println("No hay datos suficientes para analizar.");
            return;
        }

        System.out.println("\n--- Analisis estadistico ---");
        System.out.println("Total de intentos procesados: " + totalIntentos);
        
        
        double pctRechazo = ((double) cantRechazados / totalIntentos) * 100;
       
        pctRechazo = Math.round(pctRechazo * 10.0) / 10.0; 
        
        System.out.println("Rechazados: " + cantRechazados + " (" + pctRechazo + "%)");

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < cantAdmitidos; i++) {
            if (parAdmitidos[i].equalsIgnoreCase("C1")) {
                c1++;
            } else if (parAdmitidos[i].equalsIgnoreCase("C2")) {
                c2++;
            }
        }
        System.out.println("Admitidos por paralelo -> C1: " + c1 + " | C2: " + c2);
        
        double tasaAdmision = ((double) cantAdmitidos / totalIntentos) * 100;
        tasaAdmision = Math.round(tasaAdmision * 10.0) / 10.0;
        
        System.out.println("Tasa de admision: " + tasaAdmision + "%");
    }







	public static void generarReportes() {
        
    }







	public static void administracionCurso(Scanner sc) {
        System.out.println("--- Administracion del curso ---");
        System.out.println("1) Cambiar paralelo de un alumno");
        System.out.println("2) Eliminar alumno del curso");
        System.out.println("3) Inscribir alumno nuevo");
        System.out.println("4) Volver");
        System.out.print("Ingrese opcion: ");
        
        String opcion = sc.nextLine();
        
        // a
        
        
        guardarAlumnosTxt();
    }







	private static void guardarAlumnosTxt() {
		// TODO Auto-generated method stub
		
	}







	public static void inscripcionManual(Scanner sc) {
        System.out.println("\nComo desea inscribir a la persona?");
        System.out.println("1) Por nombre completo");
        System.out.println("2) Por RUT");
        System.out.print("Ingrese opcion: ");
        String op = sc.nextLine();

        if (op.equals("2")) {
            System.out.print("\nIngrese RUT: ");
            String rut = sc.nextLine().trim();
            boolean encontrado = false;

            for (int i = 0; i < cantAlumnos; i++) {
                if (rut.equalsIgnoreCase(rutAlumnos[i])) {
                    encontrado = true;
                    if (!yaEstaAdmitido(rut)) {
                        if (cantAdmitidos < nAdmitidos.length) {
                            nAdmitidos[cantAdmitidos] = nombreAlumnos[i];
                            apAdmitidos[cantAdmitidos] = apellidoAlumnos[i];
                            rutAdmitidos[cantAdmitidos] = rut;
                            parAdmitidos[cantAdmitidos] = paraleloAlumnos[i];
                            cantAdmitidos++;
                            System.out.println("Admitido manualmente.");
                        } else {
                            System.out.println("Limite de admitidos alcanzado. No hay espacio.");
                        }
                    } else {
                        System.out.println("Ya estaba en el grupo.");
                    }
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("El RUT " + rut + " no pertenece a ningun paralelo del curso.");
                if (cantRechazados < lineaRechazados.length) {
                    lineaRechazados[cantRechazados] = "Sin nombre registrado, RUT: " + rut;
                    cantRechazados++;
                }
            }
        }
        // a
    }







	public static void procesarSolicitudes() {
        if (cantAlumnos == 0 && cantSolicitudes == 0) {
            System.out.println("ERROR, Debe cargar los archivos primero.");
            return;
        }

        System.out.println("Procesando solicitudes...");
        int admitidosHoy = 0;
        int rechazadosHoy = 0;

        for (int i = 0; i < cantSolicitudes; i++) {
            String nombreSolicitud = nombreSolicitudes[i];
            String apellidoSolicitud = apellidoSolicitudes[i];
            boolean encontrado = false;

            
            for (int j = 0; j < cantAlumnos; j++) {
                
                if (nombreSolicitud.equalsIgnoreCase(nombreAlumnos[j]) && apellidoSolicitud.equalsIgnoreCase(apellidoAlumnos[j])) {
                    encontrado = true;
                    
                    
                    if (!yaEstaAdmitido(rutAlumnos[j])) {
                        
                        if (cantAdmitidos < nAdmitidos.length) {
                            nAdmitidos[cantAdmitidos] = nombreAlumnos[j];
                            apAdmitidos[cantAdmitidos] = apellidoAlumnos[j];
                            rutAdmitidos[cantAdmitidos] = rutAlumnos[j];
                            parAdmitidos[cantAdmitidos] = paraleloAlumnos[j];
                            cantAdmitidos++;
                            admitidosHoy++;
                            System.out.println( nombreSolicitud + " " + apellidoSolicitud + " -> admitido en " + paraleloAlumnos[j]);
                        } else {
                            System.out.println("Limite de admitidos alcanzado. No hay espacio en memoria.");
                        }
                    }
                    break; 
                }
            }

            if (!encontrado) {
                
                if (cantRechazados < lineaRechazados.length) {
                    lineaRechazados[cantRechazados] = nombreSolicitud + " " + apellidoSolicitud + " - No pertenece a ningun paralelo del curso";
                    cantRechazados++;
                    rechazadosHoy++;
                    System.out.println(  nombreSolicitud + " " + apellidoSolicitud + " -> no pertenece a ningun paralelo");
                }
            }
        }
        System.out.println("");
        System.out.println("Resumen: " + admitidosHoy + " admitidos / " + rechazadosHoy + " rechazados.");
    }







	public static boolean yaEstaAdmitido(String rut) {
        for (int i = 0; i < cantAdmitidos; i++) {
            if (rutAdmitidos[i].equalsIgnoreCase(rut)) {
                return true;
            }
        }
        return false;
    }







	private static void cargarArchivos() {
		 cantAlumnos = 0;
		 cantSolicitudes = 0;
		 
		 try {
			 File archAlumnos = new File("Alumnos.txt");
			 Scanner lector = new Scanner(archAlumnos);
			 	
			 while (lector.hasNextLine() && cantAlumnos < nombreAlumnos.length) {
				 String linea = lector.nextLine().strip();
				 
				 if (!linea.isEmpty()) {
					 String[] partes = linea.split(";");
					 
					 if (partes.length == 4) {
						 nombreAlumnos[cantAlumnos]= partes[0];
						 apellidoAlumnos[cantAlumnos]= partes[1];
						 rutAlumnos[cantAlumnos]= partes[2];
						 paraleloAlumnos[cantAlumnos] = partes[3];
						 cantAlumnos++;
					 }
				 }
			 }
			 lector.close();
			 
			 
		 }
		 
		 catch (IOException e) {
			 System.out.println("El archivo Alumnos.txt no existe o no se pudo leer.");
		 }
		
		try {
			File archSolicitudes = new File("Solicitudes.txt");
			Scanner lector = new Scanner(archSolicitudes);
			
			while (lector.hasNextLine() && cantSolicitudes < nombreSolicitudes.length) {
				String linea = lector.nextLine().strip();
				if (!linea.isEmpty()) {
					String[] partes = linea.split("-");
					if (partes.length == 2) {
						nombreSolicitudes[cantSolicitudes] = partes[0];
						apellidoSolicitudes[cantSolicitudes] = partes[1];
						cantSolicitudes++;
						
					}
				}
			}
			lector.close();
		}
		catch (IOException e) {
			System.out.println("El archivo Solicitudes.txt no existe o no se pudo leer.");
		}
		System.out.println("");
		System.out.println("Archivos procesados.");
        System.out.println("- " + cantAlumnos + " alumnos en la lista.");
        System.out.println("- " + cantSolicitudes + " solicitudes de ingreso.");
	}

}
