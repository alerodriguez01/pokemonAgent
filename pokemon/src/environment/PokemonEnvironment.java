package environment;

import agent.PokemonPerception;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.AgentState;
import structures.Adversario;

import java.util.*;

public class PokemonEnvironment extends Environment {

    public PokemonEnvironment() {
        // Create the environment state
        this.environmentState = new PokemonEnvironmentState();
        environmentState.initState();
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

    public Perception getSatelitePercept(){
        // Crear la nueva percepcion a retornar
        PokemonPerception perception = new PokemonPerception();
        perception.satelitePerception(this); // Pasamos null porque no es necesario el agente para setear la percepcion
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

        int agentEnergy;

        if(actionReturned != null){
          agentEnergy = pokemonEnvironmentState.getEnergiaAgente();
            // si el agente no tiene energia, ha fallado.
          if (agentEnergy <= 0)
                return true;
        }

        return false;
    }

    /**
     * Metodo usado para actualizar el estado del ambiente.
     */
    @Override
    public void updateState(AgentState ast, Action action) {
        super.updateState(ast, action);

        // Mover adversarios
        this.moverAdversarios();
    }


    public void moverAdversarios() {
        List<Adversario> adversarios = this.getEnvironmentState().getAdversarios();
        List<Integer> lugaresAdyacentes;
        List<List<Integer>> lugares = this.getEnvironmentState().getLugares();
        Adversario adv;

        Random proximoLugar = new Random();

        List<Integer> lugaresVistos;
        Integer lugaresPorVer;
        Integer lugarRandom;

        int l = 0;

        //int cantAdv = this.getEnvironmentState().getAdversarios().size();

        List<Adversario> advVistos = new ArrayList<>();

        while (l < lugares.size()) { // cantAdv > 0 && l < lugares.size()
            adv = adversarios.get(l);
            if (adv != null && !advVistos.contains(adv)) // i.e. hay un enemigo en el lugar y todavia no se movio
            {
                // Si el adversario no es maestro (el maestro no se mueve)
                if (!adv.getEsMaestro()) {

                    lugaresAdyacentes = lugares.get(l);

                    // Decidir a que lugar adyacente moverse
                    lugaresVistos = new ArrayList<>();
                    lugaresPorVer = lugaresAdyacentes.size();

                    lugarRandom = proximoLugar.nextInt(lugaresAdyacentes.size());
                    lugaresPorVer--;
                    lugaresVistos.add(lugarRandom);

                    // Mientras nos queden lugares por ver y el adyacente elegido pseudoaleatoriamente tiene enemigo
                    while(lugaresPorVer > 0 && adversarios.get(lugarRandom) != null){
                        lugarRandom = proximoLugar.nextInt(lugaresAdyacentes.size());
                        if(!lugaresVistos.contains(lugarRandom)) {
                            lugaresVistos.add(lugarRandom);
                            lugaresPorVer--;
                        }
                    }
                    // Si el adyacente no contiene un adversario, moverse
                    if (adversarios.get(lugarRandom) == null) {
                        adversarios.set(l, null);
                        adversarios.set(lugarRandom, adv);
                    }
                    advVistos.add(adv);
                    //cantAdv--;
                }
            }
            l++;
        }
    }

}
