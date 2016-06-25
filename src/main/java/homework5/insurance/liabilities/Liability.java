package homework5.insurance.liabilities;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Liability {
    private String objectOfInsurance;
    private String risk;
    private int riskLevel;
    private int monthlyInstallment;
    private int repayment;

    static String [] risks = {"Минимальный", "Средний", "Полный"};

    public String getObjectOfInsurance() {
        return objectOfInsurance;
    }
    public void setObjectOfInsurance(String objectOfInsurance) {
        this.objectOfInsurance = objectOfInsurance;
    }

    public int getRiskLevel() {
        return riskLevel;
    }
    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getMonthlyInstallment() {
        return monthlyInstallment;
    }
    public void setMonthlyInstallment(int monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public int getRepayment() {
        return repayment;
    }
    public void setRepayment(int repayment) {
        this.repayment = repayment;
    }

    @Override
    public String toString() {
        return "Страхование{ " +
                "Тип: " + objectOfInsurance +
                ", Степень риска = " + risk +
                ", Ещемесячный взнос = " + monthlyInstallment +
                " $, Страховая выплата " + repayment +
                " $ }";
    }

    public Liability(String objectOfInsurance, String risk, int monthlyInstallment, int repayment) {
        this.objectOfInsurance = objectOfInsurance;
        this.risk = risk;
        if (this.risk.equals(risks[0])){
            this.riskLevel = 3;
        }
        else if (this.risk.equals(risks[1])){
            this.riskLevel = 2;
        }
        else if (this.risk.equals(risks[2])){
            this.riskLevel = 1;
        }
        this.monthlyInstallment = monthlyInstallment;
        this.repayment = repayment;
    }

    public class LiabililyRiskLevelComparator implements Comparator<Liability>{
        @Override
        public int compare(Liability o1, Liability o2) {
            return o1.getRiskLevel() - o2.getRiskLevel();
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }


}