package agent;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import structures.Adversario;
import utilities.Utilities;

import java.util.*;

public class PokemonAgentState extends SearchBasedAgentState {

    /**
     * Atributos que definen el estado
     */
    private Integer lugarActual;
    private List<List<Integer>> lugares;
    private Integer cantidadPokemonesAdversarios;
    private List<Adversario> lugarPokemonesAdversariosConocidos;
    private List<Boolean> lugarPokebolasConocidos;
    private Integer energiaInicial;
    private Integer energiaActual;
    private Integer[] enfriamientoAtaqueEspecial;
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
        return state.getLugarActual().equals(this.lugarActual) &&
                state.getCantidadPokemonesAdversarios().equals(this.cantidadPokemonesAdversarios) &&
                state.getLugarPokemonesAdversariosConocidos().equals(this.lugarPokemonesAdversariosConocidos) &&
                state.getLugarPokebolasConocidos().equals(this.lugarPokebolasConocidos) &&
                state.getEnergiaInicial().equals(this.energiaInicial) &&
                state.getEnergiaActual().equals(this.energiaActual) &&
                state.getEnfriamientoAtaqueEspecial()[0].equals(this.enfriamientoAtaqueEspecial[0]) &&
                state.getEnfriamientoAtaqueEspecial()[1].equals(this.enfriamientoAtaqueEspecial[1]) &&
                state.getEnfriamientoAtaqueEspecial()[2].equals(this.enfriamientoAtaqueEspecial[2]) &&
                state.getAtaqueEspecialFueHabiltado()[0] == this.ataqueEspecialFueHabiltado[0] &&
                state.getAtaqueEspecialFueHabiltado()[1] == this.ataqueEspecialFueHabiltado[1] &&
                state.getAtaqueEspecialFueHabiltado()[2] == this.ataqueEspecialFueHabiltado[2] &&
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
        nuevoEstado.setAtaqueEspecialFueHabiltado(this.getAtaqueEspecialFueHabiltado().clone());
        nuevoEstado.setCantidadPokemonesAdversarios(this.getCantidadPokemonesAdversarios());
        nuevoEstado.setEnfriamientoAtaqueEspecial(this.getEnfriamientoAtaqueEspecial().clone());
        nuevoEstado.setMaestroFueDerrotado(this.isMaestroFueDerrotado());
        nuevoEstado.setLugarActual(this.getLugarActual());

        // ??
        List<Boolean> newPokebolasConocidas = new ArrayList<>();
        for (Boolean bool: this.lugarPokebolasConocidos)
            newPokebolasConocidas.add(bool);
        nuevoEstado.setLugarPokebolasConocidos(newPokebolasConocidas);

        List<Adversario> newAdvsConocidos = new ArrayList<>();
        for (Adversario adv: this.lugarPokemonesAdversariosConocidos)
            if (adv != null)
                newAdvsConocidos.add(adv.clone());
            else
                newAdvsConocidos.add(null);
        nuevoEstado.setLugarPokemonesAdversariosConocidos(newAdvsConocidos);

