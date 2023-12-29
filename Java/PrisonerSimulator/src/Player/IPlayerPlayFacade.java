package Player;

import Game.Decision;

public interface IPlayerPlayFacade {
    Decision makeDecision(int rivalId);

    void storeDecision(int rivalId, Decision decision);

    void updateScore(int delta, int rivalId);

    int getId();

    String getName();

    Decision getLastDecision(int rivalId);

    int getScore();

    int getLastDelta(int rivalId);
}
