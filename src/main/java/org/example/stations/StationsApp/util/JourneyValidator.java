package org.example.stations.StationsApp.util;

import org.example.stations.StationsApp.models.Journey;
import org.example.stations.StationsApp.services.JourneyService;
import org.example.stations.StationsApp.services.StationService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Levantosina
 */
@Component
public class JourneyValidator  implements Validator {

    private final JourneyService journeyService;

    public JourneyValidator(JourneyService journeyService) {
        this.journeyService = journeyService;

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Journey.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Journey journey = (Journey) target;

        if (journey.getDepartureStationName().equals(journey.getReturnStationName())) {
            errors.rejectValue("returnStationName", "returnStationName", "Departure and return stations cannot be the same");
        }

        if (!isValidString(journey.getDepartureStationName())) {
            errors.rejectValue("departureStationName", "departureStationName", "Invalid departure station name. Only string characters are allowed.");
        }

        if (!isValidString(journey.getReturnStationName())) {
            errors.rejectValue("returnStationName", "returnStationName", "Invalid return station name. Only string characters are allowed.");
        }
        if (!isValidString(journey.getDepartureStationName())) {
            errors.rejectValue("departureStationName", "departureStationName", "Invalid departure station name");
        } else if (!journeyService.doesStationExist(journey.getDepartureStationName())) {
            errors.rejectValue("departureStationName", "departureStationName", "Departure station does not exist in the database");
        }

        if (!isValidString(journey.getReturnStationName())) {
            errors.rejectValue("returnStationName", "returnStationName", "Invalid return station name");
        } else if (!journeyService.doesStationExist(journey.getReturnStationName())) {
            errors.rejectValue("returnStationName", "returnStationName", "Return station does not exist in the database");
        }
    }

    private boolean isValidString(String value) {
        return value != null && value.matches("[a-zA-Z]+");
    }

}
