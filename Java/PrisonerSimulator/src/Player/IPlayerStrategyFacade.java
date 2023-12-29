package Player;

import Game.Decision;

import java.util.List;

public interface IPlayerStrategyFacade {
    int getScore();

    List<Decision> getMyDecisionsByRivalId(int rivalId);

    List<Decision> getRivalDecisionsById(int rivalId);
}
