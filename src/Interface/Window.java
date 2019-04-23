package Interface;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application implements Runnable {

    private final int WIDTH = 700;
    private final int HEIGHT = 600;
    private Pane pane;
    private Scene scene;
    private Canvas canvas;
    private Thread thread;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Random Graphics");
        initComponents(primaryStage);
        primaryStage.show();
    }

    private void initComponents(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.canvas = new Canvas(WIDTH, HEIGHT);
        this.thread = new Thread(this);
        this.thread.start();
        this.pane.getChildren().add(this.canvas);
        primaryStage.setScene(this.scene);
    }

    private void myDraw(GraphicsContext gc) {
        Random rand = new Random();
        int movx = rand.nextInt(WIDTH - 100) + 1;
        int movy = rand.nextInt(HEIGHT - 100) + 1;
        int movx1 = rand.nextInt(500 - 100) + 1;
        int movy1 = rand.nextInt(500 - 100) + 1;

        while (true) {
            try {

                if (movx < 60 || movy < 60) {
                    gc.clearRect(0, 0, WIDTH, HEIGHT);
                    if (movx < 60) {
                        movx = movx + (int) (Math.random() * (60 - 10) + 10);

                    } else {
                        movy = movy + (int) (Math.random() * (60 - 10) + 10);
                    }
                    gc.setFill(Color.CHARTREUSE);
                    gc.fillRect(movx, movy, 100, 100);

                    gc.setFill(Color.DEEPPINK);
                    movx1 += 10;
                    movy1 += 10;
                    gc.fillOval(movx1, movy1, 100, 100);
                    Thread.sleep(100);
                }

                if (movx1 < 60 || movy1 < 60) {
                    gc.clearRect(0, 0, WIDTH, HEIGHT);
                    if (movx1 < 60) {
                        movx1 = movx1 + (int) (Math.random() * (60 - 10) + 10);
                    } else {
                        movy1 = movy1 + (int) (Math.random() * (60 - 10) + 10);
                    }
                    movx += 10;
                    movy += 10;
                    gc.setFill(Color.CHARTREUSE);
                    gc.fillRect(movx, movy, 100, 100);

                    gc.setFill(Color.DEEPPINK);
                    gc.fillOval(movx1, movy1, 100, 100);
                    Thread.sleep(100);
                }

                while (movx >= 60 && movy >= 60 && movx <= 560 && movy <= 450 && movx1 >= 60 && movy1 >= 60 && movx1 <= 560 && movy1 <= 450) {
                    gc.clearRect(0, 0, WIDTH, HEIGHT);

                    if (movx % 2 != 0) {
                        movx = movx + (int) (Math.random() * (40 - 25) + 25);
                        movy = movy + (int) (Math.random() * (40 - 25) + 25);
                        movx1 = movx1 + (int) (Math.random() * (40 - 25) + 25);
                        movy1 = movy1 + (int) (Math.random() * (40 - 25) + 25);
                    } else {
                        movx = movx - (int) (Math.random() * (40 - 25) + 25);
                        movy = movy - (int) (Math.random() * (40 - 25) + 25);
                        movx1 = movx1 - (int) (Math.random() * (40 - 25) + 25);
                        movy1 = movy1 - (int) (Math.random() * (30 - 25) + 25);
                    }
                    gc.setFill(Color.CHARTREUSE);
                    gc.fillRect(movx, movy, 100, 100);

                    gc.setFill(Color.DEEPPINK);
                    gc.fillOval(movx1, movy1, 100, 100);
                    Thread.sleep(100);
                }

                if (movx > 560 || movy > 450) {
                    gc.clearRect(0, 0, WIDTH, HEIGHT);
                    if (movx > 560) {
                        movx = movx - (int) (Math.random() * (60 - 10) + 10);

                    } else {
                        movy = movy - (int) (Math.random() * (60 - 10) + 10);
                    }
                    gc.setFill(Color.CHARTREUSE);
                    gc.fillRect(movx, movy, 100, 100);

                    movx1 -= 10;
                    movy1 -= 10;
                    gc.setFill(Color.DEEPPINK);
                    gc.fillOval(movx1, movy1, 100, 100);
                    Thread.sleep(100);
                }

                if (movx1 > 560 || movy1 > 450) {
                    gc.clearRect(0, 0, WIDTH, HEIGHT);
                    if (movx1 > 560) {
                        movx1 = movx1 - (int) (Math.random() * (60 - 10) + 10);
                    } else {
                        movy1 = movy1 - (int) (Math.random() * (60 - 10) + 10);
                    }
                    gc.setFill(Color.CHARTREUSE);
                    movx -= 10;
                    movy -= 10;
                    gc.fillRect(movx, movy, 100, 100);

                    gc.setFill(Color.DEEPPINK);
                    gc.fillOval(movx1, movy1, 100, 100);
                    Thread.sleep(100);
                }

            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public void run() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        myDraw(gc);
    }
}
