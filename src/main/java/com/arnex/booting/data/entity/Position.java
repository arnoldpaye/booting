package com.arnex.booting.data.entity;

public enum Position {
    HOUSEKEEPING,
    SECURITY,
    FRONT_DESK,
    CONCIERGE;

    @Override
    public String toString() {
        switch (this) {
            case HOUSEKEEPING:
                return "Housekeeping";
            case SECURITY:
                return "Security";
            case FRONT_DESK:
                return "Front Desk";
            case CONCIERGE:
                return "Concierge";
        }
        return "";
    }
}
