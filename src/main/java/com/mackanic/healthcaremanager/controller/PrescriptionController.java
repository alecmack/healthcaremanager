package com.mackanic.healthcaremanager.controller;

import com.mackanic.healthcaremanager.model.Prescription;
import com.mackanic.healthcaremanager.service.PrescriptionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("writeNew/patient/{patientId}/provider/{providerId}")
    public ResponseEntity<String> writeNewPrescription(@PathVariable Long patientId, @PathVariable
                                                    Long providerId, @RequestBody Prescription prescription) {

        return prescriptionService.writeNewPrescription(patientId, providerId, prescription);

    }

    @DeleteMapping("delete/{prescriptionId}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long prescriptionId) {
        return prescriptionService.deletePrescription(prescriptionId);
    }

}
