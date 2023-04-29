import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QLearning {

    private final int mWidth = 5;
    private final int mHeight = 5;
    private final int count = mHeight * mWidth;

    private final int reward = 50;
    private final int penalty = -20;

    private final double a = 0.1;
    private final double b = 0.9;

    private double[] [] Q;
    private char[][] Maze;
    private int[][] R;

    public static void main(String[] args) {
        QLearning ql = new QLearning();

        ql.init();
        ql.calculate();
        ql.printQ();
    }

    public void init() {
        Maze m = new Maze();
        File file = new File("maze.txt");
        Q = new double[count][count];
        Maze = new char[mHeight][mWidth];
        R = new int[count][count];


    }

    void calculate () {
        Random r = new Random();

        for(int i =0; i < 1000; i++){
            int crtState = r.nextInt(count);

            while (!FinalState(crtState)) {
                int[] actionsFromCurrentState = possibleActionsFromState(crtState);

                int index = r.nextInt(actionsFromCurrentState.length);
                int nextState = actionsFromCurrentState[index];

                double q = Q[crtState][nextState];
                double maxQ = maxQ(nextState);
                int r = R[crtState][nextState];

                double value = q + a * (r + b * maxQ - q);
                Q[crtState][nextState] = value;

                crtState = nextState;
            }
        }
    }
    boolean FinalState(int state) {
        int i = state / mWidth;
        int j = state - i * mWidth;

        return Maze[i][j] == 'C';
    }


    void printQ() {


    }



}
