package homework1;
/**Created by Yurii.**/
public class Dz1_3 {
    public static void main(String[] args) {
        double pi, s, v1, v2;
        int r, r2, h;
        pi = 3.14;
        r = 15;
        r2 = 25;
        h = 20;
        v1 = pi * (r * r) * h;
        v2 = pi * h * ((r2 * r2) - (r * r));
        s = 2 * pi * r * h;
        System.out.println("Обьём цилиндра при радиусе: " + r + " см " + "и высоте: " + h + " см "  + " = " + v1 + " см3");
        System.out.println("Обьём полого цилиндра при внутреннем радиусе: " + r + " см "  + "и внешнем радиусе: " + r2 + " см " + "и высоте: " + h + " см " + " = " + v2 + " см3");
        System.out.println("Площадь боковой поверхности цилиндра(не полого) при радиусе: " + r + " см " + "и высоте: " + h + " см "  + " = " + s + " см2");


    }
}
