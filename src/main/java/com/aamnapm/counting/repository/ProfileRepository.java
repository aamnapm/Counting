package com.aamnapm.counting.repository;

import com.aamnapm.counting.model.Profile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Transactional
public interface ProfileRepository extends PagingAndSortingRepository<Profile, UUID>, JpaSpecificationExecutor<Profile> {

    Optional<Profile> findById(UUID uuid);

    Optional<Profile> findByName(String name);

    Optional<Profile> findByNationalCode(String nationalCode);

    Optional<Profile> findByAge(int age);

    List<Profile> findAll();

    void deleteById(UUID uuid);


//    @Override
//    void deleteById(UUID uuid);
}
