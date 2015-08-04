package discount.model;

import java.util.List;

/**
 *
 */
public interface ProductGroup {
    String getName();
    List<Discount> getDiscounts();
}
