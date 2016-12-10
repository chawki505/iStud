package iStud.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by chawki on 09/12/16.
 */
public class NoteHW {

    private final DoubleProperty homeWork;


    public NoteHW() {
        this(0);
    }

    public NoteHW(double hm) {

        this.homeWork = new SimpleDoubleProperty(hm);


    }


    public double getHomeWork() {
        return homeWork.get();
    }

    public DoubleProperty homeWorkProperty() {
        return homeWork;
    }

    public void setHomeWork(double homeWork) {
        this.homeWork.set(homeWork);
    }


    @Override
    public String toString() {
        return "NoteHW{" +
                "homeWork=" + homeWork +
                '}';
    }
}
