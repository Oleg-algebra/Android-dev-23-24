1. Опишіть клас Фігура, що інкапсулює основні геометричні характеристики та методи. Для фігури визначено методи:
    
    •    dimention() – що повертає вимірність фігури (двовимірна чи три¬вимірна).

    •    perimetr() – що повертає периметр фігури (для три-вимірних фігур метод має породжувати виключення або повертати None).
      
    •    square() – що повертає площу фігури (для три-вимірних фігур метод має породжувати виключення або повертати None).
      
    •    squareSurface() – що повертає площу бічної фігури (для дво-вимірних фігур метод має породжувати виключення або повертати None).
    
    •    squareBase() – що повертає площу основи фігури (для дво-вимірних фігур метод має породжувати виключення або повертати None).
    
    •    height() – що повертає висоту фігури (для дво-вимірних фігур метод має породжувати виключення або повертати None).
      
    •    volume() –метод, що обчислює міру фігури (для плоскої фігури – площу, для об’ємної – відповідно об’єм).
      
    Від класу Фігура (або його нащадків) наслідуються такі класи
    
    •    Трикутник – визначається довжинами трьох сторін.

    •    Прямокутник – визначається двома сторонами
      
    •    Трапеція – визначається двома основами та двома бічними сторонами.

    •    Паралелограм – визначається двома сторонами та висотою.
    
    •    Круг – визначається радіусом.
    
    •    Куля – визначається радіусом.

    •    Трикутна піраміда – підклас класу Трикутник – моделює правильну трикутну піраміду, в основі якої лежить правильний трикутник – визначається довжиною сторони основи та висотою.

    •    Чотирикутна піраміда – підклас класу Прямокутник – моделює правильну чотирикутну піраміду, в основі якої лежить прямокутник –визначається довжинами сторін основи та висотою.

    •    Прямокутний паралелепіпед – підклас класу Прямокутник – визначається довжинами трьох ребер.

    •    Конус – підклас класу Круг – моделює правильний конус – визначається радіусом основи та висотою.

    •    Трикутна призма – підклас класу Трикутник – моделює пряму призму в основі якої лежить трикутник – визначається довжинами трьох сторін та висотою.
2. Нехай дано список фігур. Серед заданих фігур, знайдіть фігуру, міра якої є найбільшою.
      Перелік фігур зберігається у текстовому файлі – у кожному окремому рядку файла вказується назва фігури та список параметрів, що визначають фігуру відповідно до зазначеного вище. 
      Параметри розділені одним або кількома символами пропуску. Назви фігур вказані таким чином: 
    Triangle – Трикутник, Rectangle – Прямокутник, Trapeze – Трапеція, Parallelogram – Паралелограм, 
    Circle – Круг, Ball – Куля, TriangularPyramid – Трикутна піраміда, QuadrangularPyramid – Чотирикутна піраміда, 
    RectangularParallelepiped - Прямокутний паралелепіпед, Cone – Конус, TriangularPrism – Трикутна призма.

3. Відповіді до задачі:
   ==============src\resourses\input01.txt===============\
   Incorrect parameters amount: 19 \
   2D figure with max square: Trapeze(base1=6.0, base2=15.0, lateral1=20.0, lateral2=7.0) \
   3D figure with max volume: Ball(radius=25.0) \
   ==============src\resourses\input02.txt=============== \
   Incorrect parameters amount: 95 \
   2D figure with max square: Trapeze(base1=8.0, base2=8.0, lateral1=18.0, lateral2=18.0) \
   3D figure with max volume: Ball(radius=25.0) \
   ==============src\resourses\input03.txt=============== \
   Incorrect parameters amount: 184 \
   2D figure with max square: Trapeze(base1=11.0, base2=14.0, lateral1=15.0, lateral2=20.0) \
   3D figure with max volume: Ball(radius=25.0)