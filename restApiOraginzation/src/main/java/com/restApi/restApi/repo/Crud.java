package com.restApi.restApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restApi.restApi.dto.Qsp;

@Repository
public interface Crud extends JpaRepository<Qsp, String>
{

}
