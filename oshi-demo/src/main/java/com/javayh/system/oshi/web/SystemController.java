package com.javayh.system.oshi.web;

import com.javayh.system.oshi.entity.SystemHardwareInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-10-11
 */
@RestController
public class SystemController {

    @GetMapping
    public SystemHardwareInfo sys() throws Exception {
        SystemHardwareInfo systemHardwareInfo = new SystemHardwareInfo();
        systemHardwareInfo.copyTo();
        return systemHardwareInfo;
    }
}
