package Observer.WeatheStation.Simple;

import java.util.*;
import java.util.Observer;

public class StatisticsDisplay implements Observer.WeatheStation.Simple.Observer {

    Stack<Float> temperatures = new Stack<>();
    Stack<Float> humidities = new Stack<>();

    float avgTemp = 0f;
    float avgHum = 0f;

    float maxTemp = 0f;
    float maxHum = 0f;

    float minTemp = 999f;
    float minHum = 999f;

    public void update(float temperature, float humidity) {
        setMeasurements(temperature, humidity);
        avgTemp = calcAvg(temperatures.iterator());
        avgHum = calcAvg(humidities.iterator());

        System.out.printf("[StatisticsDisplay] Avg Temp: %sC, Avg Humidity: %s%%, Max temp %sC, Max Humidity %s%%, Min Temp %sC, Min Humidity %s%%",  avgTemp, avgHum, maxTemp, maxHum, minTemp, minHum);
    }

    public float calcAvg(Iterator<Float> iterator) {
        float avg = 0;
        int count = 0;
        while (iterator.hasNext()) {
            avg += iterator.next();
            count++;
        }
        return avg / count;
    }

    public void setMeasurements(float temperature, float humidity) {
        if (this.temperatures.size() >= 7) {
            this.temperatures.pop();
        }

        if(this.humidities.size() >= 7) {
            this.humidities.pop();
        }

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }

        if (humidity > maxHum) {
            maxHum = humidity;
        }

        if (temperature < minTemp) {
            minTemp = temperature;
        }

        if (humidity < minHum) {
            minHum = temperature;
        }

        this.temperatures.push(temperature);
        this.humidities.push(humidity);
    }

}
