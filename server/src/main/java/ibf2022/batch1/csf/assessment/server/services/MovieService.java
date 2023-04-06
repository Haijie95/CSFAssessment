package ibf2022.batch1.csf.assessment.server.services;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ibf2022.batch1.csf.assessment.server.models.Review;;

@Service
public class MovieService {
	private static final String NY_TIME_URL="https://api.nytimes.com/svc/movies/v2/reviews/search.json"; 
	private static final String API_KEY="3DciUIlFCCJ4YAXHkelQAk9StF76jiGG";

	// TODO: Task 4
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	public List<Review> searchReviews(String query) throws IOException{
		
		ResponseEntity<String> response=null;
		List<Review> r = null;
		
		//create the uri string
		String reviewUrl = UriComponentsBuilder
		.fromUriString(NY_TIME_URL)
		.queryParam("query", query)
		.queryParam("api-key", API_KEY)
		.toUriString();

		//got the link correct
		// System.out.println("The link is :"+reviewUrl);

		RestTemplate template = new RestTemplate();
		response = template.getForEntity(reviewUrl, String.class);
		
		//got the response
		// System.out.println(response);
	
		r=Review.create(response.getBody());

		System.out.println(r);

		return r;
	}

}
