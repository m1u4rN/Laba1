import java.util.Scanner;

public class Main {
    // Чтение неотрицательного целого числа
    private static int readNonNegativeInt(Scanner in, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            System.out.flush();
            String line = in.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Пусто. Введите целое число ≥ 0.");
                continue;
            }
            if (!line.matches("\\d+")) {
                System.out.println("Ошибка: нужно целое число без знаков.");
                continue;
            }
            try {
                value = Integer.parseInt(line);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Слишком большое число (макс 2147483647).");
            }
        }
    }

    // Чтение строки (не пустой)
    private static String readNonEmptyString(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            System.out.flush();
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Пусто. Введите непустое значение.");
                continue;
            }
            return line;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Hotel hotel = new Hotel();

        // Название
        String name = readNonEmptyString(in, "Введите название гостиницы: ");
        hotel.setName(name);

        // Общее число мест
        int total = readNonNegativeInt(in, "Введите общее число мест (≥ 0): ");
        hotel.setTotalPlaces(total);

        // Число заселённых мест (должно быть ≤ total)
        int occupied;
        while (true) {
            occupied = readNonNegativeInt(in, "Введите число заселённых мест (0.." + total + "): ");
            if (occupied > total) {
                System.out.println("Ошибка: заселённых мест не может быть больше общего числа (" + total + ").");
                continue;
            }
            break;
        }
        hotel.setOccupiedPlaces(occupied);

        // Стоимость за день (write-only свойство)
        int rate = readNonNegativeInt(in, "Введите стоимость проживания за день (руб., ≥ 0): ");
        hotel.setDailyRate(rate);

        // На сколько дней посчитать выручку
        int days = readNonNegativeInt(in, "Введите число дней для расчёта общей выручки (≥ 0): ");

        System.out.println();
        hotel.print();
        System.out.println("Выручка за " + days + " дн.: " + hotel.computeRevenueForDays(days) + " руб.");

        in.close();
    }
}
