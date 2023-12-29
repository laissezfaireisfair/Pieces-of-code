import Game.Configurator;
import Game.Game;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int MIN_ARGUMENTS = 3;

    public static void main(String[] args) {
        if (args.length < MIN_ARGUMENTS) {
            System.out.printf("Not enough arguments, expected at least %d, got: %d", MIN_ARGUMENTS, args.length);
            return;
        }

        try {
            ejectNamesFromArguments(args);
            ejectModeFromArguments(args);
            ejectStepsFromArguments(args);
            ejectMatrixFromArguments(args);
        } catch (Exception exception) {
            System.out.printf("Getting input failed: %s", exception.getMessage());
            return;
        }

        var game = new Game();

        try {
            game.run();
        } catch (Exception exception) {
            System.out.printf("Exception. End of simulation.\nDetails: %s %s\n", exception, exception.getMessage());
            for (var traceEntry : exception.getStackTrace())
                System.out.println(traceEntry);
        }
    }

    //region PrivatePart
    private static void ejectNamesFromArguments(String[] args) {
        var names = Arrays.stream(args).filter((a) -> !a.startsWith("--")).collect(Collectors.toList());
        Configurator.Instance().setStrategyNames(names);
    }

    private static void ejectModeFromArguments(String[] args) {
        var mode = Arrays.stream(args).filter((a) -> a.startsWith("--mode=")).findAny();

        if (mode.isEmpty()) return;

        var modeParsed = mode.get().substring(7);

        Configurator.Instance().setModeName(modeParsed);
    }

    private static void ejectStepsFromArguments(String[] args) {
        var steps = Arrays.stream(args).filter((a) -> a.startsWith("--steps=")).findAny();

        if (steps.isEmpty()) return;

        var stepsParsed = Integer.parseInt(steps.get().substring(8));

        Configurator.Instance().setRoundsCount(stepsParsed);
    }

    private static void ejectMatrixFromArguments(String[] args) throws IOException {
        var matrixPath = Arrays.stream(args).filter((a) -> a.startsWith("--matrix=")).findAny();

        if (matrixPath.isEmpty()) return;

        var file = new File(matrixPath.get());
        try (var scanner = new Scanner(file)) {
            var cooperationReward = scanner.nextInt();
            var cooperationFine = scanner.nextInt();
            var defectReward = scanner.nextInt();
            var defectFine = scanner.nextInt();

            Configurator.Instance().setCooperationReward(cooperationReward);
            Configurator.Instance().setCooperationFine(cooperationFine);
            Configurator.Instance().setDefectReward(defectReward);
            Configurator.Instance().setDefectFine(defectFine);
        }
    }
    //endregion
}