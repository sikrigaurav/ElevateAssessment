package com.elevate.incidents.service;


import com.elevate.incidents.helper.IncidentTypes;
import com.elevate.incidents.model.*;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class IncidentsApi {

    public Map<Long, UserStructure> getAllIncidents() throws IOException, ParseException {
        IncidentTypes incidentTypes = new IncidentTypes();
        Map<String, Long> identities = incidentTypes.getIdentities();
        List<DenialIncident> denialIncidentList = incidentTypes.getDenialIncidents();
        List<UnauthorizedIncident> unauthorizedIncidentList = incidentTypes.getUnauthorizedIncidents();
        List<IntrusionIncident> intrusionIncidentList = incidentTypes.getIntrusionIncidents();
        List<ExecutableIncident> executableIncidentList = incidentTypes.getExecutableIncidents();
        List<MisuseIncident> misuseIncidentList = incidentTypes.getMisuseIncidents();
        List<ProbingIncident> probingIncidentList = incidentTypes.getProbingIncidents();
        List<OtherIncident> otherIncidentList = incidentTypes.getOtherIncidents(identities);

        List<Incidents> incidentsList = new ArrayList<>();

        for(DenialIncident denial : denialIncidentList) {
            Incidents incident = new Incidents();
            incident.setPriority(denial.getPriority());
            incident.setTimestamp(denial.getTimestamp());
            incident.setReported_by(denial.getReported_by());
            incident.setSource_ip(denial.getSource_ip());
            incident.setEmployee_id(denial.getReported_by());
            incident.setType(denial.getType());
            incidentsList.add(incident);
        }

        for(UnauthorizedIncident unauthorized : unauthorizedIncidentList) {
            Incidents incident = new Incidents();
            incident.setPriority(unauthorized.getPriority());
            incident.setTimestamp(unauthorized.getTimestamp());
            incident.setEmployee_id(unauthorized.getEmployee_id());
            incident.setType(unauthorized.getType());
            incidentsList.add(incident);
        }

        for(IntrusionIncident intrusionIncident : intrusionIncidentList) {
            Incidents incident = new Incidents();
            incident.setPriority(intrusionIncident.getPriority());
            incident.setTimestamp(intrusionIncident.getTimestamp());
            incident.setSource_ip(intrusionIncident.getSource_ip());
            incident.setEmployee_id(identities.get(intrusionIncident.getInternal_ip()));
            incident.setType(intrusionIncident.getType());
            incidentsList.add(incident);
        }

        for(ExecutableIncident executableIncident : executableIncidentList) {
            Incidents incident = new Incidents();
            incident.setPriority(executableIncident.getPriority());
            incident.setTimestamp(executableIncident.getTimestamp());
            incident.setMachine_ip(executableIncident.getMachine_ip());
            if(identities.get(executableIncident.getMachine_ip())!=null)
                incident.setEmployee_id(identities.get(executableIncident.getMachine_ip()));
            incident.setType(executableIncident.getType());
            incidentsList.add(incident);
        }

        for(MisuseIncident misuseIncident : misuseIncidentList) {
            Incidents incident = new Incidents();
            incident.setPriority(misuseIncident.getPriority());
            incident.setTimestamp(misuseIncident.getTimestamp());
            incident.setEmployee_id(misuseIncident.getEmployee_id());
            incident.setType(misuseIncident.getType());
            incidentsList.add(incident);
        }

        for(ProbingIncident probingIncident : probingIncidentList) {
            Incidents incident = new Incidents();
            incident.setPriority(probingIncident.getPriority());
            incident.setTimestamp(probingIncident.getTimestamp());
            incident.setIp(probingIncident.getIp());
            if(identities.get(probingIncident.getIp())!=null)
                incident.setEmployee_id(identities.get(probingIncident.getIp()));
            incident.setType(probingIncident.getType());
            incidentsList.add(incident);
        }

        for(OtherIncident otherIncident : otherIncidentList) {
            Incidents incident = new Incidents();
            incident.setPriority(otherIncident.getPriority());
            incident.setTimestamp(otherIncident.getTimestamp());
            incident.setEmployee_id(otherIncident.getIdentifier());
            incident.setType(otherIncident.getType());
            incidentsList.add(incident);
        }

        Map<Long,List<Incidents>> groupByEmployee= new HashMap<>();

        groupByEmployee = incidentsList.stream()
                .collect(Collectors.groupingBy(Incidents::getEmployee_id));

        TreeMap<Long, UserStructure> finalMap = new TreeMap<>();

        for(Long employeeId: groupByEmployee.keySet()) {
            UserStructure user = new UserStructure();
            LowPriorityIncident lowPriorityIncident = new LowPriorityIncident();
            MediumPriorityIncident mediumPriorityIncident = new MediumPriorityIncident();
            HighPriorityIncident highPriorityIncident = new HighPriorityIncident();
            CriticalPriorityIncident criticalPriorityIncident = new CriticalPriorityIncident();
            List<Incidents> list = groupByEmployee.get(employeeId);
            for(Incidents incidents: list) {
                if(incidents.getPriority().equalsIgnoreCase("low")) {
                    lowPriorityIncident.setIncidentsList(list);
                    lowPriorityIncident.setCount(lowPriorityIncident.getCount()+1);
                }
                else if(incidents.getPriority().equalsIgnoreCase("medium")) {
                    mediumPriorityIncident.setIncidentsList(list);
                    mediumPriorityIncident.setCount(mediumPriorityIncident.getCount()+1);
                }
                else if(incidents.getPriority().equalsIgnoreCase("high")) {
                    highPriorityIncident.setIncidentsList(list);
                    highPriorityIncident.setCount(highPriorityIncident.getCount()+1);
                }
                else {
                    criticalPriorityIncident.setIncidentsList(list);
                    criticalPriorityIncident.setCount(criticalPriorityIncident.getCount()+1);
                }
            }
            user.setLow(lowPriorityIncident);
            user.setMedium(mediumPriorityIncident);
            user.setHigh(highPriorityIncident);
            user.setCritical(criticalPriorityIncident);
            finalMap.put(employeeId, user);
        }

        return finalMap;
    }
}
