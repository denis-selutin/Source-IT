package discount.model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public interface Product {
    String getName();
    List<ProductGroup> getGroups();
    BigDecimal getPrice();
    Long getId();
    BigDecimal adjustPrice();
}
