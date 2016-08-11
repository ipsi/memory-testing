package io.pivotal.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DevouringController {

    private final String url;

    @Autowired
    public DevouringController(@Value("${api_url}") String url) {
        this.url = url;
    }

    public ResponseEntity<String> proxy(@RequestHeader HttpHeaders headers, @RequestBody String body) throws URISyntaxException {
        RequestEntity<String> requestEntity = new RequestEntity<>(body, headers, HttpMethod.POST, new URI("http://"));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(requestEntity, String.class);
    }

    @RequestMapping("/devour")
    public Map<String, Object> devour() {
        Map<String, Object> v = new HashMap<>();

        RestOperations restOperations = new RestTemplate();
        ResponseEntity<Map> entity = restOperations.getForEntity(url, Map.class);
        if (!entity.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Bad response from sleeper! [" + entity.getStatusCode() + "]");
        }

        v.put("devoured", entity.getBody().get("consumable"));
        v.put("taste", "delicious");


        return v;
    }

    @RequestMapping("/devour_not")
    public Map<String, Object> devourNot() {
        Map<String, Object> v = new HashMap<>();
        v.put("devoured", "half roast oxen");
        v.put("taste", "delicious");

        return v;
    }
}
