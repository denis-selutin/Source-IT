package com.logistic.api.model.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;

/**
 * Created by Denis on 5/25/2015.
 */
public interface Package {
    public String getPackageId();
    public int getWeight();
    public Type getType();
    public Address getReceiverAddress();
    public Address getSenderAddress();
    public FullName getSenderFullName();
    public FullName getReceiverFullName();

    /**
     * http://www.ups.com/worldshiphelp/WS15/RUS/AppHelp/Codes/Package_Type_Codes.htm
     */
    public static enum Type {
        T_CP("Место груза"), T_30("Палета", 50), T_10("Коробка UPS 10 кг", 10),
        T_25("Коробка UPS 25 кг", 25), T_27("Средняя коробка UPS Express");

        private final String description;
        private final int maxWeight;

        private Type(String description) {
            this(description, 0);
        }

        private Type(String description, int maxWeight) {
            this.description = description;
            this.maxWeight = maxWeight;
        }

        public String getDescription() {
            return description;
        }

        public int getMaxWeight() {
            return maxWeight;
        }
    }
}
