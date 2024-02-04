package com.trading.common.annotation.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
@Component
public class CountLockAspect {

    private final Lock lock = new ReentrantLock();

    @Pointcut("@annotation(com.trading.common.annotation.lock.CountLock)")
    public void lockPointcut() {
    }

    @Around("lockPointcut()")
    public Object lock(ProceedingJoinPoint joinPoint) throws Throwable {
        lock.lock();
        try {
            return joinPoint.proceed();
        } finally {
            lock.unlock();
        }
    }
}
