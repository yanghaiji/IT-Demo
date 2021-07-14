package com.javayh.advanced.java.function;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-06-03
 */
public class TestFunction {
    public static void main(String[] args) {
        UserDto userDto = new UserDto(1,"234");
        print(userDto);
    }

    public static <T> void print(UserDto userDto){
        AppFunction<UserDto, Integer> appFunction1 = new AppFunction<UserDto, Integer>() {
            @Override
            public Integer app(UserDto dto) {
                return dto.getAge();
            }
        };
        AppFunction<UserDto, Integer> appFunction2 = dto -> dto.getAge();
        AppFunction<UserDto, Integer> appFunction3 = UserDto::getAge;
        System.out.println(appFunction3.app(userDto));
    }
}


@Data
class UserDto{
    private Integer age;
    private String name;

    public UserDto(Integer age, String name) {
        this.age =age;
        this.name =name;
    }
}

@FunctionalInterface
interface AppFunction<F,T>{
    T app(F f);
}

