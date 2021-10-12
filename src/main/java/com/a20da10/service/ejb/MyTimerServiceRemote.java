package com.a20da10.service.ejb;

import javax.ejb.Remote;
import javax.ejb.Timer;

@Remote
public interface MyTimerServiceRemote {
    public void setTimer(long interval);
    public void programmaticTimeout(Timer timer);
}
