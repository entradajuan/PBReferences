package com.needine.pbreferences.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.needine.pbreferences.domain.Reference;
import com.needine.pbreferences.domain.Service;
import com.needine.pbreferences.service.ReferenceService;
import com.needine.pbreferences.service.ServiceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/service")
public class ServiceController {

    private final int serverPort;
    
    private final ServiceService serviceService;

    public ServiceController(final ServiceService serviceService, @Value("${server.port}") int serverPort) {
    	this.serverPort = serverPort;
    	this.serviceService = serviceService;
    }
    
    @PostMapping("/createService")
    ResponseEntity<Service> createService(@RequestBody Service service) {
        log.info("Server port {}: Creating Service {}", serverPort, service.toString());
  	  return ResponseEntity.ok(serviceService.create(service));
    }

    
}
