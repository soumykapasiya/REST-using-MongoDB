package com.kapasiya.restusingmongodb.controller;


import com.kapasiya.restusingmongodb.entity.Friend;
import com.kapasiya.restusingmongodb.serviceDef.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FriendController
{
    @Autowired
    FriendService friendService;

    @GetMapping("/friends")
    public List<Friend> getAllFriends()
    {
        return friendService.getFriends();
    }

    @PostMapping("/addFriend")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Friend> addFriend(@RequestBody Friend friend)
    {
        return friendService.addFriend(friend);
    }

    @GetMapping("/friendByName/{name}")
    public Friend getFriendByName(@PathVariable String name)
    {
        return friendService.getByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public List<Friend> removeFriendByID(@PathVariable String id)
    {
       return  friendService.removeFriend(id);
    }

    @PutMapping("/updateFriend")
    public List<Friend> updateFriend(@RequestBody Friend friend)
    {
         return  friendService.updateFriend(friend);
    }

    @GetMapping("friendByID/{id}")
    public Friend getFriendById(@PathVariable String id)
    {
        return friendService.getFriend(id);
    }

}