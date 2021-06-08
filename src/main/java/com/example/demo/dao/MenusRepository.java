package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Menus;



@Repository
public interface MenusRepository extends JpaRepository<Menus, Long>{
	@org.springframework.data.jpa.repository.Query("select u from Menus u where u.qr = ?1")
	List<Menus> findByQr(long qr);
}
