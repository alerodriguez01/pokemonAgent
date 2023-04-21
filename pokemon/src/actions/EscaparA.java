package actions;

import agent.PokemonAgentState;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import structures.Adversario;

public class EscaparA extends SearchAction {

    private Integer lugar;

    public EscaparA(Integer lugar) {
        this.lugar = lugar;
    }

    /**
     * Este metodo actualiza el estado del nodo del arbol cuando
     * el proceso de busqueda esta corriendo.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PokemonAgentState pokemonAgentState = (PokemonAgentState) s;

        Adversario adv = pokemonAgentState.getLugarPokemonesAdversariosConocidos().get(pokemonAgentState.getLugarActual());

        if(pokemonAgentState.getEnergiaActual() > 0 &&
                pokemonAgentState.getLugares().get(pokemonAgentState.getLugarActual()).contains(lugar) &&
                adv != null){

            pokemonAgentState.setLugarActual(lugar);
            pokemonAgentState.setEnergiaActual(pokemonAgentState.getEnergiaActual() - (int) Math.round(0.25 * adv.getEnergia()));

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
                pokemonAgentState.getLugares().get(pokemonAgentState.getLugarActual()).contains(lugar) &&
                adv != null){

            // Cambiamos estado agente
            pokemonAgentState.setLugarActual(lugar);
            pokemonAgentState.setEnergiaActual(pokemonAgentState.getEnergiaActual() - (int) Math.round(0.25 * adv.getEnergia()));

            // Cambiamos estado ambiente
            environmentState.setLugarActualAgente(lugar);
            environmentState.setEnergiaAgente(environmentState.getEnergiaAgente() - (int) Math.round(0.25 * adv.getEnergia()));

            return environmentState;
        }

        return null;
    }

    @Override
    public String toString() {
        return "EscaparA"+lugar;
    }

}
