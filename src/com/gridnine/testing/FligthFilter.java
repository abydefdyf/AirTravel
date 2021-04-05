package com.gridnine.testing;

import java.util.LinkedList;
import java.util.List;
import java.time.Duration;
import java.time.LocalDateTime;

public class FligthFilter implements IFlightFilter {

	@Override
	public List<Flight> beforeCurrentTime(List<Flight> flights) {
		List<Flight> filteredFlight = new LinkedList<Flight>();
		for (var flight : flights) {
			var isValid = true;
			for (var segment : flight.getSegments()) {
				if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
					isValid = false;
					break;
				}
			}
			if (isValid) {
				filteredFlight.add(flight);
			}
		}
		return filteredFlight;
	}

	@Override
	public List<Flight> invalidFlight(List<Flight> flights) {
		List<Flight> filteredFlight = new LinkedList<Flight>();
		for (var flight : flights) {
			var isValid = true;
			for (var segment : flight.getSegments()) {
				if (segment.getArrivalDate().compareTo(segment.getDepartureDate()) == -1) {
					isValid = false;
					break;

				}
			}
			if (isValid) {
				filteredFlight.add(flight);
			}
		}
		return filteredFlight;
	}

	@Override
	public List<Flight> totalTimeOnEarth(List<Flight> flights) {
		
		List<Flight> filteredFlight = new LinkedList<>();
		
		Duration dateDifference;
		
		long FirstTransplant = 0;
		
		for (var flight : flights) {


			if (flight.getSegments().size() == 1) {
				filteredFlight.add(flight);
			}

			if (flight.getSegments().size() == 2) {
				dateDifference = Duration.between(flight.getSegments().get(0).getArrivalDate(),
						flight.getSegments().get(1).getDepartureDate());
				FirstTransplant = dateDifference.getSeconds();
				if (dateDifference.getSeconds() <= 7200) {
					filteredFlight.add(flight);
				}
			}else if (flight.getSegments().size() == 3) {
				dateDifference = Duration.between(flight.getSegments().get(1).getArrivalDate(),
						flight.getSegments().get(2).getDepartureDate());
				if ((dateDifference.getSeconds() + FirstTransplant) <= 7200) {
					filteredFlight.add(flight);
				}

			}
		}
		return filteredFlight;

	}

}
