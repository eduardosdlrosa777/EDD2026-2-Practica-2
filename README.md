Eduardo Sanchez de la Rosa
426008938
eduardosdlrosa@ciencias.unam.mx

NOTA: El main esta en Playlist.
NOTA2: Use la lista doblemente ligada como estructura de datos, no incluyo la lista ligada porque no se uso en mi proyecto.
NOTA3: Que tenga un buen dia maestra!!!

Este proyecto es un simulador de reproductor de música que utiliza una Lista Doblemente Ligada personalizada para gestionar canciones de manera eficiente. La aplicación permite realizar operaciones esenciales como agregar temas al inicio o final, buscar y eliminar canciones, y calcular la duración total de la playlist.

Gracias a la estructura de nodos doblemente ligados, el sistema facilita la navegación fluida entre pistas (avanzar y retroceder) y mantiene un control preciso sobre la canción actual en reproducción. Además, incluye un sistema de validación robusto para prevenir errores de entrada y permite marcar pistas como favoritas, destacándolas visualmente en la lista.

Clase Cancion

Es la unidad básica de información (el modelo de datos). Se encarga de representar una pista musical almacenando sus atributos esenciales: nombre, artista, duración y si ha sido marcada como favorita. También incluye la lógica para compararse con otras canciones y mostrar su información en formato de texto.

Clase Validador

Actúa como un filtro de seguridad para la entrada de datos. Su función es asegurar que el programa no "truene" (se cierre por error) si el usuario ingresa texto cuando se espera un número o si elige opciones fuera de rango. Gestiona las excepciones y repite las preguntas hasta obtener una respuesta válida.

Clase Playlist

Es el cerebro o controlador del programa. Contiene el método main y se encarga de conectar la interfaz de usuario (el menú) con la estructura de datos (ListaDoblementeLigada). Gestiona la lógica de reproducción, como mover el "puntero" de la canción actual hacia adelante o hacia atrás, y coordina todas las acciones que el usuario solicita.

