import java.util.*;

public class Maze {
    Random rand = new Random();
    private int[] [] maze;
    private int width;
    private int length;

    public Maze(){
        this.maze = new int[width][length];
        this.width = width;
        this.length = length;

        for(int i = 0; i<length; i++){
            for(int j = 0; j< width; j++){
                maze[i][j] = 0;
            }
        }
    }
}
