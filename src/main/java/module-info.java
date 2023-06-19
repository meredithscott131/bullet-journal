module cs3500.pa05 {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;

  opens cs3500.pa05 to javafx.fxml;
  exports cs3500.pa05;
  exports cs3500.pa05.controller;
  exports cs3500.pa05.model;
  exports cs3500.pa05.view;
  exports cs3500.pa05.json;
  opens cs3500.pa05.controller to javafx.fxml;
  exports cs3500.pa05.controller.Task;
  opens cs3500.pa05.controller.Task to javafx.fxml;
  exports cs3500.pa05.controller.event;
  opens cs3500.pa05.controller.event to javafx.fxml;
}