package com.elevate.incidents.model;

import java.util.Date;

public class UnauthorizedIncident {
    private String priority;

    private long employee_id;

    private Double timestamp;

    private String type = "unauthorized";

    public String getType() {
        return type;
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

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }
}
