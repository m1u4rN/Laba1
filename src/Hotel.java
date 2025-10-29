public class Hotel {
    private String name;
    private int occupiedPlaces;
    private int totalPlaces;
    private int dailyRate;

    public Hotel() { }

    public Hotel(String name, int occupiedPlaces, int totalPlaces, int dailyRate) {
        setName(name);
        setTotalPlaces(totalPlaces);
        setOccupiedPlaces(occupiedPlaces);
        setDailyRate(dailyRate);
    }

    public void setName(String name) {
        if (name == null) {
            System.out.println("Ошибка: название гостиницы пустое!");
            return;
        }

        String trimmed = name.trim();
        if (trimmed.isEmpty()) {
            System.out.println("Ошибка: название гостиницы пустое!");
            return;
        }

        // Проверка: только буквы и пробелы
        if (!trimmed.matches("[\\p{L}\\s]+")) {
            System.out.println("Ошибка: название гостиницы должно содержать только буквы (и пробелы).");
            return;
        }

        this.name = trimmed;
    }

    public void setTotalPlaces(int totalPlaces) {
        if (totalPlaces < 0) {
            System.out.println("Ошибка: общее число мест не может быть отрицательным");
            this.totalPlaces = 0;
            return;
        }
        this.totalPlaces = totalPlaces;
        if (occupiedPlaces > totalPlaces) {
            System.out.println("Предупреждение: заселённых мест больше, чем всего. Ставлю " + totalPlaces + ".");
            occupiedPlaces = totalPlaces;
        }
    }

    public void setOccupiedPlaces(int occupiedPlaces) {
        if (occupiedPlaces < 0) {
            System.out.println("Ошибка: число заселённых мест не может быть отрицательным");
            this.occupiedPlaces = 0;
            return;
        }
        if (occupiedPlaces > totalPlaces) {
            System.out.println("Ошибка: заселённых мест не может быть больше общего числа (" + totalPlaces + ")");
            this.occupiedPlaces = totalPlaces;
            return;
        }
        this.occupiedPlaces = occupiedPlaces;
    }

    public void setDailyRate(int dailyRate) {
        if (dailyRate < 0) {
            System.out.println("Ошибка: стоимость за день не может быть отрицательной");
            this.dailyRate = 0;
            return;
        }
        this.dailyRate = dailyRate;
    }

    public String getName() {
        return name;
    }

    public int getOccupiedPlaces() {
        return occupiedPlaces;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public long computeDailyRevenue() {
        return (long) occupiedPlaces * (long) dailyRate;
    }

    public long computeRevenueForDays(int days) {
        if (days < 0) {
            System.out.println("Ошибка: число дней не может быть отрицательным");
            return 0L;
        }
        return computeDailyRevenue() * (long) days;
    }

    public void print() {
        System.out.println("Гостиница: " + name);
        System.out.println("Заселено: " + occupiedPlaces + " из " + totalPlaces);
        System.out.println("Выручка за день: " + computeDailyRevenue() + " руб.");
    }
}
