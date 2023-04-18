package agent;

import environment.PokemonEnvironment;
import environment.PokemonEnvironmentState;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import structures.Adversario;
import structures.Lugar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonPerception extends Perception {

    private Map<Lugar, Adversario> lugarPokemonesAdversariosAdyacentes;
    private Map<Lugar, Boolean> lugarPokebolasAdyacentes;

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

        Lugar lugarAgente = estadoAmb.getlugarActualAgente();
        List<Lugar> adyacencias = lugarAgente.getLugaresAdyacentes();
        adyacencias.add(lugarAgente);

        Map<Lugar, Adversario> lugarPokemonesAdversarios = estadoAmb.getLugarPokemonesAdversarios();
        for (Lugar lugarAdy: adyacencias) {
            Adversario adv = lugarPokemonesAdversarios.get(lugarAdy);
            lugarPokemonesAdversariosAdyacentes.put(lugarAdy, adv);
        }

        Map<Lugar, Boolean> lugarPokebolas = estadoAmb.getLugarPokebolas();
        for (Lugar lugarAdy: adyacencias) {
            lugarPokebolasAdyacentes.put(lugarAdy, lugarPokebolas.get(lugarAdy));
        }

    }

    /**
     * Metodo para representar como string la percepcion.
     */
    @Override
    public String toString() {
        String str = "";
        for (var par: lugarPokemonesAdversariosAdyacentes.entrySet()) {
            str += "/n" + par.getKey().toString() + " : " + par.getValue() == null ? "no hay enemigo" : par.getValue().toString() +
                    ", pokebola: " + lugarPokebolasAdyacentes.get(par.getKey());
        }
        return str;
    }

    public Map<Lugar, Adversario> getLugarPokemonesAdversariosAdyacentes() {
        return lugarPokemonesAdversariosAdyacentes;
    }

    public void setLugarPokemonesAdversariosAdyacentes(Map<Lugar, Adversario> lugarPokemonesAdversariosAdyacentes) {
        this.lugarPokemonesAdversariosAdyacentes = lugarPokemonesAdversariosAdyacentes;
    }

    public Map<Lugar, Boolean> getLugarPokebolasAdyacentes() {
        return lugarPokebolasAdyacentes;
    }

    public void setLugarPokebolasAdyacentes(Map<Lugar, Boolean> lugarPokebolasAdyacentes) {
        this.lugarPokebolasAdyacentes = lugarPokebolasAdyacentes;
    }
}
