package com.owlapps.samarony.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.owlapps.samarony.model.DatabaseCarSequence;

@Service
public class SequenceCarGeneratorService {
	
	@Autowired 
	private MongoOperations mongo;
	
	public long generateSequence(String seqName) {
	    DatabaseCarSequence counter = mongo.findAndModify(query(where("_id").is(seqName)),
	      new Update().inc("seq",1), options().returnNew(true).upsert(true),
	      DatabaseCarSequence.class);
	    return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
}