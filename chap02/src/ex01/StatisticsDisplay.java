package ex01;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements DisplayElement, Observer {
	private List<Float> temperatureFloats;
	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
		temperatureFloats = new ArrayList<>();
	}
	@Override
	public void update(float temperature, float humidity, float pressure) {
		temperatureFloats.add(temperature);
		display();
	}
	
	@Override
	public void display() {
		int size = temperatureFloats.size();
		if (size < 1) {
			return;
		}
		float sum = 0, max = 0, min = 100000;
		for (int i=0; i<size; i++) {
			float temperature = temperatureFloats.get(i);
			sum += temperatureFloats.get(i);
			min = temperature < min ? temperature : min;
			max = temperature > min ? temperature : min;
		}
		
		System.out.println("평균/최고/최저 온도 " + sum / size + "/" + max + "/" + min);
	}
}
