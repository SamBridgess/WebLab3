package com.example.lab3;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class FormPoint implements Serializable {
    // This class uses evil workarounds because ace components sliderEntry can
    // only store integer values, so we store X and R values as integers and
    // then convert them to floats with specified steps.

    private int x = 0;
    private String y = "0.0";
    private int r = 0;

    private boolean valid = true;
    private String xMsg = "";
    private String yMsg = "";
    private String rMsg = "";

    @Inject
    private transient AttemptsManager attempts;

    private void validateAll() {
        valid = true;

        xMsg = "";
        if (x < -6 || x > 6) {
            valid = false;
            xMsg = "X should be a value between -3 and 3";
        }

        yMsg = "";
        try {
            double dy = Double.parseDouble(y);
            if (dy < -3 || dy > 3) {
                valid = false;
                yMsg = "Y should be a float between -3 and 3";
            }
        } catch (NumberFormatException e) {
            valid = false;
            yMsg = "Invalid number";
        }

        rMsg = "";
        if (r < 0 || r > 16 || r % 4 != 0) {
            valid = false;
            rMsg = "R should be a integer between 2 and 5";
        }
    }

    public void submit() {
        // If data is not valid, frontend should stop user
        // from reaching this method
        if (!valid) return;

        final long start = System.nanoTime();
        final double x = this.x / 2.0d;
        final double y = Double.parseDouble(this.y);
        final double r = this.r / 4.0d + 2;
        final boolean res = AreaChecker.check(x, y, r);
        System.out.println(x);
        System.out.println(y);
        System.out.println(r);
        System.out.println(res);

        PointAttempt attempt = new PointAttempt();
        attempt.setX(x);
        attempt.setY(y);
        attempt.setR(r);
        attempt.setSuccess(res);
        attempt.setAttemptTime(System.currentTimeMillis());
        attempt.setProcessTime((System.nanoTime() - start) / 1000d);

        attempts.addAttempt(attempt);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        validateAll();
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
        validateAll();
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
        validateAll();
    }

    public String getXMsg() {
        return xMsg;
    }

    public String getYMsg() {
        return yMsg;
    }

    public String getRMsg() {
        return rMsg;
    }

    public boolean isValid() {
        return valid;
    }
}
