package actions;

import agent.PokemonAgentState;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import structures.Adversario;

public class UsarAtaqueEspecial2 extends SearchAction {
    /**
     * Este metodo actualiza el estado del nodo del arbol cuando
     * el proceso de busqueda esta corriendo.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PokemonAgentState pokemonAgentState = (PokemonAgentState) s;

        Adversario adv = pokemonAgentState.getLugarPokemonesAdversariosConocidos().get(pokemonAgentState.getLugarActual());

        if(pokemonAgentState.getEnergiaActual() > 0 &&
           pokemonAgentState.getAtaqueEspecialFueHabiltado()[1] &&
           pokemonAgentState.getEnfriamientoAtaqueEspecial()[1] == 0 &&
           adv != null &&
           adv.getEnergia() > 0){

            int auxEnergia = pokemonAgentState.getEnergiaActual();
            pokemonAgentState.setEnergiaActual((int) Math.round(adv.getEnergia()*1.3));
            adv.setEnergia(auxEnergia);
            pokemonAgentState.setEnfriamientoAtaqueEspecial2(3);

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
           pokemonAgentState.getAtaqueEspecialFueHabiltado()[1] &&
           pokemonAgentState.getEnfriamientoAtaqueEspecial()[1] == 0 &&
           adv != null &&
           adv.getEnergia() > 0){

            // Agente
            int auxEnergia = pokemonAgentState.getEnergiaActual();
            pokemonAgentState.setEnergiaActual((int) Math.round(adv.getEnergia()*1.3));
            adv.setEnergia(auxEnergia);
            pokemonAgentState.setEnfriamientoAtaqueEspecial2(3);

            // Ambiente
            Adversario advAmbiente = environmentState.getLugarPokemonesAdversarios().get(environmentState.getLugarActualAgente());
            advAmbiente.setEnergia(auxEnergia);

            return environmentState;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Usar ataque especial 2";
    }
}
