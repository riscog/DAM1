package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Maquina;

public class TestMaquinaExpendedora {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Maquina maquina = new Maquina();
		
		int opcion = 100, opcionAdmin = 0;
		
		while ( true ) {
			
			System.out.println(maquina.mostrarProductos());														//////////////////////////////
			System.out.println("\nElige un producto: ");
			
			try {
				opcion = entrada.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Opcion no valida");
			}
			
			if ( maquina.existeProducto(opcion)	) {																//////////////////////////////
				
				System.out.println("Introduce importe en centimos: ");
				int dinero = entrada.nextInt();
				
				int codigoError = maquina.almacenarEnAcumulador(dinero);										//////////////////////////////
				
				if ( codigoError == -1 ) {
					System.out.println("¡Moneda no valida!");
				}
				
				int codigo = maquina.compararPrecio(opcion, dinero);											//////////////////////////////
				
				while ( codigo == 2 || codigoError == -1 ) {
					
					System.out.println("Dinero introducido: " + maquina.mostrarDineroIntroducido());			//////////////////////////////
					
					System.out.println("Introduce importe en centimos (0 para devolver monedas introducidas): ");
					dinero = entrada.nextInt();
					
					if ( dinero == 0 ) {
						
						System.out.println(maquina.devolverMonedasAcumulador());								//////////////////////////////
						break;
						
					} else {
						codigoError = maquina.almacenarEnAcumulador(dinero);									//////////////////////////////
						
						if ( codigoError == -1 ) {
							System.out.println("¡Moneda no válida!");
						}
					
						int dineroIntroducido = maquina.mostrarDineroIntroducido();								//////////////////////////////
						codigo = maquina.compararPrecio(opcion, dineroIntroducido);								//////////////////////////////
					}
				}
				
				if ( codigo == 1 ) {
					
					System.out.println(maquina.devolverCambio(opcion, dinero)); 								//////////////////////////////
					System.out.println("Puede recoger su " + maquina.nombreProducto(opcion) + "\n");			//////////////////////////////
					maquina.reducirCantidad(opcion);															//////////////////////////////
					maquina.acumuladorA0();																		//////////////////////////////
					
				} else if ( codigo == 0 ) {
					
					System.out.println("Puede recoger su " + maquina.nombreProducto(opcion) + "\n");			//////////////////////////////	
					maquina.reducirCantidad(opcion);															//////////////////////////////
					maquina.almacenarEnCajetin(); 																//////////////////////////////
					maquina.acumuladorA0(); 
					
				}
				
			} else if ( maquina.comprobarContrasennia(opcion) ) {												//////////////////////////////
				
				boolean salir = false;
				
				while ( !salir ) {
				
					System.out.println("*** MENU DE MANTENIMIENTO ***");
					System.out.println("1. Introducir productos.");
					System.out.println("2. Introducir cambios.");
					System.out.println("3. Recaudacion.");
					System.out.println("4. Salir del menu.");
					
					try {
						opcionAdmin = entrada.nextInt();
					} catch (InputMismatchException ex) {
						System.out.println("Opcion no valida");
					}
					
					if ( opcionAdmin == 1 ) {
						
						System.out.println("Producto: ");
						int n = entrada.nextInt();
						System.out.println("Cantidad de producto a introducir:");
						int cantidad = entrada.nextInt();
						
						int codigo = maquina.meterProductos(n, cantidad);										//////////////////////////////
						
						if ( codigo == 0 ) {
							System.out.println("Productos introducidos con exito.\n");
						} else if ( codigo == -1 ) {
							System.out.println("¡Ese producto no existe!\n");
						}
						
					} else if ( opcionAdmin == 2 ) {
						
						System.out.println("Valor de la moneda: ");
						int valor = entrada.nextInt();
						System.out.println("Cantidad de monedas a introducir:");
						int cantidad = entrada.nextInt();
							
						int codigo = maquina.meterCambios(valor, cantidad);										//////////////////////////////
						
						if ( codigo == 0 ) {
							System.out.println("Cambios introducidos con exito.\n");
						} else {
							System.out.println("¡Esa moneda no existe!\n");
						}
						
					} else if ( opcionAdmin == 3 ) {
						
						System.out.println(maquina.saberMonedasCajetin());										//////////////////////////////
						
					} else if ( opcionAdmin == 4 ) {
						
						System.out.println("Saliendo al menu principal...");
						salir = true;
						
					} else {
						System.out.println("Opcion no valida");
					}
				}
			} else {
				System.out.println("¡Ese producto no existe!");
			}
			
		}

	}

}
