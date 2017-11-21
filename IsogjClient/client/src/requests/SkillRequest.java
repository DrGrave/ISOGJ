package requests;

import entity.UserSkill;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SkillRequest {
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    public UserSkill[] getAllUserSkills(String[] authorization, int userId){
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", authorization[0]);
            HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
            HttpEntity<UserSkill[]> userSkillEnt = restTemplate.exchange(REST_SERVICE_URI + "/UserSkill/"+ userId, HttpMethod.GET, entity, UserSkill[].class);
            return userSkillEnt.getBody();
        }catch (HttpClientErrorException ex){
            return null;
        }
    }
}
