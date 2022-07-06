package com.elevate.incidents.model;

import java.util.Date;

public class OtherIncident {
    private String priority;

    private long identifier;

    private Double timestamp;

    private String type = "other";

    public String getPriority() {
        return priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }
}
