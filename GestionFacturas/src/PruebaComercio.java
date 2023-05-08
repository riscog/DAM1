import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.*;
import modelo.Comercio;

public class PruebaComercio {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Comercio comercio = new Comercio();
		
		int opcion = 0;
		boolean salir = false;
		
		while ( !salir ) {
			
			System.out.println("\t*** MENU ***");
			System.out.println("0.	Salir.");
			System.out.println("1.	Registrar cliente.");
			System.out.println("2.	Anniadir producto al almacen.");
			System.out.println("3. 	Anniadir existencias de un producto.");
			System.out.println("4.	Generar pedido.");
			System.out.println("5.	Generar factura.");
			System.out.println("6.	Visualizar factura.");
			System.out.println("7.	Visualizar facturas de un cliente.");
			//System.out.println("8.	Guardar factura en un archivo.\n");
			
			try {
				opcion = entrada.nextInt();
				
			if ( opcion == 0 ) {
				
				salir = true;
				
			} else if ( opcion == 1 ) {
				
				System.out.println("Introduce el DNI: ");
				String dni = entrada.next();
				System.out.println("Introduce el nombre: ");
				String nombre = entrada.next();
				System.out.println("Introduce el descuento para el cliente (0 para descuento predefinido del 10%): ");
				int descuento = entrada.nextInt();
				
		        if ( descuento == 0 ) {
		            descuento = 10;
		        }
				
				comercio.registrarCliente(dni, nombre, descuento);								///////////////////////////////////
				
			} else if ( opcion == 2 ) {
				
				System.out.println("Introduce el nombre del producto: ");
				String nombre = entrada.next();
				System.out.println("Introduce el precio del producto: ");
				double precio = entrada.nextDouble();
				System.out.println("Introduce las cantidades a añadir: ");
				int cantidad = entrada.nextInt();
				
				comercio.nuevoProducto(nombre, precio, cantidad);								///////////////////////////////////
				
			} else if ( opcion == 3 ) {
				
				System.out.println("Introduce el nombre del producto: ");
				String nombre = entrada.next();
				System.out.println("Introduce las cantidades a añadir: ");
				int cantidad = entrada.nextInt();
				
				comercio.reposicionExistencias(nombre, cantidad);								///////////////////////////////////
				
			} else if ( opcion == 4 ) {
				
				System.out.println("Introduce el DNI del cliente: ");
				String dni = entrada.next();
				
				if ( comercio.existeCliente(dni) ) {
					
					System.out.println(comercio.mostrarProductos());
					
					boolean finalizar = false;
					
					while ( !finalizar ) {
					
						System.out.println("Introduce el nombre del producto (f para finalizar): ");
						String nombre = entrada.next();
						
						if ( nombre.equals("f") ) {
							
							finalizar = true;
							
						} else if ( comercio.existeProducto(nombre) ) {
							
							System.out.println("Introduce la cantidad de " + nombre + ": ");
							int cantidad = entrada.nextInt();
							
							comercio.generarPedido(dni, nombre, cantidad);						///////////////////////////////////
							
							System.out.println("Pedido generado con exito.\n");
							
						}
					}
				}
				
			} else if ( opcion == 5 ) {
				
				System.out.println("Introduce el DNI del cliente: ");
				String dni = entrada.next();
				
				if ( comercio.existeCliente(dni) ) {
					
					System.out.println(comercio.gererarFactura(dni)); 							///////////////////////////////////
					
				}
				
			} else if ( opcion == 6 ) {
				
				System.out.println("Introduce el numero de la factura: ");
				int numero = entrada.nextInt();
				
				System.out.println(comercio.visualizarFactura(numero)); 						///////////////////////////////////
				
			} else if ( opcion == 7 ) {
				
				System.out.println("Introduce el DNI del cliente: ");
				String dni = entrada.next();
				
				System.out.println(comercio.visualizarFacturasCliente(dni)); 					///////////////////////////////////
				
			/*} else if ( opcion == 8 ) {
				
				
			*/	
			} else {
				System.out.println("¡Opcion no valida!\n");
			}
			
			} catch (InputMismatchException e) {
				System.out.println(e);
				salir = false;
			} catch (YaExisteCliente e) {
				System.out.println(e);
			} catch (YaExisteProducto e) {
				System.out.println(e);
			} catch (NoExisteProducto e) {
				System.out.println(e);
			} catch (NoExisteCliente e) {
				System.out.println(e);
			} catch (NoExisteFactura e) {
				System.out.println(e);
			}
			
		}

	}

}
