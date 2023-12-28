package Game;

public enum Decision {
    Cooperate,
    Defect;

    public String toString() {
        switch (this) {
            case Cooperate:
                return "Cooperate";
            case Defect:
                return "Defect";
        }
        return "Unknown decision";
    }
}
