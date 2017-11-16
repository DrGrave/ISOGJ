package requests;

import entity.MyUserCredentials;
import entity.User;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



public class LoginController {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public String[] loginEvent(MyUserCredentials user) {
        System.out.println("Testing create User API----------");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(user, httpHeaders ); // for request
            HttpEntity<String> response = restTemplate.exchange(REST_SERVICE_URI+"/login", HttpMethod.POST, entity, String.class);
            HttpHeaders headers = response.getHeaders();
            String[] head = new String[]{headers.get("Authorization").get(0), headers.get("UserId").get(0)};
            if (headers.get("Authorization") != null && headers.get("UserId") != null) {
                return head;
            } return null;
        }catch (HttpClientErrorException ex){
            return null;
        }
    }

    public User getUser(String[] auto) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", auto[0]);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<User> userEntity = restTemplate.exchange(REST_SERVICE_URI + "/User/"+auto[1], HttpMethod.GET, entity, User.class);
            return userEntity.getBody();
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
