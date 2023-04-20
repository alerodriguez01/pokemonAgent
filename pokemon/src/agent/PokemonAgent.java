package agent;

import actions.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import structures.Lugar;
import utilities.Utilities;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokemonAgent extends SearchBasedAgent {

    public PokemonAgent() {
        // El objetivo del Pokemon
        PokemonGoal goal = new PokemonGoal();

        // El estado del agente (inicializacion)
        PokemonAgentState pokemonAgentState = new PokemonAgentState();
        this.setAgentState(pokemonAgentState);

        // Crear los operadores
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new ConsumirPokebola());
        operators.addElement(new HabilitarAtaqueEspecial1());
        operators.addElement(new HabilitarAtaqueEspecial2());
        operators.addElement(new HabilitarAtaqueEspecial3());
        for (Lugar lugar : pokemonAgentState.getLugares()) {
            operators.addElement(new MoverseA(lugar));
            operators.addElement(new EscaparA(lugar));
        }
        operators.addElement(new Pelear());
        operators.addElement(new UsarAtaqueEspecial1());
        operators.addElement(new UsarAtaqueEspecial2());
        operators.addElement(new UsarAtaqueEspecial3());

        // Crear el problema que resolvera el Pokemon
        Problem problem = new Problem(goal, pokemonAgentState, operators);
        this.setProblem(problem);
    }

    /**
     * Este metodo es ejecutado por el simulador para darle la percepcion
     * al agente.
     * Con esto, el actualiza el estado del agente.
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

    /**
     * Este metodo es ejecutado por el simulador para preguntarle al agente por una accion.
     */
    @Override
    public Action selectAction() {
        // Create the search strategy
        DepthFirstSearch strategy = new DepthFirstSearch();

        /**
         * Another search strategy examples:
         *
         * Depth First Search:
         * DepthFirstSearch strategy = new DepthFirstSearch();
         *
         * Breath First Search:
         * BreathFirstSearch strategy = new BreathFirstSearch();
         *
         * Uniform Cost:
         * IStepCostFunction costFunction = new CostFunction();
         * UniformCostSearch strategy = new UniformCostSearch(costFunction);
         *
         * A Star Search:
         * IStepCostFunction cost = new CostFunction();
         * IEstimatedCostFunction heuristic = new Heuristic();
         * AStarSearch strategy = new AStarSearch(cost, heuristic);
         *
         * Greedy Search:
         * IEstimatedCostFunction heuristic = new Heuristic();
         * GreedySearch strategy = new GreedySearch(heuristic);
         */

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(PokemonAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
    }
}
