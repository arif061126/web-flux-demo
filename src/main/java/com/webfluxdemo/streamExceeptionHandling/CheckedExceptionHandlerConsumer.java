package com.webfluxdemo.streamExceeptionHandling;

@FunctionalInterface //not mandatory
public interface CheckedExceptionHandlerConsumer <Target, ExceptionObject extends Exception>{
    public void accept(Target target) throws ExceptionObject;
}
