package utilities;

import agent.PokemonAgentState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utilities {
    public static final int CANT_LUGARES = 29;
    public static final int ID_LUGAR_MAESTRO = 21;
    public static final int CANT_ADVERSARIOS = 14; // Sin incluir al maestro
    public static final int CANT_POKEBOLAS = 5;
    private static int idLugarInicialAgente = -1;
    private static int energiaInicialAgente = 100;//250;//1000;
    private static List<List<Integer>> lugares = null;

    public static List<List<Integer>> crearMapa() {

        // Establecer lugares
        if (lugares == null) {
            lugares = new ArrayList<>();

            // Mapa completo
            ///*
            // Lugar 0
            lugares.add(Arrays.asList(1));
            // Lugar 1
            lugares.add(Arrays.asList(0, 2, 9));
            // Lugar 2
            lugares.add(Arrays.asList(1, 7, 3));
            // Lugar 3
            lugares.add(Arrays.asList(2, 6, 4, 8));
            // Lugar 4
            lugares.add(Arrays.asList(3, 5));
            // Lugar 5
            lugares.add(Arrays.asList(4, 6));
            // Lugar 6
            lugares.add(Arrays.asList(5, 3));
            // Lugar 7
            lugares.add(Arrays.asList(2, 8));
            // Lugar 8
            lugares.add(Arrays.asList(3, 7, 9, 12));
            // Lugar 9
            lugares.add(Arrays.asList(1, 8, 10, 11));
            // Lugar 10
            lugares.add(Arrays.asList(9, 11, 13));
            // Lugar 11
            lugares.add(Arrays.asList(9, 10, 14));
            // Lugar 12
            lugares.add(Arrays.asList(8, 15));
            // Lugar 13
            lugares.add(Arrays.asList(10, 17));
            // Lugar 14
            lugares.add(Arrays.asList(11, 15, 17));
            // Lugar 15
            lugares.add(Arrays.asList(12, 14, 16, 17));
            // Lugar 16
            lugares.add(Arrays.asList(15, 21));
            // Lugar 17
            lugares.add(Arrays.asList(13, 14, 15, 19, 20));
            // Lugar 18
            lugares.add(Arrays.asList(20, 21));
            // Lugar 19
            lugares.add(Arrays.asList(17, 22, 24));
            // Lugar 20
            lugares.add(Arrays.asList(17, 18, 23, 25));
            // Lugar 21
            lugares.add(Arrays.asList(16, 18, 27));
            // Lugar 22
            lugares.add(Arrays.asList(19, 25));
            // Lugar 23
            lugares.add(Arrays.asList(20, 27));
            // Lugar 24
            lugares.add(Arrays.asList(19));
            // Lugar 25
            lugares.add(Arrays.asList(20, 22, 26));
            // Lugar 26
            lugares.add(Arrays.asList(25, 28));
            // Lugar 27
            lugares.add(Arrays.asList(21, 23, 28));
            // Lugar 28
            lugares.add(Arrays.asList(26, 27));
            //*/


            //America:
            /*
            // Lugar 0
            lugares.add(Arrays.asList(1));
            // Lugar 1
            lugares.add(Arrays.asList(0, 2, 9));
            // Lugar 2
            lugares.add(Arrays.asList(1, 7, 3));
            // Lugar 3
            lugares.add(Arrays.asList(2, 6, 4, 8));
            // Lugar 4
            lugares.add(Arrays.asList(3, 5));
            // Lugar 5
            lugares.add(Arrays.asList(4, 6));
            // Lugar 6
            lugares.add(Arrays.asList(5, 3));
            // Lugar 7
            lugares.add(Arrays.asList(2, 8));
            // Lugar 8
            lugares.add(Arrays.asList(3, 7, 9));
            // Lugar 9
            lugares.add(Arrays.asList(1, 8));

             */

        }
        return lugares;
    }

    public static int getPosInicialAgente() {

        if (idLugarInicialAgente == -1) {
            Random random = new Random();
            int lugar;
            do {
                lugar = random.nextInt(Utilities.CANT_LUGARES);
            } while (lugar == Utilities.ID_LUGAR_MAESTRO);

            idLugarInicialAgente = lugar;
        }
        return idLugarInicialAgente;
    }

    public static int getEnergiaInicialAgente() {

        if (energiaInicialAgente == -1) {
            Random random = new Random();
            int cota = 500; // Ver cota inferior y superior de energia
            energiaInicialAgente = cota + random.nextInt(cota);
        }
        return energiaInicialAgente;
    }

    public static void decrementarEnfriamientoAtaquesEspeciales(PokemonAgentState pas) {
        for (int i = 0; i < 3; i++) {
            // Enfriamiento ataque especial i+1
            if(pas.getAtaqueEspecialFueHabiltado()[i]){
                if(pas.getEnfriamientoAtaqueEspecial()[i] > 0)
                    pas.getEnfriamientoAtaqueEspecial()[i] -= 1;
            }
        }
    }
}
