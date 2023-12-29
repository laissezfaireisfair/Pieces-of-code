package Player.Strategy;

import Game.Decision;
import Player.IPlayerStrategyFacade;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class KindForgivingRepeaterStrategy implements IStrategy {
    private final Random random;
    private static final int FORGIVE_THRESHOLD = 5;

    public KindForgivingRepeaterStrategy() {
        random = new Random();
    }

    @Override
    public Decision MakeDecision(IPlayerStrategyFacade player, int rivalId) {
        var rivalDecisions = player.getRivalDecisionsById(rivalId);
        if (Optional.ofNullable(rivalDecisions).map(List::isEmpty).orElse(true))
            return Decision.Cooperate;

        var lastRivalDecision = rivalDecisions.get(rivalDecisions.size() - 1);
        if (lastRivalDecision == Decision.Defect)
        {
            var diceResult = random.nextInt(6) + 1;
            if (diceResult >= FORGIVE_THRESHOLD)
                return Decision.Cooperate;
        }

        return lastRivalDecision;
    }
}
