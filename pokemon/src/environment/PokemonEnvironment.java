package environment;

import agent.PokemonPerception;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.AgentState;
import structures.Adversario;
import structures.Lugar;

import java.util.*;

public class PokemonEnvironment extends Environment {

    public PokemonEnvironment() {
        // Create the environment state
        this.environmentState = new PokemonEnvironmentState();
    }

    @Override
    public PokemonEnvironmentState getEnvironmentState() {
        return (PokemonEnvironmentState) super.getEnvironmentState();
    }

    /**
     * Metodo llamado por el simulador. Dado el agente, crea una nueva percepcion
     * leyendo la posicion del agente.
     */
    @Override
    public Perception getPercept() {
        // Crear la nueva percepcion a retornar
        PokemonPerception perception = new PokemonPerception();
        perception.initPerception(null, this); // Pasamos null porque no es necesario el agente para setear la percepcion
        return perception;
    }

    @Override
    public String toString() {
        return environmentState.toString();
    }

    /**
     * Metodo utilzado por el ambiente para saber si el agente ha fallado
     */
    @Override
    public boolean agentFailed(Action actionReturned) {

        PokemonEnvironmentState pokemonEnvironmentState = this.getEnvironmentState();

        int agentEnergy = pokemonEnvironmentState.getAgentEnergy();

        // si el agente no tiene energia, ha fallado.
        if (agentEnergy <= 0)
            return true;

        return false;
    }

    @Override
    public void updateState(AgentState ast, Action action) {
        super.updateState(ast, action);

        // Mover adversarios
        this.moverAdversarios2();
    }

    public void moverAdversarios2() {
        Map<Lugar, Adversario> lugarPokemonesAdversarios = this.getEnvironmentState().getLugarPokemonesAdversarios();
        List<Lugar> lugares = this.getEnvironmentState().getLugares();
        List<Lugar> lugaresAdyacentes;
        Adversario adv;

        Random adversariosAMover = new Random();
        Random decidirMoverse = new Random();
        Random proximoLugar = new Random();
        int eleccionLugar;
        int l = 0;
        // Decidir aleatoriamente cuantos enemigos se van a mover
        int cantAdv = this.getEnvironmentState().getAdversarios().size();
        int cantAdvAMover =  adversariosAMover.nextInt(cantAdv + 1);
        int advRestantes = cantAdvAMover;
        while (advRestantes > 0 && l < lugares.size())
        {
            adv = lugarPokemonesAdversarios.get(lugares.get(l));
            if (adv != null) // i.e. hay un enemigo en el lugar
            {
                // Si el adversario no es maestro (el maestro no se mueve)
                if (!adv.getEsMaestro()) {
                    // Decidir si mover al adversario
                    if (((double) decidirMoverse.nextInt(cantAdvAMover + 1)) / cantAdvAMover <= 0.75) // Con p = 3/4 el adversario que puede moverse se mueve
                    {
                        lugaresAdyacentes = lugares.get(l).getLugaresAdyacentes();

                        // Decidir a que lugar adyacente moverse
                        eleccionLugar = proximoLugar.nextInt(lugaresAdyacentes.size());
                        // Si el adyacente contiene un adversario, no moverse
                        if (lugarPokemonesAdversarios.get(lugaresAdyacentes.get(eleccionLugar)) == null) {
                            lugarPokemonesAdversarios.put(lugares.get(l), null);
                            lugarPokemonesAdversarios.put(lugaresAdyacentes.get(eleccionLugar), adv);
                        }
                    }

                    advRestantes--;
                }
            }

            l++;
        }
    }

}
