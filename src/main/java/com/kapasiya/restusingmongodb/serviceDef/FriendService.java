package com.kapasiya.restusingmongodb.serviceDef;

import com.kapasiya.restusingmongodb.entity.Friend;
import java.util.List;

public interface FriendService
{
    List<Friend> getFriends();

    List<Friend> addFriend(Friend friend);

    List<Friend> removeFriend(String id);

    List<Friend> updateFriend(Friend friend);

    Friend getFriend(String id);

    Friend getByName(String name);
}
