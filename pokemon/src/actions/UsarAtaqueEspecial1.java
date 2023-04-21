package actions;

import agent.PokemonAgentState;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import structures.Adversario;

public class UsarAtaqueEspecial1 extends SearchAction {
    /**
     * Este metodo actualiza el estado del nodo del arbol cuando
     * el proceso de busqueda esta corriendo.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PokemonAgentState pokemonAgentState = (PokemonAgentState) s;

        Adversario adv = pokemonAgentState.getLugarPokemonesAdversariosConocidos().get(pokemonAgentState.getLugarActual());

        if(pokemonAgentState.getEnergiaActual() > 0 &&
           pokemonAgentState.getAtaqueEspecialFueHabiltado()[0] &&
           pokemonAgentState.getEnfriamientoAtaqueEspecial()[0] == 0 &&
           adv != null &&
           adv.getEnergia() > 0){

            pokemonAgentState.setEnergiaActual((int) Math.round(1.2 * pokemonAgentState.getEnergiaActual()));
            adv.setEnergia((int) Math.round(adv.getEnergia() * 0.8));
            pokemonAgentState.setEnfriamientoAtaqueEspecial1(3);

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

        Adversario adv = pokemonAgentState.getLugarPokemonesAdversariosConocidos().get(pokemonAgentState.getLugarActual());

        if(pokemonAgentState.getEnergiaActual() > 0 &&
           pokemonAgentState.getAtaqueEspecialFueHabiltado()[0] &&
           pokemonAgentState.getEnfriamientoAtaqueEspecial()[0] == 0 &&
           adv != null &&
           adv.getEnergia() > 0){

            // Agente
            pokemonAgentState.setEnergiaActual((int) Math.round(1.2 * pokemonAgentState.getEnergiaActual()));
            adv.setEnergia((int) Math.round(adv.getEnergia() * 0.8));
            pokemonAgentState.setEnfriamientoAtaqueEspecial1(3);

            // Ambiente
            Adversario advAmbiente = environmentState.getAdversarios().get(environmentState.getLugarActualAgente());
            advAmbiente.setEnergia((int) Math.round(adv.getEnergia() * 0.8));
            environmentState.setEnergiaAgente((int) Math.round(1.2 * environmentState.getEnergiaAgente()));

            return environmentState;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Usar ataque especial 1";
    }
}
