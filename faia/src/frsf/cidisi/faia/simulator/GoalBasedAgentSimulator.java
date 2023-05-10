/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa
 * y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package frsf.cidisi.faia.simulator;

import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import agent.PokemonAgent;
import agent.PokemonAgentState;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;
import structures.Adversario;
import ui.PokemonUI;

public abstract class GoalBasedAgentSimulator extends Simulator {

    /**
     * 
     * @param environment
     */
    public GoalBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public GoalBasedAgentSimulator(Environment environment, Agent agent) {
        Vector<Agent> ags = new Vector<Agent>();
        ags.add(agent);

        this.environment = environment;
        this.agents = ags;
    }

    @Override
    public void start() {

        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();

        Perception perception;
        Action action;
        GoalBasedAgent agent;

        agent = (GoalBasedAgent) this.getAgents().firstElement();

        /*
         * Simulation starts. The environment sends perceptions to the agent, and
         * it returns actions. The loop condition evaluation is placed at the end.
         * This works even when the agent starts with a goal state (see agentSucceeded
         * method in the SearchBasedAgentSimulator).
         */
        Random random = new Random();
        int enfriamientoSatelite = 0;

        PokemonUI ui = new PokemonUI();
        ui.setAllNoVisible();

        do {

            System.out.println("------------------------------------");

            // Uso de satelite perception
            if(enfriamientoSatelite == 0){

                enfriamientoSatelite = 5 + random.nextInt(6);
                System.out.println("Sending satelite perception to agent...");
                perception = this.getSatelitePercept();
                agent.see(perception);
                System.out.println("Satelite perception: " + perception);
                ui.getLabelSatelite().setVisible(true);
            } else{ // Perception normal
                enfriamientoSatelite--;
                System.out.println("Sending perception to agent...");
                perception = this.getPercept();
                agent.see(perception);
                System.out.println("Perception: " + perception);
                ui.getLabelSatelite().setVisible(false);
            }
            PokemonAgent pokemonAgent = (PokemonAgent) agent;
            /*
            // Enfriamientos
            PokemonAgent pokemonAgent = (PokemonAgent) agent;
            PokemonAgentState pokemonAgentState = (PokemonAgentState) pokemonAgent.getAgentState();
            for (int i = 0; i < 3; i++) {
                // Enfriamiento ataque especial i+1
                if(pokemonAgentState.getAtaqueEspecialFueHabiltado()[i]){
                    if(pokemonAgentState.getEnfriamientoAtaqueEspecial()[i] > 0)
                        pokemonAgentState.getEnfriamientoAtaqueEspecial()[i] -= 1;
                }
            }
             */

            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);

            System.out.println("Asking the agent for an action...");
            action = agent.selectAction();

            if (action == null) {
                break;
            }

            System.out.println("Action returned: " + action);
            System.out.println();

            this.mostrarUI(ui, ((PokemonEnvironmentState) environment.getEnvironmentState()).getLugarActualAgente(), ((PokemonEnvironmentState) environment.getEnvironmentState()).getAdversarios(), ((PokemonEnvironmentState) environment.getEnvironmentState()).getLugarPokebolas(), ((PokemonEnvironmentState) environment.getEnvironmentState()).getEnergiaAgente(), action);

            this.actionReturned(agent, action);


            // Necesario para no sugerir siempre el moverse a y escapar a en un orden especifico.
            // Evita entrar en un bucle.
            pokemonAgent.mezclarOperadores();

            // Introducir delay para ver los movimientos de los enemigos y agente
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        } while (!this.agentSucceeded(action) && !this.agentFailed(action));

        mostrarUI(ui, ((PokemonEnvironmentState) environment.getEnvironmentState()).getLugarActualAgente(), ((PokemonEnvironmentState) environment.getEnvironmentState()).getAdversarios(), ((PokemonEnvironmentState) environment.getEnvironmentState()).getLugarPokebolas(), ((PokemonEnvironmentState) environment.getEnvironmentState()).getEnergiaAgente(), action);

        // Check what happened, if agent has reached the goal or not.
        if (this.agentSucceeded(action)) {
            System.out.println("Agent has reached the goal!");
            ui.getLabelVictoria().setVisible(true);
        } else {
            System.out.println("ERROR: The simulation has finished, but the agent has not reached his goal.");
            ui.getLabelDerrota().setVisible(true);
        }

        // Leave a blank line
        System.out.println();

        // FIXME: This call can be moved to the Simulator class
        this.environment.close();

        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
    }

    private void mostrarUI(PokemonUI ui, Integer lugarAgente, List<Adversario> adversarios, List<Boolean> pokebolas, Integer energiaAgente, Action action) {
        ui.setAllNoVisible();

        ui.setPikachuVisible(lugarAgente);
        for (int i = 0; i < adversarios.size(); i++) {
            if(adversarios.get(i) != null){
                ui.setAdvVisible(i, adversarios.get(i).getEsMaestro());
            }
        }


        for (int i = 0; i < pokebolas.size(); i++) {
            if(pokebolas.get(i)) ui.setPokebolaVisible(i);
        }

        ui.setLabelEnergia(energiaAgente);
        if(action != null) ui.setLabelUltimaAccion(action.toString());

    }

    /**
     * Here we update the state of the agent and the real state of the
     * simulator.
     * @param action
     */
    protected void updateState(Action action) {
        this.getEnvironment().updateState(((GoalBasedAgent) agents.elementAt(0)).getAgentState(), action);
    }

    public abstract boolean agentSucceeded(Action action);

    public abstract boolean agentFailed(Action action);

    /**
     * This method is executed in the mail loop of the simulation when the
     * agent returns an action.
     * @param agent
     * @param action
     */
    public abstract void actionReturned(Agent agent, Action action);

    /**
     * @return The name of the simulator, e.g. 'SearchBasedAgentSimulator'
     */
    public abstract String getSimulatorName();
}
