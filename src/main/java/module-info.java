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
  exports cs3500.pa05.controller.task;
  opens cs3500.pa05.controller.task to javafx.fxml;
  exports cs3500.pa05.controller.event;
  opens cs3500.pa05.controller.event to javafx.fxml;
  exports cs3500.pa05.controller.bujofile;
  opens cs3500.pa05.controller.bujofile to javafx.fxml;
  exports cs3500.pa05.controller.welcome;
  opens cs3500.pa05.controller.welcome to javafx.fxml;
  exports cs3500.pa05.controller.title;
  opens cs3500.pa05.controller.title to javafx.fxml;
  exports cs3500.pa05.controller.choosejournal;
  opens cs3500.pa05.controller.choosejournal to javafx.fxml;
  exports cs3500.pa05.controller.password;
  opens cs3500.pa05.controller.password to javafx.fxml;
  exports cs3500.pa05.controller.tempjournal;
  opens cs3500.pa05.controller.tempjournal to javafx.fxml;
}