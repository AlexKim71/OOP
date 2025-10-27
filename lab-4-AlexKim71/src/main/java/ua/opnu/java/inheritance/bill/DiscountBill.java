package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item item) {
        super.add(item);
    }

    // Метод для округлення до 13 знаків після коми
    private double round(double value) {
        return Math.round(value * 1_000_000_000_000.0) / 1_000_000_000_000.0;
    }

    @Override
    public double getTotal() {
        double total = 0.0;
        for (Item i : getItems()) {
            total += i.getPriceWithDiscount(regularCustomer);
        }
        return round(total);
    }

    public int getDiscountCount() {
        if (!regularCustomer) return 0;
        int count = 0;
        for (Item i : getItems()) {
            if (i.getDiscount() > 0.0) count++;
        }
        return count;
    }

    public double getDiscountAmount() {
        if (!regularCustomer) return 0.0;
        double totalDiscount = 0.0;
        for (Item i : getItems()) {
            totalDiscount += i.getDiscount();
        }
        return round(totalDiscount);
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double fullPrice = 0.0;
        double discountedPrice = 0.0;
        for (Item i : getItems()) {
            fullPrice += i.getPrice();
            discountedPrice += i.getPriceWithDiscount(true);
        }
        if (fullPrice == 0) return 0.0;
        double percent = 100.0 - (discountedPrice * 100.0 / fullPrice);
        return round(percent);
    }
}
