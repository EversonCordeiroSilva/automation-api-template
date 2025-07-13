package com.linkedin.eversoncordeiro_da_silva.logics;

import com.linkedin.eversoncordeiro_da_silva.logics.commons.Generic_Logic;

import static com.linkedin.eversoncordeiro_da_silva.utils.Context.newRequest;
import static com.linkedin.eversoncordeiro_da_silva.utils.Context.rest;

public class Hellowold_PtBr_Logic extends Generic_Logic {
    public void setCaptura(String pokeName) {
        newRequest();
        rest().pathParam("nome_pokemon",pokeName);
    }


    public void setTrainerId(Integer trainerId) {
        newRequest();
        rest().pathParam("id", trainerId);
    }
}
