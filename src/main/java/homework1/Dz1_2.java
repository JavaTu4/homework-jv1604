package homework1;
/**Created by Yurii.**/
public class Dz1_2 {
    public static void main(String[] args) {
        double pi, s, l, s2;
        int r, r2;
        r = 25;
        pi = 3.14;
        r2 = 30;
        l = 2 * pi * r;
        s = pi * (r * r);
        s2 = pi * ((r2 * r2)-(r * r));
        System.out.println("Длинна окружности при радиусе: " + r + " см " + " = " + l + " см ");
        System.out.println("Площадь окружности при радиусе: " + r + " см " + " = " + s + " см2");
        System.out.println("Площадь кольца при внутреннем радиусе: " + r + " см " + "и внешнем радиусе: " + r2 + " см " + " = " + s2 + " см2");
    }
}
