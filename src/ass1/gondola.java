package ass1;

import java.util.concurrent.*;

class gondola implements Runnable{

    private final ass1.tourist_controller tourist_controller;
    private int base_or_top;

    gondola(ass1.tourist_controller tourist_controller) {
        this.tourist_controller = tourist_controller;
    }


    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException{
    //timeout?

        return true;
    }


//TODO
//get permits for gondola spaces and spaces at the top
//move people from bottom to top
// release gondola permits
//get permits for gondola spaces
//move people from top to gone    (make sure ti increase top_station.counter)
// release gondola and top space permits

    @Override
    public void run() {
        System.out.println("Created " + Thread.currentThread().getName());

    }
}
