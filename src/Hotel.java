public class Hotel {
    private String name;
    private int occupiedPlaces;
    private int totalPlaces;
    private int dailyRate; // свойство только для записи (нет геттера)

    public Hotel() { }

    public Hotel(String name, int occupiedPlaces, int totalPlaces, int dailyRate) {
        setName(name);
        setTotalPlaces(totalPlaces);
        setOccupiedPlaces(occupiedPlaces);
        setDailyRate(dailyRate);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Ошибка: название гостиницы пустое!");
            return;
        }
        this.name = name.trim();
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

    // write-only: геттера нет
    public void setDailyRate(int dailyRate) {
        if (dailyRate < 0) {
            System.out.println("Ошибка: стоимость за день не может быть отрицательной");
            this.dailyRate = 0;
            return;
        }
        this.dailyRate = dailyRate;
    }

    // Геттеры для удобства (кроме dailyRate)
    public String getName() { return name; }
    public int getOccupiedPlaces() { return occupiedPlaces; }
    public int getTotalPlaces() { return totalPlaces; }

    /** Выручка за 1 день */
    public long computeDailyRevenue() {
        return (long) occupiedPlaces * (long) dailyRate;
    }

    /** Общая выручка за N дней (N ≥ 0) */
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
