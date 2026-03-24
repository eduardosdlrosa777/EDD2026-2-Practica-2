import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Playlist {

    /** Crea las canciones */
    public static Cancion crearCancion(Scanner input, int flag, Validador validador) {
	System.out.println("Introduce el nombre de la cancion: ");
	String nombre = input.nextLine();
	System.out.println("Introduce el nombre del artista: ");
	String artista = input.nextLine();
	Cancion cancion = new Cancion(nombre, artista);
	if(flag == 0) {
	    int duracion = validador.validadorCancion();
	    cancion.agregarDuracion(duracion);
	}
	return cancion;	
    }

    /** Punto de entrada: Controla el flujo del reproductor y la lista. */
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	ListaDoblementeLigada playlist = new ListaDoblementeLigada();
	Validador validador = new Validador();
	int respuesta= 1;
	int indice = -1;
	
	System.out.println("Bienvenido al reproductor de Audio!\nPodrias indicarme que te gustaria hacer?");
	while(respuesta == 1) {
	    respuesta = validador.validadorMenu();
	    switch(respuesta) {
	    case 1: /** Agrega una cancion al inicio */
		playlist.agregar(0, crearCancion(input,0,validador));
		if(indice != -1){
		    indice = indice + 1;
		}
		break;
	    case 2: /** Agrega una cancion al final */
		playlist.agregar(playlist.longitudLista(), crearCancion(input,0,validador));
		break;
	    case 3: /** Elimina una cancion buscada, si no hay mas que una cancion elimina la cancion */
		if(playlist.longitudLista() > 1) {
		    playlist.eliminar(crearCancion(input,1,validador));
		    indice = -1;
		}else{
		    System.out.println("Eliminando la unica cancion de tu playlist!!!");
		    playlist.vacia();
		    indice = -1;
		}
		break;
	    case 4: /** Busca una cancion por nombre */
		if(playlist.contiene(crearCancion(input,1,validador))){
		    System.out.println("La cancion se encuentra en tu lista actualmente.");
		}else{
		    System.out.println("No se encontraron coincidencias en tu lista actual.");
		}
		break;
		case 5: /** Imprime la playlist */
		    System.out.println("Playlist Actual: ");
		    int i = 1;
    
		    Iterator<Cancion> it5 = playlist.iterador(); 
		    
		    while(it5.hasNext()) {
			Cancion actual = it5.next();
			String prefijo = "";
			String tagFav = actual.obtenerStatus() ? "<FAV> " : ""; 
			if (indice != -1 && (indice + 1 == i)) {
			    prefijo = " >> ";
			}
			
			System.out.println(prefijo + i + ". " + tagFav + actual.obtenerNombre() +
					   " - " + actual.obtenerArtista() + " (" + actual.obtenerDuracion() + "s)");
        
			i++;
		    }
		    break;
		    
	    case 6: /** Calcula el tiempo de la playlist */
		int suma  = 0;
		Iterator<Cancion> it6 = playlist.iterador();
		
		while(it6.hasNext()) {
		    Cancion actual = it6.next();
		    suma = suma + actual.obtenerDuracion();
		}
		System.out.println("La duracion total de tu playlist actual es: " + suma + "s");
		break;
	    case 7: /** Define la cancion que se reproduce en la playlist */
		System.out.println("Introduce la cancion que gustas reproducir: ");
		indice = playlist.regresarIndice(crearCancion(input,1,validador));
		if(indice != -1) {
		    System.out.println("Reproduciendo: " + playlist.obtenerDato(indice));
		}else{
		    System.out.println("Esa cancion no se encuentra en tu playlist, gustarias agregarla?\n1) Si\n2) No");
		    respuesta = input.nextInt();
		    input.nextLine();
		    if(respuesta == 1){
			System.out.println("Introduce la informacion: ");
			playlist.agregar(playlist.longitudLista(), crearCancion(input,0,validador));
		    }
		}
		break;
	    case 8: /** Regresa a la cancion anterior en la playlist*/
		if(indice == -1) {
		    System.out.println("No hay cancion actual seleccionada.");
		}else{
		    indice = indice - 1;
		    if(indice < 0) {
			indice = playlist.longitudLista() - 1;
			System.out.println("Reproduciendo: " + playlist.obtenerDato(indice));
		    }else{
			System.out.println("Reproduciendo: " + playlist.obtenerDato(indice));
		    }
		}
		break;
	    case 9: /** Salta a la cancion siguiente en la playlist*/
		if(indice == -1) {
		    System.out.println("No hay cancion actual seleccionada.");
		}else{
		    indice = indice + 1;
		    if(indice > playlist.longitudLista() - 1) {
			indice = 0;
			System.out.println("Reproduciendo: " + playlist.obtenerDato(indice));
		    }else{
			System.out.println("Reproduciendo: " + playlist.obtenerDato(indice));
		    }
		}
		break;
	    case 10: /** Marca la cancion actual como favorita*/
		if (playlist.estaVacio() || indice == -1) {
		    System.out.println("No hay canción seleccionada para marcar como favorita.");
		} else {
		    Cancion actual = (Cancion) playlist.obtenerDato(indice);
		    
		    System.out.println("¿Seguro que quieres marcar a: " + actual.obtenerNombre() + " como favorita?");
		    int confirmacion = validador.validadorFavorita();
        
		    if (confirmacion == 1) {
			actual.marcarStatus(true);
			System.out.println("¡Marcada como favorita!");
		    } else {
			actual.marcarStatus(false);
            System.out.println("Eliminada de favoritos.");
		    }
		}
		break;
		
	    }
	    respuesta = validador.validadorSalida(); /** Confirmacion de salida*/
	    System.out.print("\033[H\033[2J");
	}
    } 
}
