package ass1;

import java.util.concurrent.*;

class gondola implements Runnable{

    private final ass1.tourist_controller tourist_controller;
    private int base_or_top;

    gondola(ass1.tourist_controller tourist_controller) {
        this.tourist_controller = tourist_controller;
    }


    public boolean tryAcquiregondola(int permits, long timeout, TimeUnit unit) throws InterruptedException{
//        System.out.println("entered tryacquire gondola");
        for (int i = 0;i< permits;i++) {
            if (!tourist_controller.gondola_spaces.tryAcquire(timeout, unit)){
                System.out.println("No gondola spaces");
                return false;
            }
        }
//        System.out.println("exited tryacquire gondola");
        //I didnt realise tryaquire actually took the permits, will try fix later
        tourist_controller.gondola_spaces.release(permits);
        return true;
    }

    public boolean tryAcquiretop(int permits, long timeout, TimeUnit unit) throws InterruptedException{
//        System.out.println("entered tryacquire summit");
        for (int i = 0;i< permits;i++) {
            if (!tourist_controller.top_spaces.tryAcquire(timeout, unit)){
//                System.out.println("No summit spaces");
//                Thread.sleep(10000);
                return false;
            }
        }
        //I didnt realise tryaquire actuallytook the permits, will try fix later

        tourist_controller.top_spaces.release(permits);
//        System.out.println("exited tryacquire summit");

        return true;
    }


    void ferry_base_to_top(int passengers) throws InterruptedException {
//        System.out.println("entered ferry base to top");
        if (tryAcquiregondola(passengers,10,TimeUnit.MILLISECONDS) && tryAcquiretop(passengers,10,TimeUnit.MILLISECONDS)){
//            System.out.println("entered ferry base to top, passed if");
            tourist_controller.gondola_spaces.acquire(passengers);
            tourist_controller.top_spaces.acquire(passengers);
            int t_a_b = tourist_controller.getTourists_at_base();
            int t_a_t = tourist_controller.getTourists_at_top();
            tourist_controller.setTourists_at_base(t_a_b - passengers);
            tourist_controller.setTourists_at_top(t_a_t + passengers);
            tourist_controller.gondola_spaces.release(passengers);
            System.out.println(passengers + " passengers have gone to the top");
        }
    }

    void top_to_base(int passengers) throws InterruptedException {
        if (tryAcquiregondola(passengers,10,TimeUnit.MILLISECONDS)){
            tourist_controller.gondola_spaces.acquire(passengers);
            int t_a_t_q = tourist_controller.getTourists_waiting_top();
            tourist_controller.setTourists_waiting_top(t_a_t_q- passengers);
            tourist_controller.setDown_counter(tourist_controller.getDown_counter() + passengers);
            System.out.println(tourist_controller.getDown_counter() + " tourists have gone down so far");
            tourist_controller.gondola_spaces.release(passengers);
            tourist_controller.top_spaces.release(passengers);

        }




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
