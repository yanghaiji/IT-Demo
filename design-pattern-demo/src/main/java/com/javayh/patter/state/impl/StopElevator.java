package com.javayh.patter.state.impl;

import com.javayh.patter.state.ElevatorContext;
import com.javayh.patter.state.ElevatorState;

/**
 * <p>
 * 某种电梯
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-08-25
 */
public class StopElevator extends ElevatorState {

    @Override
    public void open() {
       super.context.setElevatorState(ElevatorContext.openElevator);
       super.context.getElevatorState().open();
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        super.context.setElevatorState(ElevatorContext.runElevator);
        super.context.getElevatorState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了......");
    }
}
