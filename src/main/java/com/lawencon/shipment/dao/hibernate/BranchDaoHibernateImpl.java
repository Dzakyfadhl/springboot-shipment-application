package com.lawencon.shipment.dao.hibernate;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.lawencon.shipment.dao.BaseDao;
import com.lawencon.shipment.dao.BranchDao;
import com.lawencon.shipment.model.BranchRegions;

/**
 * @author Dzaky Fadhilla Guci
 */
@Repository
public class BranchDaoHibernateImpl extends BaseDao implements BranchDao {

	@Override
	public List<BranchRegions> getListBranch() throws Exception {
		List<BranchRegions> listResult = em.createQuery("from BranchRegions", BranchRegions.class).getResultList();
		return listResult;

	}

	@Override
	public BranchRegions insertBranch(BranchRegions branch) throws Exception {
		em.persist(branch);
		return branch;
	}

	@Override
	public BranchRegions getBranchByCode(String branchCode) throws Exception {

		List<BranchRegions> listResult = em
				.createQuery("from BranchRegions where branch_code = ?1 ", BranchRegions.class)
				.setParameter(1, branchCode).getResultList();

		return getResultModel(listResult);

	}

	@Override
	public BranchRegions updateData(BranchRegions branch) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void deleteData(String id) throws Exception {
		// TODO Auto-generated method stub

	}

}
