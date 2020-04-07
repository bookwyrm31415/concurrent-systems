package ass1;

public class top_station implements Runnable {
    private final ass1.tourist_controller tourist_controller;
    int counter = 0;

    void increment_counter(){
        counter += 1;
    }

    public top_station(ass1.tourist_controller tourist_controller) {
        this.tourist_controller = tourist_controller;
    }

    void top_to_queue(){
        if (tourist_controller.getTourists_at_top() > 0) {
            //move someone from the top to the waiting to get down queue
            int t_a_t = tourist_controller.getTourists_at_top();
            int t_a_t_q = tourist_controller.getTourists_waiting_top();
            tourist_controller.setTourists_at_top(t_a_t - 1);
            tourist_controller.setTourists_waiting_top(t_a_t_q + 1);
            System.out.println("A tourist is waiting to get down");
            increment_counter();
        }

    }

    @Override
    public void run() {
        System.out.println("Created " + Thread.currentThread().getName());
        //TODO set to 500
        while  (counter <= 20){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            top_to_queue();

        }
        System.out.println("Everyone is home");
        return;
    }
}
