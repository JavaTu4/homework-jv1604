package homework5.homeAppliances.appliances;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Appliance {
    private String name;
    private int powerInHour;
    private boolean status;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPowerInHour() {
        return powerInHour;
    }
    public void setPowerInHour(int powerInHour) {
        this.powerInHour = powerInHour;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Appliance(String name, int powerInHour, boolean status) {
        this.name = name;
        this.powerInHour = powerInHour;
        this.status = status;
    }

    static boolean randomStatus(){
        int random = random(0,1);
        if (random == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }


    @Override
    public String toString() {
        if (this.status){
            return "[ Электроприбор {\""+name+"\", Потребляемая мощность = "+
                    powerInHour+" Вт*ч, Статус = Включён}";
        }
        else {
            return "[ Электроприбор {\""+name+"\", Потребляемая мощность = "+
                    powerInHour+" Вт*ч, Статус = Выключен}";
        }
    }

    public class AppliancePowerComparator implements Comparator<Appliance>{
        @Override
        public int compare(Appliance o1, Appliance o2) {
            return o1.getPowerInHour() - o2.getPowerInHour();
        }
    }
}
