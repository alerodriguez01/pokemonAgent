package agent;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import structures.Adversario;
import structures.Lugar;
import utilities.Utilities;

import java.util.*;

public class PokemonAgentState extends SearchBasedAgentState {

    /**
     * Atributos que definen el estado
     */
    private Lugar lugarActual;
    private List<Lugar> lugares;
    private int cantidadPokemonesAdversarios;
    private Map<Lugar, Adversario> lugarPokemonesAdversariosConocidos;
    private Map<Lugar, Boolean> lugarPokebolasConocidos;
    private int energiaInicial;
    private int energiaActual;
    private int[] enfriamientoAtaqueEspecial;
    private boolean[] ataqueEspecialFueHabiltado;
    private boolean maestroFueDerrotado;

    /**
     * Constructor para iniciar el estado
     */
    public PokemonAgentState() {
        this.initState();
    }


    /**
     * Este metodo es usado en el proceso de busqueda para verificar si el nodo
     * ya existe en la busqueda actual.
     */
    @Override
    public boolean equals(Object obj) {
        PokemonAgentState state = (PokemonAgentState) obj;
        return  state.getLugarActual().equals(this.lugarActual) &&
                state.getCantidadPokemonesAdversarios() == this.cantidadPokemonesAdversarios &&
                state.getLugarPokemonesAdversariosConocidos().equals(this.lugarPokemonesAdversariosConocidos) &&
                state.getLugarPokebolasConocidos().equals(this.lugarPokebolasConocidos) &&
                state.getEnergiaInicial() == this.energiaInicial &&
                state.getEnergiaActual() == this.energiaActual &&
                state.getEnfriamientoAtaqueEspecial() == this.enfriamientoAtaqueEspecial &&
                state.getAtaqueEspecialFueHabiltado() == this.getAtaqueEspecialFueHabiltado() &&
                state.isMaestroFueDerrotado() == this.maestroFueDerrotado;
    }


    /**
     * Este metodo clona el estado del agente. Es usado en el proceso de busqueda
     * cuando se crea el arbol de busqueda.
     */
    @Override
    public SearchBasedAgentState clone() {
        PokemonAgentState nuevoEstado = new PokemonAgentState();
        nuevoEstado.setEnergiaActual(this.getEnergiaActual());
        nuevoEstado.setEnergiaInicial(this.getEnergiaInicial());
        nuevoEstado.setAtaqueEspecialFueHabiltado(this.getAtaqueEspecialFueHabiltado());
        nuevoEstado.setCantidadPokemonesAdversarios(this.getCantidadPokemonesAdversarios());
        nuevoEstado.setEnfriamientoAtaqueEspecial(this.getEnfriamientoAtaqueEspecial());
        nuevoEstado.setMaestroFueDerrotado(this.isMaestroFueDerrotado());
        nuevoEstado.setLugarActual(lugarActual);
        nuevoEstado.setLugarPokebolasConocidos(Map.copyOf(this.getLugarPokebolasConocidos()));
        nuevoEstado.setLugarPokemonesAdversariosConocidos(Map.copyOf(this.getLugarPokemonesAdversariosConocidos()));
        return nuevoEstado;
    }

    /**
     * Este metodo es usado para actualizar el estado del Pokemon cuando
     * recibe una percepcion del ambiente.
     */
    @Override
    public void updateState(Perception p) {
        PokemonPerception perception = (PokemonPerception) p;
        Adversario adv;

        for (var par: perception.getLugarPokebolasAdyacentes().entrySet()) {
            lugarPokebolasConocidos.put(par.getKey(), par.getValue());
        }
        // ver de cambiar, poco performante
        for (var par: perception.getLugarPokemonesAdversariosAdyacentes().entrySet()) {
            // Busco si el enemigo esta en mi lista de enemigos concidos, y lo saco
            for (Lugar lugar: lugarPokemonesAdversariosConocidos.keySet()) {
                adv = lugarPokemonesAdversariosConocidos.get(lugar);
                if(adv != null && adv.equals(par.getValue())) {
                    lugarPokemonesAdversariosConocidos.put(lugar, null);
                    break;
                }
            }
            // Lo agrego en el nuevo lugar
            lugarPokemonesAdversariosConocidos.put(par.getKey(), par.getValue());
        }

    }

