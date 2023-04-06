package ibf2022.batch1.csf.assessment.server.models;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue.ValueType;

// DO NOT MODIFY THIS CLASS
public class Review {
	// display_title
	private String title;
	// mpaa_rating
	private String rating;
	// byline
	private String byline;
	// headline
	private String headline;
	// summary_short 
	private String summary;
	// link.url
	private String reviewURL;
	// multimedia.src
	private String image = null;

	private int commentCount = 0;

	public void setTitle(String title) { this.title = title; }
	public String getTitle() { return this.title; }

	public void setRating(String rating) { this.rating = rating; }
	public String getRating() { return this.rating; }

	public void setByline(String byline) { this.byline = byline; }
	public String getByline() { return this.byline; }

	public void setHeadline(String headline) { this.headline = headline; }
	public String getHeadline() { return this.headline; }

	public void setSummary(String summary) { this.summary = summary; }
	public String getSummary() { return this.summary; }

	public void setReviewURL(String reviewURL) { this.reviewURL = reviewURL; }
	public String getReviewURL() { return this.reviewURL; }

	public void setImage(String image) { this.image = image; }
	public String getImage() { return this.image; }
	public boolean hasImage() { return null != this.image; }

	public void setCommentCount(int commentCount) { this.commentCount = commentCount; };
	public int getCommentCount() { return this.commentCount; }


	@Override
	public String toString() {
		return "Review{title:%s, rating:%s}".formatted(title, rating);
	}

	public static List<Review> create(String response) throws IOException{
		//initialise new list
		// List<Review> r = new LinkedList<>();

		//stream the json string
		String payload = response;

		JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject movieResp = reader.readObject();
        JsonArray jsonArr = movieResp.getJsonArray("results");
		if(jsonArr.getValueType()==ValueType.NULL){
			return Collections.emptyList();
		} else{
			return jsonArr.stream()
                .map(v -> v.asJsonObject())
                .map(Review::createReview)
                .toList();
		}
	}

	public static Review createReview(JsonObject o){
        //initialise a new character
        Review r = new Review();
        
        //getting needed info
		r.title= o.getString("display_title");
		r.rating= o.getString("mpaa_rating");
		r.byline= o.getString("byline");
		r.headline= o.getString("headline");
		r.summary= o.getString("summary_short");
		
		//to extract the image and url
		// JsonObject link = o.getJsonObject("link");
		// JsonObject multimedia = o.getJsonObject("multimedia");
		
		// if(link!=null && multimedia!=null){
		// 	r.reviewURL= link.getString("url");
		// r.image= multimedia.getString("src");
		// }
		// returned null....

		if (o.get("multimedia").getValueType() != ValueType.NULL) {
            System.out.println(o.get("multimedia").getValueType() + " multimedia");
            System.out.println(o.get("link").getValueType() + " multimedia link");

            r.image=o.getJsonObject("multimedia").getString("src");
        }else {
			r.image="/image/placeholder.jpg";
		}

		//return this review
		System.out.println("what is here? "+r);
        return r;
    }
	
}
