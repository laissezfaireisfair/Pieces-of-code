package Game;

import java.util.ArrayList;
import java.util.List;

public class Configurator {
    //region PrivatePart
    private static Configurator instance = null;

    private int roundsCount = 5;

    private int cooperationReward = 5;

    private int cooperationFine = 10;

    private int defectReward = 10;

    private int defectFine = 7;

    private List<String> strategyNames = new ArrayList<>(List.of("KindRepeaterStrategy", "KindRepeaterStrategy", "KindRepeaterStrategy"));
    private String modeName = "fast";

    //endregion

    public static Configurator Instance() {
        if (instance == null) instance = new Configurator();

        return instance;
    }

    public int getRoundsCount() {
        return roundsCount;
    }

    public void setRoundsCount(int roundsCount) {
        this.roundsCount = roundsCount;
    }

    public int getCooperationReward() {
        return cooperationReward;
    }

    public void setCooperationReward(int cooperationReward) {
        this.cooperationReward = cooperationReward;
    }

    public int getCooperationFine() {
        return cooperationFine;
    }

    public void setCooperationFine(int cooperationFine) {
        this.cooperationFine = cooperationFine;
    }

    public int getDefectReward() {
        return defectReward;
    }

    public void setDefectReward(int defectReward) {
        this.defectReward = defectReward;
    }

    public int getDefectFine() {
        return defectFine;
    }

    public void setDefectFine(int defectFine) {
        this.defectFine = defectFine;
    }

    public List<String> getStrategyNames() {
        return strategyNames;
    }

    public void setStrategyNames(List<String> strategyNames) {
        this.strategyNames = strategyNames;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }
}
