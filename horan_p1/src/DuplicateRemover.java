import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover
{
    Set<String> uniqueWords = new HashSet<String>();
    int counter;

    public void remove(String dataFile) throws IOException {
        File dup = new File(dataFile);
        Scanner reader = new Scanner(dup);

        int copy;
        counter = 0;
        String temp;


        while(reader.hasNextLine())
        {
            copy = 0;
            temp = reader.nextLine();
            uniqueWords.add(temp);
        }
        reader.close();
    }

    public void write(String outputFile) throws IOException {
        //File out = new File(outputFile);
        FileWriter writer = new FileWriter(outputFile);

        writer.write(uniqueWords + "\n");

        writer.close();
    }
}
