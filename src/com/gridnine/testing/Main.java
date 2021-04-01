package com.gridnine.testing;


public class Main {
    public static void main(String[] args) {


        FligthFilter fligthFilter = new FligthFilter();
        System.out.println("���������: ����� �� �������� �������");
        for (var flight : fligthFilter.beforeCurrentTime(FlightBuilder.createFlights())){
            System.out.println(flight);
        }

        System.out.println("���������: ������� �������� � ����� ������ ������ ���� ������");
        for (var flight : fligthFilter.invalidFlight(FlightBuilder.createFlights())){
            System.out.println(flight);
        }

        System.out.println("���������: ����� �����, ���������� �� ����� ��������� ��� ����");
        for (var flight : fligthFilter.totalTimeOnEarth(FlightBuilder.createFlights())){
            System.out.println(flight);
        }



    }
}
