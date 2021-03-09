package com.lawencon.shipment.dao.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.BranchDao;
import com.lawencon.shipment.error.IllegalRequestException;
import com.lawencon.shipment.model.BranchRegions;
import com.lawencon.shipment.repo.BranchRegionsRepo;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository(value = "jpa_branch")
public class BranchDaoJpaImpl extends BaseDao implements BranchDao {

	@Autowired
	private BranchRegionsRepo branchRegionsRepo;

	@Override
	public List<BranchRegions> getListBranch() throws Exception {
		return branchRegionsRepo.findAll();
	}

	@Override
	public BranchRegions insertBranch(BranchRegions branch) throws Exception {
		branchRegionsRepo.save(branch);
		return branch;
	}

	@Override
	public BranchRegions getBranchByCode(String branchCode) throws Exception {
		return branchRegionsRepo.findByBranchCode(branchCode);

	}

	@Override
	public BranchRegions updateData(BranchRegions branch) throws Exception {
		return branchRegionsRepo.save(branch);
	}

	@Override
    public void deleteData(String id) throws Exception {
      branchRegionsRepo.deleteById(id);
	}

    @Override
    public BranchRegions findById(String id) throws Exception {
      return branchRegionsRepo.findById(id)
          .orElseThrow(() -> new IllegalRequestException("id", id));

    }

}
