package homework5.mobileConnection.tariffs;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Tariff {
    private String name;
    private int clients;
    private int cityMinutes;
    private int intercityMinutes;
    private int installment;

    static int[] minutes ={30,60,90,120,240};

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getClients() {
        return clients;
    }
    public void setClients(int clients) {
        this.clients = clients;
    }

    public int getInstallment() {
        return installment;
    }
    public void setInstallment(int installment) {
        this.installment = installment;
    }

    public int getCityMinutes() {
        return cityMinutes;
    }
    public void setCityMinutes(int cityMinutes) {
        this.cityMinutes = cityMinutes;
    }

    public int getIntercityMinutes() {
        return intercityMinutes;
    }
    public void setIntercityMinutes(int intercityMinutes) {
        this.intercityMinutes = intercityMinutes;
    }

    @Override
    public String toString() {
        return "Тариф{ " +
                name +
                ", Клиенты = " + clients +
                ", Абонплата = " + installment +
                " UAH, Выделенное время на разговоры: Городские = " + cityMinutes +
                " мин., Междугородние = " + intercityMinutes +
                " мин.}";
    }

    public Tariff(String name, int clients, int installment, int cityMinutes, int intercityMinutes) {
        this.name = name;
        this.clients = clients;
        this.installment = installment;
        this.cityMinutes = cityMinutes;
        if (this.cityMinutes == 30){
            this.installment = installment;
        }
        else if (this.cityMinutes == 60){
            this.installment = installment + 50;
        }
        else if (this.cityMinutes == 90){
            this.installment = installment * 2;
        }
        else if (this.cityMinutes == 120){
            this.installment = installment * 3;
        }
        else if (this.cityMinutes == 240){
            this.installment = installment * 4;
        }
        this.intercityMinutes = intercityMinutes;
        if (this.intercityMinutes == 30){
            this.installment = this.installment + 30;
        }
        else if (this.intercityMinutes == 60){
            this.installment = this.installment + 60;
        }
        else if (this.intercityMinutes == 90){
            this.installment = this.installment * 2;
        }
        else if (this.intercityMinutes == 120){
            this.installment = this.installment * 3;
        }
        else if (this.intercityMinutes == 240){
            this.installment = this.installment * 4;
        }
    }

    public class TariffInstallmentComparator implements Comparator <Tariff> {
        @Override
        public int compare(Tariff o1, Tariff o2) {
            return o1.getInstallment() - o2.getInstallment();
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
