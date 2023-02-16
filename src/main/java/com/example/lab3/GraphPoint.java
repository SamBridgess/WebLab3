package com.example.lab3;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class GraphPoint {
    private double x;
    private double y;
    private double r;

    @Inject
    private AttemptsManager attempts;

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

    public void submit() {
        final long start = System.nanoTime();
        final boolean res = AreaChecker.check(x, y, r);

        PointAttempt attempt = new PointAttempt();
        attempt.setX(x);
        attempt.setY(y);
        attempt.setR(r);
        attempt.setSuccess(res);
        attempt.setAttemptTime(System.currentTimeMillis());
        attempt.setProcessTime((System.nanoTime() - start) / 1000d);

        attempts.addAttempt(attempt);
    }
}
