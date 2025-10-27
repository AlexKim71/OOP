package ua.opnu.java.inheritance.bill;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    // Метод для конвертації double в BigDecimal з точністю 15 знаків
    private BigDecimal toBigDecimal(double value) {
        return BigDecimal.valueOf(value).setScale(15, RoundingMode.HALF_UP);
    }

    @Override
    public double getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Item i : getItems()) {
            total = total.add(toBigDecimal(i.getPriceWithDiscount(regularCustomer)));
        }
        return total.doubleValue();
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
        BigDecimal totalDiscount = BigDecimal.ZERO;
        for (Item i : getItems()) {
            totalDiscount = totalDiscount.add(toBigDecimal(i.getDiscount()));
        }
        return totalDiscount.doubleValue();
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        BigDecimal fullPrice = BigDecimal.ZERO;
        BigDecimal discountedPrice = BigDecimal.ZERO;
        for (Item i : getItems()) {
            fullPrice = fullPrice.add(toBigDecimal(i.getPrice()));
            discountedPrice = discountedPrice.add(toBigDecimal(i.getPriceWithDiscount(true)));
        }
        if (fullPrice.compareTo(BigDecimal.ZERO) == 0) return 0.0;
        BigDecimal percent = BigDecimal.valueOf(100.0)
                .subtract(discountedPrice.multiply(BigDecimal.valueOf(100.0)).divide(fullPrice, 15, RoundingMode.HALF_UP));
        return percent.doubleValue();
    }
}
