import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {

    // step 9
    private int score = 0;

    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");

        // Step 5
        Label scoreLabel = new Label("Score: " + score);
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);

        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10
        // step 7
        Button dessertButton = new Button("Dessert");
        pane.getChildren().add(dessertButton);

        Button[] desertButton = new Button[7];
        for (int i = 0; i < 7; i++) {
            desertButton[i] = new Button("Desert");
            pane.getChildren().add(desertButton[i]);
        }

        // step 8
        randomizeButtonPositions(new Random(), desertButton);
        randomizeButtonPositions(new Random(), new Button[] { dessertButton });

        // step 9
        dessertButton.setOnAction(e -> {
            score++;
            scoreLabel.setText("Score: " + score);
            randomizeButtonPositions(new Random(), desertButton);
            randomizeButtonPositions(new Random(), new Button[] { dessertButton });
            exitButton.requestFocus();
        });

        for (Button randDesertButton : desertButton) {
            randDesertButton.setOnAction(event -> {
                score--;
                scoreLabel.setText("Score: " + score);
                randomizeButtonPositions(new Random(), desertButton);
                randomizeButtonPositions(new Random(), new Button[] { dessertButton });
                exitButton.requestFocus();
            });
        }

        // step 10
        exitButton.requestFocus();
        stage.setScene(scene);
        stage.show();
    }

    private void randomizeButtonPositions(Random rand, Button[] buttonArray) {
        for (Button button : buttonArray) {
            double x = rand.nextDouble() * 600;
            double y = rand.nextDouble() * 400;
            button.setLayoutX(x);
            button.setLayoutY(y);
        }
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
