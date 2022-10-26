package com.kamran.hassan.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // Indicates that an annotated class is a "Repository", originally defined by Domain-Driven Design (Evans, 2003) as "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".
public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findByroomNumber(String roomNumber);
}

// More Example - https://www.baeldung.com/spring-data-crud-repository-save#:~:text=CrudRepository%20is%20a%20Spring%20Data,for%20interacting%20with%20a%20database.


// Inplace of Long anything like String, UUID, etc can be used but remember this refers to primary if or key