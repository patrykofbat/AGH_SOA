package shop.beans;

import javax.faces.bean.ManagedBean;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "additional")
public class Additional {

    private Map<String, String> additonals = new HashMap<>();
    private Map<String, String> additionalLabels = new HashMap<>() {{
       put("spendMoney", "Ile jesteś w stanie przeznaczyc miesięcznie na zakup ubrania?");
       put("buyingPeriod", "Jak często dokonujesz zakupu ubrania?");
       put("preferColor", "W jakich kolorach preferujesz ubrania?");
       put("preferType", "Jakiego rodzaju ubrania najchętniej kupujesz?");
    }};

    private Map<String, String> spendMoneyOptions = new HashMap<>() {{
        put("do 100 zł", "0");
        put("100-500 zł", "1");
        put("500-1000 zł", "2");
        put("powyżej 1000 zł", "3");

    }};
    private Map<String, String> buyingPeriodOptions = new HashMap<>() {{
        put("Codziennie", "0");
        put("Raz w tygodniu", "1");
        put("Raz w miesiącu", "2");
        put("Kilka razy w roku", "3");

    }};
    private Map<String, String> preferColorOptions = new HashMap<>() {{
        put("Kolorowo-jaskrawych", "0");
        put("Stonowanych w szarościach", "1");
        put("W czerni i bieli", "2");
        put("W samej czerni", "3");

    }};
    private Map<String, String> preferTypeOptions = new HashMap<>() {{
        put("garsonki", "0");
        put("bluzki", "1");
        put("spódniczki", "2");
        put("spodnie", "3");
    }};


    public Map<String, String> getSpendMoneyOptions() {
        return spendMoneyOptions;
    }

    public void setSpendMoneyOptions(Map<String, String> spendMoneyOptions) {
        this.spendMoneyOptions = spendMoneyOptions;
    }

    public Map<String, String> getBuyingPeriodOptions() {
        return buyingPeriodOptions;
    }

    public void setBuyingPeriodOptions(Map<String, String> buyingPeriodOptions) {
        this.buyingPeriodOptions = buyingPeriodOptions;
    }

    public Map<String, String> getPreferColorOptions() {
        return preferColorOptions;
    }

    public void setPreferColorOptions(Map<String, String> preferColorOptions) {
        this.preferColorOptions = preferColorOptions;
    }

    public Map<String, String> getPreferTypeOptions() {
        return preferTypeOptions;
    }

    public void setPreferTypeOptions(Map<String, String> preferTypeOptions) {
        this.preferTypeOptions = preferTypeOptions;
    }

    public Map<String, String> getAdditonals() {
        return additonals;
    }

    public void setAdditonals(Map<String, String> additonals) {
        this.additonals = additonals;
    }

    public Map<String, String> getAdditionalLabels() {
        return additionalLabels;
    }

    public void setAdditionalLabels(Map<String, String> additionalLabels) {
        this.additionalLabels = additionalLabels;
    }

    public void submit() {
        System.out.println("elo");
        for (Map.Entry<String, String> entry: this.additonals.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
