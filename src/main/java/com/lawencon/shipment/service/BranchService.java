package com.lawencon.shipment.service;

import java.util.List;
import com.lawencon.shipment.model.BranchRegions;

/**
 * @author Dzaky Fadhilla Guci
 */

public interface BranchService {

	List<BranchRegions> getListBranch() throws Exception;

	BranchRegions insertBranch(BranchRegions branch) throws Exception;

	BranchRegions getBranchByCode(String branchCode) throws Exception;

	BranchRegions updateData(BranchRegions branch) throws Exception;

    void deleteData(String id) throws Exception;
}
