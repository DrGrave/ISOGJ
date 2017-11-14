package requests;


import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



public class LoginController {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public String loginEvent(MyUserCredentials user) {
        System.out.println("Testing create User API----------");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(user, httpHeaders ); // for request
            HttpEntity<String> response = restTemplate.exchange(REST_SERVICE_URI+"/login", HttpMethod.POST, entity, String.class);
            HttpHeaders headers = response.getHeaders();
            if (headers.get("Authorization") != null) {
                return headers.get("Authorization").get(0);
            } return null;
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
