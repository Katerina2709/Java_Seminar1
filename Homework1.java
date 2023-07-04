package JavaPr;
// import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
public class Homework1 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите задание:\n1 - Вычислить n-ое треугольное число и факториал n!" +
                    "\n2 - Вывести все простые числа от 1 до 1000\n3 - Калькулятор" +
                    "\n4 - Восстановить уравнение вида q + w = e, где некоторые цифры заменены на '?'\n0 - Выход");
            String task = scan.nextLine();
            switch (task) {
                case "1":
                    task1();
                    break;
                case "2":
                    task2();
                    break;
                case "3":
                    task3();
                    break;
                case "4":
                    task4();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Задание не выбрано");
            }
            if (flag) {
                System.out.println("\nПродолжить?:\n1 - Да\n2 - Нет");
                char choice = scan.nextLine().charAt(0);
                if (choice != '1') flag = false;
            }
        }
    }
        // Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение
        // чисел от 1 до n)

    public static void task1() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите целое положительное число: ");
        if (scn.hasNextInt()) {
            int number = scn.nextInt();
            if (number > 0) {
                int triangle = number * (number + 1) / 2;
                int factorial = 1;
                for (int i = 1; i <= number; i++) {
                    factorial *= i;
                }
                System.out.printf("\n%d-е треугольное число = %d, \n%d! = %d\n",
                        number, triangle, number, factorial);
            } else {
                System.out.println("\nВведено неверное число");
            }
        } else {
            System.out.println("\nВведено неверное число");
        }
    }

    // Вывести все простые числа от 1 до 1000

    public static void task2() {
        int n = 1000;
        System.out.printf("'\nПростые числа от 1 до %d:\n", n);
        for (int i = 2; i <= n; i++) {
            boolean fl = true;
            for (int j = 2; (j < i) && fl; j++) {
                if (i % j == 0) {
                    fl = false;
                }
            }
            if (fl) {
                System.out.printf("%d ", i);
            }
        }
    }

    // Реализовать простой калькулятор

    public static void task3() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        if (scn.hasNextDouble()) {
            double num1 =scn.nextDouble();
            System.out.print("Введите знак операции (+, -, * или /): ");
            char operation = scan.nextLine().charAt(0);
            System.out.print("Введите второе число: ");
            if (scn.hasNextDouble()) {
                double num2 = scn.nextDouble();
                switch (operation) {
                    case '+':
                        System.out.printf("Сумма = %.2f", (num1 + num2));
                        break;
                    case '-':
                        System.out.printf("Разность = %.2f", (num1 - num2));
                        break;
                    case '*':
                        System.out.printf("Произведение = %.2f", (num1 * num2));
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("\nНа 0 делить нельзя");
                            break;
                        }
                        System.out.printf("Частное = %.2f", (num1 / num2));
                        break;
                    default:
                        System.out.println("\nВведен неверный знак операции");
                }
            } else {
                System.out.println("\nВведено неверное число");
            }
        } else {
            System.out.println("\nВведено неверное число");
        }
    }
    // Задано уравнение вида q + w = e, q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
    // Требуется восстановить выражение до верного равенства.
    // Предложить хотя бы одно решение или сообщить, что его нет.
    // Ввод: 2? + ?5 = 69
    // Вывод: 24 + 45 = 69
    // Ввод: 32?0 + 5? = 3?69
    // Вывод: 3210 + 59 = 3269
    public static void task4() {
        String[] partsOfEquation = new String[3];
        Scanner scn = new Scanner(System.in);
        System.out.printf("В уравнении вида q + w = e (q, w, e >= 0) - \nвведите первое слагаемое q: ");
        partsOfEquation[0] = scn.nextLine();
        System.out.printf("введите второе слагаемое w: ");
        partsOfEquation[1] = scn.nextLine();
        System.out.printf("введите значение суммы e: ");
        partsOfEquation[2] = scn.nextLine();
        boolean inputEquation = true;
        //проверка на правильность ввода
        for (String item : partsOfEquation) {
            for (int i = 0; i < item.length() && inputEquation; i++) {
                if (!Character.isDigit(item.charAt(i)) && item.charAt(i) != '?') {
                    inputEquation = false;
                }
            }
            if (!inputEquation) break;
        }
        if (!inputEquation) {
            System.out.println("\nВведены некорректные данные");
        } else {
            System.out.printf("\nРешение уравнения %s + %s = %s: \n", partsOfEquation[0], partsOfEquation[1], partsOfEquation[2]);
            int n1 = partsOfEquation[0].length();
            int n2 = partsOfEquation[1].length();
            int n3 = partsOfEquation[2].length();
            if (n1 < n3) {
               for (int ind1 = 1; ind1 <= (n3-n1); ind1++) {
                   partsOfEquation[0] = "0" +  partsOfEquation[0];
               }
            }
            if (n2 < n3) {
                for (int ind2 = 1; ind2 <= (n3-n2); ind2++) {
                    partsOfEquation[1] = "0" +  partsOfEquation[1];
                }
            }
            String[] temp = partsOfEquation.clone();
            int f = 0;
            boolean result = Poisk1 (partsOfEquation, temp, f);
//            System.out.printf("\nrresult = " + result);
            if (result) {
                System.out.printf("\n   %s + %s = %s\n", temp[0].substring(n3-n1),
                        temp[1].substring(n3-n2), temp[2]);
            } else {
                System.out.println("\nРешения нет");
            }
        }
    }
    public static boolean Poisk1 (String [] partsOfEq, String[] result, int flag1) {
        String q = partsOfEq[0];
        String w = partsOfEq[1];
        String e = partsOfEq[2];
        int n = q.length();
        int res = 0;
        int k = 0;
        int m = 9;
        boolean flagMain = false;
        int i2 = 0;
        if (q.charAt(n - 1) != '?') {
            k = Character.getNumericValue(q.charAt(n - 1));
            m = k;
        }
        for (int i = k; i <= m; i++) {
            int l = 0;
            int p = 9;
            if (w.charAt(n - 1)  != '?') {
                l = Character.getNumericValue(w.charAt(n - 1));
                p = l;
            }
            for (int j = l; j <= p; j++) {
                res = i + j + flag1;
                if (e.charAt(n - 1)  == '?') {
                    flagMain = true;
                    i2 = j;
                    break;
                } else {
                    if (res % 10 == Character.getNumericValue(e.charAt(n - 1))) {
                        flagMain = true;
                        i2 = j;
                        break;
                    }
                }
            }
            if (flagMain) {
                if (res > 9) {
                    flag1 = 1;
                    res = res % 10;
                } else {
                    flag1 = 0;
                }
                FillResult (result, n, i, i2, res);
                break;
            }
        }
//  выход из функции (окончание или рекурсия)
        if (flagMain) {
            n--;
            if (n == 0) return true;
            partsOfEq[0] = q.substring(0, n);
            partsOfEq[1] = w.substring(0, n);
            partsOfEq[2] = e.substring(0, n);
            return Poisk1(partsOfEq, result, flag1);
        }
        return false;
    }
    public static void FillResult (String [] resultat, int d, int a, int b, int c) {
        StringBuilder resultTempQ  = new StringBuilder(resultat[0]);
        StringBuilder resultTempW  = new StringBuilder(resultat[1]);
        StringBuilder resultTempE  = new StringBuilder(resultat[2]);
        char rab1 = Integer.toString(a).charAt(0);
        resultTempQ.setCharAt(d-1,rab1);
        char rab2 = Integer.toString(b).charAt(0);
        resultTempW.setCharAt(d-1,rab2);
        char rab3 = Integer.toString(c).charAt(0);
        resultTempE.setCharAt(d-1,rab3);
        resultat[0] = resultTempQ.toString();
        resultat[1] = resultTempW.toString();
        resultat[2] = resultTempE.toString();
    }
}
