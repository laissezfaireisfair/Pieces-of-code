package Player;

import Game.Decision;

public interface IPlayerPlayFacade {
    Decision MakeDecision(int rivalId);

    void StoreDecision(int rivalId, Decision decision);

    void UpdateScore(int delta, int rivalId);

    int GetId();

    String GetName();

    Decision GetLastDecision(int rivalId);

    int GetScore();

    int GetLastDelta(int rivalId);
}
