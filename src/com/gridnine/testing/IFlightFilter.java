package com.gridnine.testing;

import java.util.List;

public interface IFlightFilter {

  List<Flight> beforeCurrentTime(List<Flight> flights);

  List<Flight> invalidFlight(List<Flight> flights);

  List<Flight> totalTimeOnEarth (List<Flight> flights);
}
