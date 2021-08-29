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
public class OpenElevator extends ElevatorState {

    @Override
    public void open() {
        System.out.println("电梯门开启......");
    }

    @Override
    public void close() {
        super.context.setElevatorState(ElevatorContext.closeElevator);
        super.context.getElevatorState().close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
