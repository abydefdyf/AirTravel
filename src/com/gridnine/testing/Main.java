package com.gridnine.testing;


public class Main {
    public static void main(String[] args) {


        FligthFilter fligthFilter = new FligthFilter();
        System.out.println("исключить: вылет до текущего момента");
        for (var flight : fligthFilter.beforeCurrentTime(FlightBuilder.createFlights())){
            System.out.println(flight);
        }

        System.out.println("исключить: имеются сегменты с датой прилёта раньше даты вылета");
        for (var flight : fligthFilter.invalidFlight(FlightBuilder.createFlights())){
            System.out.println(flight);
        }

        System.out.println("исключить: общее время, проведённое на земле превышает два часа");
        for (var flight : fligthFilter.totalTimeOnEarth(FlightBuilder.createFlights())){
            System.out.println(flight);
        }



    }
}
