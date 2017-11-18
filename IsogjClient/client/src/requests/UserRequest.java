package requests;

import entity.TypeOfUser;
import entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class UserRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public User[] getAllUsers(String[] authorization){
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", authorization[0]);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<User[]> usersEnt = restTemplate.exchange(REST_SERVICE_URI + "/User/", HttpMethod.GET, entity, User[].class);
            return usersEnt.getBody();
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
