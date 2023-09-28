import java.util.Scanner;
import controllers.*;
import models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    private static SongController songController = new SongController();

    /* Esta función sirve para leer información desde un archivo CSV. */
    public static void ReadCSV(SongController songController) {
        /* Array de songs */

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
                if (count == MaxSongs) {
                    break;
                }

                count++;
                String[] values = line.split(cvsSplitBy);
                String year = values[yearIndex];
                String artists = values[artistsIndex];
                String id = values[idIndex];
                String name = values[nameIndex];
                

                /* Así creo una canción! */
                Song song = new Song(name, artists, year, id);
                System.out.printf("Ingresando canción: %s\n", song.toString());
                
                /* Así accedo al controlador de canciones! */
                songController.addSong(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            System.out.print("Elige una opción: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Buscar cancion");
                    Scanner a = new Scanner(System.in);
                    String b = a.nextLine();
                    songController.searchSong(b);

                    break;
                case 2:
                    System.out.print("Introduce el id de la canción para añadir a la lista de reproducción: ");
                    break;
                case 3:
                    System.out.print("Reproduciendo siguiente canción: ");
                    break;
                case 4:
                    System.out.print("Próxima canción: ");
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
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
