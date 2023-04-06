package ibf2022.batch1.csf.assessment.server.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.data.mongodb.core.query.Criteria;
// import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import ibf2022.batch1.csf.assessment.server.models.Comment;

@Repository
public class MovieRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	// TODO: Task 5
	// You may modify the parameter but not the return type
	// Write the native mongo database query in the comment below
	//
	public int countComments(Object param) {
		int count=0;
		Criteria c = Criteria.where("title").is(param);
		
		List<String> comments = mongoTemplate.find(Query.query(c), String.class);
        if(comments.isEmpty()){
			return 0;
		} else{
			return count=comments.size();
		}
		//mongo query
		//db.find({"title"})
	}

	// TODO: Task 8
	// Write a method to insert movie comments comments collection
	// Write the native mongo database query in the comment below
	//
	public void insertComment(Comment comment) {
        //convert to document
        Document doc = comment.toDocument();
        //insert into collection
		mongoTemplate.insert(doc, "comment");
    }
	//mongo query
	// 	db.tv_shows insert ({
	// name: 
	// rating: 
	// comment:
	// })

}
