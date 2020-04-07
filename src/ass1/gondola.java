package ass1;

import java.util.concurrent.*;

class gondola implements Runnable{

    private final ass1.tourist_controller tourist_controller;
    private int base_or_top;

    gondola(ass1.tourist_controller tourist_controller) {
        this.tourist_controller = tourist_controller;
    }


    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException{


        return true;
    }





    @Override
    public void run() {
        System.out.println("Created " + Thread.currentThread().getName());
    }
}
