package agent;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class PokemonHeuristic implements IEstimatedCostFunction {
    @Override
    public double getEstimatedCost(NTree node) {
        return ((PokemonAgentState) node.getAgentState()).getCantidadPokemonesAdversarios();
    }
}
