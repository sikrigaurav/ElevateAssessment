package com.elevate.incidents.model;

public class UserStructure {
    private LowPriorityIncident low;
    private MediumPriorityIncident medium;
    private HighPriorityIncident high;
    private CriticalPriorityIncident critical;

    public LowPriorityIncident getLow() {
        return low;
    }

    public void setLow(LowPriorityIncident low) {
        this.low = low;
    }

    public MediumPriorityIncident getMedium() {
        return medium;
    }

    public void setMedium(MediumPriorityIncident medium) {
        this.medium = medium;
    }

    public HighPriorityIncident getHigh() {
        return high;
    }

    public void setHigh(HighPriorityIncident high) {
        this.high = high;
    }

    public CriticalPriorityIncident getCritical() {
        return critical;
    }

    public void setCritical(CriticalPriorityIncident critical) {
        this.critical = critical;
    }
}
