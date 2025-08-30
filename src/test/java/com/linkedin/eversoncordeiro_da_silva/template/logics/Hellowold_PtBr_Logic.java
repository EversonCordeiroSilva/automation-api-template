package com.linkedin.eversoncordeiro_da_silva.template.logics;

import com.linkedin.eversoncordeiro_da_silva.template.logics.commons.Generic_Logic;

import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.newRequest;
import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.rest;

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
