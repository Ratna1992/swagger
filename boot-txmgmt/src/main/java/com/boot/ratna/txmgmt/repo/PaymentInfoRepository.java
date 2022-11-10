package com.boot.ratna.txmgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.ratna.txmgmt.entity.PaymentEntity;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentEntity, String> {

}
