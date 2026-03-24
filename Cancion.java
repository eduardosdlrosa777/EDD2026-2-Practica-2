public class Cancion {

    String nombre;
    String artista;
    int duracion;
    boolean status;

    /** Constructor: Inicializa la canción con nombre y artista. */
    public Cancion(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = 0;
        this.status = false;
    }

    /** Asigna la duración en segundos a la canción. */
    public void agregarDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    /** Devuelve el nombre de la canción. */
    public String obtenerNombre() {
        return nombre;
    }

    /** Devuelve el artista de la canción. */
    public String obtenerArtista(){
        return artista;
    }
    
    /** Devuelve la duración en segundos. */
    public int obtenerDuracion() {
        return duracion;
    }

    /** Devuelve si la canción es favorita o no. */
    public boolean obtenerStatus() {
        return status;
    }

    /** Cambia el estado de favorita de la canción. */
    public void marcarStatus(boolean status) {
        this.status = status;
    }

    /** Compara canciones por nombre y artista ignorando mayúsculas. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return nombre.equalsIgnoreCase(cancion.obtenerNombre()) && 
               artista.equalsIgnoreCase(cancion.obtenerArtista());
    }
    
    /** Representación textual de la canción. */
    @Override
    public String toString() {
        return this.nombre + " - " + this.artista + "\nDuracion = " + this.duracion + " s";
    }
}
