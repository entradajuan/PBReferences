package com.needine.pbreferences.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.needine.pbreferences.domain.Reference;
import com.needine.pbreferences.domain.Service;
import com.needine.pbreferences.dto.OperationDTO;
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

    @GetMapping("/getAll")
    ResponseEntity<List<Service>> getAll() {
        log.info("Server port {}: Getting all services. ", serverPort);
        return ResponseEntity.ok(serviceService.getAll());
    }

    @GetMapping("/getServicesByReference/{ReferenceId}")
    ResponseEntity<List<Object[]>> getServicesByReference(@PathVariable String ReferenceId) {
        log.info("Server port {}: GetServicesByReference of {} reference ", serverPort, ReferenceId);
        return ResponseEntity.ok(serviceService.getServicesByReference(ReferenceId));
    }

    @PostMapping("/createService")
    ResponseEntity<Service> createService(@RequestBody Service service) {
    	log.info("Server port {}: Creating Service {}", serverPort, service.toString()); 
  	  	return ResponseEntity.ok(serviceService.create(service));
    }
    
    @PostMapping(value="/doOperation")
    ResponseEntity<OperationDTO> doOperation(@RequestBody OperationDTO transferDTO) {
    	transferDTO.setCreated(LocalDateTime.now());
    	transferDTO.setFinished("started");
    	log.info("Server port {}: Doing an operation {}", serverPort, transferDTO.toString());
    	serviceService.doOperation(transferDTO);
    	return ResponseEntity.ok(transferDTO);
    }

    
}