    /**
     * Metodo opcional para inicializar el estado inicial del agente.
     */
    @Override
    public void initState() {
        // Crear mapa del agente
        lugares = Utilities.crearMapa();
        lugarActual = lugares.get(Utilities.getPosInicialAgente());
        // Inicializar demas variables
        cantidadPokemonesAdversarios = Utilities.CANT_ADVERSARIOS;
        lugarPokemonesAdversariosConocidos = new HashMap<>();
        lugarPokebolasConocidos = new HashMap<>();
        for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
            lugarPokemonesAdversariosConocidos.put(lugares.get(i), null);
            lugarPokebolasConocidos.put(lugares.get(i), null);
        }
        energiaInicial = Utilities.getEnergiaInicialAgente();
        energiaActual = Utilities.getEnergiaInicialAgente();
        enfriamientoAtaqueEspecial = new int[3];
        enfriamientoAtaqueEspecial[0] = 0;
        enfriamientoAtaqueEspecial[1] = 0;
        enfriamientoAtaqueEspecial[2] = 0;
        ataqueEspecialFueHabiltado = new boolean[3];
        ataqueEspecialFueHabiltado[0] = false;
        ataqueEspecialFueHabiltado[1] = false;
        ataqueEspecialFueHabiltado[2] = false;
        maestroFueDerrotado = false;

    }

    /**
     * Este metodo retorna la representacion del estado del agente como String
     */
    @Override
    public String toString() {
        return "PokemonAgentState{" +
                "lugarActual=" + lugarActual +
                ", cantidadPokemonesAdversarios=" + cantidadPokemonesAdversarios +
                ", lugarPokemonesAdversariosConocidos=" + lugarPokemonesAdversariosConocidos +
                ", lugarPokebolasConocidos=" + lugarPokebolasConocidos +
                ", energiaInicial=" + energiaInicial +
                ", energiaActual=" + energiaActual +
                ", enfriamientoAtaqueEspecial=" + Arrays.toString(enfriamientoAtaqueEspecial) +
                ", ataqueEspecialFueHabiltado=" + Arrays.toString(ataqueEspecialFueHabiltado) +
                ", maestroFueDerrotadoo=" + maestroFueDerrotado +
                '}';
    }
    /**
     * Metodos extras
     */


    /**
     * Getters y setters
     */
    public Lugar getLugarActual() {
        return lugarActual;
    }

    public void setLugarActual(Lugar lugarActual) {
        this.lugarActual = lugarActual;
    }

    public int getCantidadPokemonesAdversarios() {
        return cantidadPokemonesAdversarios;
    }

    public void setCantidadPokemonesAdversarios(int cantidadPokemonesAdversarios) {
        this.cantidadPokemonesAdversarios = cantidadPokemonesAdversarios;
    }

    public Map<Lugar, Adversario> getLugarPokemonesAdversariosConocidos() {
        return lugarPokemonesAdversariosConocidos;
    }

    public void setLugarPokemonesAdversariosConocidos(Map<Lugar, Adversario> lugarPokemonesAdversariosConocidos) {
        this.lugarPokemonesAdversariosConocidos = lugarPokemonesAdversariosConocidos;
    }

    public Map<Lugar, Boolean> getLugarPokebolasConocidos() {
        return lugarPokebolasConocidos;
    }

    public void setLugarPokebolasConocidos(Map<Lugar, Boolean> lugarPokebolasConocidos) {
        this.lugarPokebolasConocidos = lugarPokebolasConocidos;
    }

    public int getEnergiaInicial() {
        return energiaInicial;
    }

    public void setEnergiaInicial(int energiaInicial) {
        this.energiaInicial = energiaInicial;
    }

    public int getEnergiaActual() {
        return energiaActual;
    }

    public void setEnergiaActual(int energiaActual) {
        this.energiaActual = energiaActual;
    }

    public int[] getEnfriamientoAtaqueEspecial() {
        return enfriamientoAtaqueEspecial;
    }

    public void setEnfriamientoAtaqueEspecial(int[] enfriamientoAtaqueEspecial) {
        this.enfriamientoAtaqueEspecial = enfriamientoAtaqueEspecial;
    }
    public void setEnfriamientoAtaqueEspecial1(int enfriamientoAtaqueEspecial) {
        this.enfriamientoAtaqueEspecial[0] = enfriamientoAtaqueEspecial;
    }
    public void setEnfriamientoAtaqueEspecial2(int enfriamientoAtaqueEspecial) {
        this.enfriamientoAtaqueEspecial[1] = enfriamientoAtaqueEspecial;
    }
    public void setEnfriamientoAtaqueEspecial3(int enfriamientoAtaqueEspecial) {
        this.enfriamientoAtaqueEspecial[2] = enfriamientoAtaqueEspecial;
    }
    public boolean[] getAtaqueEspecialFueHabiltado() {
        return ataqueEspecialFueHabiltado;
    }


    public void setAtaqueEspecialFueHabiltado(boolean[] ataqueEspecialFueHabiltado) {
        this.ataqueEspecialFueHabiltado = ataqueEspecialFueHabiltado;
    }

    public void setAtaqueEspecial1FueHabiltado() {
        this.ataqueEspecialFueHabiltado[0] = true;
    }
    public void setAtaqueEspecial2FueHabiltado() {
        this.ataqueEspecialFueHabiltado[1] = true;
    }
    public void setAtaqueEspecial3FueHabiltado() {
        this.ataqueEspecialFueHabiltado[2] = true;
    }

    public boolean isMaestroFueDerrotado() {
        return maestroFueDerrotado;
    }

    public void setMaestroFueDerrotado(boolean maestroFueDerrotadoo) {
        this.maestroFueDerrotado = maestroFueDerrotadoo;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }
}
