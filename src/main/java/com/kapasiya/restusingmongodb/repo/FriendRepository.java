package com.kapasiya.restusingmongodb.repo;

import com.kapasiya.restusingmongodb.entity.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface FriendRepository extends MongoRepository<Friend, String>
{
     Friend findByName(String name);
}
