package homework2;

import java.util.Scanner;

import static java.lang.Math.PI;


public class Tor {

    public static void main(String[] args) throws Exception {
        int input;
        do {
            System.out.println("Сделайте ваш выбор:");
            System.out.println("Введите \"1\" для расчёта площади поверхности тороида.");
            System.out.println("Введите \"2\" для расчёта обьёма тороида.");
            input = readInt();
        }
        while (input < 1 || input > 2);

        switch (input) {
            case 1: {
                System.out.println("Вы выбрали расчёт площади поверхности тороида\nВведите внешний и внутренний радиусы тороида");
                int r11 = readInt();
                int r22 = readInt();
                double ploshad;
                ploshad = 4 * (PI * PI) * (r11 * r22);
                System.out.print("Площадь поверхности тороида с внешним радиусом: " + r11 + " и внутренним радиусом " + r22 + " = ");
                System.out.printf("%.2f %s", ploshad, "cm2");
            }break;
            case 2: {
                System.out.println("Вы выбрали расчёт обьёма тороида\nВведите внешний и внутренний радиусы тороида");
                int r123 = readInt();
                int r223 = readInt();
                double obem;
                obem = 2 * (PI * PI) * r123 * (r223 * r223);
                System.out.print("Обьём тороида с внешним радиусом: " + r123 + " и внутренним радиусом " + r223 + " = ");
                System.out.printf("%.2f %s", obem, "cm3");
            }break;
        }
    }

    private static int readInt() throws Exception {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        if (!sc.hasNextInt()) {
            System.out.println("Вы ввели не число, попоробуйте еще раз");
            readInt();
        } else {
            input = sc.nextInt();
        }
        return input;
    }
}
