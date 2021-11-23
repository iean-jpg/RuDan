package com.liyue.servlet.product;

import com.liyue.pojo.product;
import com.liyue.service.product.ProductService;
import com.liyue.service.product.ProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/product/updateProduct")
public class editServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        product product = new product();
        int prodId = Integer.parseInt(req.getParameter("prodId"));
        product.setProdId(prodId);
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    String filedName = item.getFieldName();
                    if (filedName.equals("catid")) {
                        product.setCatId(Integer.parseInt(item.getString("utf-8")));
                    } else if (filedName.equals("prodname")) {
                        product.setProdName(item.getString("utf-8"));
                    } else if (filedName.equals("prodtype")) {
                        product.setProdType(item.getString("utf-8"));
                    } else if (filedName.equals("prodprice")) {
                        product.setProdPrice(Float.parseFloat(item.getString("utf-8")));
                    } else if (filedName.equals("proddesc")) {
                        product.setProdText(item.getString("utf-8"));
                    } else if (filedName.equals("prodfirstshow")) {
                        product.setProdFirstShow(Integer.parseInt(item.getString("utf-8")));
                    }
                } else {
                    String filename = item.getName();
                    if (filename != null && !filename.equals("")) {
                        String ext = filename.substring(filename.lastIndexOf("."));
                        String newFileName = (new Date()).getTime() + ext;
                        String path = this.getServletContext().getRealPath("/images");
                        File file = new File(path, newFileName);
                        item.write(file);
                        product.setProdImage(newFileName);
                    }
                }
            }
            productService.updateProduct(product);
            resp.sendRedirect("/product/getallproduct");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

