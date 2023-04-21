package utilities;

import structures.Lugar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utilities {
    public static final int CANT_LUGARES = 8;//29;
    public static final int ID_LUGAR_MAESTRO = 6;//21;
    public static final int CANT_ADVERSARIOS = 3;//15; // Sin incluir al maestro
    public static final int CANT_POKEBOLAS = 2;//5;
    private static int idLugarInicialAgente = -1;
    private static int energiaInicialAgente = -1;

    public static List<Lugar> crearMapa(){
        List<Lugar> lugares = new ArrayList<>();
        // Crear lugares con ID
        for (int i = 0; i < CANT_LUGARES; i++) {
            lugares.add(new Lugar(i));
        }

        // Establecer adyacencias
        List<List<Lugar>> adyacencias = new ArrayList<>();

        // TODO: hacer matriz de adyacencias mejor?

        /* Mapa completo

        // Lugar 0
        adyacencias.add(Arrays.asList(lugares.get(1)));
        // Lugar 1
        adyacencias.add(Arrays.asList(lugares.get(0), lugares.get(2), lugares.get(9)));
        // Lugar 2
        adyacencias.add(Arrays.asList(lugares.get(1), lugares.get(7), lugares.get(3)));
        // Lugar 3
        adyacencias.add(Arrays.asList(lugares.get(2), lugares.get(6), lugares.get(4), lugares.get(8)));
        // Lugar 4
        adyacencias.add(Arrays.asList(lugares.get(3), lugares.get(5)));
        // Lugar 5
        adyacencias.add(Arrays.asList(lugares.get(4), lugares.get(6)));
        // Lugar 6
        adyacencias.add(Arrays.asList(lugares.get(5), lugares.get(3)));
        // Lugar 7
        adyacencias.add(Arrays.asList(lugares.get(2), lugares.get(8)));
        // Lugar 8
        adyacencias.add(Arrays.asList(lugares.get(3), lugares.get(7), lugares.get(9), lugares.get(12)));
        // Lugar 9
        adyacencias.add(Arrays.asList(lugares.get(1), lugares.get(8), lugares.get(10), lugares.get(11)));
        // Lugar 10
        adyacencias.add(Arrays.asList(lugares.get(9), lugares.get(11), lugares.get(13)));
        // Lugar 11
        adyacencias.add(Arrays.asList(lugares.get(9), lugares.get(10), lugares.get(14)));
        // Lugar 12
        adyacencias.add(Arrays.asList(lugares.get(8), lugares.get(15)));
        // Lugar 13
        adyacencias.add(Arrays.asList(lugares.get(10), lugares.get(17)));
        // Lugar 14
        adyacencias.add(Arrays.asList(lugares.get(11), lugares.get(15), lugares.get(17)));
        // Lugar 15
        adyacencias.add(Arrays.asList(lugares.get(12), lugares.get(14), lugares.get(17), lugares.get(16)));
        // Lugar 16
        adyacencias.add(Arrays.asList(lugares.get(15), lugares.get(21)));
        // Lugar 17
        adyacencias.add(Arrays.asList(lugares.get(13), lugares.get(14), lugares.get(15),  lugares.get(19), lugares.get(20)));
        // Lugar 18
        adyacencias.add(Arrays.asList(lugares.get(20), lugares.get(21)));
        // Lugar 19
        adyacencias.add(Arrays.asList(lugares.get(17), lugares.get(22),lugares.get(24)));
        // Lugar 20
        adyacencias.add(Arrays.asList(lugares.get(17), lugares.get(18),lugares.get(23),lugares.get(25)));
        // Lugar 21
        adyacencias.add(Arrays.asList(lugares.get(16), lugares.get(18),lugares.get(27)));
        // Lugar 22
        adyacencias.add(Arrays.asList(lugares.get(19), lugares.get(25)));
        // Lugar 23
        adyacencias.add(Arrays.asList(lugares.get(20), lugares.get(27)));
        // Lugar 24
        adyacencias.add(Arrays.asList(lugares.get(19)));
        // Lugar 25
        adyacencias.add(Arrays.asList(lugares.get(22), lugares.get(20),lugares.get(26)));
        // Lugar 26
        adyacencias.add(Arrays.asList(lugares.get(25), lugares.get(28)));
        // Lugar 27
        adyacencias.add(Arrays.asList(lugares.get(21), lugares.get(28),lugares.get(23)));
        // Lugar 28
        adyacencias.add(Arrays.asList(lugares.get(26), lugares.get(27)));

  */

/*
        Mapa auxiliar
*/
        // Lugar 0
        adyacencias.add(Arrays.asList(lugares.get(1)));
        // Lugar 1
        adyacencias.add(Arrays.asList(lugares.get(0), lugares.get(2)));
        // Lugar 2
        adyacencias.add(Arrays.asList(lugares.get(1), lugares.get(7), lugares.get(3)));
        // Lugar 3
        adyacencias.add(Arrays.asList(lugares.get(2), lugares.get(6), lugares.get(4)));
        // Lugar 4
        adyacencias.add(Arrays.asList(lugares.get(3), lugares.get(5)));
        // Lugar 5
        adyacencias.add(Arrays.asList(lugares.get(4), lugares.get(6)));
        // Lugar 6
        adyacencias.add(Arrays.asList(lugares.get(5), lugares.get(3)));
        // Lugar 7
        adyacencias.add(Arrays.asList(lugares.get(2)));


        // Seteo de adyacencias
        for (int i = 0; i < CANT_LUGARES; i++) {
            lugares.get(i).setLugaresAdyacentes(adyacencias.get(i));
        }

        return lugares;
    }
    public static int getPosInicialAgente(){
        Random random = new Random();
        int lugar = idLugarInicialAgente;
        if(lugar == -1){
            do{
                lugar = random.nextInt(Utilities.CANT_LUGARES);
            }while (lugar == Utilities.ID_LUGAR_MAESTRO);
        }
        return 5;
    }
    public static int getEnergiaInicialAgente(){
        Random random = new Random();
        int energia = energiaInicialAgente;
        if(energia == -1){
            do{
                energia = random.nextInt(Utilities.CANT_LUGARES);
            }while (energia == Utilities.ID_LUGAR_MAESTRO);
        }
        return 1000;
    }

}
