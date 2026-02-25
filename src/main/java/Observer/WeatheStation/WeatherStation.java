package Observer.WeatheStation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    private float temperature;
    private float humidity;

    List<Observer> observers;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;

        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity);
        }
    }
}
