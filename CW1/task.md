Потрібно змоделювати просту систему оформлення замовлення доставки їжі: піца, напої, кошик замовлення.

Готовий проект запушити на GitHub та скинути посилання на репозиторій на пошту hodovychenko@op.edu.ua
---

### Завдання 1. Базовий тип товару

1. Створіть абстрактний клас `Product` з полями:

   * `String name`
   * `double price`

   і методами:

   * конструктор для задання `name` і `price`
   * `getName()`, `getPrice()`
   * абстрактний метод

     ```java
     public abstract String getInfo();
     ```

2. Створіть клас `Pizza`, який наслідує `Product`.

   Додатково:

   * поле `String size` (наприклад `"Small"`, `"Medium"`, `"Large"`)

   Реалізуйте:

   ```java
   @Override
   public String getInfo() {
       // приклад формату:
       // "Pizza Margherita (Large) - 189.0 UAH"
   }
   ```

3. Створіть клас `Drink`, який наслідує `Product`.

   Додатково:

   * поле `boolean isCold` (true = холодний напій, false = гарячий)

   Реалізуйте:

   ```java
   @Override
   public String getInfo() {
       // приклад формату:
       // "Cola [cold] - 45.0 UAH"
       // "Tea [hot] - 30.0 UAH"
   }
   ```

Після цього пункту у вас має бути ієрархія:
`Product` ← `Pizza`, `Drink`.

---

### Завдання 2. Знижки через інтерфейс

1. Створіть інтерфейс `Discountable`:

   ```java
   public interface Discountable {
       double applyDiscount(double percent);
   }
   ```

   `percent` — це відсоток знижки. Наприклад, 10 означає мінус 10%.

2. Зробіть так, щоб `Pizza` і `Drink` реалізовували цей інтерфейс.

   Усередині `applyDiscount`:

   * вирахуйте нову ціну з урахуванням знижки;
   * поле `price` змінювати не обовʼязково, достатньо просто повернути значення.

   Формула:

   ```java
   newPrice = price - (price * percent / 100.0);
   ```

---

### Завдання 3. Узагальнений кошик (дженерік + масив)

Створіть дженерік-клас `Cart<T>` БЕЗ колекцій.

Вимоги до `Cart<T>`:

1. Поля:

   ```java
   private T[] items;
   private int count; // скільки реально елементів додано
   ```

   Пояснення:

   * `items` — масив фіксованого розміру (наприклад, на 10 елементів).
   * `count` — скільки елементів уже є в кошику.

2. Конструктор без параметрів:

   * створює масив на 10 елементів.
   * `count` = 0.

   Приклад ідеї:

   ```java
   public Cart() {
       items = (T[]) new Object[10]; // попередження компілятора ок
       count = 0;
   }
   ```

3. Метод додавання елементу:

   ```java
   public void addItem(T item) {
       // покласти item в масив, якщо є місце
       // збільшити count
   }
   ```

   Якщо масив уже заповнений — можна просто нічого не додавати (або вивести повідомлення в консоль). Розширювати масив не треба.

4. Метод отримання кількості:

   ```java
   public int getCount() {
       return count;
   }
   ```

5. Метод друку вмісту кошика з використанням лямбди:

   ```java
   public String printCart(java.util.function.Function<T, String> formatter) {
       // сформувати один довгий текст:
       // кожен елемент з нового рядка
       // рядок про елемент беремо через formatter.apply(...)
       // повернути підсумковий рядок
   }
   ```

   Пояснення:

   * `Function<T,String>` — це стандартний функціональний інтерфейс з одним методом `apply(T value)`, який повертає рядок.
   * Тобто ми дозволяємо "налаштувати", як саме виводити елемент.

---

### Завдання 4. Перевірка роботи (main)

Створіть клас `Main` з методом `public static void main(String[] args)` і там зробіть:

1. Створіть кілька товарів:

   ```java
   Pizza p1 = new Pizza("Margherita", 189.0, "Large");
   Pizza p2 = new Pizza("Pepperoni", 210.0, "Medium");

   Drink d1 = new Drink("Cola", 45.0, true);
   Drink d2 = new Drink("Tea", 30.0, false);
   ```

2. Покажіть знижку:

   ```java
   double newPrice = p1.applyDiscount(10); // 10%
   System.out.println("Price after discount: " + newPrice);
   ```

3. Створіть два кошики:

   ```java
   Cart<Pizza> pizzaCart = new Cart<>();
   Cart<Drink> drinkCart = new Cart<>();
   ```

4. Додайте товари:

   ```java
   pizzaCart.addItem(p1);
   pizzaCart.addItem(p2);

   drinkCart.addItem(d1);
   drinkCart.addItem(d2);
   ```

5. Надрукуйте вміст кожного кошика, використовуючи ЛЯМБДИ:

   ```java
   String pizzasText = pizzaCart.printCart(
       item -> item.getInfo()
   );

   String drinksText = drinkCart.printCart(
       drink -> "Drink: " + drink.getInfo()
   );

   System.out.println("=== Pizza cart ===");
   System.out.println(pizzasText);

   System.out.println("=== Drink cart ===");
   System.out.println(drinksText);
   ```

6. Виведіть кількість елементів:

   ```java
   System.out.println("Pizza count = " + pizzaCart.getCount());
   System.out.println("Drink count = " + drinkCart.getCount());
   ```

---