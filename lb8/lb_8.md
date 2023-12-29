
1. **Чим інтерфейс Set відрізняється від інтерфейсів Collection та List?**
   - **Collection**: Це базовий інтерфейс для управління групою об'єктів. Не визначає конкретні порядки для елементів.
   - **List**: Розширює інтерфейс Collection та визначає структуру у вигляді списку (список з повторенням, з індексацією).
   - **Set**: Теж розширює інтерфейс Collection, але визначає унікальні елементи без порядку.

2. **HashSet відрізняється від TreeSet?**
   - **HashSet**: Зберігає елементи у хеш-таблиці, не гарантує жодного порядку.
   - **TreeSet**: Зберігає елементи у відсортованому стані (на основі порівнянь або при заданні компаратора).

3. **Що таке хешування, хеш, хеш-код, хеш-функція?**
   - **Хешування**: Це процес перетворення вхідних даних будь-якого об'єкта у фіксований розмірний рядок (хеш).
   - **Хеш (hash)**: Фіксований розмірний рядок, отриманий в результаті хешування.
   - **Хеш-код (hash code)**: Це числова представленість хешу, отримана за допомогою хеш-функції.
   - **Хеш-функція**: Алгоритм, який перетворює вхідні дані в хеш.

4. **Яким вимогам має відповідати коректна хеш-функція?**
   - Кожному об'єкту повинен відповідати унікальний хеш-код.
   - Повинна бути ефективною з точки зору часу обчислення.
   - Має гарантувати рівномірну розподіленість хеш-кодів.

5. **Які властивості притаманні хорошій хеш-функції?**
   - **Єфективність**: Швидко обчислюється.
   - **Рівномірність розподілу**: Хеш-коди розподілені рівномірно для різних вхідних даних.
   - **Стійкість до зіткнень**: Мінімізує ймовірність зіткнень (колізій) для різних об'єктів.

6. **Якими критеріями мають відповідати об’єкти для того, щоб посилання на них можна було зберігати у HashSet?**
   - Повинні правильно визначати методи `equals` та `hashCode`.
   - Мають бути імутабельними (незмінними), якщо вони використовуються як ключі.

7. **Які є переваги/недоліки використання HashSet у порівнянні з TreeSet?**
   - **HashSet**:
      - **Переваги**: Швидкий доступ, додавання та видалення елементів.
      - **Недоліки**: Не впорядкований, не сортований.
   - **TreeSet**:
      - **Переваги**: Елементи зберігаються в порядку сортування.
      - **Недоліки**: Операції додавання та видалення менш ефективні.

8. **Чим поняття size відрізняється від capacity? Чи може size бути більший за capacity? Чи може capacity бути більший за size? Якщо так, то за яких умов?**
   - **Size**: Кількість елементів в колекції.
   - **Capacity**: Розмір фізичної структури даних, яка зберігає колекцію (наприклад, у хеш-таблиці).
   - **Size більший за capacity**: Ні, size не може бути більшим за capacity.
   - **Capacity більший за size**: Так, наприклад, коли розмір хеш-таблиці збільшується (resize).

9. **Що таке load factor та на що і як він впливає?**
   - **Load Factor**: Це відношення кі

лькості елементів до розміру таблиці.
   - **Вплив**: Чим менший load factor, тим менше ймовірність зіткнень, але більше використовується пам'яті. Збільшення load factor може призвести до зіткнень, але зменшить використання пам'яті.

10. **Що таке асоціативний масив? Чим ключ відрізняється від значення?**
    - **Асоціативний масив**: Структура даних, яка відображає ключі на значення.
    - **Ключ**: Унікальний ідентифікатор елемента у масиві (визначає порядок).
    - **Значення**: Дані, пов'язані з ключем.

11. **Чи може в асоціативному масиві зберігатись кілька однакових ключів або однакових значень?**
    - **Ключі**: В асоціативному масиві ключі повинні бути унікальними.
    - **Значення**: Значення можуть повторюватись.

12. **До яких наслідків може привести зберігання неімутабельних об’єктів у HashSet, у HashMap в якості ключа та у HashMap в якості значення?**
    - Зміни в неімутабельних об'єктах можуть призвести до непередбачуваної поведінки в колекціях. Це може призвести до невірного розташування об'єкта в колекції або навіть до втрати об'єкта.

13. **Чи можуть об’єкти без інтерфейсу Comparable зберігатись у TreeMap?**
    - Об'єкти без інтерфейсу Comparable можуть зберігатись у TreeMap, якщо в конструкторі TreeMap вказано компаратор.

14. **Чи можуть об’єкти без інтерфейсу Comparable зберігатись у HashMap? Чи взагалі впливає на щось наявність у об’єктів інтерфейсу Comparable при зберіганні у HashMap?**
    - Об'єкти без інтерфейсу Comparable можуть зберігатись у HashMap без проблем. Наявність інтерфейсу Comparable не впливає на спроможність об'єктів бути збереженими у HashMap.