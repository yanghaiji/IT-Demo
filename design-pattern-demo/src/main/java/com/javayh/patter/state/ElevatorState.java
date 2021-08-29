package com.javayh.patter.state;

/**
 * <p>
 * 维护状态的抽象
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-08-25
 */
public abstract class ElevatorState {
    protected ElevatorContext context;

    public void setContext(ElevatorContext context) {
        this.context = context;
    }


    /**
     * 开门
     */
    public abstract void open();

    /**
     * 关门
     */
    public abstract void close();

    /**
     * 运行
     */
    public abstract void run();

    /**
     * 停止
     */
    public abstract void stop();
}
