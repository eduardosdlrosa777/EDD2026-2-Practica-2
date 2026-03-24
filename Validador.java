import java.util.Scanner;
import java.util.InputMismatchException;
public class Validador {

    Scanner input = new Scanner(System.in);
    int respuesta;

    public Validador(){
	this.respuesta = 0;
    }

    /** Valida la selección del menú principal (1-10). */
    public int validadorMenu(){
	boolean flag = true;
	while(flag) {
	    try {
		System.out.println("1) Agregar una cancion al inicio de la playlist.\n2) Agregar una cancion al final de la playlist.\n3) Eliminar una cancion por titulo.\n4) Buscar una cancion\n5) Mostrar todas las canciones de la playlist\n6) Mostrar la duracion total de la playlist.\n7) Reproducir la cancion actual.\n8) Regresar a la cancion anterior.\n9) Avanzar a la siguiente cancion.\n10) Marcar cancion como ~Favorita~.");
		respuesta = input.nextInt();
		System.out.print("\033[H\033[2J");
		if(respuesta > 10 || respuesta < 1) {
		    System.out.println("Ingresa una respuesta del 1 al 10");
		}else {
		    flag = false;
		}
	    }catch(InputMismatchException e) {
		System.out.print("\033[H\033[2J");
		System.out.println("Ingresa una opcion valida");
		input.next();
	    }
	}
	return respuesta;
    }

    /** Valida la decisión de continuar o salir. */
    public int validadorSalida(){
	boolean flag = true;
	while(flag) {
	    try {
		System.out.println("Te gustaria realizar alguna otra actividad?\n1) Si\n2) No");
		respuesta = input.nextInt();
		if(respuesta > 2 || respuesta < 1) {
		    System.out.print("\033[H\033[2J");
		    System.out.println("Ingresa una respuesta del 1 al 2");
		}else {
		    flag = false;
		}
	    }catch(InputMismatchException e) {
		System.out.print("\033[H\033[2J");
		System.out.println("Ingresa una opcion valida");
		input.next();
	    }
	}
	return respuesta;
    }

    /** Valida que la duración sea un entero positivo. */
    public int validadorCancion() {
	boolean flag = true;
	while(flag) {
	    try {
		System.out.println("Introduce la duracion de la cancion: ");
		respuesta = input.nextInt();
		flag = false;
	    }catch(InputMismatchException e) {
		System.out.print("\033[H\033[2J");
		System.out.println("Ingresa una opcion valida");
		input.next();
	    }
	}
	return respuesta;
    }

    /** Valida la confirmación de favorito. */
    public int validadorFavorita(){
	boolean flag = true;
	while(flag) {
	    try {
		System.out.println("1) Si\n2) No");
		respuesta = input.nextInt();
		if(respuesta > 2 || respuesta < 1) {
		    System.out.print("\033[H\033[2J");
		    System.out.println("Ingresa una respuesta del 1 al 2");
		}else {
		    flag = false;
		}
	    }catch(InputMismatchException e) {
		System.out.print("\033[H\033[2J");
		System.out.println("Ingresa una opcion valida");
		input.next();
	    }
	}
	return respuesta;
    }
}
