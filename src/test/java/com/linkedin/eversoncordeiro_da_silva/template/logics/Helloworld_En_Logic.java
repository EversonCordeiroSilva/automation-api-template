package com.linkedin.eversoncordeiro_da_silva.template.logics;

import com.linkedin.eversoncordeiro_da_silva.template.logics.commons.Generic_Logic;

import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.newRequest;
import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.rest;

public class Helloworld_En_Logic extends Generic_Logic {

    public void setCapture(String pokeName) {
        newRequest();
        rest().pathParam("pokemon_name", pokeName);
    }

    public void setTrainerId(Integer trainerId) {
        newRequest();
        rest().pathParam("id", trainerId);
    }
}
