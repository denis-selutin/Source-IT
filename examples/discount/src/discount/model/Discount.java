package discount.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public interface Discount {
    DiscountType getType();
    BigDecimal getDiscount();
    Date getExpireDate();
    Date getStartDate();
}
