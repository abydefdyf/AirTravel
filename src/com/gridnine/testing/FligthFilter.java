package com.gridnine.testing;

import java.util.LinkedList;
import java.util.List;
import java.time.LocalDateTime;

public class FligthFilter implements IFlightFilter {


    @Override
    public List<Flight> beforeCurrentTime(List<Flight> flights) {
        List<Flight> filteredFlight = new LinkedList<Flight>();
                for (var flight  : flights){
                    var isValid = true;
            for (var segment : flight.getSegments()){
               if (segment.getDepartureDate().isBefore(LocalDateTime.now())){
                   isValid = false;
                   break;
               }
            }
            if (isValid){
                filteredFlight.add(flight);
            }
        }
                return filteredFlight;
    }

    @Override
    public List<Flight> invalidFlight(List<Flight> flights) {
        List<Flight> filteredFlight = new LinkedList<Flight>();
        for (var flight : flights){
            var isValid = true;
            for (var segment : flight.getSegments()){
                if (segment.getArrivalDate().compareTo(segment.getDepartureDate()) == -1){
                    isValid = false;
                    break;

                }
            }
            if (isValid){
                filteredFlight.add(flight);
            }
        }
        return filteredFlight;
    }

    @Override
    public List<Flight> totalTimeOnEarth(List<Flight> flights) {
        List<Flight> filteredFlight = new LinkedList<>();
        for (var flight : flights){
            var isValid = true;

            if (flight.getSegments().size() > 1){
               if ((flight.getSegments().get(0).getArrivalDate().getHour() + flight.getSegments().get(0).getArrivalDate().getMinute()) - (flight.getSegments().get(1).getDepartureDate().getHour() + flight.getSegments().get(1).getArrivalDate().getMinute()) < -2){
                   isValid = false;
                   break;
               }
            }
            if (isValid){
                filteredFlight.add(flight);
            }
        }
        return filteredFlight;
    }
}
