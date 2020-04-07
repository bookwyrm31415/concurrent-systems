package ass1;

public class base_station implements Runnable {
    private final ass1.tourist_controller tourist_controller;
    int counter = 0;

    public base_station(ass1.tourist_controller tourist_controller) {
        this.tourist_controller = tourist_controller;
    }

    @Override
    public void run() {
        System.out.println("Created " + Thread.currentThread().getName());
        //TODO up to 500
//        tourist_controller.setTourists_at_base(25);
        for(int i=0;i<500;i++) {
            int t_a_b = tourist_controller.getTourists_at_base();
            tourist_controller.setTourists_at_base(t_a_b+1);
            System.out.println("Person arrived");
            try {
                Thread.sleep((int)(Math.random()*200));
            } catch (InterruptedException ignored) {}
        }
        System.out.println("500 people arrived");
        return;
    }
}
