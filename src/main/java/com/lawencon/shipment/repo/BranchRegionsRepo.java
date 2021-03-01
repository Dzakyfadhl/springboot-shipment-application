package com.lawencon.shipment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.model.BranchRegions;

/**
 * @author Dzaky Fadhilla Guci
 */

@Repository
public interface BranchRegionsRepo extends JpaRepository<BranchRegions, String> {

	BranchRegions findByBranchCode(String branchCode) throws Exception;
}
