package com.neetpiq.spring.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description")
			));
	
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	
	public Topic getTopic(String topicId) {
		return topics.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
	}


	public void addTopic(Topic topic) {
		topics.add(topic);
	}


	public void updateTopic(String id, Topic topic) {
		for(int idx=0; idx < topics.size(); idx++) {
			Topic curTopic = topics.get(idx);
			if(curTopic.getId().equals(id)) {
				topics.set(idx, topic);
				break;
			}
		}
		
		return;
	}


	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
