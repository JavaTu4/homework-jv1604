package homework2;

import java.util.Scanner;

import static java.lang.Math.PI;


public class Dz2_1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String text = "Сделайте ваш выбор:\nВведите \"1\" для расчёта площади поверхности тороида.\nВведите \"2\" для расчёта обьёма тороида.";
        lab1: for (int a = 0;a == 0;) {
            System.out.println(text);
            int vibor = sc.nextInt();
            if (vibor > 2 || vibor <= 0) {
                System.out.println("Вы ввели недопустимое значение");
                continue lab1;
            }
            else {
                switch (vibor) {
                    case 1: {
                        System.out.println("Вы выбрали расчёт площади поверхности тороида\nВведите внешний и внутренний радиусы тороида");
                        double r11 = sc.nextDouble();
                        double r22 = sc.nextDouble();
                        double ploshad;
                        ploshad = 4 * (PI * PI) * (r11 * r22);
                        System.out.print("Площадь поверхности тороида с внешним радиусом: " + r11 + " и внутренним радиусом " + r22 + " = ");
                        System.out.printf("%.2f %s", ploshad, "cm2");
                    }break;
                    case 2: {
                        System.out.println("Вы выбрали расчёт обьёма тороида\nВведите внешний и внутренний радиусы тороида");
                        double r123 = sc.nextDouble();
                        double r223 = sc.nextDouble();
                        double obem;
                        obem = 2 * (PI * PI) * r123 * (r223 * r223);
                        System.out.print("Обьём тороида с внешним радиусом: " + r123 + " и внутренним радиусом " + r223 + " = ");
                        System.out.printf("%.2f %s", obem, "cm3");
                    }break;
                }
            }
        }
    }
}
