import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Simulator {
    private static int sizeSimulation;

    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Error !!! Not file !!!");
            System.exit(1);
        }
        List<Flyable> flyables = new ArrayList<>();
        WeatherTower weatherTower = new WeatherTower();
        checkFile(args[0]);
        parserFile(flyables, args[0]);
        for (Flyable f : flyables){
            f.registerTower(weatherTower);
        }
        for (int i = 0; i < sizeSimulation; i++){
            weatherTower.changeWeather();
        }
        Message.closeFile();
    }

    public static void parserFile(List<Flyable> flyables, String fileName){
        String line;
        String[] airInfo;
        int height;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            sizeSimulation = Integer.parseInt(bufferedReader.readLine());
            while ((line = bufferedReader.readLine()) != null){
                airInfo = line.split(" ");
                if ((height = Integer.parseInt(airInfo[4])) > 100)
                    height = 100;
                flyables.add(AircraftFactory.newAircraft(airInfo[0], airInfo[1],
                        Integer.parseInt(airInfo[2]),
                        Integer.parseInt(airInfo[3]),
                        height));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void checkFile(String fileName){
        String line;
        String[] airInfo;
        String[] airName = {"Baloon", "JetPlane", "Helicopter"};

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            Integer.parseInt(bufferedReader.readLine());
            while ((line = bufferedReader.readLine()) != null){
                if ((airInfo = line.split(" ")).length != 5){
                    throw new ValidException("Error size in line !!!");
                } else if (!Arrays.asList(airName).contains(airInfo[0])){
                    throw new ValidException("Error air name !!!");
                }
                if (Integer.parseInt(airInfo[2]) < 0 || Integer.parseInt(airInfo[3]) < 0 || Integer.parseInt(airInfo[4]) < 0){
                    throw new ValidException("Error coordinates or height !!!");
                }
            }
            bufferedReader.close();
        } catch (NumberFormatException | IOException | ValidException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
