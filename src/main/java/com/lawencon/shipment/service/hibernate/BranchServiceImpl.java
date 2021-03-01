package com.lawencon.shipment.service.hibernate;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.BranchDao;
import com.lawencon.shipment.model.BranchRegions;
import com.lawencon.shipment.service.BranchService;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	@Qualifier(value = "jpa_branch")
	private BranchDao branchDao;

	@Override
	public List<BranchRegions> getListBranch() throws Exception {
		return branchDao.getListBranch();

	}

	@Override
	public BranchRegions insertBranch(BranchRegions branch) throws Exception {
		String branchCode = "BR" + branch.getRegion();
		branch.setBranchCode(branchCode.toUpperCase());
		return branchDao.insertBranch(branch);

	}

	@Override
	public BranchRegions getBranchByCode(String branchCode) throws Exception {
		return branchDao.getBranchByCode(branchCode);
	}

	@Override
	public BranchRegions updateData(BranchRegions branch) throws Exception {
		String branchCode = "BR" + branch.getRegion();
		branch.setBranchCode(branchCode.toUpperCase());
		return branchDao.updateData(branch);
	}

	@Override
    public void deleteData(String id) throws Exception {
      branchDao.deleteData(id);
	}
}
