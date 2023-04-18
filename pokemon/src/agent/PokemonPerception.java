package agent;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonPerception extends Perception {

    public PokemonPerception(){

    }

    public PokemonPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * Metodo utilizado para inicializar la percepcion
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {

    }

    /**
     * Metodo para representar como string la percepcion.
     */
    @Override
    public String toString() {
        return null;
    }
}
