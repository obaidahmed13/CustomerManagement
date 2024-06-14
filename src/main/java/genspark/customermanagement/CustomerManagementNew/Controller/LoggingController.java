package CustomerManagmentSystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoggingController {
    @GetMapping("/log")
    public void Log() {
//        Log logger;
        Logger logger = LoggerFactory.getLogger("LoggingController.class");
        logger.trace("Log level");

    }
}
