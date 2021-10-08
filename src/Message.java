import java.io.FileWriter;
import java.io.IOException;

public class Message {
    private static FileWriter fileWriter;
    static {
        try {
            fileWriter = new FileWriter("simulation.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String msg){
        try {
            fileWriter.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeFile(){
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
