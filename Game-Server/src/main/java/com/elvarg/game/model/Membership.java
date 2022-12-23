package com.elvarg.game.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Membership {
    private int daysRemaining;
    private LocalDateTime startDate;

    public Membership() {
        this.daysRemaining = 0;
        this.startDate = LocalDateTime.now();
    }

    public int getDaysRemaining() {
        return daysRemaining;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void addTime(int days) {
        this.daysRemaining += days;
    }

    public void removeDay() {
        this.daysRemaining--;
        this.startDate = LocalDateTime.now();
    }

    public void checkTime() {
        if (daysRemaining < 0) {
            daysRemaining = 0;
            return;
        }
        if (LocalDateTime.now().isAfter(startDate.plusDays(1))) {
            removeDay();
        }
    }

    public boolean isMember() {
        if (daysRemaining > 0)
            return true;
        else
            return false;
    }

    public void setAs(Membership other) {
        this.daysRemaining = other.daysRemaining;
        this.startDate = other.startDate;
    }
}
