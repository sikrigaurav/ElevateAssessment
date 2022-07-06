package com.elevate.incidents.model;

import java.util.Date;

public class ExecutableIncident {
    private String priority;

    private String machine_ip;

    private Double timestamp;

    private String type = "executable";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMachine_ip() {
        return machine_ip;
    }

    public void setMachine_ip(String machine_ip) {
        this.machine_ip = machine_ip;
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
}
