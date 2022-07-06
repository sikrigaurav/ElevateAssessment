package com.elevate.incidents.model;

import java.util.List;

public class Incidents implements Comparable<Incidents>{
    private String type;
    private String priority;
    private long employee_id;
    private Double timestamp;
    private String source_ip;

    private String machine_ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private String ip;

    public String getMachine_ip() {
        return machine_ip;
    }

    public void setMachine_ip(String machine_ip) {
        this.machine_ip = machine_ip;
    }

    private long reported_by;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
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

    public long getReported_by() {
        return reported_by;
    }

    public void setReported_by(long reported_by) {
        this.reported_by = reported_by;
    }

    public int compareTo(Incidents incident) {
        long employeeId = ((Incidents) incident).getEmployee_id();
        return (int) (this.employee_id - employeeId);
    }
}
