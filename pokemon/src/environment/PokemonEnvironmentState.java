package environment;

import frsf.cidisi.faia.state.EnvironmentState;
import structures.Adversario;
import structures.Lugar;
import utilities.Utilities;

import java.util.*;

public class PokemonEnvironmentState extends EnvironmentState {

    // Atributos del mundo real
    private int energiaAgente;
    private Lugar lugarActualAgente;
    private List<Lugar> lugares;
    private List<Adversario> adversarios;
    private Map<Lugar, Adversario> lugarPokemonesAdversarios;
    private Map<Lugar, Boolean> lugarPokebolas;

    private final int CANT_LUGARES = Utilities.CANT_LUGARES;
    private final int CANT_ADVERSARIOS = Utilities.CANT_ADVERSARIOS;
    private final int MEDIA_ENERGIA_ADVERSARIOS = 15;
    private final int VARIANZA_ENERGIA_ADVERSARIOS = 5;
    private final int CANT_POKEBOLAS = 5;
    private final int ID_LUGAR_MAESTRO = Utilities.ID_LUGAR_MAESTRO;


    /**
     * Metodo usado para inicializar el mundo real inicial
     */
    @Override
    public void initState() {
        // Setea todos los lugares y el lugar actual del agente
        lugares = Utilities.crearMapa();
        lugarActualAgente = lugares.get(Utilities.getPosInicialAgente());
        // Setea cada lugar con sus pokebolas
        crearPokebolas();
        // Setea cada lugar con su adversario
        crearAdversarios();
        energiaAgente = Utilities.getEnergiaInicialAgente();
    }

    private void crearPokebolas() {
        lugarPokebolas = new HashMap<>();
        for (Lugar lugar: lugares) {
            lugarPokebolas.put(lugar, false);
        }
        Random lugarRandom = new Random();
        int valorRandom;
        List<Integer> lugaresVistos = new ArrayList<>();
        lugaresVistos.add(ID_LUGAR_MAESTRO);

        int i = CANT_POKEBOLAS;
        while(i > 0) {
            valorRandom = lugarRandom.nextInt(CANT_LUGARES);
            if(!lugaresVistos.contains(valorRandom)){
                lugarPokebolas.put(lugares.get(valorRandom), true);
                lugaresVistos.add(valorRandom);
                i--;
            }
        }
    }

    private void crearAdversarios() {
        lugarPokemonesAdversarios = new HashMap<>();
        adversarios = new ArrayList<>();

        List<Integer> idLugaresAdvComunes = distribuirAdversarios();
        //List<Integer> idLugaresAdvComunes = Arrays.asList(3, 4, 5, 6, 10, 15, 25);

        Random random = new Random();
        int varianza;

        int idAdv = 0;
        Adversario advComun;
        for (Lugar lugar: lugares) {
            if (idLugaresAdvComunes.contains(lugar.getId())) {
                // La energia del adversario es 15 +- 5
                varianza = (int) Math.pow(-1,random.nextInt(2)) * random.nextInt(VARIANZA_ENERGIA_ADVERSARIOS+1);
                advComun = new Adversario(idAdv, MEDIA_ENERGIA_ADVERSARIOS+varianza, false);
                lugarPokemonesAdversarios.put(lugar, advComun);
                adversarios.add(advComun);
                idAdv++;
            } else
                lugarPokemonesAdversarios.put(lugar, null);
        }
        // Agregar al maestro
        Adversario maestro = new Adversario(idAdv, 100, true);
        lugarPokemonesAdversarios.put(lugares.get(ID_LUGAR_MAESTRO), maestro);
        adversarios.add(maestro);
    }

    private List<Integer> distribuirAdversarios() {
        List<Integer> lugaresAdversarios = new ArrayList<>();

        Random lugarRandom = new Random();
        int valorRandom;
        List<Integer> lugaresOcupados = new ArrayList<>();
        for (int i = 0; i < lugarPokebolas.size(); i++) {
            if(lugarPokebolas.get(lugares.get(i)) == true) lugaresOcupados.add(i);
        }


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
        String str = "\nAgente: " + lugarActualAgente.toString() + "\n";
        for (Lugar lugar: lugares) {
            Adversario adv = lugarPokemonesAdversarios.get(lugar);
            if(adv != null)
                str += "\n" + lugar.toString() + ": " + adv.toString();
            else
                str += "\n" + lugar.toString() + ": sin adversario";

            str += "; hayPokebola: " + lugarPokebolas.get(lugar);
        }

        return str;
    }

    /**
     * Getters y setters
     */
    public int getEnergiaAgente() {
        return energiaAgente;
    }

    public Lugar getlugarActualAgente() {
        return lugarActualAgente;
    }

    public Map<Lugar, Adversario> getLugarPokemonesAdversarios() {
        return lugarPokemonesAdversarios;
    }

    public Map<Lugar, Boolean> getLugarPokebolas() {
        return lugarPokebolas;
    }

    public List<Adversario> getAdversarios() {
        return adversarios;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setEnergiaAgente(int energiaAgente) {
        this.energiaAgente = energiaAgente;
    }

    public Lugar getLugarActualAgente() {
        return lugarActualAgente;
    }

    public void setLugarActualAgente(Lugar lugarActualAgente) {
        this.lugarActualAgente = lugarActualAgente;
    }

    public void setLugarPokemonesAdversarios(Map<Lugar, Adversario> lugarPokemonesAdversarios) {
        this.lugarPokemonesAdversarios = lugarPokemonesAdversarios;
    }

    public void setLugarPokebolas(Map<Lugar, Boolean> lugarPokebolas) {
        this.lugarPokebolas = lugarPokebolas;
    }

    public void setAdversarios(List<Adversario> adversarios) {
        this.adversarios = adversarios;
    }
}
