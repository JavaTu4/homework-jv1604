package homework2;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Dz2_1
{
    public static void main(String[] args) throws Exception
    {
        double pi = 3.14;
        String text = "Сделайте ваш выбор:\nВведите \"1\" для расчёта площади поверхности тороида.\nВведите \"2\" для расчёта обьёма тороида.";

        System.out.println(text);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String vibor = reader.readLine();
        int vibor1 = Integer.parseInt(vibor);

        switch (vibor1){

            case 1:
                System.out.println("Вы выбрали расчёт площади поверхности тороида\nВведите внешний и внутренний радиусы тороида");
                String r1 = reader.readLine();
                String r2 = reader.readLine();
                double r11 = Double.parseDouble(r1);
                double r22 = Double.parseDouble(r2);
                double ploshad;
                ploshad = 4 * (pi * pi) * r11 * r22;
                System.out.println("Площадь поверхности тороида с внешним радиусом: " +r11+ " и внутренним радиусом " +r22+ " = " +ploshad+ " cm2");
                break;

            case 2:
                System.out.println("Вы выбрали расчёт обьёма тороида\nВведите внешний и внутренний радиусы тороида");
                String r13 = reader.readLine();
                String r23 = reader.readLine();
                double r123 = Double.parseDouble(r13);
                double r223 = Double.parseDouble(r23);
                double obem;
                obem = 2 * (pi * pi) * r123 * (r223 * r223);
                System.out.println("Обьём тороида с внешним радиусом: " +r123+ " и внутренним радиусом " +r223+ " = " +obem+ " см3");
        }
        if (vibor1 > 2 || vibor1 <= 0)
        {
            System.out.println("Вы ввели какую-то фигню!");
        }

    }
}
