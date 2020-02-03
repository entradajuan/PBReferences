package com.needine.pbreferences.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reference")
public class ReferenceController {
	
    private final int serverPort;
    
//    private final ReferenceService referenceService;

	@Autowired
    public ReferenceController(/*final MessageService messageService,*/ @Value("${server.port}") int serverPort) {
//        this.messageService = messageService;
        this.serverPort = serverPort;
    }

    @GetMapping("/test/{value}")
    int test(final @PathVariable("value") String value) {
        log.info("Server port {}: Getting vlue = {}  ", serverPort, value);
        
        return 200;
    }

}
