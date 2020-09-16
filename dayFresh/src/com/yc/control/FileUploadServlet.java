package com.yc.control;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.yc.dao.GoodsDAO;
import com.yc.dao.impl.GoodsDAOImpl;
import com.yc.po.GoodsPO;
import com.yc.util.StringUtil;

@WebServlet("/goodsFile.action")
public class FileUploadServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -518690603780591930L;
	GoodsDAO dao = new GoodsDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("add".equals(op)) {
			doFileUpload(request, response);
		} else if ("update".equals(op)) {
			update(request, response);
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String typeNo = null;
		String balance = null;
		String price = null;
		String goodsName = null;
		String intro = null;
		//String pictures = null;
		String unit = null;
		String qperied = null;
		String weight = null;
		String descr = null;
		String imagePath = null;
		try {
			// 创建磁盘文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 获取文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求对象
			List<FileItem> list = upload.parseRequest(request);
			if (null != list) {
				for (FileItem item : list) {
					if (item.isFormField()) {
						// 普通表单元素
						
						if ("typeNo".equals(item.getFieldName())) {
							typeNo = item.getString("UTF-8");
						} else if ("balance".equals(item.getFieldName())) {
							balance = item.getString("UTF-8");
						} else if ("price".equals(item.getFieldName())) {
							price = item.getString("UTF-8");
						} else if ("goodsName".equals(item.getFieldName())) {
							goodsName = item.getString("UTF-8");
						} else if ("intro".equals(item.getFieldName())) {
							intro = item.getString("UTF-8");
						} else if ("unit".equals(item.getFieldName())) {
							unit = item.getString("UTF-8");
						} else if ("qperied".equals(item.getFieldName())) {
							qperied = item.getString("UTF-8");
						} else if ("weight".equals(item.getFieldName())) {
							weight = item.getString("UTF-8");
						} else if ("descr".equals(item.getFieldName())) {
							descr = item.getString("UTF-8");
						}
					} else {
						// 文件
					

						// 图片永久存放在服务器中
						String path = this.getServletContext().getRealPath("/") + "../goodsimages";
						
						// 文件名字冲突
						String fileName = System.currentTimeMillis() + item.getName();
						File file = new File(path, fileName);
						// 将图片数据写入到file文件中
						item.write(file);
						imagePath = "../goodsimages/" + file.getName();
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 将数据封装到po对象中
		GoodsPO po = new GoodsPO();
		String goodsNo = (String) request.getSession().getAttribute("goodsNo");
		if (goodsNo != null) {
			int goodsno = Integer.valueOf(goodsNo);
			po.setGoodsNo(goodsno);
		}
		po.setDescr(descr);
		po.setGoodsName(goodsName);
		po.setIntro(intro);
		po.setPictures(imagePath);
		po.setQperied(qperied);
		po.setUnit(unit);
		po.setWeight(weight);
		if (StringUtil.isNotNull(typeNo)) {
			po.setTypeNo(Integer.parseInt(typeNo));
		}
		if (StringUtil.isNotNull(balance)) {
			po.setBalance(Integer.parseInt(balance));
		}
		if (StringUtil.isNotNull(price)) {
			po.setPrice(Double.parseDouble(price));
		}
		// 调用dao方法
		try {
			int a = dao.modifyGoodsPO(po);
			toPrintJson(response, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doFileUpload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String typeNo = null;
		String balance = null;
		String price = null;
		String goodsName = null;
		String intro = null;
		//String pictures = null;
		String unit = null;
		String qperied = null;
		String weight = null;
		String descr = null;
		String imagePath = null;
		try {
			// 创建磁盘文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 获取文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求对象
			List<FileItem> list = upload.parseRequest(request);
			if (null != list) {
				for (FileItem item : list) {
					if (item.isFormField()) {
						// 普通表单元素
						if ("typeNo".equals(item.getFieldName())) {
							typeNo = item.getString("UTF-8");
						} else if ("balance".equals(item.getFieldName())) {
							balance = item.getString("UTF-8");
						} else if ("price".equals(item.getFieldName())) {
							price = item.getString("UTF-8");
						} else if ("goodsName".equals(item.getFieldName())) {
							goodsName = item.getString("UTF-8");
						} else if ("intro".equals(item.getFieldName())) {
							intro = item.getString("UTF-8");
						} else if ("unit".equals(item.getFieldName())) {
							unit = item.getString("UTF-8");
						} else if ("qperied".equals(item.getFieldName())) {
							qperied = item.getString("UTF-8");
						} else if ("weight".equals(item.getFieldName())) {
							weight = item.getString("UTF-8");
						} else if ("descr".equals(item.getFieldName())) {
							descr = item.getString("UTF-8");
						}
					} else {
						// 图片永久存放在服务器中
						String path = this.getServletContext().getRealPath("/") + "../goodsimages";
						// 文件名字冲突
						String fileName = System.currentTimeMillis() + item.getName();
						File file = new File(path, fileName);
						// 将图片数据写入到file文件中
						item.write(file);
						imagePath = "../goodsimages/" + file.getName();
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 将数据封装到po对象中
		GoodsPO po = new GoodsPO();
		po.setDescr(descr);
		po.setGoodsName(goodsName);
		po.setIntro(intro);
		po.setPictures(imagePath);
		po.setQperied(qperied);
		po.setUnit(unit);
		po.setWeight(weight);
		if (StringUtil.isNotNull(typeNo)) {
			po.setTypeNo(Integer.parseInt(typeNo));
		}
		if (StringUtil.isNotNull(balance)) {
			po.setBalance(Integer.parseInt(balance));
		}
		if (StringUtil.isNotNull(price)) {
			po.setPrice(Double.parseDouble(price));
		}
		// 调用dao方法
		try {
			int a = dao.addGoods(po);
			toPrintJson(response, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
