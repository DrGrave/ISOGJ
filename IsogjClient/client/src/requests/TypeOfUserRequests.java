package requests;

import entity.TypeOfUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class TypeOfUserRequests {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public TypeOfUser[] getAllTypeOfUsers(String[] authorization){
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", authorization[0]);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<TypeOfUser[]> typeOfUserEnt = restTemplate.exchange(REST_SERVICE_URI + "/TypeOfUser/", HttpMethod.GET, entity, TypeOfUser[].class);
            return typeOfUserEnt.getBody();
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
