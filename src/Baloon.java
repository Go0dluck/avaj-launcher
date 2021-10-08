public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String getWeather = weatherTower.getWeather(coordinates);
        switch (getWeather){
            case ("RAIN"):
                //System.out.println(getType() + "#" + getName() + "(" + getId() + "): Oh shit, my hair is all wet (");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): Oh shit, my hair is all wet (\n");
                coordinates.setHeight(coordinates.getHeight() - 5);
                break;
            case ("FOG"):
                //System.out.println(getType() + "#" + getName() + "(" + getId() + "): How can you see through such a fog");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): How can you see through such a fog\n");
                coordinates.setHeight(coordinates.getHeight() - 3);
                break;
            case ("SUN"):
                //System.out.println(getType() + "#" + getName() + "(" + getId() + "): How my face burns");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): How my face burns\n");
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                if (coordinates.getHeight() > 100)
                    coordinates.setHeight(100);
                break;
            case ("SNOW"):
                //System.out.println(getType() + "#" + getName() + "(" + getId() + "): Well, here is a full basket of snow");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): Well, here is a full basket of snow\n");
                coordinates.setHeight(coordinates.getHeight() - 15);
                break;
        }
        if (coordinates.getHeight() <= 0){
            //System.out.println(getType() + "#" + getName() + "(" + getId() + "): landing");
            Message.write(getType() + "#" + getName() + "(" + getId() + "): landing\n");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public String getName(){
        return super.getName();
    }

    public String getType() {
        return "Baloon";
    }

    public long getId(){
        return super.getId();
    }
}
