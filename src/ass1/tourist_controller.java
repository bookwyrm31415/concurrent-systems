package ass1;

import java.util.concurrent.Semaphore;

//object to keep count of where all the tourists are
class tourist_controller {
    private int tourists_at_base = 0;
    private int tourists_on_gondola = 0;
    private int tourists_at_top = 0;
    private int tourists_waiting_top = 0;
    private int down_counter = 0;

    public int getDown_counter() {
        return down_counter;
    }

    public void setDown_counter(int down_counter) {
        this.down_counter = down_counter;
    }

    Semaphore gondola_spaces = new Semaphore(10);
    Semaphore top_spaces = new Semaphore(50);

    int getTourists_at_base() {
        return tourists_at_base;
    }

    void setTourists_at_base(int tourists_at_base) {
        this.tourists_at_base = tourists_at_base;
    }

    public int getTourists_on_gondola() {
        return tourists_on_gondola;
    }

    public void setTourists_on_gondola(int tourists_on_gondola) {
        this.tourists_on_gondola = tourists_on_gondola;
    }

    public int getTourists_at_top() {
        return tourists_at_top;
    }

    public void setTourists_at_top(int tourists_at_top) {
        this.tourists_at_top = tourists_at_top;
    }

    public int getTourists_waiting_top() {
        return tourists_waiting_top;
    }

    public void setTourists_waiting_top(int tourists_waiting_top) {
        this.tourists_waiting_top = tourists_waiting_top;
    }
}
