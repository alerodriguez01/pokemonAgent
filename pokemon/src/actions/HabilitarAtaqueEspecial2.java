package actions;

import agent.PokemonAgentState;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class HabilitarAtaqueEspecial2 extends SearchAction {
    /**
     * Este metodo actualiza el estado del nodo del arbol cuando
     * el proceso de busqueda esta corriendo.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PokemonAgentState pokemonAgentState = (PokemonAgentState) s;

        if(pokemonAgentState.getEnergiaActual() > 0 &&
           pokemonAgentState.getEnergiaActual() >= 1.75 * pokemonAgentState.getEnergiaInicial() &&
        !pokemonAgentState.getAtaqueEspecialFueHabiltado()[1]) {
            pokemonAgentState.setAtaqueEspecial2FueHabiltado();
            return pokemonAgentState;
        }

        return null;
    }

    /**
     * Este metodo retorna el costo de la accion.
     */
    @Override
    public Double getCost() {
        return null;
    }

    /**
     * Este metodo actualiza el estado del agente y del mundo real.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        PokemonEnvironmentState environmentState = (PokemonEnvironmentState) est;
        PokemonAgentState pokemonAgentState = (PokemonAgentState) ast;

        if(pokemonAgentState.getEnergiaActual() > 0 &&
           pokemonAgentState.getEnergiaActual() >= 1.75 * pokemonAgentState.getEnergiaInicial() &&
                !pokemonAgentState.getAtaqueEspecialFueHabiltado()[1]) {
            // Actualiza el estado del pokemon
            pokemonAgentState.setAtaqueEspecial2FueHabiltado();
            // Y en esta accion, el ambiente no se modifica
            return environmentState;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Habilitar ataque 2";
    }
}
