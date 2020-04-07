package ass1;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Erebor {


    public static void main(String[] args) throws InterruptedException {
        //create tourist controller
        tourist_controller tourist_controller = new tourist_controller();


        //create gondola thread
        gondola gondola = new gondola(tourist_controller);
        Thread gondola_thread = new Thread(gondola);
        gondola_thread.setName("gondola_thread");
        gondola_thread.start();


        //create station threads
        base_station base_station = new base_station(tourist_controller);
        Thread base_station_thread = new Thread(base_station);
        base_station_thread.setName("base_station_thread");
        base_station_thread.start();

        top_station top_station = new top_station(tourist_controller);
        Thread top_station_thread = new Thread(top_station);
        top_station_thread.setName("top_station_thread");
        top_station_thread.start();


        while (top_station_thread.isAlive()) {
            if (tourist_controller.getTourists_at_base() >= 10) {
                try {
                    gondola.ferry_base_to_top(10);
                } catch (Error e) {
                    e.printStackTrace();
                }

            }
            if (tourist_controller.getTourists_waiting_top() >= 10){
                try{
                    gondola.top_to_base(10);
                } catch (Error e) {
                    e.printStackTrace();
                }
            }
        }


    }


}

