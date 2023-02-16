package com.example.lab3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Stores the time taken to process the request in ms, the attempt time in ms, and result of the attempt.
 */
@Entity(name="attempts")
@Table(name="attempts", schema = "s335191")
public class PointAttempt {
    @Id
    @SequenceGenerator(name="attemptsIdGenerator", sequenceName = "ATTEMPTS_ID_GEN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attemptsIdGenerator")
    private long id;
    private double x;
    private double y;
    private double r;
    @Column(name="attempt_time")
    private long attemptTime;
    @Column(name="process_time")
    private double processTime;
    private boolean success;

    public long getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public long getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(long attemptTime) {
        this.attemptTime = attemptTime;
    }

    public double getProcessTime() {
        return processTime;
    }

    public void setProcessTime(double processTime) {
        this.processTime = processTime;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}