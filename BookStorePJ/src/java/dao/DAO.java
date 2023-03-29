/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCategoryID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "  FROM [product]\n"
                + "  where  cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByIDNguoiBan(int sellID) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "  FROM [product]\n"
                + "  where  sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, sellID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchListProductByName(String search) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "  FROM [product]\n"
                + "  where  [name] like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);

            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Product getProductByID(String id) {

        try {
            String sql = "SELECT *\n"
                    + "  FROM [product]\n"
                    + "  where  id = ?";
            //PreparedStatement lad truyen co tham so , statement la truyen ko co tham so
            conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setImage(rs.getString(3));
            product.setPrice(rs.getInt(4));
            product.setTitle(rs.getString(5));
            product.setDescription(rs.getString(6));

            return product;

        } catch (Exception ex) {

        }
        return null;

    }

    public Account login(String user, String pass) {
        String query = "SELECT *\n"
                + "  FROM [BookStore].[dbo].[Account]\n"
                + "  where [user] =? and pass=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public Account checkAccountExist(String user) {
        String query = "SELECT *\n"
                + "  FROM [BookStore].[dbo].[Account]\n"
                + "  where [user] =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void signup(String user, String pass) {
        try {
            String sql = "INSERT INTO  Account\n"
                    + "     VALUES\n"
                    + "           (?,?,0,0)";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.execute();
            ps.close();
        } catch (Exception ex) {
        }

    }

    public void deleteProduct(String id) {
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            String sql = "DELETE FROM [product]\n"
                    + "      WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(String name, String image, String price, String title, String descpiption, String category, int sid) {
        try {
            String sql = "INSERT INTO [dbo].[product]\n"
                    + "           ([name]\n"
                    + "           ,[image]\n"
                    + "           ,[price]\n"
                    + "           ,[title]\n"
                    + "           ,[description]\n"
                    + "           ,[cateID]\n"
                    + "           ,[sell_ID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, descpiption);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.execute();
            ps.close();

        } catch (Exception ex) {

        }

    }

    public void updateProduct(String name, String image, String price, String title, String descpiption, String category, String pid) {
        try {
            String sql = "UPDATE [dbo].[product]\n"
                    + "   SET [name]=? \n"
                    + "      ,[image]=?\n"
                    + "      ,[price]=?\n"
                    + "      ,[title]=? \n"
                    + "      ,[description]=? \n"
                    + "      ,[cateID]=? \n"
                    + "      \n"
                    + " WHERE id =?";
            conn = new DBContext().getConnection();//mo ket noi voi sql
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, descpiption);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.execute();
            ps.close();

        } catch (Exception ex) {

        }

    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        String cid = "H";
//        Product list = dao.getProductByID(cid);
//        Product list1 = dao.getLast();
        Account login = dao.login("longle", "123");
        List<Product> listC = dao.searchListProductByName(cid);
        System.out.println(login);

        for (Product o : listC) {
            System.out.println(o);
        }
    }

}
