package iStud.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by chawki on 09/12/16.
 */
public class NoteHW {

    private final DoubleProperty homeWork;
    private final IntegerProperty id;


    public NoteHW() {
        this(0, 0);
    }

    public NoteHW(double hm, int id) {

        this.homeWork = new SimpleDoubleProperty(hm);
        this.id = new SimpleIntegerProperty(id);


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
        return "NoteHW{" +
                "homeWork=" + homeWork +
                ", id=" + id +
                '}';
    }
}
