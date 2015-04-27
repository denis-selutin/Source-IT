package lection1;

/**
 * Created by Denis on 4/25/2015.
 */
abstract class BaseFigure implements Figure {
    protected String name;
    public BaseFigure() {
        name = "55";
    }
    public abstract void setPoints();
}
