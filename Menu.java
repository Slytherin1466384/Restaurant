package Less13;

import java.util.Map;

public class Menu {

    Map<String,Double> nameAndPrice;

    public Menu(Map<String, Double> nameAndPrice) {
        this.nameAndPrice = nameAndPrice;
    }

    public Map<String, Double> getNameAndPrice() {
        return nameAndPrice;
    }

    public void setNameAndPrice(Map<String, Double> nameAndPrice) {
        this.nameAndPrice = nameAndPrice;
    }
}
