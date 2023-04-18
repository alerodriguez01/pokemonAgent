package agent;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class PokemonGoal  extends GoalTest {
    @Override
    public boolean isGoalState(AgentState agentState) {
        // Retornar la prueba de meta
        return false;
    }
}
