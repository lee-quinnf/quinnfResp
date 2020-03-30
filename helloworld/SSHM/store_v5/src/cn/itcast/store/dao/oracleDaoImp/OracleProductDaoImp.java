package cn.itcast.store.dao.oracleDaoImp;

import java.util.List;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.domain.Product;

public class OracleProductDaoImp implements ProductDao {

	@Override
	public List<Product> findHots() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findNews() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductByPid(String pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRecords(String cid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalRecords() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> findAllProductsWithPage(int startIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Product product) throws Exception {
		// TODO Auto-generated method stub

	}

}
