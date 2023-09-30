import java.util.Scanner;
import controllers.*;
import models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    private static SongController songController = new SongController();


    public static void ReadCSV(SongController songController) {


        long start = System.nanoTime();


        String csvFile = "data.csv";
        String line = "";
        String cvsSplitBy = ",(?![^\\[]*\\])";
        int yearIndex = 1;
        int artistsIndex = 3;
        int idIndex = 8;
        int nameIndex = 14;
        int MaxSongs = 10;
        int count = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (count == MaxSongs){
                    break;
                }
                count++;
                String[] values = line.split(cvsSplitBy);
                String year = values[yearIndex];
                String artists = values[artistsIndex];
                String id = values[idIndex];
                String name = values[nameIndex];
                

                Song song = new Song(id, name, artists, year);
                
                System.out.printf("Ingresando canción: %s\n", song.toString());


                songController.addSong(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("Agregar todas las canciones se demoró: " + duration + "ms");
    }

    private static PlayerController playerController = new PlayerController();


    public static void ReadCSV(PlayerController playerController) {


        long start = System.nanoTime();


        String csvFile = "data.csv";
        String line = "";
        String cvsSplitBy = ",(?![^\\[]*\\])";
        int yearIndex = 1;
        int artistsIndex = 3;
        int idIndex = 8;
        int nameIndex = 14;


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(cvsSplitBy);
                String year = values[yearIndex];
                String artists = values[artistsIndex];
                String id = values[idIndex];
                String name = values[nameIndex];
                

                Song song = new Song(id, name, artists, year);
                
                System.out.printf("Ingresando canción: %s\n", song.toString());


                playerController.AgregarSong(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("Agregar todas las canciones a la lista de reproduccion se demoró: " + duration + "ms");
    }


    private static HistoryController historyController = new HistoryController();


    public static void ReadCSV(HistoryController historyController) {

 
        long start = System.nanoTime();


        String csvFile = "data.csv";
        String line = "";
        String cvsSplitBy = ",(?![^\\[]*\\])";
        int yearIndex = 1;
        int artistsIndex = 3;
        int idIndex = 8;
        int nameIndex = 14;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(cvsSplitBy);
                String year = values[yearIndex];
                String artists = values[artistsIndex];
                String id = values[idIndex];
                String name = values[nameIndex];
                

                Song song = new Song(id, name, artists, year);
                
                System.out.printf("Ingresando canción: %s\n", song.toString());

             
                historyController.anadirSong(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("Agregar todas las canciones al historial se demoró: " + duration + "ms");
    }







    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menú UDP Music ---");
            System.out.println("1. Buscar canción por título");
            System.out.println("2. Añadir canción a lista de reproducción");
            System.out.println("3. Reproducir siguiente canción");
            System.out.println("4. Ver próxima canción en lista de reproducción");
            System.out.println("5. Ver últimas 5 canciones reproducida");
            System.out.println("6. Salir");
            System.out.println("7. Agregar canciones!");
            System.out.println("8. Agregar canciones a lista de reproduccion!");
            System.out.println("9. Agregar canciones al historial");
            System.out.println("10 Cambiar orden de lista de reproduccion, la primera cancion se vaya al final");
            System.out.println("11 Cambiar orden de lista de reproduccion, la ultima cancion ahora es la primera");
            System.out.println("12 Verificar con ID si es que ya se reprodució la canción por ende se encuentra en el historial");
            System.out.print("Elige una opción: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Introduce el título de la canción a buscar: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String tituloABuscar = scanner2.nextLine();
                    long start = System.nanoTime();
                    Song cancionEncontrada = songController.buscarSong(tituloABuscar);
                        if (cancionEncontrada != null) {
                            System.out.println("Canción encontrada: " + cancionEncontrada.getTitle());
                        } else {
                            System.out.println("La canción no fue encontrada.");
                        }
                    long duration = (System.nanoTime() - start)/1000000;
                    System.out.println("\n Se demoró en encontrar la cancion con titulo: " + duration + "ms");
                    break;
                case 2:
                    System.out.print("Introduce el titulo de la canción para añadir a la lista de reproducción: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String tituloABuscar2 = scanner3.nextLine();
                    Song aux = songController.buscarSong(tituloABuscar2);
                    playerController.AgregarSong(aux);

                    break;
                case 3:
                    System.out.print("Reproduciendo siguiente canción: ");
                    playerController.ReproducirNextSong();
                    break;
                case 4:
                    System.out.print("Próxima canción: ");
                    playerController.VerNextSong();
                    break;
                case 5:
                    System.out.print("Últimas 5 canciones reproducidas: ");

                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                case 7:
                    System.out.println("Agregar canciones a UDPMusic.");
                    ReadCSV(songController);
                    break;
                case 8:
                    System.out.println("Agregar canciones a la lista de reproducción.");
                    ReadCSV(playerController);
                    break;
                case 9:
                    System.out.println("Agregar canciones al historial.");
                    ReadCSV(historyController);
                    break;
                case 10:   
                    System.out.println("Cambiando el orden si es posible...");
                    playerController.cambiarOrdenPrimeraAUltimaSong();
                    break;
                case 11:
                    System.out.println("Cambiando el orden si es posible...");
                    playerController.cambiarOrdenUltimaAPrimeraSong();
                    break;
                case 12:
                    System.out.print("Introduce el id de la canción para buscarla en el historial: ");
                    Scanner scanner4 = new Scanner(System.in);
                    String idABuscar = scanner4.nextLine();
                    long start3 = System.nanoTime();
                    String IdEncontrado = historyController.buscarSongsPorID(idABuscar);
                        if (IdEncontrado != null) {
                            System.out.println("Canción encontrada: " + IdEncontrado);
                        } else {
                            System.out.println("La canción no fue encontrada.");
                        }
                    long duration3 = (System.nanoTime() - start3)/1000000;
                    System.out.println("\n Se demoró en encontrar la cancion con titulo: " + duration3 + "ms");
                    
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (choice != 6);

        scanner.close();
    }
}