import java.util.*;

/**
 * Maquina de vending de Mario Risco García 
 * @author Mario
 *
 */

public class CandyShop {
	
	//COLORES PARA LA CONSOLA
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	//FUNCION QUE RELLENA LA CANTIDAD DE TODOS LOS PRODUCTOS A 3
	public static void rellenarTodosProductosA3(int[][] cantidades, int cantidadProducto) {
		
		for ( int fila = 0; fila < 4; fila++ ) {
			for ( int col = 0; col < 4; col++ ) {
				
				cantidades[fila][col] = cantidadProducto;
				
			}
		}
	}
	
	//FUNCION QUE DEVUELVE UN BOOLEANO CON TRUE SI ENCUENTRA LA POSICION DENTRO DE LA MATRIZ DE POSICIONES
	public static boolean posicionEncontrada(String posicionElegida, String[][] posiciones) {
		
		boolean encontrado = false;
		
		for ( int fila = 0; fila < 4 && !encontrado; fila++ ) {
			for ( int col = 0; col < 4 && !encontrado; col++ ) {
				
				if ( posicionElegida.equals(posiciones[fila][col]) ) {
					
					encontrado = true;
					
				}
			}
		}
		return encontrado;
	}
	
	//FUNCION QUE DEVUELVE UN ARRAY DE DOS POSICIONES, 1 - FILA Y 2 - COLUMNA, DE LA MATRIZ DE POSICIONES
	public static int[] posicionGolosina(String posicionElegida, String[][] posiciones) {
		
		int[] arrayPosicion = new int[2];
		boolean encontrado = false;
		
		for ( int fila = 0; fila < 4 && !encontrado; fila++ ) {
			for ( int col = 0; col < 4 && !encontrado; col++ ) {
				
				if ( posicionElegida.equals(posiciones[fila][col]) ) {
					
					arrayPosicion[0] = fila;
					arrayPosicion[1] = col;
					encontrado = true;
					
				}
			}
		}
		return arrayPosicion;
	}
	
	//FUNCION QUE DEVUELVE UN BOOLEANO CON TRUE SI HAY EXISTENCIAS DEL PRODUCTO ELEGIDO
	public static boolean hayStock(String posicionElegida, int[][] cantidades, String[][] posiciones) {
		
		boolean stock = false;
		
		if ( cantidades[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]] > 0 ) {
			stock = true;
		}
		
