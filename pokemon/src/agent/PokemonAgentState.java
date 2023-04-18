package agent;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class PokemonAgentState extends SearchBasedAgentState {

    /**
     * Atributos que definen el estado
     */



    /**
     * Constructor para iniciar el estado
     */
    public PokemonAgentState() {
        this.initState();
    }

    /**
     * Constructor con parametros
     */
    public PokemonAgentState(int params) {

    }

    /**
     * Este metodo es usado en el proceso de busqueda para verificar si el nodo
     * ya existe en la busqueda actual.
     */
    @Override
    public boolean equals(Object obj) {
        return false;
    }


    /**
     * Este metodo clona el estado del agente. Es usado en el proceso de busqueda
     * cuando se crea el arbol de busqueda.
     */
    @Override
    public SearchBasedAgentState clone() {
        return null;
    }

    /**
     * Este metodo es usado para actualizar el estado del Pokemon cuando
     * recibe una percepcion del ambiente.
     */
    @Override
    public void updateState(Perception p) {

    }

    /**
     * Metodo opcional para inicializar el estado inicial del agente.
     */
    @Override
    public void initState() {

    }

    /**
     * Este metodo retorna la representacion del estado del agente como String
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     * Metodos extras
     */


    /**
     * Getters y setters
     */


}
