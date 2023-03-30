import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Taller;

public class PruebaTaller {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Taller taller = new Taller();
		
		int opcion = 0;

		while ( true ) {
			
			System.out.println("*** MENU ***");
			System.out.println("1. Registrar trabajo");
			System.out.println("2. Aumentar horas");
			System.out.println("3. Aumentar coste de piezas");
			System.out.println("4. Finalizar trabajo");
			System.out.println("5. Mostrar trabajo");
			System.out.println("6. Borrar trabajo");
			
			try {
				opcion = entrada.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("¡Opcion no valida!\n");
			}
			
			if ( opcion == 1 ) {
				
				System.out.println("Introduce el tipo de trabajo (RM, RCP, RE o Revision):");
				String tipoTrabajo = entrada.next();
				System.out.println("Describe brevemente el trabajo: ");
				String descripcion = entrada.next();
				
				int codigo = -1;
				
				if ( tipoTrabajo.equalsIgnoreCase("RE") ) {
					
					System.out.println("Introduce el nombre del ingeniero:");
					String ingeniero = entrada.next();
					System.out.println("Introduce la maquina con la que se realiza el trabajo:");
					String maquina = entrada.next();
					
					codigo = taller.anadirTrabajo(tipoTrabajo, descripcion, ingeniero, maquina);
					
				} else {
					
					codigo = taller.anadirTrabajo(tipoTrabajo, descripcion);
					
				}
				
				if ( codigo == -1 ) {
					System.out.println("No existe ese tipo de trabajo en este taller.\n");
				} else {
					System.out.println("Trabajo anniadido correctamente.\n");
				}
				
			} else if ( opcion == 2 ) {
				
				System.out.println("Expecifica el id del trabajo:");
				int id = entrada.nextInt();
				System.out.println("Indica el numero de horas:");
				int horas = entrada.nextInt();
				
				int codigo = taller.aumentarHoras(id, horas);
				
				if ( codigo == 0 ) {
					System.out.println("El numero de horas no puede ser negativo.\n");
				} else if ( codigo == -1 ) {
					System.out.println("No existe un trabajo con ese identificador.\n");
				} else if ( codigo == -2 ) {
					System.out.println("El trabajo ya esta finalizado.\n");
				} else if ( codigo == 1 ) {
					System.out.println("Horas anniadidas al trabajo.\n");
				}
				
			} else if ( opcion == 3 ) {
				
				System.out.println("Expecifica el id del trabajo:");
				int id = entrada.nextInt();
				System.out.println("Indica el coste de las piezas:");
				double precio = entrada.nextDouble();
				
				int codigo = taller.aumentarCostePiezas(id, precio);
				
				if ( codigo == 0 ) {
					System.out.println("El coste de las piezas no puede ser negativo.\n");
				} else if ( codigo == -1 ) {
					System.out.println("Ese trabajo no es de tipo reparacion.\n");
				} else if ( codigo == -2 ) {
					System.out.println("El trabajo ya esta finalizado.\n");
				} else if ( codigo == -3 ) {
					System.out.println("No existe un trabajo con ese identificador.\n");
				} else if ( codigo == 1 ) {
					System.out.println("Coste de piezas anniadidas al trabajo.\n");
				}
				
			} else if ( opcion == 4 ) {
				
				System.out.println("Expecifica el id del trabajo:");
				int id = entrada.nextInt();
				
				int codigo = taller.finalizarTrabajo(id);
				
				if ( codigo == -1 ) {
					System.out.println("No existe un trabajo con ese identificador.\n");
				} else if ( codigo == 0 ) {
					System.out.println("El trabajo ya esta finalizado.\n");
				} else if ( codigo == 1 ) {
					System.out.println("Trabajo finalizado correctamente.\n");
				}
				
			} else if ( opcion == 5 ) {
				
				System.out.println("Expecifica el id del trabajo:");
				int id = entrada.nextInt();
				
				System.out.println(taller.muestraTrabajo(id));
				
			} else if ( opcion == 6 ) {
			
				System.out.println("Expecifica el id del trabajo:");
				int id = entrada.nextInt();
				
				int codigo = taller.borrarTrabajo(id);
				
				if ( codigo == -1 ) {
					System.out.println("No existe un trabajo con ese identificador.\n");
				} else if ( codigo == 1 ) {
					System.out.println("Trabajo borrado correctamente.\n");
				}
				
			} else {
				System.out.println("¡Opcion no valida!\n");
			}
			
		}
		
	}

}
