package com.elevate.incidents.helper;

import com.elevate.incidents.common.ElevateResponse;
import com.elevate.incidents.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidentTypes {
    public List<DenialIncident> getDenialIncidents() throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        List<DenialIncident> listDenial = new ArrayList<>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/incidents/denial/");
        JSONArray jsonArray = (JSONArray) incidents.get("results");
        for (Object o : jsonArray) {
            DenialIncident denialIncident = new DenialIncident();
            JSONObject obj = (JSONObject) o;
            denialIncident.setPriority((String) obj.get("priority"));
            denialIncident.setReported_by((Long) obj.get("reported_by"));
            denialIncident.setTimestamp((Double) obj.get("timestamp"));
            denialIncident.setSource_ip((String) obj.get("source_ip"));
            listDenial.add(denialIncident);
        }
        return listDenial;
    }

    public List<IntrusionIncident> getIntrusionIncidents() throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        List<IntrusionIncident> listIntrusion = new ArrayList<>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/incidents/intrusion/");
        JSONArray jsonArray = (JSONArray) incidents.get("results");
        for (Object o : jsonArray) {
            IntrusionIncident intrusionIncident = new IntrusionIncident();
            JSONObject obj = (JSONObject) o;
            intrusionIncident.setPriority((String) obj.get("priority"));
            intrusionIncident.setInternal_ip((String) obj.get("internal_ip"));
            intrusionIncident.setTimestamp((Double) obj.get("timestamp"));
            intrusionIncident.setSource_ip((String) obj.get("source_ip"));
            listIntrusion.add(intrusionIncident);
        }
        return listIntrusion;
    }

    public List<ExecutableIncident> getExecutableIncidents() throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        List<ExecutableIncident> listExecutable = new ArrayList<>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/incidents/executable/");
        JSONArray jsonArray = (JSONArray) incidents.get("results");
        for (Object o : jsonArray) {
            ExecutableIncident executableIncident = new ExecutableIncident();
            JSONObject obj = (JSONObject) o;
            executableIncident.setPriority((String) obj.get("priority"));
            executableIncident.setMachine_ip((String) obj.get("machine_ip"));
            executableIncident.setTimestamp((Double) obj.get("timestamp"));
            listExecutable.add(executableIncident);
        }
        return listExecutable;
    }

    public List<MisuseIncident> getMisuseIncidents() throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        List<MisuseIncident> listMisuse = new ArrayList<>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/incidents/misuse/");
        JSONArray jsonArray = (JSONArray) incidents.get("results");
        for (Object o : jsonArray) {
            MisuseIncident misuseIncident = new MisuseIncident();
            JSONObject obj = (JSONObject) o;
            misuseIncident.setPriority((String) obj.get("priority"));
            misuseIncident.setEmployee_id((Long) obj.get("employee_id"));
            misuseIncident.setTimestamp((Double) obj.get("timestamp"));
            listMisuse.add(misuseIncident);
        }
        return listMisuse;
    }

    public List<ProbingIncident> getProbingIncidents() throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        List<ProbingIncident> listProbing = new ArrayList<>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/incidents/probing/");
        JSONArray jsonArray = (JSONArray) incidents.get("results");
        for (Object o : jsonArray) {
            ProbingIncident probingIncident = new ProbingIncident();
            JSONObject obj = (JSONObject) o;
            probingIncident.setPriority((String) obj.get("priority"));
            probingIncident.setIp((String) obj.get("ip"));
            probingIncident.setTimestamp((Double) obj.get("timestamp"));
            listProbing.add(probingIncident);
        }
        return listProbing;
    }

    public List<OtherIncident> getOtherIncidents(Map<String, Long> identities) throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        List<OtherIncident> listOther = new ArrayList<>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/incidents/other/");
        JSONArray jsonArray = (JSONArray) incidents.get("results");
        for (Object o : jsonArray) {
            OtherIncident otherIncident = new OtherIncident();
            JSONObject obj = (JSONObject) o;
            otherIncident.setPriority((String) obj.get("priority"));
            if(obj.get("identifier") instanceof String)
                otherIncident.setIdentifier(identities.get(obj.get("identifier")));
            else
                otherIncident.setIdentifier((Long) obj.get("identifier"));
            otherIncident.setTimestamp((Double) obj.get("timestamp"));
            listOther.add(otherIncident);
        }
        return listOther;
    }

    public List<UnauthorizedIncident> getUnauthorizedIncidents() throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        List<UnauthorizedIncident> listUnauthorized = new ArrayList<>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/incidents/unauthorized/");
        JSONArray jsonArray = (JSONArray) incidents.get("results");
        for (Object o : jsonArray) {
            UnauthorizedIncident unauthorizedIncident = new UnauthorizedIncident();
            JSONObject obj = (JSONObject) o;
            unauthorizedIncident.setPriority((String) obj.get("priority"));
            unauthorizedIncident.setEmployee_id((Long) obj.get("employee_id"));
            unauthorizedIncident.setTimestamp((Double) obj.get("timestamp"));
            listUnauthorized.add(unauthorizedIncident);
        }
        return listUnauthorized;
    }

    public Map<String,Long> getIdentities() throws IOException, ParseException {
        ElevateResponse response = new ElevateResponse();
        Map<String,Long> map = new HashMap<String,Long>();
        JSONObject incidents = response.getResponse("https://incident-api.use1stag.elevatesecurity.io/identities/");
        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(incidents.toJSONString(), new TypeReference<HashMap<String,Long>>(){});
        return map;
    }
}
