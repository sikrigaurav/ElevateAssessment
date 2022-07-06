package com.elevate.incidents.model;

import java.util.ArrayList;
import java.util.List;

public class MediumPriorityIncident {
    private int count;
    private List<Incidents> incidentsList = new ArrayList<>();;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Incidents> getIncidentsList() {
        return incidentsList;
    }

    public void setIncidentsList(List<Incidents> incidentsList) {
        this.incidentsList = incidentsList;
    }
}
