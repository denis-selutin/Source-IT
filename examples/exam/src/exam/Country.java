package exam;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public interface Country {
    String getName();
    Long getPopulation();
    BigDecimal getSquare();
    List<State> getStates();
}
