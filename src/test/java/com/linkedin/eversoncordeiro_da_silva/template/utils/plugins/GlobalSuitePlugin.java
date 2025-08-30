package com.linkedin.eversoncordeiro_da_silva.template.utils.plugins;

import com.linkedin.eversoncordeiro_da_silva.template.utils.Context;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;

// TODO: KILL IT IN VERSION CUCUMBER 7+
@Deprecated
public class GlobalSuitePlugin implements ConcurrentEventListener {
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        // "BeforeAll" – uma vez no início da suíte
        publisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        // "AfterAll" – uma vez no final da suíte
        publisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);

    }

    private void onTestRunStarted(TestRunStarted event) {
        Context.start();
        // inicialização global aqui (conexões, carregar configs, etc.)
    }

    private void onTestRunFinished(TestRunFinished event) {
        System.out.println("Tearing down the test environment...");
//        System.out.println(rest().log().all()); // Log all requests and responses for debugging purposes.
        Context.tearDown();
        // finalização global aqui (fechar conexões, flush de relatórios, etc.)
    }
}
