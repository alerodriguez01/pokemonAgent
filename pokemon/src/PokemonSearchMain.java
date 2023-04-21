import agent.PokemonAgent;
import agent.PokemonAgentState;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import environment.PokemonEnvironment;

public class PokemonSearchMain {
    public static void main(String[] args){

        PokemonAgent pokemonAgent = new PokemonAgent();

        PokemonEnvironment pokemonEnvironment = new PokemonEnvironment();

        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(pokemonEnvironment, pokemonAgent);

        simulator.start();

    }
}
