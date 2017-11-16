package requests;

import entity.Gender;
import entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class AdminRequests {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public Gender[] getAllGenders(String[] authorization){
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", authorization[0]);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<Gender[]> genderEnt = restTemplate.exchange(REST_SERVICE_URI + "/Gender/", HttpMethod.GET, entity, Gender[].class);
            return genderEnt.getBody();
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
