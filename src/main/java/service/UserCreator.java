package service;

import model.JourneyData;
import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL));
    }
}