        return nuevoEstado;
    }

    /**
     * Este metodo es usado para actualizar el estado del Pokemon cuando
     * recibe una percepcion del ambiente.
     */
    @Override
    public void updateState(Perception p) {
        PokemonPerception perception = (PokemonPerception) p;

        for (var par : perception.getLugarPokebolasAdyacentes().entrySet()) {
            lugarPokebolasConocidos.set(par.getKey(), par.getValue());
        }

        // Por cada par de (idLugar, Adversario) percibido
        for (var par : perception.getLugarPokemonesAdversariosAdyacentes().entrySet()) {

            // 1. Me fijo si tengo un adversario percibido adyacente a mi posicion (mi lugar o alrededores)
            if (par.getValue() != null) {

                // Busco si el enemigo esta en mi lista de enemigos concidos, y lo saco
                for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
                    Adversario adv = lugarPokemonesAdversariosConocidos.get(i);
                    if (adv != null && adv.equals(par.getValue())) {
                        lugarPokemonesAdversariosConocidos.set(i, null);
                        break;
                    }
                }
            }

            // 2. Me fijo si en el lugar que va a ir el adversario percibido (sea null o adversario), ya existe un enemigo conocido
            Adversario advAdyacenteConocido = lugarPokemonesAdversariosConocidos.get(par.getKey());
            if (advAdyacenteConocido != null) {
                // Busco una posicion vacia (distinta de las adyacentes), y lo muevo ahi
                for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
                    // Si el lugar NO es adyacente y no hay enemigo alli
                    if (!perception.getLugarPokemonesAdversariosAdyacentes().containsKey(i) && lugarPokemonesAdversariosConocidos.get(i) == null) {
                        lugarPokemonesAdversariosConocidos.set(i, advAdyacenteConocido);
                        break;
                    }
                }
            }
            // Finalmente, lo agrego en el nuevo lugar (sea un adversario o null)
            lugarPokemonesAdversariosConocidos.set(par.getKey(), par.getValue());
        }
    }

    /**
     * Metodo opcional para inicializar el estado inicial del agente.
     */
    @Override
    public void initState() {
        // Crear mapa del agente
        lugares = Utilities.crearMapa();
        lugarActual = Utilities.getPosInicialAgente();
        // Inicializar demas variables
        cantidadPokemonesAdversarios = Utilities.CANT_ADVERSARIOS + 1;
        lugarPokemonesAdversariosConocidos = new ArrayList<>();
        lugarPokebolasConocidos = new ArrayList<>();
        for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
            lugarPokemonesAdversariosConocidos.add(null);
            lugarPokebolasConocidos.add(null);
        }
        energiaInicial = Utilities.getEnergiaInicialAgente();
        energiaActual = Utilities.getEnergiaInicialAgente();
        enfriamientoAtaqueEspecial = new Integer[3];
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
                ", lugares=" + lugares +
                ", cantidadPokemonesAdversarios=" + cantidadPokemonesAdversarios +
                ", lugarPokemonesAdversariosConocidos=" + lugarPokemonesAdversariosConocidos +
                ", lugarPokebolasConocidos=" + lugarPokebolasConocidos +
                ", energiaInicial=" + energiaInicial +
                ", energiaActual=" + energiaActual +
                ", enfriamientoAtaqueEspecial=" + Arrays.toString(enfriamientoAtaqueEspecial) +
                ", ataqueEspecialFueHabiltado=" + Arrays.toString(ataqueEspecialFueHabiltado) +
                ", maestroFueDerrotado=" + maestroFueDerrotado +
                '}';
    }
/**
 * Metodos extras
 */


    /**
     * Getters y setters
     */


    public Integer getCantidadPokemonesAdversarios() {
        return cantidadPokemonesAdversarios;
    }

    public void setCantidadPokemonesAdversarios(Integer cantidadPokemonesAdversarios) {
        this.cantidadPokemonesAdversarios = cantidadPokemonesAdversarios;
    }


    public Integer getEnergiaInicial() {
        return energiaInicial;
    }

    public void setEnergiaInicial(Integer energiaInicial) {
        this.energiaInicial = energiaInicial;
    }

    public Integer getEnergiaActual() {
        return energiaActual;
    }

    public void setEnergiaActual(Integer energiaActual) {
        this.energiaActual = energiaActual;
    }

    public Integer[] getEnfriamientoAtaqueEspecial() {
        return enfriamientoAtaqueEspecial;
    }

    public void setEnfriamientoAtaqueEspecial(Integer[] enfriamientoAtaqueEspecial) {
        this.enfriamientoAtaqueEspecial = enfriamientoAtaqueEspecial;
    }

    public void setEnfriamientoAtaqueEspecial1(Integer enfriamientoAtaqueEspecial) {
        this.enfriamientoAtaqueEspecial[0] = enfriamientoAtaqueEspecial;
    }

    public void setEnfriamientoAtaqueEspecial2(Integer enfriamientoAtaqueEspecial) {
        this.enfriamientoAtaqueEspecial[1] = enfriamientoAtaqueEspecial;
    }

    public void setEnfriamientoAtaqueEspecial3(Integer enfriamientoAtaqueEspecial) {
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

    public Integer getLugarActual() {
        return lugarActual;
    }

    public void setLugarActual(Integer lugarActual) {
        this.lugarActual = lugarActual;
    }

    public List<List<Integer>> getLugares() {
        return lugares;
    }

    public void setLugares(List<List<Integer>> lugares) {
        this.lugares = lugares;
    }

    public List<Adversario> getLugarPokemonesAdversariosConocidos() {
        return lugarPokemonesAdversariosConocidos;
    }

    public void setLugarPokemonesAdversariosConocidos(List<Adversario> lugarPokemonesAdversariosConocidos) {
        this.lugarPokemonesAdversariosConocidos = lugarPokemonesAdversariosConocidos;
    }

    public List<Boolean> getLugarPokebolasConocidos() {
        return lugarPokebolasConocidos;
    }

    public void setLugarPokebolasConocidos(List<Boolean> lugarPokebolasConocidos) {
        this.lugarPokebolasConocidos = lugarPokebolasConocidos;
    }
}
