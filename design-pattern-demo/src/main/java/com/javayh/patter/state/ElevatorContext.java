package com.javayh.patter.state;

import com.javayh.patter.state.impl.CloseElevator;
import com.javayh.patter.state.impl.OpenElevator;
import com.javayh.patter.state.impl.RunElevator;
import com.javayh.patter.state.impl.StopElevator;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-08-25
 */
public class ElevatorContext {
    public final static OpenElevator openElevator = new OpenElevator();
    public final static CloseElevator closeElevator = new CloseElevator();
    public final static RunElevator runElevator = new RunElevator();
    public final static StopElevator stopElevator = new StopElevator();
    private ElevatorState elevatorState;

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
        this.elevatorState.setContext(this);
    }


    public void open() {
        this.elevatorState.open();
    }

    public void close() {
        this.elevatorState.close();
    }

    public void run() {
        this.elevatorState.run();
    }

    public void stop() {
        this.elevatorState.stop();
    }
}
