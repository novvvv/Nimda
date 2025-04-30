package com.nimda.nimda;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class SolvedAcProfileController {

    private final RestTemplate restTemplate = new RestTemplate();

    private final List<String> userIds = List.of(
            "ju020620",
            "seoyun",
            "nov2pro",
            "blue234",
            "seojun",
            "chaasspp"
    );

    @GetMapping("/profiles")
    public String getProfiles(Model model) {
        List<Map<String, Object>> profiles = new ArrayList<>();

        for (String userId : userIds) {
            String url = "https://solved.ac/api/v3/user/show?handle=" + userId;
            try {
                ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
                if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                    Map<String, Object> original = response.getBody();
                    Map<String, Object> filtered = new HashMap<>();
                    filtered.put("handle", userId);
                    filtered.put("tier", original.get("tier"));
                    filtered.put("rating", original.get("rating"));
                    filtered.put("solvedCount", original.get("solvedCount"));
                    filtered.put("rank", original.get("rank"));
                    profiles.add(filtered);
                }
            } catch (Exception e) {
                System.out.println("Failed to fetch for user: " + userId);
            }
        }

        // Tier 기준 내림차순 정렬
        profiles.sort((a, b) -> {
            Integer tierA = (Integer) a.get("tier");
            Integer tierB = (Integer) b.get("tier");
            return tierB.compareTo(tierA); // 내림차순
        });

        model.addAttribute("profiles", profiles);
        return "profiles";
    }




}