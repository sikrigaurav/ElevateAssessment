package com.elevate.incidents.controller;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.elevate.incidents.model.Incidents;
import com.elevate.incidents.model.UserStructure;
import com.elevate.incidents.service.IncidentsApi;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elevate")
public class ElevateController {

    @RequestMapping(value="/incidents", method=RequestMethod.GET)
    public Map<Long, UserStructure> getIncidents() throws IOException, ParseException {
        IncidentsApi api = new IncidentsApi();
        return api.getAllIncidents();
    }
}
