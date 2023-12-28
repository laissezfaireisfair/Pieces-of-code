package Game;

public class GameRules {
    //region PrivatePart
    private final int roundsCount;
    private final int cooperationReward;
    private final int cooperationFine;
    private final int defectFine;
    private final int defectReward;
    //endregion

    public GameRules(int roundsCount, int cooperationReward, int cooperationFine, int defectFine, int defectReward) {
        this.roundsCount = roundsCount;
        this.cooperationReward = cooperationReward;
        this.cooperationFine = cooperationFine;
        this.defectFine = defectFine;
        this.defectReward = defectReward;
    }

    public int getRoundsCount() {
        return roundsCount;
    }

    public int getCooperationReward() {
        return cooperationReward;
    }

    public int getCooperationFine() {
        return cooperationFine;
    }

    public int getDefectFine() {
        return defectFine;
    }

    public int getDefectReward() {
        return defectReward;
    }
}
