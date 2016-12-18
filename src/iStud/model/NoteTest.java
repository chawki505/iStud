package iStud.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * Created by chawki on 09/12/16.
 */
public class NoteTest {

    private final DoubleProperty test;
    private final IntegerProperty id;


    public NoteTest() {
        this(0, 0);
    }

    public NoteTest(double test, int id) {

        this.test = new SimpleDoubleProperty(test);
        this.id = new SimpleIntegerProperty(id);
    }

    public double getTest() {
        return test.get();
    }

    public DoubleProperty testProperty() {
        return test;
    }

    public void setTest(double test) {
        this.test.set(test);
    }


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Override
    public String toString() {
        return "NoteTest{" +
                "test=" + test +
                ", id=" + id +
                '}';
    }
}
