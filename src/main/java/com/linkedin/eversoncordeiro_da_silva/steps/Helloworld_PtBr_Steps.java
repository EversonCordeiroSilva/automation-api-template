package com.linkedin.eversoncordeiro_da_silva.steps;

import com.linkedin.eversoncordeiro_da_silva.logics.Hellowold_PtBr_Logic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

import java.util.HashMap;

public class Helloworld_PtBr_Steps {
    private Hellowold_PtBr_Logic logic;

    public Helloworld_PtBr_Steps(){
        logic = new Hellowold_PtBr_Logic();
    }

    @Dado("eu capturei {string}")
    public void euCapturei(String pokeName) {
        logic.setCaptura(pokeName);
    }


    @Então("espero o {int}")
    public void esperoOSTATUSCODE(Integer statusCode) {
        logic.statusExpected(statusCode);
    }

    @Dado("eu sou {string} com identificador {int}")
    public void euSouComIdentificador(String trainerName, Integer trainerId) {
        logic.setTrainerId(trainerId);
    }

    @E("eu sou cadastrado no {string} como {string} no campo {string}")
    public void euSouCadastradoNoComoNoCampo(String payloadName, String workName, String campName) {
        HashMap<String, String> payload = new HashMap<>();
        payload.put(campName, workName);
        logic.setValueInPayload(payloadName, payload);
    }
}
