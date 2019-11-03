import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


public class DuplicateCounter
{

    int[] wordCounter;
    Map<String, Integer> counter = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException
    {
        File dup = new File(dataFile);
        Scanner reader = new Scanner(dup);
        wordCounter = new int[1];

        String temp;

        while(reader.hasNextLine())
        {
            temp = reader.nextLine();
            if(!counter.containsKey(temp))
            {
                counter.put(temp, 1);
                wordCounter = Arrays.copyOf(wordCounter, wordCounter.length + 1);
            }
            else
            {
                counter.put(temp,counter.get(temp)+1 );
            }
        }
        reader.close();
    }

    public void write(String dataFile) throws IOException {
        //File out = new File(dataFile);
        FileWriter writer = new FileWriter(dataFile);
        Set<Map.Entry<String,Integer> >st = counter.entrySet();
        for(Map.Entry<String, Integer> me:st)
        {
            writer.write(me.getKey()+":" + me.getValue() + "\n");
        }
        writer.close();
    }
}
