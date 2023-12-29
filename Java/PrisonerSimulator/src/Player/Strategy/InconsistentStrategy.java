package Player.Strategy;

import Game.Decision;
import Player.IPlayerStrategyFacade;

import java.util.List;
import java.util.Optional;

public class InconsistentStrategy implements IStrategy {
    @Override
    public Decision MakeDecision(IPlayerStrategyFacade player, int rivalId) {
        var myDecisions = player.getMyDecisionsByRivalId(rivalId);
        if (Optional.ofNullable(myDecisions).map(List::isEmpty).orElse(true)) return Decision.Cooperate;

        return myDecisions.get(myDecisions.size() - 1) == Decision.Cooperate ? Decision.Defect : Decision.Cooperate;
    }
}
