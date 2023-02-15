package main;
import java.util.*;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;

public class MenuOpciones {
	
	// MAIN
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		// PETICION Y DECLARACION DE OBJETOS JUGADOR, EQUIPO Y PARTIDO
		
		System.out.println("Introduce el nombre del primer equipo:");
		String nombreE1 = entrada.next();
		System.out.println("Introduce el nombre del jugador 1 del primer equipo:");
		String nombreJ1 = entrada.next();
		System.out.println("Introduce el nombre del jugador 2 del primer equipo:");
		String nombreJ2 = entrada.next();
		
		System.out.println("\nIntroduce el nombre del segundo equipo:");
		String nombreE2 = entrada.next();
		System.out.println("Introduce el nombre del jugador 1 del segundo equipo:");
		String nombreJ3 = entrada.next();
		System.out.println("Introduce el nombre del jugador 2 del segundo equipo:");
		String nombreJ4 = entrada.next();
		
		Partido partido = new Partido(nombreE1, nombreJ1, nombreJ2, nombreE2, nombreJ3, nombreJ4);
		
		int limitePartido = 10, opcion = 0;
		String barra = "-";
		
		// BUCLE DE MENU DEL PARTIDO
		
		while ( !partido.ganaE1(limitePartido) || !partido.ganaE2(limitePartido) ) {					//////////////////////		//////////////////////
			
			System.out.println("\n	 *** MENU ***");
			System.out.println(barra.repeat(32));
			System.out.println("1. Contabiliza punto ganador.");
			System.out.println("2. Contabiliza error no forzado.");
			System.out.println("3. Contabiliza saque directo.");
			System.out.println("4. Muestra estadisticas jugador.");
			System.out.println("5. Muestra estadisticas equipo.");
			System.out.println(barra.repeat(32) + "\n");
			
			// CONTROL DE EXCEPCIONES PARA LA OPCION DEL MENU
			
			try {
				opcion = entrada.nextInt();
			} catch(InputMismatchException ex) {
				entrada.next();
			}
			
			// CASOS DE USO
			
			if ( opcion == 1 ) {
				
				System.out.println("Introduce el nombre del jugador que ha puntuado:");
				String nombre = entrada.next();
				
				int codigo = partido.contabiliza(nombre, opcion);												////////////////////////////////////////////////
				
				if ( codigo == 1 ) {
					System.out.println("Punto añadido a " + nombre);
				} else if ( codigo == -1 ) {
					System.out.println("¡Ese jugador no existe!");
				}
				
			} else if ( opcion == 2 ) {
				
				System.out.println("Introduce el nombre del jugador que ha errado:");
				String nombre = entrada.next();
				
				int codigo = partido.contabiliza(nombre, opcion);												////////////////////////////////////////////////
				
				if ( codigo == 2 ) {
					System.out.println("Error añadido a " + nombre);
				} else if ( codigo == -1 ) {
					System.out.println("¡Ese jugador no existe!");
				}
				
			} else if ( opcion == 3 ) {
				
				System.out.println("Introduce el nombre del jugador que ha realizado un saque directo:");
				String nombre = entrada.next();
				
				int codigo = partido.contabiliza(nombre, opcion);												////////////////////////////////////////////////
				
				if ( codigo == 3 ) {
					System.out.println("Saque directo añadido a " + nombre);
				} else if ( codigo == -1 ) {
					System.out.println("¡Ese jugador no existe!");
				}
				
			} else if ( opcion == 4 ) {
				
				System.out.println("Introduce el nombre del jugador:");
				String nombre = entrada.next();
				
				System.out.println(partido.estadisticasJugador(nombre));								////////////////////////////////////////////////
				
			} else if ( opcion == 5 ) {
				
				System.out.println("Introduce el nombre del equipo:");
				String nombre = entrada.next();
				
				System.out.println(partido.estadisticasEquipo(nombre));									////////////////////////////////////////////////
				
			} else {
				System.out.println("¡Opcion no valida!\n");
			}
			
		}
		
		// CONDICION PARA SABER EL GANADOR
		
		if ( partido.ganaE1(limitePartido) ) {															////////////////////////////////////////////////
			System.out.println("¡GANA " + nombreE1 + "!");
		} else if ( partido.ganaE2(limitePartido) ){													////////////////////////////////////////////////
			System.out.println("¡GANA " + nombreE2 + "!");
		} else {
			System.out.println("¡Ha habido un empate!");
		}

	}

}
