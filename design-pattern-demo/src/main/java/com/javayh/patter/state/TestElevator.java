package com.javayh.patter.state;

import com.javayh.patter.state.impl.CloseElevator;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-08-25
 */
public class TestElevator {
    public static void main(String[] args) {
        ElevatorContext context = new ElevatorContext();
        context.setElevatorState(new CloseElevator());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
