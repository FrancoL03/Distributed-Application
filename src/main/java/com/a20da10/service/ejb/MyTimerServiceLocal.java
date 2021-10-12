package com.a20da10.service.ejb;

import javax.ejb.Local;
import javax.ejb.Timer;

@Local
public interface MyTimerServiceLocal {
    public void setTimer(long interval);
    public void programmaticTimeout(Timer timer);
}
