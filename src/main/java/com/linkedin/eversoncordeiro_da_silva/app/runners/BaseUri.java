package com.linkedin.eversoncordeiro_da_silva.app.runners;

public enum BaseUri {
    POKE_API,
    REQRES_API;

    @Override
    public String toString(){
        switch (this){
            case POKE_API:
                return "https://pokeapi.co/api/v2";
            case REQRES_API:
                return "https://reqres.in/api";
            default:
                return null;
        }
    }
}
