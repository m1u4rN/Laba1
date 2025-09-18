
public class Hotel {
    private String name;          // название гостиницы
    private int occupiedBeds;     // заселённых мест
    private int totalBeds;        // всего мест
    private double paymentPerDay; // оплата за день (write-only свойство)

    public Hotel(String name, int occupiedBeds, int totalBeds, double paymentPerDay) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Название гостиницы не может быть пустым.");
        if (totalBeds < 0)
            throw new IllegalArgumentException("Общее число мест не может быть отрицательным.");
        if (occupiedBeds < 0)
            throw new IllegalArgumentException("Число заселённых не может быть отрицательным.");
        if (occupiedBeds > totalBeds)
            throw new IllegalArgumentException("Заселённых больше, чем всего мест.");
        if (paymentPerDay < 0)
            throw new IllegalArgumentException("Оплата за день не может быть отрицательной.");

        this.name = name;
        this.occupiedBeds = occupiedBeds;
        this.totalBeds = totalBeds;
        this.paymentPerDay = paymentPerDay;
    }

    // --- Геттеры (свойства для чтения) ---
    public String getName() { return name; }
    public int getOccupiedBeds() { return occupiedBeds; }
    public int getTotalBeds() { return totalBeds; }

    // Кол-во свободных мест
    public int getFreeBeds() { return totalBeds - occupiedBeds; }

    // --- Свойство ТОЛЬКО ДЛЯ ЗАПИСИ ---
    // Нет getPaymentPerDay(), только setter -> write-only
    public void setPaymentPerDay(double paymentPerDay) {
        if (paymentPerDay < 0)
            throw new IllegalArgumentException("Оплата за день не может быть отрицательной.");
        this.paymentPerDay = paymentPerDay;
    }

    // Метод: общая выручка за заданное число дней
    public double calculateRevenue(int days) {
        if (days < 0)
            throw new IllegalArgumentException("Число дней не может быть отрицательным.");
        return occupiedBeds * paymentPerDay * days;
    }
}
