package agent;

import actions.EscaparA;
import actions.MoverseA;
import actions.Pelear;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class PokemonCostFunction implements IStepCostFunction {

    @Override
    public double calculateCost(NTree node) {
        double cost = 0.0;

        if (node.getAction() instanceof Pelear)
            cost = 1.0;
        else if (node.getAction() instanceof MoverseA)
            cost = 3.0;
        else if (node.getAction() instanceof EscaparA)
            cost = 5.0;

        //    ConsumirPokebola, HabilitarAtaqueEspecial_i y USarAtaqueEspecial_i
        //    no tienen costo

        return cost;// + node.getParent().getCost();
    }
}
