package ibf2022.batch1.csf.assessment.server.models;

import org.bson.Document;

public class Comment {
    public String name;
    public int rating;
    public String comment;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    //to document
    public Document toDocument() {
		Document doc = new Document();
		doc.put("name", getName());
		doc.put("rating", getRating());
		doc.put("comment", getComment());
		return doc;
	}
    
}
