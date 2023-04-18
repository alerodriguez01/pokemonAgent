package environment;

import frsf.cidisi.faia.state.EnvironmentState;
import structures.Adversario;
import structures.Lugar;

import java.lang.reflect.Array;
import java.util.*;

public class PokemonEnvironmentState extends EnvironmentState {

    /**
     * Atributos del mundo real
     */
    private int agentEnergy;
    private Lugar lugarActualAgente;
    private List<Lugar> lugares;
    private Map<Lugar, Adversario> lugarPokemonesAdversarios;
    private Map<Lugar, Boolean> lugarPokebolas;

    private final int cantidadLugares = 29;

    /**
     * Metodo usado para inicializar el mundo real inicial
     */
    @Override
    public void initState() {

        // Setea el lugar actual del agente
        lugares = crearMapa();
        lugarActualAgente = lugares.get(0);

        // Setea cada lugar con su adversario
        crearAdversarios();
        // Setea cada lugar con sus pokebolas
        crearPokebolas();

    }

    private void crearPokebolas() {
        lugarPokebolas = new HashMap<>();
        List<Integer> pokebolas = new ArrayList<>(Arrays.asList(7,10,18,19,28));
        for (Lugar lugar:lugares) {
            if (pokebolas.contains(lugar.getId()))
                lugarPokebolas.put(lugar, true);
            else lugarPokebolas.put(lugar, false);
        }
    }

    private void crearAdversarios() {
        lugarPokemonesAdversarios = new HashMap<>();

        List<Integer> adversarios = new ArrayList<>(Arrays.asList()); // no ponemos el maestro

        int idAdv = 0;
        Adversario maestro = new Adversario(idAdv, 100, true);
        lugarPokemonesAdversarios.put(lugares.get(21), maestro);

        for (Lugar lugar:lugares) {
            idAdv++;
            if (adversarios.contains(lugar.getId()))
                lugarPokemonesAdversarios.put(lugar, new Adversario(idAdv, 15, false));
            else lugarPokemonesAdversarios.put(lugar, null);
        }

    }

    // Publico para que el ambiente y el agente construyan el mismo mapa
    public List<Lugar> crearMapa() {

        List<Lugar> lugares = new ArrayList<>();

        // Crear lugares con ID
        for (int i = 0; i < cantidadLugares; i++) {
            lugares.add(new Lugar(i));
        }

        // Establecer adyacencias
        List<List<Lugar>> adyacencias = new ArrayList<>();

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

        // Seteo de adyacencias
        for (int i = 0; i < cantidadLugares; i++) {
            lugares.get(i).setLugaresAdyacentes(adyacencias.get(i));
        }

        return lugares;
    }

    /**
     * Representacion en string del mundo real
     */
    @Override
    public String toString() {
        String lugarAgente = "Lugar del agente: " + lugarActualAgente.getId() + "/n";
        String lugarEnemigos = "";
        String pokebolas = "";
        for (Lugar lugar: lugares) {

            Adversario adv = lugarPokemonesAdversarios.get(lugar);
            if(adv != null)
                lugarEnemigos += "/n" + "Lugar " + lugar.toString() + ": Adversario " + adv.toString();
            else lugarEnemigos += "/n" + "Lugar " + lugar.getId() + ": Adversario no hay";

            pokebolas += "/n" + "Lugar"  + lugar.getId() + ", pokebola: " + lugarPokebolas.get(lugar);
        }

        return lugarAgente + lugarEnemigos + pokebolas;
    }

    /**
     * Getters y setters
     */
    public int getAgentEnergy() {
        return agentEnergy;
    }

    public void setAgentEnergy(int agentEnergy) {
        this.agentEnergy = agentEnergy;
    }

    public Lugar getlugarActualAgente() {
        return lugarActualAgente;
    }

    public void setlugarActualAgente(Lugar lugarActualAgente) {
        this.lugarActualAgente = lugarActualAgente;
    }

    public Map<Lugar, Adversario> getLugarPokemonesAdversarios() {
        return lugarPokemonesAdversarios;
    }

    public void setLugarPokemonesAdversarios(Map<Lugar, Adversario> lugarPokemonesAdversarios) {
        this.lugarPokemonesAdversarios = lugarPokemonesAdversarios;
    }

    public Map<Lugar, Boolean> getLugarPokebolas() {
        return lugarPokebolas;
    }

    public void setLugarPokebolas(Map<Lugar, Boolean> lugarPokebolas) {
        this.lugarPokebolas = lugarPokebolas;
    }
}
