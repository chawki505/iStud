package ch.makery.address.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


/**
 * Created by chawki on 09/12/16.
 */
public class NoteTest {

    private final DoubleProperty test;


    public NoteTest() {
        this(0);
    }

    public NoteTest(double test) {

        this.test = new SimpleDoubleProperty(test);


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


    @Override
    public String toString() {
        return "NoteTest{" +
                "test=" + test +
                '}';
    }
}
