package com.needine.pbreferences.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.needine.pbreferences.domain.Reference;
import com.needine.pbreferences.service.ReferenceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reference")
public class ReferenceController {
	
    private final int serverPort;
    
    private final ReferenceService referenceService;

	@Autowired
    public ReferenceController(final ReferenceService referenceService, @Value("${server.port}") int serverPort) {
        this.referenceService = referenceService;
        this.serverPort = serverPort;
    }

    @GetMapping("/test/{value}")
    List<Reference> test(final @PathVariable("value") String value) {
        log.info("Server port {}: Getting vlue = {}  ", serverPort, value);
        
        return referenceService.getAll();
    }

}
