package Task2;

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
        Line line = new Line(n);
        for(int i =0;i<n;i++){
            do {
                randInt = rand.nextInt(n); 
                }while(bool[randInt]);
                bool[randInt] = true;
                Monster monster = new Monster(i*4, 100, 100);
                line.put(monster, randInt);
        }


        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new QuickSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
