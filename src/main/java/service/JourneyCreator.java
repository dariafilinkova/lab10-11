package service;

import model.JourneyData;

public class JourneyCreator {

    public static final String TEST_DATA_CAR_DESTINATION = "testdata.car.destination";
    public static final String TEST_DATA_CAR_DESTINATION_TO = "testdata.car.destinationTo";

    public static JourneyData journeyFromProperty() {
        return new JourneyData(TestDataReader.getTestData(TEST_DATA_CAR_DESTINATION));
    }

    public static JourneyData journeyFromPropertyTo() {
        return new JourneyData(TestDataReader.getTestData(TEST_DATA_CAR_DESTINATION_TO));
    }

}
