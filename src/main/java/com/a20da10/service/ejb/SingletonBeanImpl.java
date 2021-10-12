package com.a20da10.service.ejb;

import javax.ejb.Singleton;

@Singleton(name = "SingletonBeanImpl")
public class SingletonBeanImpl implements SingletonBeanLocal, SingletonBeanRemote{
}
