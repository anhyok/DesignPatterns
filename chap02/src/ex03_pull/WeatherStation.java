package ex03_pull;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		List<DisplayElement> displayElements = new ArrayList<>();
		
		displayElements.add(new CurrentConditionsDisplay(weatherData));
		displayElements.add(new StatisticsDisplay(weatherData));
		displayElements.add(new ForecastDisplay(weatherData));
		displayElements.add(new HeatindexDisplay(weatherData));
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		
		System.out.println("\nREFRESH\n");
		for (DisplayElement displayElement : displayElements) {
			displayElement.display();
		}
	}

}
