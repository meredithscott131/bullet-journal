package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ChangeInUpdate implements ChangeListener {

  Calendar calendar;
  ChangeInUpdate(Calendar calendar) {
    this.calendar = calendar;
  }

  @Override
  public void changed(ObservableValue observable, Object oldValue, Object newValue) {
    updateCalendar();

  }
}

