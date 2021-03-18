package com.cg.hims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Integer>{

	public Policy addPolicy(Policy policy);

	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException;

	public Policy findPolicyById(Integer policyId) throws PolicyNotFoundException;

	public Policy removePolicy(Integer policyId) throws PolicyNotFoundException;

	public List<Policy> showAllPolicies();

}
