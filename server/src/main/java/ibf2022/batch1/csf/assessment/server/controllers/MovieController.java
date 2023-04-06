package ibf2022.batch1.csf.assessment.server.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.batch1.csf.assessment.server.models.Comment;
import ibf2022.batch1.csf.assessment.server.models.Review;
import ibf2022.batch1.csf.assessment.server.repositories.MovieRepository;
import ibf2022.batch1.csf.assessment.server.services.MovieService;
import jakarta.json.JsonArray;

@RestController
@CrossOrigin("**")
public class MovieController {

	// TODO: Task 3, Task 4, Task 8

	//Task 3/4
	@Autowired
	private MovieService mSvc;

	@Autowired
	private MovieRepository mRepo;

	@GetMapping(path="/api/search")
	public ResponseEntity<List<Review>> getReview
	(@RequestParam(required = true) String movieName) throws IOException
	{	
		JsonArray result = null;

		List<Review> r = this.mSvc.searchReviews(movieName);
		System.out.println("The list of reviews:"+r);
		
        if (r.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

	//Task 8
	@PostMapping(path="/api/comment")
	public ResponseEntity<String> postComment (
		@RequestBody(required=true) Comment formVal){
			mRepo.insertComment(formVal);

			return new ResponseEntity<>(HttpStatus.OK);
		}
        
	


}
