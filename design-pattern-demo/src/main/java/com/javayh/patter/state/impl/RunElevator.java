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
public class RunElevator extends ElevatorState {

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯正在运行......");
    }

    @Override
    public void stop() {
        super.context.setElevatorState(ElevatorContext.stopElevator);
        super.context.getElevatorState().stop();
    }
}
