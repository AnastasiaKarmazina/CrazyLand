package utils;

import java.util.Scanner;

public class OptionValidator {
    public static int validateOptionInput(Scanner scanner) {

        int[] options = {0, 1, 2};

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_NUMBER_MSG, str);
        }
        int inputData = scanner.nextInt();
        while (!contains(options, inputData)) {
            System.out.println(Constants.NO_SUCH_OPTION_MSG);
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf(Constants.NAN_NUMBER_MSG, str);
            }
            inputData = scanner.nextInt();
        }
        return inputData;
    }
    public static boolean contains(final int[] array, final int value) {
        boolean result = false;
        for (int i : array) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
