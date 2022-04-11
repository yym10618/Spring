package kr.co.ch07.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.CustomerVo;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerVo, String> {

}
