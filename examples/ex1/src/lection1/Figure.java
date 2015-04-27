package lection1;

import java.io.Serializable;

/**
 * Created by Denis on 4/25/2015.
 */
interface Figure extends Cloneable, Serializable{
    static final String name = "";
    public void draw();
}
