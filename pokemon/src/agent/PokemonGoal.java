package agent;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class PokemonGoal  extends GoalTest {
    @Override
    public boolean isGoalState(AgentState agentState) {
        PokemonAgentState state = (PokemonAgentState) agentState;
        return state.isMaestroFueDerrotado() && state.getCantidadPokemonesAdversarios() == 0;
    }
}
