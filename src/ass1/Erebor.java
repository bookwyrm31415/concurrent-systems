package ass1;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Erebor {


    public static void main(String[] args) throws InterruptedException {
        //create tourist controller
        tourist_controller tourist_controller = new tourist_controller();


        //create gondola thread
        gondola gondola = new gondola( tourist_controller);
        Thread gondola_thread = new Thread(gondola);
        gondola_thread.setName("gondola_thread");
        gondola_thread.start();


        //create station threads
        base_station base_station = new base_station(tourist_controller);
        Thread base_station_thread = new Thread(base_station);
        base_station_thread.setName("base_station_thread");
//        base_station_thread.start();

        top_station top_station = new top_station(tourist_controller);
        Thread top_station_thread = new Thread(top_station);
        top_station_thread.setName("top_station_thread");
        top_station_thread.start();






        while (top_station_thread.isAlive()){

//            gondola.tryAcquire(10,1,TimeUnit.SECONDS);
//            gondola.tryAcquire(10,1,TimeUnit.SECONDS);
            tourist_controller.setTourists_at_top(20);
            for ( int i = 0; i <20 ;i++){
                top_station.top_to_queue();
            }


        }
        }




    }
