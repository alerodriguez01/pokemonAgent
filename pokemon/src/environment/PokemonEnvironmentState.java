package environment;

import frsf.cidisi.faia.state.EnvironmentState;

public class PokemonEnvironmentState extends EnvironmentState {

    /**
     * Atributos del mundo real
     */
    private int agentEnergy;

    /**
     * Metodo usado para inicializar el mundo real inicial
     */
    @Override
    public void initState() {

    }

    /**
     * Representacion en string del mundo real
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     * Getters y setters
     */
    public int getAgentEnergy() {
        return agentEnergy;
    }

    public void setAgentEnergy(int agentEnergy) {
        this.agentEnergy = agentEnergy;
    }
}
