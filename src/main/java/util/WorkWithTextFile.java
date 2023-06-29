package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class WorkWithTextFile {
    public static void writeToFile(List<String> list, String filename){
        String time=new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        File file=new File("src/main/java/logs/"+time+filename+".txt");
        FileWriter out=null;
        try {
            out=new FileWriter(file);
            for (String l : list) {
                out.write(l+"\n");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(Map<String,String> map, String filename){
        String time=new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        File file=new File("src/main/java/logs/"+time+filename+".txt");
        FileWriter out=null;
        try {
            out=new FileWriter(file);
           for(Map.Entry<String, String> m:map.entrySet()){
               out.write(m.toString()+"\n");
           }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  List<String> readFile(String fileName){
        File file=new File(fileName);
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  br.lines().toList();
    }
}
