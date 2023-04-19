import agent.PokemonAgent;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import environment.PokemonEnvironment;

public class PokemonSearchMain {
    public static void main(String[] args){

        //PokemonAgent pokemonAgent = new PokemonAgent();

        PokemonEnvironment pokemonEnvironment = new PokemonEnvironment();

        pokemonEnvironment.getEnvironmentState().initState();
        System.out.println(pokemonEnvironment.toString());
        pokemonEnvironment.moverAdversarios2();
        // pokemonEnvironment.moverAdversarios(pokemonEnvironment.getEnvironmentState().getlugarActualAgente(), null);
        System.out.println(pokemonEnvironment.toString());

        //SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(pokemonEnvironment, pokemonAgent);

        //simulator.start();




    }
}
