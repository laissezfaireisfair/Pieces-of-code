package Player.Strategy;

import Game.Decision;
import Player.IPlayerStrategyFacade;

import java.util.List;
import java.util.Optional;

public class KindRepeaterStrategy implements IStrategy {
    @Override
    public Decision MakeDecision(IPlayerStrategyFacade player, int rivalId) {
        var rivalDecisions = player.getRivalDecisionsById(rivalId);
        if (Optional.ofNullable(rivalDecisions).map(List::isEmpty).orElse(true))
            return Decision.Cooperate;

        return rivalDecisions.get(rivalDecisions.size() - 1);
    }
}
