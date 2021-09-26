package Task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {

    public static void main(String[] args) throws IOException {
        int n = 64;
        boolean[] bool = new boolean[n];
        int randInt = 0;
        Random rand = new Random();
        Matrix matrix = new Matrix(8,8);
        for(int i =0;i<n;i++){
            do {
                randInt = rand.nextInt(n); 
                }while(bool[randInt]);
                bool[randInt] = true;
                Monster monster = new Monster(i, 100+i, 100);
                matrix.put(monster, randInt);
        }


        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new SelectSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
