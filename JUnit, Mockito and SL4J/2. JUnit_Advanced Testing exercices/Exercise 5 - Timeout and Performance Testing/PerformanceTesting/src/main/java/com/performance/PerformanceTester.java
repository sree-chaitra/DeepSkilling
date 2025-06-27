package com.performance;

public class PerformanceTester {
	public void performTask() {
        // Simulate a task that takes some time (for example, 200ms)
        try {
            Thread.sleep(200);  // 200 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
