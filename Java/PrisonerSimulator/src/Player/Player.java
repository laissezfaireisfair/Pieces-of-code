package Player;

import Game.Decision;
import Player.Strategy.IStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements IPlayerPlayFacade, IPlayerStrategyFacade {
    //region PrivatePart
    private final int id;

    private final String name;

    private final Map<Integer, List<Decision>> myDecisionsByRivalId;

    private final Map<Integer, List<Decision>> rivalDecisionsById;

    private final Map<Integer, Integer> lastDeltaById;
    private final IStrategy strategy;
    private int score;
    //endregion

    public Player(int id, String name, IStrategy strategy) {
        this.id = id;
        this.name = name;
        this.strategy = strategy;
        myDecisionsByRivalId = new HashMap<>();
        rivalDecisionsById = new HashMap<>();
        lastDeltaById = new HashMap<>();
        score = 0;
    }

    @Override
    public Decision makeDecision(int rivalId) {
        var decision = strategy.MakeDecision(this, rivalId);

        if (myDecisionsByRivalId.containsKey(rivalId)) {
            myDecisionsByRivalId.get(rivalId).add(decision);
        } else {
            myDecisionsByRivalId.put(rivalId, new ArrayList<>(List.of(decision)));
        }

        return decision;
    }

    @Override
    public void storeDecision(int rivalId, Decision decision) {
        if (rivalDecisionsById.containsKey(rivalId)) {
            rivalDecisionsById.get(rivalId).add(decision);
        } else {
            rivalDecisionsById.put(rivalId, new ArrayList<>(List.of(decision)));
        }
    }

    @Override
    public void updateScore(int delta, int rivalId) {
        score += delta;

        lastDeltaById.put(rivalId, delta);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Decision getLastDecision(int rivalId) {
        var myDecisions = myDecisionsByRivalId.get(rivalId);
        return myDecisions.get(myDecisions.size() - 1);
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public List<Decision> getMyDecisionsByRivalId(int rivalId) {
        return myDecisionsByRivalId.get(rivalId);
    }

    @Override
    public List<Decision> getRivalDecisionsById(int rivalId) {
        return rivalDecisionsById.get(rivalId);
    }

    @Override
    public int getLastDelta(int rivalId) {
        if (!lastDeltaById.containsKey(rivalId)) return 0;

        return lastDeltaById.get(rivalId);
    }
}
