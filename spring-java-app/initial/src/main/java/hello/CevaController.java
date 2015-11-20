package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CevaController {

    private static final String template = "Acest program e o prostie , %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/ceva")
    public Ceva ceva(@RequestParam(value="exemplu", defaultValue="totusi sper sa mearga") String exemplu) {
        return new Ceva(counter.incrementAndGet(),
                            String.format(template, exemplu));
    }
}
