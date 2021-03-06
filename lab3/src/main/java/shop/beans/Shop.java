package shop.beans;


import shop.util.ShopUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name="shop")
@SessionScoped
public class Shop {

    private HashMap<String, String> basicInputs = new HashMap<>() {{
        put("sex", "0");
    }};

    private Map<String, String> basicInputsLabels = new HashMap<>() {{
        put("name", "Imie");
        put("mail", "Adres E-mail");
        put("age", "Wiek");
        put("sex", "Płeć");
        put("education", "Wykształcenie");
        put("height", "Wzrost");

    }};

    private HashMap<String, String> womenInputs = new HashMap<>();
    private Map<String, String> womenInputsLabels = new HashMap<>() {{
        put("breastCircumference", "Obwód biustu (cm)");
        put("cupSize", "Wielkość miseczki (cm)");
        put("waist", "Talia (cm)");
        put("hips", "Biodra (cm)");
    }};

    private HashMap<String, String> menInputs = new HashMap<>();
    private Map<String, String> menInputsLabels = new HashMap<>() {{
        put("chest", "Klatka (cm)");
        put("waist", "Pas (cm)");
    }};


    private Map<String, String> sexes = new HashMap<>() {{
        put("Kobieta", "0");
        put("Mężczyzna", "1");
    }};

    private Map<String, String> errors = new HashMap<>();

    private boolean additionalInputs;

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public HashMap<String, String> getWomenInputs() {
        return womenInputs;
    }

    public void setWomenInputs(HashMap<String, String> womenInputs) {
        this.womenInputs = womenInputs;
    }

    public Map<String, String> getWomenInputsLabels() {
        return womenInputsLabels;
    }

    public void setWomenInputsLabels(Map<String, String> womenInputsLabels) {
        this.womenInputsLabels = womenInputsLabels;
    }

    public HashMap<String, String> getMenInputs() {
        return menInputs;
    }

    public void setMenInputs(HashMap<String, String> menInputs) {
        this.menInputs = menInputs;
    }

    public Map<String, String> getMenInputsLabels() {
        return menInputsLabels;
    }

    public void setMenInputsLabels(Map<String, String> menInputsLabels) {
        this.menInputsLabels = menInputsLabels;
    }

    public Map<String, String> getSexes() {
        return sexes;
    }

    public void setSexes(Map<String, String> sexes) {
        this.sexes = sexes;
    }

    public HashMap<String, String> getBasicInputs() {
        return basicInputs;
    }

    public void setBasicInputs(HashMap<String, String> basicInput) {
        this.basicInputs = basicInput;
    }

    public Map<String, String> getBasicInputsLabels() {
        return basicInputsLabels;
    }

    public void setBasicInputsLabels(Map<String, String> basicInputsLabels) {
        this.basicInputsLabels = basicInputsLabels;
    }

    public String submit() {
        this.errors = ShopUtil.validateData(this.basicInputs);
        System.out.println(this.errors.size());
        for (Map.Entry<String, String> entry: this.errors.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        if (this.errors.size() == 0) {
            return "additional";
        }
        return null;
    }

    public void updateSex() {
        System.out.println("update");
    }

}
