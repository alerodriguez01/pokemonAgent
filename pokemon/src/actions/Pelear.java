package actions;

import agent.PokemonAgentState;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import structures.Adversario;
import utilities.Utilities;

public class Pelear extends SearchAction {

    /**
     * Este metodo actualiza el estado del nodo del arbol cuando
     * el proceso de busqueda esta corriendo.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PokemonAgentState pokemonAgentState = (PokemonAgentState) s;

        Adversario adv = pokemonAgentState.getLugarPokemonesAdversariosConocidos().get(pokemonAgentState.getLugarActual());

        if(pokemonAgentState.getEnergiaActual() > 0 &&
           adv != null &&
           pokemonAgentState.getEnergiaActual() > adv.getEnergia()){

            // Seteo de nueva energia
            pokemonAgentState.setEnergiaActual(pokemonAgentState.getEnergiaActual() /*- adv.getEnergia()*/ + (int) Math.round(adv.getEnergia() * 0.2));
            pokemonAgentState.setCantidadPokemonesAdversarios(pokemonAgentState.getCantidadPokemonesAdversarios() - 1);
            // Mato al adversario
            pokemonAgentState.getLugarPokemonesAdversariosConocidos().set(pokemonAgentState.getLugarActual(), null);
            if(adv.getEsMaestro()) pokemonAgentState.setMaestroFueDerrotado(true);

            Utilities.decrementarEnfriamientoAtaquesEspeciales(pokemonAgentState);

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
                adv != null &&
                pokemonAgentState.getEnergiaActual() > adv.getEnergia()){

            // Agente
            // Seteo de nueva energia
            pokemonAgentState.setEnergiaActual(pokemonAgentState.getEnergiaActual() /*- adv.getEnergia()*/ + (int) Math.round(adv.getEnergia() * 0.2));
            pokemonAgentState.setCantidadPokemonesAdversarios(pokemonAgentState.getCantidadPokemonesAdversarios() - 1);
            // Mato al adversario
            pokemonAgentState.getLugarPokemonesAdversariosConocidos().set(pokemonAgentState.getLugarActual(), null);
            if(adv.getEsMaestro()) pokemonAgentState.setMaestroFueDerrotado(true);

            Utilities.decrementarEnfriamientoAtaquesEspeciales(pokemonAgentState);

            // Ambiente
            environmentState.getAdversarios().set(environmentState.getLugarActualAgente(), null);
            environmentState.setEnergiaAgente(pokemonAgentState.getEnergiaActual());

            return environmentState;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Pelear";
    }
}
