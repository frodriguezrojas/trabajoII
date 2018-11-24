package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private Square square = null;
    
    @GetMapping
    @RequestMapping("/get_square")
    public Square getSquare() {
        return square;
    }
    
    @PostMapping
    @RequestMapping("/create_square")
    public Square createSquare(@RequestParam(value="base", defaultValue="1") int base) {
    	square = new Square(counter.incrementAndGet(), base);
        return square;
    }
    
    @DeleteMapping
    @RequestMapping("/delete_square")
    public String deleteSquare() {
    	square = null;
        return "{ \"message\": \"Square deleted successfully\" }";
    }
    
    @RequestMapping("/update_square")
    public Square updateSquare(@RequestParam(value="base", defaultValue="1") int base) {
    	if(square!=null) {
        	square.changeBase(base);
            return square;
    	}else {
    		return null;
    	}
    }
}