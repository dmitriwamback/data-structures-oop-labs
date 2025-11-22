package lab8_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuTest extends Application {
    private TextField tfNumber1 = new TextField();
    private TextField tfNumber2 = new TextField();
    private TextField tfResult = new TextField();

    @Override
    public void start(Stage primaryStage) {

        // create menu bar
        MenuBar menuBar = new MenuBar();

        Menu menuOperation = new Menu("Operation");
        Menu menuExit = new Menu("Exit");
        menuBar.getMenus().addAll(menuOperation, menuExit);

        // keep the menu bar
        MenuItem menuItemAdd = new MenuItem("Add");
        MenuItem menuItemSubtract = new MenuItem("Subtract");
        MenuItem menuItemMultiply = new MenuItem("Multiply");
        MenuItem menuItemDivide = new MenuItem("Divide");
        menuOperation.getItems().addAll(menuItemAdd, menuItemSubtract, menuItemMultiply, menuItemDivide);

        MenuItem menuItemClose = new MenuItem("Close");
        menuExit.getItems().add(menuItemClose);

        // set key shortcuts
        menuItemAdd.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        menuItemSubtract.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        menuItemMultiply.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
        menuItemDivide.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        // create hbox for the forum
        HBox hBox1 = new HBox(5);
        tfNumber1.setPrefColumnCount(2);
        tfNumber2.setPrefColumnCount(2);
        tfResult.setPrefColumnCount(2);
        hBox1.getChildren().addAll(new Label("Number 1:"), tfNumber1,
                new Label("Number 2:"), tfNumber2, new Label("Result:"), tfResult);
        hBox1.setAlignment(Pos.CENTER);

        // create hbox for the buttons
        HBox hBox2 = new HBox(5);
        Button btAdd = new Button("Add");
        Button btSubtract = new Button("Subtract");
        Button btMultiply = new Button("Multiply");
        Button btDivide = new Button("Divide");
        hBox2.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
        hBox2.setAlignment(Pos.CENTER);

        // create vbox to align the menu bar, input forums, and button forum
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(menuBar, hBox1, hBox2);

        // set functionality for the menu bar items
        menuItemAdd.setOnAction(e -> perform('+'));
        menuItemSubtract.setOnAction(e -> perform('-'));
        menuItemMultiply.setOnAction(e -> perform('*'));
        menuItemDivide.setOnAction(e -> perform('/'));
        menuItemClose.setOnAction(e -> System.exit(0));

        // set functionality for the buttons
        btAdd.setOnAction(e -> perform('+'));
        btSubtract.setOnAction(e -> perform('-'));
        btMultiply.setOnAction(e -> perform('*'));
        btDivide.setOnAction(e -> perform('/'));

        // create menu popup when right click
        Menu contextOperationMenu = new Menu("Operation");
        MenuItem popupAdd = new MenuItem("Add");
        MenuItem popupSubtract = new MenuItem("Subtract");
        MenuItem popupMultiply = new MenuItem("Multiply");
        MenuItem popupDivide = new MenuItem("Divide");

        // create keyboard shortcuts
        popupAdd.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        popupSubtract.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        popupMultiply.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
        popupDivide.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        // add the menu items to the popup
        contextOperationMenu.getItems().addAll(popupAdd, popupSubtract, popupMultiply, popupDivide);

        // menu for exiting the program
        Menu contextExitMenu = new Menu("Exit");
        MenuItem popupClose = new MenuItem("Close");
        contextExitMenu.getItems().add(popupClose);

        // create context menu
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(contextOperationMenu, contextExitMenu);

        // set functionality for the popup menu
        popupAdd.setOnAction(e -> perform('+'));
        popupSubtract.setOnAction(e -> perform('-'));
        popupMultiply.setOnAction(e -> perform('*'));
        popupDivide.setOnAction(e -> perform('/'));
        popupClose.setOnAction(e -> System.exit(0));

        // right click handler
        vBox.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(vBox, e.getScreenX(), e.getScreenY());
            } else {
                contextMenu.hide();
            }
        });

        // create and present scene
        Scene scene = new Scene(vBox, 300, 250);
        primaryStage.setTitle("Exercise31_18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void perform(char operator) {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        double result = 0;
        switch (operator) {
            case '+': result = number1 + number2; break;
            case '-': result = number1 - number2; break;
            case '*': result = number1 * number2; break;
            case '/': result = number1 / number2; break;
        }
        tfResult.setText(result + "");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
