import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
//        System.out.println("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ") registered to weather tower.");
        Message.write("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ") registered to weather tower.\n");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
//        System.out.println("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ") unregistered to weather tower.");
        Message.write("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ") unregistered to weather tower.\n");
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
