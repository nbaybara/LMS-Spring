package com.nur.librarymanagement.repository;

import com.nur.librarymanagement.entity.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
