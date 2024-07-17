package com.kapasiya.restusingmongodb.serviceImpl;

import com.kapasiya.restusingmongodb.entity.Friend;
import com.kapasiya.restusingmongodb.repo.FriendRepository;
import com.kapasiya.restusingmongodb.serviceDef.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FriendServiceImpl implements FriendService
{
    @Autowired
    private FriendRepository friendRepository;

    @Override
    public List<Friend> getFriends()
    {
        return friendRepository.findAll();
    }

    @Override
    public List<Friend> addFriend(Friend friend)
    {
        System.out.println(friend.getEmail());
        System.out.println(friend.getName());
        System.out.println(friend.getPhone());
        friend.setId(UUID.randomUUID().toString().split("-")[0]);
        friendRepository.save(friend);
        return friendRepository.findAll();
    }

    @Override
    public List<Friend> removeFriend(String id)
    {
        friendRepository.deleteById(id);
        return friendRepository.findAll();
    }

    @Override
    public List<Friend> updateFriend(Friend friend)
    {

        Friend friendData = friendRepository.findById(friend.getId()).orElse(null);

        if(friendData != null)
        {
            friendData.setName(friend.getName());
            friendData.setEmail(friend.getEmail());
            friendData.setPhone(friend.getPhone());

            friendRepository.save(friendData);
        }
        else
            return null;

        return friendRepository.findAll();
    }

    @Override
    public Friend getFriend(String id)
    {
        return friendRepository.findById(id).orElse(null);
    }

    @Override
    public Friend getByName(String name)
    {
        return friendRepository.findByName(name);
    }
}