		return stock;
	}
	
	//FUNCION QUE REDUCE LA CANTIDAD DEL PRODUCTO QUE PIDE EL USUARIO
	public static void reducirCantidad(String posicionElegida, int[][] cantidades, String[][] posiciones) {
		
		cantidades[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]]--;
		
	}
	
	//CALCULA LA EL NOMBRE MAS LARGO ENTRE LOS PRODUCTOS
	public static int calcularPalabraMayorLongitud(String[][] productos) {
		
		int tamañoMax = 0;
		
		for ( int fila = 0; fila < 4; fila++ ) {								
			for ( int col = 0; col < 4; col++ ) {
				
				if ( productos[fila][col].length() > tamañoMax ) {
					
					tamañoMax = productos[fila][col].length();
					
				}
			}
		}
		return tamañoMax;
	}
	
	//CALCULA EL PRECIO CON MAYOR LONGITUD ENTRE LOS PRECIOS DE LOS PRODUCTOS
	public static int calcularPrecioMayorLongitud(double[][] precios) {
		
		int precioMax = 0;
		
		for ( int fila = 0; fila < 4; fila++ ) {								
			for ( int col = 0; col < 4; col++ ) {
				
				String digitos = String.valueOf(precios[fila][col]);
				
				if ( digitos.length() > precioMax ) {
					
					precioMax = digitos.length();
					
				}
			}
		}
		return precioMax;
	}
	
	//FUNCION QUE MUESTRA POR PANTALLA LOS PRODUCTOS DE LA MAQUINA, SU POSICION Y SU PRECIO
	public static String mostrarGolosinas(String[][] productos, double[][] precios, String[][] posiciones) {
		
		String espacio = " ";													//variable que contiene un espacio
		String barra = "-";														//variable que contiene un guion
		int numBarras = 0;
		
		String listado = "";
		
		for ( int fila = 0; fila < 4; fila++ ) {								//bucle para mostrar todos los productos
			for ( int col = 0; col < 4; col++ ) {
				
				String digitos = String.valueOf(precios[fila][col]);
				int numDecimales = calcularPrecioMayorLongitud(precios) - digitos.length();										//variable que opera para obtener la cantidad de espacios que hay que escribir tras cada precio
				
				int numEspacios = calcularPalabraMayorLongitud(productos) - productos[fila][col].length();						//variable que opera para obtener la cantidad de espacios que hay que escribir tras cada nombre
				numBarras = calcularPalabraMayorLongitud(productos) + 37 + calcularPrecioMayorLongitud(precios);				//variable que opera para obtener la cantidad de barras que hay que escribir
				
				listado += barra.repeat(numBarras) + "\n";
				listado += "| " + productos[fila][col] + espacio.repeat(numEspacios) + "\t | Posición: " + posiciones[fila][col] + "\t | Precio: " + precios[fila][col] + espacio.repeat(numDecimales) + " |\n";
				
			}
		}
		
		listado += barra.repeat(numBarras) + "\n";
		
		return listado;
		
	}
	
	//FUNCION QUE DEVUELVE UN BOOLEANO CON TRUE SI LOS DOS VALORES COINCIDEN
	public static boolean cambiarContraseña(String nuevaContraseña, String confirmacion) {
		
		boolean cambio = false;
		
		if ( confirmacion.equals(nuevaContraseña) ) {
			cambio = true;
		}
		return cambio;
	}
	
	//FUNCION QUE DEVUELVE UN BOOLEANO CON TRUE SI LA CANTIDAD QUE EL ADMINISTRADOR QUIERE INTRODUCIR CABE EN EL CAJETIN
	public static boolean cabeCantidad(int cantidadRellenar, String posicionElegida, String[][] posiciones, int[][] cantidades) {
		
		boolean cabe = false;
				
		if ( cantidades[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]] + cantidadRellenar <= 5 && cantidades[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]] + cantidadRellenar > 0 ) {				
						
			cabe = true;
						
		}
		return cabe;
	}
	
	//FUNCION QUE RELLENA EL PRODUCTO DESEADO CON LA CANTIDAD INTRODUCIDA POR EL ADMINISTRADOR
	public static void rellenarGolosina(String posicionElegida, int cantidadRellenar, String[][] posiciones, int[][] cantidades) {	
						
		cantidades[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]] += cantidadRellenar;
							
	}
	
	//FUNCION QUE CAMBIA EL PRECIO DE UNA POSICION DESEADA Y DE LOS PRODUCTOS CON EL MISMO NOMBRE DE LA MAQUINA
	public static void cambiarPrecio(String posicionElegida, double nuevoPrecio, double[][] precios, String[][] posiciones, String[][] productos) {
		
		for ( int fila = 0; fila < 4; fila++ ) {								
			for ( int col = 0; col < 4; col++ ) {
				
				if ( productos[fila][col].equals(productos[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]]) ) {
					
					precios[fila][col] = nuevoPrecio;
					
				}
			}
		}
	}
	
	//FUNCION QUE CAMBIA EL NOMBRE DEL PRODUCTO DESEADO
	public static void cambiarProducto(String posicionElegida, String nuevoProducto, String[][] posiciones, String[][] productos) {
		
		productos[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]] = nuevoProducto;
		
	}
	
	//FUNCION QUE PONE LA CANTIDAD DE UN PRODUCTO A 0
	public static void ponerCantidadA0(String posicionElegida, String[][] posiciones, int[][] cantidades) {
		
		cantidades[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]] = 0;
		
	}
	
	//FUNCION QUE AÑADE LAS VENTAS REALIZADAS DE LOS PRODUCTOS A UNA MATRIZ
	public static void sumarVentas(String posicionElegida, String[][] posiciones, int[][] ventas, String[][] productos) {
		
		for ( int fila = 0; fila < 4; fila++ ) {
			for ( int col = 0; col <4; col++ ) {
				
				if ( productos[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]].equals(productos[fila][col]) ) {
					
					ventas[fila][col]++;
					
				}
			}
		}
	}
	
	//FUNCION QUE ORDENA MEDIANTE EL METODO BURBUJA DE MENOR A MAYOR LOS NUMEROS DE UN ARRAY
	public static int[] burbuja(int array[]) {
		
		int contador = 0, contador2 = contador + 1, operacion = 0, aux = 0;
		boolean terminar = false;
		
		while ( !terminar ) {
			
			operacion = 0;
			contador = 0;
			contador2 = contador + 1;
			
			while ( contador2 < array.length ) {
			
				if ( array[contador] > array[contador2] ) {
					aux = array[contador];
					array[contador] = array[contador2];
					array[contador2] = aux;
					operacion++;
				}
			
				contador++;
				contador2++;
			
			}
			
			if ( operacion == 0 ) {
				terminar = true;
			}
			
		}
		return array;
	}
	
	//FUNCION QUE AÑADE LAS VENTAS DE LOS PRODUCTOS A UN ARRAY
	public static int[] añadirVentasArray(int[][] ventas) {
		
		int arrayVentas[] = new int[16];
		int contador = 0;
		
		for (int fila = 0; fila < 4; fila++) {
			for (int col = 0; col < 4; col++) {
				
				arrayVentas[contador] = ventas[fila][col];
				contador++;
				
			}
		}
		return arrayVentas;
	}
	
	//FUNCION QUE MUESTRA EL RANKING DE VENTAS
	public static String rankingVentas(int[][] ventas, String[][] productos) {
		
		String ranking = "";													//variable que contendrá el ranking
		
		String productosMostrados[] = new String[16];							//array con los productos ya mostrados
		int arrayVentas[] = añadirVentasArray(ventas);							//array con las ventas de los productos
		
		burbuja(arrayVentas);													//metodo burbuja para ordenar el array
		
		int contadorProductos = 0;
		int contadorProductosRepetidos = 0;
		
		int finArray = arrayVentas.length - 1;									//variable que obtiene la venta mas alta
		int ventasRepetidas = arrayVentas[finArray];
		
		boolean productoRepetido = false;
		
		if ( arrayVentas[finArray] == 0 ) {										//comprobacion si aun no se han realizado ventas
			
			ranking = "Aun no se han realizado ventas.";
			
		} else {
			
			for ( int fila = 0; fila < 4 && contadorProductos <= 3; fila++ ) {									//recorre la matriz de ventas
				for ( int col =0; col < 4 && contadorProductos <= 3; col++ ) {
					
					if ( ventas[fila][col] == arrayVentas[finArray] ) {											//si la venta coincide
						
						for ( int contador = 0; contador < productosMostrados.length && !productoRepetido; contador++ ) {	//recorre el array de los productos ya mostrados
							
							if ( productos[fila][col].equals(productosMostrados[contador]) ){					//si ya fue mostrado
								
								productoRepetido = true;														//devuelve true
								
							}
						}
						
						if ( !productoRepetido && arrayVentas[finArray] > 0 && contadorProductos < 3) {			//si el producto no fue mostrado y es mayor que 0
							
							ranking += "Producto " + (contadorProductos + 1) + ": " + productos[fila][col] + ",\tventas: " + ventas[fila][col] + "\n";
							
							productosMostrados[contadorProductosRepetidos] = productos[fila][col];				//guarda el producto en los mostrados
							contadorProductosRepetidos++;
							fila = 0; col = 0;																	//se reinicia la musqueda en la matriz ventas
							
							ventasRepetidas = arrayVentas[finArray];
							finArray--;
							
						}
						
						if ( ventasRepetidas != arrayVentas[finArray] ) {
							
							contadorProductos++;
							
						}
						
						productoRepetido = false;																//el booleano que dice si el producto ya fue mostrado vuelve a false
					}
					
					if ( fila == 3 && col == 3 ) {
						
						finArray--;
						fila = 0; col = 0;																		//se reinicia la busqueda en la matriz ventas
						
						contadorProductos++;
						
					}	
				}
			}
		}
		return ranking;
	}
	
	//FUNCION QUE MUESTRA UNA LISTA CON LOS PRODUCTOS MENOS VENDIDOS
	public static String menosVendidos(int ventas[][], String productos[][]) {
		
		String lista = "";
		
		String productosMostrados[] = new String[16];							//array con los productos ya mostrados
		int arrayVentas[] = añadirVentasArray(ventas);							//array con las ventas de los productos
		
		burbuja(arrayVentas); 													//metodo burbuja para ordenar las ventas en el array
		
		int contadorProductos = 0;
		int ventasRepetidas = arrayVentas[contadorProductos];
		
		boolean productoRepetido = false;										
		
		for ( int fila = 0 ; fila < 4 && ventasRepetidas >= arrayVentas[contadorProductos]; fila++ ) {						//recorre la matriz de ventas
			for ( int col = 0; col < 4 && ventasRepetidas >= arrayVentas[contadorProductos]; col++ ) {
				
				if ( ventas[fila][col] == arrayVentas[contadorProductos] ) {												
					
					for ( int contador = 0; contador < productosMostrados.length && !productoRepetido; contador++) {		//recorre el array de productos mostrados
						
						if ( productos[fila][col].equals(productosMostrados[contador]) ){									//si el producto ya ha sido mostrado
							
							productoRepetido = true;																		//devuelve true
							
						}
					}
					
					if ( !productoRepetido ) {																				//si no ha sido mostrado
						
						lista += "Producto: " + productos[fila][col] + ",\tventas " + ventas[fila][col] + "\n";				
						
						productosMostrados[contadorProductos] = productos[fila][col];										//guarda el producto en el array de los productos mostrados
						ventasRepetidas = arrayVentas[contadorProductos];
						contadorProductos++;
						
					}
					
					productoRepetido = false;									//se vuelve a poner en false
				}
				
			}
		}
		return lista;
	}
	
	//FUNCION QUE AÑADE EL NOMBRE DE LOS PRODUCTOS A UN ARRAY
	public static String[] añadirProductosArray(String[][] productos) {
			
			String arrayProductos[] = new String[16];
			int contador = 0;
			
			for (int fila = 0; fila < 4; fila++) {
				for (int col = 0; col < 4; col++) {
					
					arrayProductos[contador] = productos[fila][col];
					contador++;
					
				}
			}
			return arrayProductos;
		}
	
	//FUNCION QUE MUESTRA LA INFORMACION DE LOS PRODUCTOS DE LA MAQUINA (NOMBRE, PRECIO, U. DISPONIBLES Y VENTAS)
	static String infoProductos(int ventas[][], String productos[][], int cantidades[][], double precios[][]) {
		
		String lista = "";
		String[] arrayProductos = añadirProductosArray(productos);				//array con los nombres de los productos
		
		Arrays.sort(arrayProductos); 											//metodo para ordenar el array alfabéticamente
		
		String productoAnterior = "";
		int sumaCantidades = 0;
		int contador = 0;
		
		String barra = "-", espacio = " ";
		int numBarras = 0;
		
		for ( int fila = 0; fila < 4 && contador <= 15; fila++ ) {				//bucle para recorrer las matrices
			for ( int col = 0; col < 4 && contador <= 15; col++ ) {
				
				sumaCantidades = 0;
				
				if ( arrayProductos[contador].equals(productoAnterior) && contador <= arrayProductos.length - 1 ) {				//si el producto actual es igual al anterior
					
					contador++;													//salta al siguiente producto
					
				}
				
				if ( arrayProductos[contador].equals(productos[fila][col]) && !arrayProductos[contador].equals(productoAnterior) ) {			//si el producto del array y el de la matriz corresponden
					
					if ( contador <= arrayProductos.length - 1 ) {
					
						if ( contador == arrayProductos.length - 1 ) {
							
							sumaCantidades = cantidades[fila][col];
							
						} else if ( productos[fila][col].equals(arrayProductos[contador + 1]) && contador < arrayProductos.length - 1 ){										//si el siguiente producto tiene el mismo nombre
							
							for ( int filas = 0; filas < 4; filas++ ) {															//recorre la matriz en busca del producto
								for ( int columnas = 0; columnas < 4; columnas++ ) {
								
									if (productos[fila][col].equals(productos[filas][columnas])) {								//si lo encuentra
									
										sumaCantidades += cantidades[filas][columnas];											//se suman las cantidades
									
									}
								}
							}
						} else {
							sumaCantidades = cantidades[fila][col];
						}
					}
					
					int numEspacios = calcularPalabraMayorLongitud(productos) - productos[fila][col].length();						//variable que opera para obtener la cantidad de espacios que hay que escribir tras cada nombre
					numBarras = calcularPalabraMayorLongitud(productos) + 47 + calcularPrecioMayorLongitud(precios);				//variable que opera para obtener la cantidad de barras que hay que escribir en cada linea
					
					String digitos = String.valueOf(precios[fila][col]);															//metodo que convierte un numero a string
					int numDecimales = calcularPrecioMayorLongitud(precios) - digitos.length();										//variable que opera para obtener la cantidad de espacios que hay que escribir tras cada precio
					
					productoAnterior = productos[fila][col];
					
					lista += barra.repeat(numBarras) + "\n";
					lista += "| " + productos[fila][col] + espacio.repeat(numEspacios) + " | Precio: " + precios[fila][col] + espacio.repeat(numDecimales) + " | U. Disponibles: " + sumaCantidades + " | Ventas: " + ventas[fila][col] + " |\n";
					
					fila = 0; col = 0;																								//se reinicia la busqueda en la matriz
					
					contador++;
				}
			}
		}
		lista += barra.repeat(numBarras) + "\n";
		
		return lista;
	}
	
	//FUNCION QUE SUMA EN UNA MATRIZ LA RECAUDACION DE CADA PRODUCTO
	public static void sumarRecaudacion(String posicionElegida, double[][] recaudaciones, String[][] posiciones, double[][] precios) {
		
		recaudaciones[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]] += precios[posicionGolosina(posicionElegida, posiciones)[0]][posicionGolosina(posicionElegida, posiciones)[1]];
		
	}
	
	//FUNCION QUE DEVUELVE LA RECAUDACION TOTAL EN EUROS DE LA MAQUINA
	public static double recaudacionTotal(double[][] recaudaciones) {
		
		double recaudacion = 0;
				
		for ( int fila = 0; fila < 4; fila++ ) {								
			for ( int col = 0; col < 4; col++ ) {
				
				recaudacion += recaudaciones[fila][col];
				
			}
		}
		return recaudacion;
	}
	
	//MAIN
	public static void main(String[] args) {

		String[][] productos = {						//matriz con los productos de la máquina
				{"Lacasitos",	"Chicles de fresa",	"KitKat",		"Palotes"},
				{"Oreo",		"Bolsa Haribo",		"Chetoos", 		"Twix"},
				{"M&M'S", 		"Kinder Bueno", 	"Papa Delta", 	"Chicles de menta"},
				{"Lacasitos", 	"Crunch", 			"Milkbar", 		"KitKat"}
		};
		
		String[][] posiciones = {						//matriz con las posiciones de los productos
				{"AA",	"AB",	"AC",	"AD"},
				{"BA",	"BB",	"BC",	"BD"},
				{"CA",	"CB",	"CC",	"CD"},
				{"DA",	"DB",	"DC",	"DD"}
		};
		
		double[][] precios = {							//matriz con los precios de los productos
				{1.5,	0.8,	1.1,	0.9},
				{1.8, 	1, 		1.2, 	1},
				{1.8, 	1.3, 	1.2,	0.856},
				{1.5, 	1.1, 	1.1, 	1.1}
		};
		
		int[][] cantidades = new int[4][4];				//matriz con la cantidad de cada producto
		int cantidadProducto = 3;						//variable con la cantidad
		
		rellenarTodosProductosA3(cantidades, cantidadProducto);			//rellena la cantidad de todos los productos a 3
		
		int[][] ventas = new int[4][4];					//matriz con las ventas de cada producto
		
		double[][] recaudaciones = new double[4][4];
		
		Scanner entrada = new Scanner(System.in);
		
		boolean apagar = false;							//boleano que mientras sea falso la maquina permanecerá encendida
		String contraseñaCorrecta = "DAM";
		
		System.out.println(ANSI_PURPLE + "\n------------------");
		System.out.println("| CANDY SHOP 24H |");						//letrero de la maquina
		System.out.println("------------------\n" + ANSI_RESET);
		
		while ( !apagar ) {								//bucle para que la maquina permanezca encendida
			
			System.out.println(ANSI_YELLOW + "*** MENÚ ***");			//menú de usuario
			System.out.println("---------------------------");
			System.out.println("1. Pedir golosina");
			System.out.println("2. Mostrar golosinas");
			System.out.println("3. Submenú de administrador");
			System.out.println("---------------------------" + ANSI_RESET);
			
			try {										//control de exepciones
			
			int opcion = entrada.nextInt();				//int que almacena la opcion de usuario en el menú
			boolean volverMenu = false;					//boleano de vuelta al menu
			
			while ( !volverMenu ) {						//bucle para volver al menu
			
				if ( opcion == 1 ) {					//opcion 1 del menu: pedir golosina
					
					System.out.println("Introduce la posición de la golosina: ");
					String elegirProducto = entrada.next();
					
					if ( posicionEncontrada(elegirProducto, posiciones)) {									//mira si la posicion se encuentra en la maquina
						
						if ( hayStock(elegirProducto, cantidades, posiciones)) {							//mira si existen unidades en la posicion indicada
							
							reducirCantidad(elegirProducto, cantidades, posiciones);						//reduce la cantidad en la posicion indicada
							sumarVentas(elegirProducto, posiciones, ventas, productos);						//añade las ventas a una matriz cuando se compra el producto
							sumarRecaudacion(elegirProducto, recaudaciones, posiciones, precios);
							System.out.println(ANSI_BLUE + "Puede retirar su producto. ¡Gracias!\n" + ANSI_RESET);
							
						} else {
							System.out.println(ANSI_RED + "No quedan unidades del producto. Lo siento.\n" + ANSI_RESET);
						}
						
					} else {
						System.out.println(ANSI_RED + "¡Posición no válida!\n" + ANSI_RESET);
					}
					
					volverMenu = true;
					
				} else if ( opcion == 2 ) {				//opcion 2 del menu: mostrar golosinas
					
					System.out.println(ANSI_PURPLE + "Listado de los productos: " + ANSI_RESET);
					System.out.println(mostrarGolosinas(productos, precios, posiciones));					//muestra un listado con todos los productos de la maquina
					volverMenu = true;
					
				} else if ( opcion == 3 ) {				//opcion 3 del menu: submenú del administrador
					
					System.out.println("Introduce la contraseña: ");
					String contraseña = entrada.next();
					
					if ( contraseña.equals(contraseñaCorrecta) ) {											//compara la contraseña para dar acceso al menu de administrador
						
						boolean volverAdmin = true;
						
						while ( volverAdmin ) {
							
							System.out.println(ANSI_YELLOW + "\n*** MENÚ DE ADMINISTRADOR ***");							//menu de administrador
							System.out.println("---------------------------------");
							System.out.println("1. Cambiar contraseña");
							System.out.println("2. Rellenar producto");
							System.out.println("3. Cambiar precio");
							System.out.println("4. Cambiar producto");
							System.out.println("5. Ranking de los más vendidos");
							System.out.println("6. Productos menos vendidos");
							System.out.println("7. Información de los productos");
							System.out.println("8. Ventas totales");
							System.out.println("9. Cerrar sesión de administrador");
							System.out.println("10. Apagar la máquina");
							System.out.println("---------------------------------" + ANSI_RESET);
						
							try {												//control de excepciones
							
							int opcionAdmin = entrada.nextInt();
							volverAdmin = false;
						
							if ( opcionAdmin == 1 ) {							//opcion 1 del admin: cambiar contraseña
								
								System.out.println("Introduce la nueva contraseña: ");
								String nuevaContraseña = entrada.next();
								System.out.println("Confirma la nueva contraseña: ");
								String confirmacion = entrada.next();
								
								if ( cambiarContraseña(nuevaContraseña, confirmacion) ) {								//mira si la contraseña y su confirmacion coinciden
									
									contraseñaCorrecta = nuevaContraseña;												//cambia la contraseña
									System.out.println(ANSI_BLUE + "Contraseña cambiada con exito." + ANSI_RESET);
									
								} else {
									System.out.println(ANSI_RED + "¡La nueva contraseña y la confirmacion no coinciden!" + ANSI_RESET);
								}
								volverAdmin = true;
								
							} else if ( opcionAdmin == 2 ) {					//opcion 2 del admin: rellenar productos
								
								System.out.println("Posición de la golosina a rellenar: ");
								String posicionRellenar = entrada.next();
								
								if ( posicionEncontrada(posicionRellenar, posiciones) ) {								//mira si la posicion se encuentra en la maquina
									
									System.out.println("Cantidad a rellenar: ");
									int cantidadRellenar = entrada.nextInt();
									
									if ( cabeCantidad(cantidadRellenar, posicionRellenar, posiciones, cantidades)) {	//mira si la cantidad introducida cabe en la posicion indicada
										
										rellenarGolosina(posicionRellenar, cantidadRellenar, posiciones, cantidades);	//rellena la posicion con la cantidad introducida
										System.out.println(ANSI_BLUE + "Producto rellenado con " + cantidadRellenar + " unidades." + ANSI_RESET);
										
									} else {
										System.out.println(ANSI_RED + "¡En el cajetín solo caben 5 unidades!" + ANSI_RESET);
										volverAdmin = true;
									}
									
								} else {
									System.out.println(ANSI_RED + "Esa posición no se encuentra en la máquina." + ANSI_RESET);
								}
								
								volverAdmin = true;
								
							} else if ( opcionAdmin == 3 ) {					//opcion 3 del admin: cambiar precio
								
								System.out.println("Producto a cambiar el precio: ");
								String productoCambiar = entrada.next();
								
								if ( posicionEncontrada(productoCambiar, posiciones) ) {									//mira si la posicion se encuentra en la maquina
									
									System.out.println("Nuevo precio: ");
									double nuevoPrecio = entrada.nextDouble();
									
									if ( nuevoPrecio > 0 ) {
										
										cambiarPrecio(productoCambiar, nuevoPrecio, precios, posiciones, productos);			//cambia el precio de un producto
										System.out.println(ANSI_BLUE + "¡Precio cambiado con exito!" + ANSI_RESET);
										
									} else {
										System.out.println(ANSI_RED + "¿Estás seguro de poner un precio negativo? ¡Me vas a arruinar!" + ANSI_RESET);
									}
								} else {
									System.out.println(ANSI_RED + "Esa posición no se encuentra en la máquina." + ANSI_RESET);
								}
								volverAdmin = true;
								
							} else if ( opcionAdmin == 4 ) {					//opcion 4 del admin: cambiar producto
								
								System.out.println("Posicion de la golosina a cambiar: ");
								String productoCambiar = entrada.next();
								entrada.nextLine();
								
								if ( posicionEncontrada(productoCambiar, posiciones) ) {							//mira si la posicion se encuentra en la maquina
									
									System.out.println("¿Que producto quieres introducir?");
									String nuevoProducto = entrada.nextLine();
									
									cambiarProducto(productoCambiar, nuevoProducto, posiciones, productos);			//cambia el nombre del producto en una posicion deseada
									
									ponerCantidadA0(productoCambiar, posiciones, cantidades);						//pone la cantidad de tal posicion a 0
									
									System.out.println("¿Cuántas unidades del producto quieres añadir al cajetín?");
									int nuevaCantidad = entrada.nextInt();
									
									if ( cabeCantidad(nuevaCantidad, productoCambiar, posiciones, cantidades) ) {	//mira si la cantidad introducida cabe en la posicion
										
										rellenarGolosina(productoCambiar, nuevaCantidad, posiciones, cantidades);	//rellena la posicion con la cantidad introducida
										
									} else {
										System.out.println(ANSI_RED + "¡En el cajetín solo caben 5 unidades!" + ANSI_RESET);
										volverAdmin = true;
									}
									
									System.out.println("¿Qué precio quieres ponerle al producto?");
									double nuevoPrecio = entrada.nextDouble();
									
									cambiarPrecio(productoCambiar, nuevoPrecio, precios, posiciones, productos);	//cambia el precio del producto introducido
									
									System.out.println(ANSI_BLUE + "¡Producto cambiado con exito!" + ANSI_RESET);
									
								} else {
									System.out.println(ANSI_RED + "Esa posición no se encuentra en la máquina." + ANSI_RESET);
								}
								
								volverAdmin = true;
								
							} else if ( opcionAdmin == 5 ) {					//opcion 5 del admin: Ranking mas vendidos
								
								System.out.println(ANSI_PURPLE + "Ranking de los productos más vendidos: " + ANSI_RESET);
								System.out.println(rankingVentas(ventas, productos));								//muestra el ranking de los 3 productos mas vendidos
								volverAdmin = true;
								
							} else if ( opcionAdmin == 6 ) {					//opcion 6 del admin: menos vendidos
								
								System.out.println(ANSI_PURPLE + "Productos menos vendidos: " + ANSI_RESET);		//muestra los productos menos vendidos
								System.out.println(menosVendidos(ventas, productos));
								volverAdmin = true;
								
							} else if ( opcionAdmin == 7 ) {					//opcion 7 del admin: info productos
								
								System.out.println(ANSI_PURPLE + "Informacion de los productos: " + ANSI_RESET);
								System.out.println(infoProductos(ventas, productos, cantidades, precios));			//muestra la info de los productos de la maquina
								volverAdmin = true;
								
							} else if ( opcionAdmin == 8 ) {					//opcion 8 del admin: ventas totales
								
								System.out.println("Se han recaudado un total de " + ANSI_PURPLE + recaudacionTotal(recaudaciones) + " €" + ANSI_RESET);	//muestra la recaudacion total en euros de la maquina
								volverAdmin = true;
								
							} else if ( opcionAdmin == 9 ) {					//opcion 9 del admin: cerrar sesion de admin
								
								volverMenu = true;								//vuelve al menu principal
								
							} else if ( opcionAdmin == 10 ) {					//opcion 10 del admin: apagar maquina
								
								System.out.println(ANSI_PURPLE + "Apagando máquina..." + ANSI_RESET);
								volverMenu = true;								//primero vuelve al menú principal
								apagar = true;									//luego apaga la maquina por completo
								
							} else {
								System.out.println(ANSI_RED + "¡Opcion no válida!" + ANSI_RESET);
								volverAdmin = true;
							}
							} catch ( InputMismatchException ex ) {
								System.out.println(ANSI_RED + "¡Esa opción no es valida!" + ANSI_RESET);
								entrada.next();
								volverAdmin = true;
							}
						}
					} else {
						System.out.println(ANSI_RED + "Contraseña incorrecta." + ANSI_RESET);
						volverMenu = true;
					}
				} else {
					System.out.println(ANSI_RED + "¡Esa opción no es valida!\n" + ANSI_RESET);
					volverMenu = true;
				}
			}
			} catch ( InputMismatchException ex ) {
				System.out.println(ANSI_RED + "¡Esa opción no es valida!\n" + ANSI_RESET);
				entrada.next();
			}
		}
		entrada.close();
	}
}
