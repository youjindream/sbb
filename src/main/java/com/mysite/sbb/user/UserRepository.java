package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	 Optional<SiteUser> findByusername(String username); // optional: 객체가 없거나 1개, List: 객체가 여러개(0이상)
}
