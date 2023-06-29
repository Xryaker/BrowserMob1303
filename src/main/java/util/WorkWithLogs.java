package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkWithLogs {
    public static void printAllLogs(WebDriver driver){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            if (logEntry.getLevel().toString().equals("WARNING")) {//only warning
                System.out.println(logEntry.getLevel() + "    =   " + logEntry.getMessage() + "    " + logEntry.getTimestamp());
            }
        }
    }

    public static void writeLogsToFile(WebDriver driver, String filename){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        String time=new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        File file=new File("src/main/java/logs/"+time+filename+".txt");
        FileWriter out=null;
        try {
            out=new FileWriter(file);
            for (LogEntry logEntry : logEntries) {
                out.write(logEntry.toString()+"\n");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
