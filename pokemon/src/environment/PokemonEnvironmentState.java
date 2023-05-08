package environment;

import frsf.cidisi.faia.state.EnvironmentState;
import structures.Adversario;
import utilities.Utilities;

import java.util.*;

public class PokemonEnvironmentState extends EnvironmentState {

    // Atributos del mundo real
    private Integer energiaAgente;
    private Integer lugarActualAgente;
    private List<List<Integer>> lugares;
    private List<Adversario> adversarios;
    private  List<Boolean> lugarPokebolas;

    private final int CANT_LUGARES = Utilities.CANT_LUGARES;
    private final int CANT_ADVERSARIOS = Utilities.CANT_ADVERSARIOS;
    private final int MEDIA_ENERGIA_ADVERSARIOS = 15;
    private final int VARIANZA_ENERGIA_ADVERSARIOS = 5;
    private final int CANT_POKEBOLAS = Utilities.CANT_POKEBOLAS;
    private final int ID_LUGAR_MAESTRO = Utilities.ID_LUGAR_MAESTRO;


    /**
     * Metodo usado para inicializar el mundo real inicial
     */
    @Override
    public void initState() {
        // Setea todos los lugares y el lugar actual del agente
        lugares = Utilities.crearMapa();
        lugarActualAgente = Utilities.getPosInicialAgente();
        // Setea cada lugar con sus pokebolas
        crearPokebolas();
        /*
        lugarPokebolas = new ArrayList<>();
        // Pokebolas en 0, 3, 9
        lugarPokebolas.add(true);
        lugarPokebolas.add(false);
        lugarPokebolas.add(false);
        lugarPokebolas.add(true);
        lugarPokebolas.add(false);
        lugarPokebolas.add(false);
        lugarPokebolas.add(false);
        lugarPokebolas.add(false);
        lugarPokebolas.add(false);
        lugarPokebolas.add(true);

         */

        // Setea cada lugar con su adversario
        crearAdversarios();
        /*
        adversarios = new ArrayList<>();
        // Adversarios en 1, 4, 6, 7, 8
        adversarios.add(null);
        adversarios.add(new Adversario(0, 15, false));
        adversarios.add(null);
        adversarios.add(null);
        adversarios.add(new Adversario(1, 15, false));
        adversarios.add(null);
        adversarios.add(new Adversario(2, 15, false));
        adversarios.add(new Adversario(3, 15, false));
        adversarios.add(new Adversario(4, 100, true));
        adversarios.add(null);

         */

        energiaAgente = Utilities.getEnergiaInicialAgente();
    }

    private void crearPokebolas() {
        lugarPokebolas = new ArrayList<>();
        for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
            lugarPokebolas.add(false);
        }
        Random lugarRandom = new Random();
        int valorRandom;
        List<Integer> lugaresVistos = new ArrayList<>();
        lugaresVistos.add(ID_LUGAR_MAESTRO);

        int i = CANT_POKEBOLAS;
        while(i > 0) {
            valorRandom = lugarRandom.nextInt(CANT_LUGARES);
            if(!lugaresVistos.contains(valorRandom)){
                lugarPokebolas.set(valorRandom, true);
                lugaresVistos.add(valorRandom);
                i--;
            }
        }
    }

    private void crearAdversarios() {

        adversarios = new ArrayList<>();

        List<Integer> idLugaresAdvComunes = distribuirAdversarios();

        Random random = new Random();
        int varianza;

        int idAdv = 0;
        Adversario advComun;
        for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
            if (idLugaresAdvComunes.contains(i)) {
                // La energia del adversario es 15 +- 5
                varianza = (int) Math.pow(-1,random.nextInt(2)) * random.nextInt(VARIANZA_ENERGIA_ADVERSARIOS+1);
                advComun = new Adversario(idAdv, MEDIA_ENERGIA_ADVERSARIOS+varianza, false,3);
                adversarios.add(advComun);
                idAdv++;
            } else
                adversarios.add(null);
        }
        // Agregar al maestro
        Adversario maestro = new Adversario(idAdv, 100, true,3);
        adversarios.set(ID_LUGAR_MAESTRO, maestro);
    }

    private List<Integer> distribuirAdversarios() {
        List<Integer> lugaresAdversarios = new ArrayList<>();

        Random lugarRandom = new Random();
        int valorRandom;
        List<Integer> lugaresOcupados = new ArrayList<>();
        for (int i = 0; i < lugarPokebolas.size(); i++) {
            if(lugarPokebolas.get(i) == true) lugaresOcupados.add(i);
        }
        lugaresOcupados.add(Utilities.ID_LUGAR_MAESTRO);

        int i = CANT_ADVERSARIOS;
        while(i > 0) {
            valorRandom = lugarRandom.nextInt(CANT_LUGARES);
            if(!lugaresOcupados.contains(valorRandom)){
                lugaresAdversarios.add(valorRandom);
                lugaresOcupados.add(valorRandom);
                i--;
            }
        }
        return lugaresAdversarios;
    }
    

    /**
     * Representacion en string del mundo real
     */
    @Override
    public String toString() {
        return "PokemonEnvironmentState{" +
                "energiaAgente=" + energiaAgente +
                ", lugarActualAgente=" + lugarActualAgente +
                ", lugares=" + lugares +
                ", adversarios=" + adversarios +
                ", lugarPokebolas=" + lugarPokebolas +
                '}';
    }

    /**
     * Getters y setters
     */
    public int getEnergiaAgente() {
        return energiaAgente;
    }

    public List<Adversario> getAdversarios() {
        return adversarios;
    }



    public void setEnergiaAgente(int energiaAgente) {
        this.energiaAgente = energiaAgente;
    }

    public void setEnergiaAgente(Integer energiaAgente) {
        this.energiaAgente = energiaAgente;
    }

    public Integer getLugarActualAgente() {
        return lugarActualAgente;
    }

    public void setLugarActualAgente(Integer lugarActualAgente) {
        this.lugarActualAgente = lugarActualAgente;
    }

    public List<List<Integer>> getLugares() {
        return lugares;
    }

    public void setLugares(List<List<Integer>> lugares) {
        this.lugares = lugares;
    }

    public List<Boolean> getLugarPokebolas() {
        return lugarPokebolas;
    }

    public void setLugarPokebolas(List<Boolean> lugarPokebolas) {
        this.lugarPokebolas = lugarPokebolas;
    }

    public void setAdversarios(List<Adversario> adversarios) {
        this.adversarios = adversarios;
    }
}
