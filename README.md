# UDPMusic

## Objetivo

Construir un sistema que simule algunas de las funcionalidades básicas de un reproductor de música como Spotify, utilizando estructuras de datos fundamentales.

## Requisitos:

### Lista de canciones
Cada -nodo de la lista enlazada- debe contener información sobre una canción: título, artista, duración, etc.

*Funcionalidades requeridas*:
- Agregar canciones a la lista.
- Eliminar canciones de la lista.
- Buscar canciones en la lista.
- Mostrar todas las canciones en la lista.

### Reproductor

Implementar una -cola- para simular la lista de reproducción.

*Funcionalidades requeridas*:
- Añadir canciones al reproductor.
- Pausar y reanudar la reproducción.
- Saltar canciones.
- Cuando una canción termina, se desencola y se reproduce la siguiente.

### Historial de reproducción

Implementar una pila para almacenar el historia del canciones reproducidas.

*Funcionalidades requeridas*:
- Mostrar el historial de reproducción
- "Deshacer" la reproducción (sacar la última canción del historial y volver a encolarla en el reproductor).
