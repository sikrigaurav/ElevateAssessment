package com.elevate.incidents.model;

import java.util.Date;

public class IntrusionIncident {
    private String priority;

    private String internal_ip;

    private String source_ip;
    private Double timestamp;

    private String type = "intrusion";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInternal_ip() {
        return internal_ip;
    }

    public void setInternal_ip(String internal_ip) {
        this.internal_ip = internal_ip;
    }

    public String getPriority() {
        return priority;
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

    public String getSource_ip() {
        return source_ip;
    }

    public void setSource_ip(String source_ip) {
        this.source_ip = source_ip;
    }
}
