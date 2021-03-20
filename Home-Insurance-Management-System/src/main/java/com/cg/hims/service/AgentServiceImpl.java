package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.repository.AgentRepository;
import com.cg.hims.repository.PolicyHolderRepository;



@Service
@Transactional
public class AgentServiceImpl implements AgentService{
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private PolicyHolderRepository iPolicyHolderRepository;
	
	@Override
	public Agent addAgent(Agent agent) throws AgentException
	{
		try {			
			return agentRepository.save(agent);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}
		
	}

	@Override
	public Agent updateAgent(Agent agent) throws AgentNotFoundException
	{
		try {
			return agentRepository.save(agent);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
		
		
		
	}

	@Override
	public void removeAgent(int agentId) throws AgentNotFoundException
	{
		try {
			agentRepository.deleteById(agentId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public Agent findAgentById(int agentId) throws AgentNotFoundException
	{
		try {
			Optional<Agent> optional= agentRepository.findById(agentId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Agentno");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Agent> viewAllAgents() throws AgentException
	{
		try {
			return agentRepository.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AgentException(e.getMessage());
		}
	}
	
	@Override
	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		try {			
			return iPolicyHolderRepository.save(policyHolder);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException {
		try {			
			return iPolicyHolderRepository.save(policyHolder);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public void deletePolicyHolder(Integer policyHolderId) throws PolicyHolderNotFoundException {
		try {			
			iPolicyHolderRepository.deleteById(policyHolderId);
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public PolicyHolder getPolicyHolderById(Integer policyHolderId) throws PolicyHolderNotFoundException {
		try {
			Optional<PolicyHolder> optional=iPolicyHolderRepository.findById(policyHolderId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid PolicyHolder Id");
			}
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<PolicyHolder> getAllPolicyHolders() throws PolicyHolderNotFoundException {
		try {			
			return iPolicyHolderRepository.findAll();
		}catch(DataAccessException e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyHolderNotFoundException(e.getMessage());
		}
	}
	
}
