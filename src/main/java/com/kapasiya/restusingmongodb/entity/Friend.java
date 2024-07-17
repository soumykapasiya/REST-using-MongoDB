package com.kapasiya.restusingmongodb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("friends")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend
{
    @Id
    private String id;
    private String name;
    private String email;
    private long phone;
}
