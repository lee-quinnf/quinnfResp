package com.ben.crm.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ben.crm.domain.Customer;
import com.ben.crm.domain.PageBean;
import com.ben.crm.service.CustomerService;
import com.ben.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * 客户管理的Action类
 * 
 * @author quinnf
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	// 模型驱动使用的对象
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}

	// 注入Service
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 使用set方法的方式接收数据:
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		if (currPage == null) {
			currPage = 1;
		}
		this.currPage = currPage;
	}

	// 使用set方法接受每页显示记录数
	private Integer pageSize = 3;

	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	/**
	 * 文件上传提供的三个属性:
	 */
	private String uploadFileName; // 文件名称
	private File upload; // 上传文件
	private String uploadContentType; // 文件类型

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 客户管理：跳转到添加页面的方法:saveUI
	 */
	public String saveUI() {
		return "saveUI";
	}

	/**
	 * 保存客户的方法：save
	 * 
	 * @throws IOException
	 */
	public String save() throws IOException {
		// 上传图片:
		if (upload != null) {
			// 文件上传：
			// 设置文件上传路径:
			String path = "C:/upload";
			// 一个目录下存放的相同文件名：随机文件名
			String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
			// 一个目录下存放的文件过多：目录分离
			String realPath = UploadUtils.getPath(uuidFileName);
			// 创建目录:
			String url = path + realPath;
			File file = new File(url);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 文件上传:
			File dictFile = new File(url + "/" + uuidFileName);
			FileUtils.copyFile(upload, dictFile);
			// 设置image的属性的值:
			customer.setCust_image(url + "/" + uuidFileName);
		}
		// 保存客户
		customerService.save(customer);
		return "saveSuccess";
	}

	/**
	 * 分页查询客户的方法：findAll
	 */
	public String findAll() {
		// 接收参数：分页参数
		// 最好使用DetachedCriteria对象（条件查询--带分页）
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		// 设置条件：（在web层设置条件）
		if (customer.getCust_name() != null) {
			// 输入名称:
			detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		if (customer.getBaseDictSource() != null) {
			if (customer.getBaseDictSource().getDict_id() != null
					&& !"".equals(customer.getBaseDictSource().getDict_id())) {
				detachedCriteria
						.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
			}

		}
		if (customer.getBaseDictLevel() != null) {
			if (customer.getBaseDictLevel().getDict_id() != null
					&& !"".equals(customer.getBaseDictLevel().getDict_id())) {
				detachedCriteria
						.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
			}
		}
		if (customer.getBaseDictIndustry() != null && customer.getBaseDictIndustry().getDict_id() != null) {
			if (customer.getBaseDictIndustry().getDict_id() != null
					&& !"".equals(customer.getBaseDictIndustry().getDict_id())) {
				detachedCriteria
						.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
			}
		}
		// 调用业务层查询:
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	/**
	 * 删除客户的方法：delete
	 */
	public String delete() {
		// 先查询，再删除。
		customer = customerService.findById(customer.getCust_id());
		// 删除图片:
		if (customer.getCust_image() != null) {
			File file = new File(customer.getCust_image());
			if (file.exists()) {
				file.delete();
			}
		}
		// 删除客户:
		customerService.delete(customer);
		return "deleteSuccess";
	}

	/**
	 * 编辑客户的方法:edit
	 */
	public String edit() {
		// 根据id查询，跳转页面，回显数据
		customer = customerService.findById(customer.getCust_id());
		// 将customer传递到页面：
		// 两种方式：一种，手动压栈。二种，因为模型驱动的对象，默认在栈顶。
		// 如果使用第一种方式：回显数据: <s:property value="cust_name"/> <s: name="cust_name"
		// value="">
		// 如果使用第二种方式：回显数据: <s:property value="model.cust_name"/>
		// ActionContext.getContext().getValueStack().push(customer);
		// 跳转页面
		return "editSuccess";
	}

	/**
	 * 修改客户的方法:update
	 * 
	 * @throws IOException
	 */
	public String update() throws IOException {
		// 文件项是否已经选择：如果选择了，就删除原有文件，上传新文件。如果没有选，使用原有即可。
		if (upload != null) {
			// 已经选择了:
			// 删除原有文件:
			String cust_image = customer.getCust_image();
			if (cust_image != null || !"".equals(cust_image)) {
				File file = new File(cust_image);
				file.delete();
			}
			// 文件上传：
			// 设置文件上传路径:
			String path = "C:/upload";
			// 一个目录下存放的相同文件名：随机文件名
			String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
			// 一个目录下存放的文件过多：目录分离
			String realPath = UploadUtils.getPath(uuidFileName);
			// 创建目录:
			String url = path + realPath;
			File file = new File(url);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 文件上传:
			File dictFile = new File(url + "/" + uuidFileName);
			FileUtils.copyFile(upload, dictFile);

			customer.setCust_image(url + "/" + uuidFileName);
		}
		customerService.update(customer);
		return "updateSuccess";
	}
	
	public String findAllCustomer() throws IOException{
		List<Customer> list = customerService.findAll();
		// 将list转成JSON:
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"linkMans","baseDictSource","baseDictLevel","baseDictIndustry"});
		// 转成JSOn:
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
}
