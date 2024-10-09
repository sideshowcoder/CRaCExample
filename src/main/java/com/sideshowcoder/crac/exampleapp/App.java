package com.sideshowcoder.crac.exampleapp;

import java.time.Duration;

public class App {

    private static long counter = 0;
    private static CracCounter cracCounter = new CracCounter();

    public static void main(String[] args) {
        System.out.println("Running CRaC Example");
        System.out.println("CRaC Example PID(" + ProcessHandle.current().pid() + ")");

        try {

            while(true) {
                Thread.sleep(Duration.ofSeconds(1));
                System.out.println("counter(" + counter++ + ") cracCounter(" + cracCounter.getAndIncrement() + ")");
            }

        } catch (Exception e) {
            System.out.println("Received " + e.getMessage());
            System.out.println("Shutting down.");
        }

        System.exit(0);
    }

}
