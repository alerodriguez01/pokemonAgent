package agent;

import environment.PokemonEnvironment;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import structures.Adversario;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonPerception extends Perception {

    private Map<Integer, Adversario> lugarPokemonesAdversariosAdyacentes;
    private Map<Integer, Boolean> lugarPokebolasAdyacentes;

    public PokemonPerception(){
        lugarPokemonesAdversariosAdyacentes = new HashMap<>();
        lugarPokebolasAdyacentes = new HashMap<>();
    }

    public PokemonPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * Metodo utilizado para inicializar la percepcion
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {

        PokemonEnvironment amb = (PokemonEnvironment) environment;
        PokemonEnvironmentState estadoAmb = amb.getEnvironmentState();

        Integer lugarAgente = estadoAmb.getLugarActualAgente();
        List<Integer> adyacencias = new ArrayList<>(estadoAmb.getLugares().get(lugarAgente));
        adyacencias.add(lugarAgente);

        List<Adversario> lugarPokemonesAdversarios = estadoAmb.getAdversarios();
        for (Integer lugarAdy: adyacencias) {
            Adversario adv = lugarPokemonesAdversarios.get(lugarAdy);
            lugarPokemonesAdversariosAdyacentes.put(lugarAdy, adv);
        }

        List<Boolean> lugarPokebolas = estadoAmb.getLugarPokebolas();
        for (Integer lugarAdy: adyacencias) {
            lugarPokebolasAdyacentes.put(lugarAdy, lugarPokebolas.get(lugarAdy));
        }

    }

    public void satelitePerception(Environment environment){
        PokemonEnvironment amb = (PokemonEnvironment) environment;
        for (int i = 0; i < Utilities.CANT_LUGARES; i++) {
            lugarPokebolasAdyacentes.put(i, amb.getEnvironmentState().getLugarPokebolas().get(i));
            lugarPokemonesAdversariosAdyacentes.put(i, amb.getEnvironmentState().getAdversarios().get(i));
        }
    }

    @Override
    public String toString() {
        return "PokemonPerception{" +
                "lugarPokemonesAdversariosAdyacentes=" + lugarPokemonesAdversariosAdyacentes +
                ", lugarPokebolasAdyacentes=" + lugarPokebolasAdyacentes +
                '}';
    }

    public Map<Integer, Adversario> getLugarPokemonesAdversariosAdyacentes() {
        return lugarPokemonesAdversariosAdyacentes;
    }

    public void setLugarPokemonesAdversariosAdyacentes(Map<Integer, Adversario> lugarPokemonesAdversariosAdyacentes) {
        this.lugarPokemonesAdversariosAdyacentes = lugarPokemonesAdversariosAdyacentes;
    }

    public Map<Integer, Boolean> getLugarPokebolasAdyacentes() {
        return lugarPokebolasAdyacentes;
    }

    public void setLugarPokebolasAdyacentes(Map<Integer, Boolean> lugarPokebolasAdyacentes) {
        this.lugarPokebolasAdyacentes = lugarPokebolasAdyacentes;
    }
}
