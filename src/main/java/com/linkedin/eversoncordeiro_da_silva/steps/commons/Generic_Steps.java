package com.linkedin.eversoncordeiro_da_silva.steps.commons;

import com.fasterxml.jackson.core.util.RequestPayload;
import com.linkedin.eversoncordeiro_da_silva.logics.commons.Generic_Logic;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class Generic_Steps {
    Generic_Logic logic;

    public Generic_Steps() {
        logic = Generic_Logic.getInstance();
    }

    /**
     * Generic step para enviar requisição para o endpoint.
     * */
    @Quando("eu envio para a {string} no endpoint {string} {string}")
    public void euEnvioParaANoEndpoint(String apiName, String methodName, String endPointName) {
        logic.sendRequest(apiName,methodName,endPointName);
    }
    /**
     * Generic step para setar payload para a requisição.
     * */
    @E("possuo o {string}")
    public void possuoO(String payLoadName) {
        logic.loadPayload(payLoadName);
    }

    @E("valido se o pokémon possui {} {string} e se este se encontra na {string}")
    public void validoSeOPokemonPossuiMovimentoESeEsteSeEncontraNa(String campType, String value, String jsonPath) {
        logic.validateResponse(value, jsonPath);
    }
}
