package sample;

import com.sun.deploy.xml.XMLable;
import com.sun.javafx.geom.Vec2f;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Random;
import static java.lang.Math.*;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    private int windowWidth = 600;
    private int windowHeight = 600;

    private Scene createScene() {
        Group root = new Group();
        for(int i =0; i < 13; i++) {
            root.getChildren().add(createLabel());
        }
        return new Scene(root, windowWidth, windowHeight);
    }

    private Random random = new Random(); // ��� ����� ������!!

    private Label createLabel() {
        Label label = new Label();    // �������� ������� ��� Label
        label.setText("SomeText");            // ��������� ��������
        label.prefWidth(100);                // ��������� ������
        label.prefHeight(50);                // ��������� ������
        label.setAlignment(Pos.CENTER);         // ������������ ����������� �� ������
        label.setLayoutX(random.nextInt(windowWidth - 100)); // �������  �����. �
        label.setLayoutY(random.nextInt(windowHeight - 50));  // �������  �����. Y
        label.setStyle("-fx-background-color: orange;");  // �������� ��� � ���������
        addTranslateListener(label);
        return label;
    }

    private Node node;   // ������ �� ������, ������� ����� �������������
    private Vec2f delta; // ���������� ��������� ���� ������������ ��������
    // ����� ��� ����, ����� �� ���� ������� ����� ������� ��������
/*
    private void addTranslateListener(final Node node) {
        node.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                delta = new Vec2f((float) (mouseEvent.getSceneX() - node.getLayoutX()),
                        (float) (mouseEvent.getSceneY() - node.getLayoutY()));
                // ���������� ��������� ������������ ����e���
                Main.this.node = node;   // ��������� ������ �� ������
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.this.node = null;  // ������� ������ �� ������
            }
        });

        node.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (node != null) {
// ���� ���� ��� �������������, �������������
                    node.setLayoutX(mouseEvent.getSceneX() - delta.x);
                    node.setLayoutY(mouseEvent.getSceneY() - delta.y);
                }
            }
        });
    }
    */
    boolean isRotate;
    private void addTranslateListener(final Node node) {

        node.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                delta = new Vec2f((float) (mouseEvent.getSceneX() - node.getLayoutX()),
                        (float) (mouseEvent.getSceneY() - node.getLayoutY()));
                Main.this.node = node;
                if (mouseEvent.getButton() == MouseButton.SECONDARY){
                    isRotate = true;
                }
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.this.node = null;
                isRotate = false;
            }
        });


        node.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent mouseEvent) {
                if (node != null ) {
                    if (isRotate) {
                        // ������� ������ ���� ���������� �� �������� ���� ����� ����� ���������
// ��� ��������� ����������, � ������� ��� ������ ���� ��� �������)
                        double dx1 = mouseEvent.getSceneX() - node.getLayoutX();
                        double dy1 = mouseEvent.getSceneY() - node.getLayoutY();
                        double l = Math.sqrt(dx1 *dx1 + dy1 *dy1);
                        dx1 /= l; // ������������
                        dy1 /= l; // �������

                        double angle = PI/2; // �� ������ ������ ���� �����
                        double dx2 = sin(angle);      // ��������� ������,
                        double dy2 = cos(angle);      // ������� ���������� �� 90 ��������

                        double cosA = dx1 * dx2 + dy1 * dy2;
                        angle = acos(cosA);

                        if (dy1 < 0) angle = PI - angle ;
                        node.setRotate(angle / PI * 180); // �� ������ � �������
                    }
                    else {
                        node.setLayoutX(mouseEvent.getSceneX() - delta.x);
                        node.setLayoutY(mouseEvent.getSceneY() - delta.y);
                    }
                }
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
