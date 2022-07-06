package com.elevate.incidents.model;

import java.util.Date;

public class DenialIncident {

    private String priority;

    private long reported_by;

    private Double timestamp;

    private String source_ip;

    private String type = "denial";

    public String getType() {
        return type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getReported_by() {
        return reported_by;
    }

    public void setReported_by(long reported_by) {
        this.reported_by = reported_by;
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
