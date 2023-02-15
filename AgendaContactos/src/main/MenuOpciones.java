package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Agenda;

public class MenuOpciones {
	
	
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		Agenda agenda = new Agenda();
		
		int opcion = 0;
		
		while ( true ) {
		
			System.out.println("*** MENU ***");
			System.out.println("1. Añadir contacto.");
			System.out.println("2. Eliminar contacto.");
			System.out.println("3. Buscar contacto.");
			System.out.println("4. Ver todos los contactos.");
			System.out.println("5. Modificar contacto.");
			
			try {
				opcion = entrada.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("¡Opcion no valida!");
			}
			
			if ( opcion == 1 ) {
				
				System.out.println("Introduce el nombre del nuevo contacto: ");
				String nombre = entrada.next();
				
				if ( !agenda.existe(nombre) ) {
					
					System.out.println("Introduce el correo del nuevo contacto: ");
					String correo = entrada.next();
					System.out.println("Introduce el telefono del nuevo contacto: ");
					int telefono = entrada.nextInt();
					
					agenda.añadirContacto(nombre, correo, telefono);
					
					System.out.println("\n¡Nuevo contacto añadido a la agenda!\n");
					
				} else {
					System.out.println("\n¡Ese contacto ya existe!\n");
				}
				
			} else if ( opcion == 2 ) {
				
				System.out.println("Introduce el nombre del contacto que deseas borrar: ");
				String nombre = entrada.next();
				
				if ( agenda.existe(nombre) ) {
					
					agenda.eliminarContacto(nombre);
					
					System.out.println("\n¡Contacto eliminado de la agenda!\n");
					
				} else {
					System.out.println("\n¡Ese contacto no existe!\n");
				}
				
			} else if ( opcion == 3 ) {
				
				System.out.println("Introduce el nombre del contacto que deseas buscar: ");
				String nombre = entrada.next();
				
				if ( agenda.existe(nombre) ) {
					
					System.out.println(agenda.buscarContacto(nombre));
					
				} else {
					System.out.println("\n¡Ese contacto no existe!\n");
				}
				
			} else if ( opcion == 4 ) {
				
				System.out.println(agenda.mostrarContactos());
				
			} else if ( opcion == 5 ) {
				
				System.out.println("Introduce el nombre del contacto que deseas modificar: ");
				String nombre = entrada.next();
				
				if ( agenda.existe(nombre) ) {
					
					System.out.println("¿Quieres cambiar el correo del contacto? escribe si/no");
					String respuesta = entrada.next();
					
					if ( respuesta.equals("si") ) {
						
						System.out.println("Introduce el nuevo correo: ");
						String correo = entrada.next();
						
						agenda.modificarCorreo(nombre, correo);
						
						System.out.println("\n¡Correo del contacto modificado!\n");
						
					}
					
					System.out.println("¿Quieres cambiar el telefono del contacto? escribe si/no");
					respuesta = entrada.next();
					
					if ( respuesta.equals("si") ) {
						
						System.out.println("Introduce el nuevo telefono: ");
						int telefono = entrada.nextInt();
						
						agenda.modificarTelefono(nombre, telefono);
						
						System.out.println("\n¡Telefono del contacto modificado!\n");
						
					}
					
				} else {
					System.out.println("\n¡Ese contacto no existe!\n");
				}
				
			} else if ( opcion == 6 ) {
				
				System.out.println("En la agenda hay " + agenda.cantidadContactos());
				
			}
		
		}
	}

}
