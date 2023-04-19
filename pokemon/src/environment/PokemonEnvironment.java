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

    /**
     * Metodo usado para actualizar el estado del ambiente.
     */
    @Override
    public void updateState(AgentState ast, Action action) {
        super.updateState(ast, action);

        // Mover adversarios
        moverAdversarios(getEnvironmentState().getlugarActualAgente(), null); // Metodo 1
        
        this.moverAdversarios2(); // Metodo 2
    }

    private void moverAdversarios(Lugar actual, List<Lugar> lugaresVistos) {
        Map<Lugar, Adversario> lugarPokemonesAdversarios = getEnvironmentState().getLugarPokemonesAdversarios();

        // Me aseguro de que no pasar por un lugar visto
        List<Integer> randomVistos = new ArrayList<>();
        Integer randomsPorVer = actual.getLugaresAdyacentes().size() - 1;

        Integer random = (int) Math.random() * (actual.getLugaresAdyacentes().size() - 1);
        randomsPorVer--;
        randomVistos.add(random);
        Lugar lugarDestino = actual.getLugaresAdyacentes().get(random);

        if (lugaresVistos == null) lugaresVistos = new ArrayList<>();

        // Si elegi un lugar random, y ya esta dentro de los visitados anteriormente
        // trato de cambiarlo (ejecuto el bucle mientras me queden lugares adyacentes por ver)
        while(lugaresVistos.contains(lugarDestino) && randomsPorVer != 0){
            random = (int) Math.random() * (actual.getLugaresAdyacentes().size() - 1);
            if(!randomVistos.contains(random)){
                randomVistos.add(random);
                randomsPorVer--;
            }
            lugarDestino = actual.getLugaresAdyacentes().get(random);
        }
        // Si no me quedaron opciones por moverme, entonces no me queda otra que arrancar nuevamente
        // desde el nodo actual
        if(randomsPorVer == 0) lugaresVistos = new ArrayList<>();

        Adversario advActual = lugarPokemonesAdversarios.get(actual);
        // Si en el lugar actual tengo enemigo
        if(advActual != null) {

            // Hay adversario en el adyacente random
            if (lugarPokemonesAdversarios.get(lugarDestino) != null) {

                lugaresVistos.add(actual); // agrego el lugar actual como lugar visto

                moverAdversarios(lugarDestino, lugaresVistos);

                // Pudo haber cambiado el camino (y ya no estoy incluido en el)
                // si estoy en el camino actual y no cambio mi adversario
                if (lugaresVistos.contains(actual) && lugarPokemonesAdversarios.get(actual) == advActual){
                    lugarPokemonesAdversarios.put(lugarDestino, advActual);
                }

            } else { // caso base
                lugarPokemonesAdversarios.put(lugarDestino, advActual);
            }
        }else{
            // Si no tengo enemigos en el lugar actual es porque el algoritmo inicio en un lugar
            // sin enemigos. Lo arranco nuevamente desde otro nodo.
            moverAdversarios(lugarDestino, lugaresVistos);
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
