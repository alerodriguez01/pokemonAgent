package actions;


import agent.PokemonAgentState;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

import java.util.Random;


public class ConsumirPokebola extends SearchAction {
    /**
     * Este metodo actualiza el estado del nodo del arbol cuando
     * el proceso de busqueda esta corriendo.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PokemonAgentState pokemonAgentState = (PokemonAgentState) s;

        if(pokemonAgentState.getEnergiaActual() > 0 &&
           pokemonAgentState.getLugarPokebolasConocidos().get(pokemonAgentState.getLugarActual()) &&
           pokemonAgentState.getLugarPokemonesAdversariosConocidos().get(pokemonAgentState.getLugarActual()) == null){

            Random random = new Random();
            int energiaPokebola = 5 + random.nextInt(6); // Entre 5 y 10
            pokemonAgentState.setEnergiaActual(pokemonAgentState.getEnergiaActual()+energiaPokebola);
            pokemonAgentState.getLugarPokebolasConocidos().put(pokemonAgentState.getLugarActual(), false);

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
                pokemonAgentState.getLugarPokebolasConocidos().get(pokemonAgentState.getLugarActual()) &&
                pokemonAgentState.getLugarPokemonesAdversariosConocidos().get(pokemonAgentState.getLugarActual()) == null){

            // Cambio del estado del pokemon
            Random random = new Random();
            int energiaPokebola = 5 + random.nextInt(6); // Entre 5 y 10
            pokemonAgentState.setEnergiaActual(pokemonAgentState.getEnergiaActual()+energiaPokebola);
            pokemonAgentState.getLugarPokebolasConocidos().put(pokemonAgentState.getLugarActual(), false);

            // Cambio del estado del ambiente
            environmentState.getLugarPokebolas().put(environmentState.getlugarActualAgente(), false);

            return environmentState;

        }
        return null;
    }

    @Override
    public String toString() {
        return "Consumir pokebola";
    }
}
