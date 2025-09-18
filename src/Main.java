// Main.java
public class Main {
    public static void main(String[] args) {
        Hotel h = new Hotel("Sunrise Hotel", 80, 100, 50.0);

        System.out.println("Гостиница: " + h.getName());
        System.out.println("Заселено/Всего: " + h.getOccupiedBeds() + "/" + h.getTotalBeds());
        System.out.println("Свободно мест: " + h.getFreeBeds());

        double revenue3days = h.calculateRevenue(3);
        System.out.println("Выручка за 3 дня: " + revenue3days);

        // Покажем свойство «только для записи»: меняем цену, но прочитать её нельзя
        h.setPaymentPerDay(60.0);
        System.out.println("Выручка за 3 дня (после смены цены): " + h.calculateRevenue(3));
    }
}
