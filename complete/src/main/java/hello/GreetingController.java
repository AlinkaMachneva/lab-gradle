package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;


@RestController
public class GreetingController {

    private static final String template = "Your city is %s, it has %d symbols and %d symbols O!";
    private final AtomicLong counter = new AtomicLong();
    


   @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="city", defaultValue="choose a city") String city) {
                int count = city.length();
                int col = 0;
                char [] symbols = city.toCharArray();
                for (int i = 0; i < count; i++) {
                    if(symbols[i] == 'о') {
                        col++;
                    } 
                }
                
        		return new Greeting(counter.incrementAndGet(),
                            String.format(template, city, count, col));
    }
}