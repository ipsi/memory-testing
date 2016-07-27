package io.pivotal.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DevouringController {

    private final String url;

    @Autowired
    public DevouringController(@Value("${api_url}") String url) {
        this.url = url;
    }

    @RequestMapping("/devour")
    public Map<String, Object> devour() {
        RestOperations restOperations = new RestTemplate();
        ResponseEntity<Map> entity = restOperations.getForEntity(url, Map.class);
        if (!entity.getStatusCode().is2xxSuccessful())
            throw new RuntimeException("Bad response from sleeper! [" + entity.getStatusCode() + "]");

        Map<String, Object> v = new HashMap<>();
        v.put("devoured", entity.getBody().get("consumable"));
        v.put("taste", "delicious");

        return v;
    }
}
