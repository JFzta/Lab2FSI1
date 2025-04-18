package com.udea.Airline.controller;

import com.udea.Airline.model.FlightRequest;
import com.udea.Airline.model.FlightResponse;
import com.udea.Airline.model.Passenger;
import com.udea.Airline.service.FlightEvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador que expone la API REST y las vistas web para evaluación de vuelos.
 */
@Controller
@RequestMapping("/flight")
public class FlightEvaluationController {

    private final FlightEvaluationService evaluationService;

    @Autowired
    public FlightEvaluationController(FlightEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    /**
     * Endpoint REST que recibe JSON con FlightRequest y devuelve FlightResponse.
     */
    @PostMapping("/api/evaluate")
    @ResponseBody
    public FlightResponse evaluateApi(
            @Valid @RequestBody FlightRequest request,
            BindingResult result) {
        if (result.hasErrors()) {
            // En caso de error de validación, devolver un FlightResponse con mensaje
            FlightResponse errorResponse = new FlightResponse();
            errorResponse.setMessage("Error de validación: " +
                    result.getAllErrors().stream()
                            .map(e -> e.getDefaultMessage())
                            .reduce((a,b) -> a + "; " + b)
                            .orElse("Datos inválidos"));
            return errorResponse;
        }
        return evaluationService.evaluate(request);
    }

    /**
     * Muestra el formulario web para ingresar datos de vuelo.
     */
    @GetMapping("/form")
    public String showForm(Model model) {
        // Inicializar FlightRequest con Passenger vacío para el form
        FlightRequest fr = new FlightRequest();
        fr.setPassenger(new Passenger());
        model.addAttribute("flightRequest", fr);
        return "flight_form";
    }

    /**
     * Procesa el formulario web y muestra el resultado.
     */
    @PostMapping("/evaluate")
    public String evaluateWeb(
            @Valid @ModelAttribute("flightRequest") FlightRequest request,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "flight_form";
        }
        FlightResponse response = evaluationService.evaluate(request);
        model.addAttribute("flightResponse", response);
        return "flight_result";
    }
}
