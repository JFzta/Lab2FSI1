package com.udea.Airline.service;

import java.util.concurrent.ThreadLocalRandom;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.Airline.model.FlightRequest;
import com.udea.Airline.model.FlightResponse;

@Service
public class FlightEvaluationService {

    private final KieContainer kieContainer;

    @Autowired
    public FlightEvaluationService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    /**
     * Evalúa un FlightRequest generando datos aleatorios de vuelo y retraso,
     * dispara las reglas y retorna un FlightResponse con los resultados.
     */
    public FlightResponse evaluate(FlightRequest request) {
//        // 1. Generar datos aleatorios de vuelo
//        double randomDuration = ThreadLocalRandom.current().nextDouble(0.5, 12.0);
//        int randomDelay = ThreadLocalRandom.current().nextInt(0, 241);
//        boolean randomEmergency = ThreadLocalRandom.current().nextBoolean();
//
//        request.setFlightDurationHours(randomDuration);
//        request.setFlightDelayMinutes(randomDelay);
//        request.setEmergencyExitAvailable(randomEmergency);

        if (request.getFlightDurationHours() == null) {
            double randomDuration = ThreadLocalRandom.current().nextDouble(0.5, 12.0);
            request.setFlightDurationHours(randomDuration);
        }

        if (request.getFlightDelayMinutes() == null) {
            int randomDelay = ThreadLocalRandom.current().nextInt(0, 241);
            request.setFlightDelayMinutes(randomDelay);
        }

        if (request.getEmergencyExitAvailable() == null) {
            boolean randomEmergency = ThreadLocalRandom.current().nextBoolean();
            request.setEmergencyExitAvailable(randomEmergency);
        }
        // 2. Preparar respuesta y sesión Drools
        FlightResponse response = new FlightResponse();
        KieSession kieSession = kieContainer.newKieSession();

        try {
            // 3. Insertar hechos
            kieSession.insert(request);
            kieSession.insert(response);

            // 4. Disparar todas las reglas definidas en flight_rules.drl
            kieSession.fireAllRules();
        } finally {
            // 5. Liberar la sesión
            kieSession.dispose();
        }

        return response;
    }
}

