package org.codejudge.sb.controller;

import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.request.LeadRequest;
import org.codejudge.sb.request.StatusRequest;
import org.codejudge.sb.response.ErrorResponse;
import org.codejudge.sb.response.LeadResponse;
import org.codejudge.sb.response.Response;
import org.codejudge.sb.response.UpdateResponse;
import org.codejudge.sb.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping(value = "/leads/{id}")
    public ResponseEntity<Response> getLead(@PathVariable int id) {
        try {
            Response response = leadService.getLead(id);
            if (response instanceof LeadResponse)
                return new ResponseEntity<>(response, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("failure", "Interval Exception");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/leads")
    public ResponseEntity<Response> createLead(@RequestBody LeadRequest leadRequest) {
        try {
            Response response = leadService.createLead(leadRequest);
            if (response instanceof LeadResponse)
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            //log.info("Exception {}", e);
            ErrorResponse errorResponse = new ErrorResponse("failure", "Interval Exception");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/leads/{id}")
    public ResponseEntity<Response> updateLead(@PathVariable int id, @RequestBody LeadRequest leadRequest) {
        try {
            Response response = leadService.updateLead(id, leadRequest);
            if (response instanceof UpdateResponse)
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            //log.info("Exception {}", e);
            ErrorResponse errorResponse = new ErrorResponse("failure", "Interval Exception");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "leads/{id}")
    public ResponseEntity deleteLead(@PathVariable int id) {
        try {
            Response response = leadService.deleteLead(id);
            if (response instanceof UpdateResponse)
                return new ResponseEntity<>(response, HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            //log.info("Exception {}", e);
            ErrorResponse errorResponse = new ErrorResponse("failure", "Interval Exception");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/mark_lead/{id}")
    public ResponseEntity<Response> updateLead(@PathVariable int id, @RequestBody StatusRequest statusRequest) {
        try {
            Response response = leadService.updateLeadStatus(id, statusRequest);
            if (response instanceof UpdateResponse)
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            //log.info("Exception {}", e);
            ErrorResponse errorResponse = new ErrorResponse("failure", "Interval Exception");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
