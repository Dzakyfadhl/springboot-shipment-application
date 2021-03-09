package com.lawencon.shipment.service.hibernate;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.shipment.dao.BranchDao;
import com.lawencon.shipment.model.BranchRegions;
import com.lawencon.shipment.service.BranchService;
import com.lawencon.shipment.util.ValidationUtil;

/**
 * @author Dzaky Fadhilla Guci
 */

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

  @Autowired
  @Qualifier(value = "jpa_branch")
  private BranchDao branchDao;

  @Autowired
  private ValidationUtil validationUtil;

  @Override
  public List<BranchRegions> getListBranch() throws Exception {
    return branchDao.getListBranch();

  }

  @Override
  public BranchRegions insertBranch(BranchRegions branch) throws Exception {
    String branchCode = "BR" + branch.getRegion();
    branch.setCreatedAt(LocalDateTime.now());
    branch.setBranchCode(branchCode.toUpperCase());
    return branchDao.insertBranch(branch);
  }

  @Override
  public BranchRegions getBranchByCode(String branchCode) throws Exception {
    return branchDao.getBranchByCode(branchCode);
  }

  @Override
  public BranchRegions updateData(BranchRegions branch) throws Exception {
    BranchRegions br = findById(branch.getId());

    br.setRegion(branch.getRegion());
    br.setPhone(branch.getPhone());
    br.setAddress(branch.getAddress());
    br.setUpdatedBy(branch.getUpdatedBy());
    br.setUpdatedAt(LocalDateTime.now());

    String branchCode = "BR" + branch.getRegion();
    br.setBranchCode(branchCode.toUpperCase());
    return branchDao.updateData(br);
  }

  @Override
  public void deleteData(String id) throws Exception {
    validationUtil.validateUUID(id);
    BranchRegions branch = branchDao.findById(id);
    branchDao.deleteData(branch.getId());
  }

  @Override
  public BranchRegions findById(String id) throws Exception {
    validationUtil.validateUUID(id);
    return branchDao.findById(id);
  }
}
