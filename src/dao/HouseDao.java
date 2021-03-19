package dao;

import bean.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 32098
 */
public class HouseDao extends BaseDao{
    private static HouseDao houseDao = null;

    private HouseDao(){}

    public static synchronized HouseDao getSingletonInstance(){
        if (houseDao == null){
            houseDao = new HouseDao();
        }
        return houseDao;
    }

    public House selectById(int id){
        Connection con;
        House h = null;
        try {
            con = this.openConnection();
            String sql = "select * from house where houseid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                String title = rs.getString("title");
                double area = rs.getDouble("area");
                double price = rs.getDouble("price");
                String info = rs.getString("info");
                int typeId = rs.getInt("typeid");
                h = new House(id,title,area,price,info,typeId);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return h;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<House> selectAllHouses(){
        List<House> houses = new ArrayList<>();

        try {
            Connection con = this.openConnection();
            String sql = "select * from house";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                int id = rs.getInt("houseid");
                String title = rs.getString("title");
                double area = rs.getDouble("area");
                double price = rs.getDouble("price");
                String info = rs.getString("info");
                int typeId = rs.getInt("typeid");
                House h = new House(id,title,area,price,info,typeId);
                houses.add(h);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return houses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertHouse(House h){
        try {
            Connection con = this.openConnection();
            String sql = "insert into house values (null, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, h.getTitle());
            ps.setDouble(2, h.getArea());
            ps.setDouble(3, h.getPrice());
            ps.setString(4, h.getInfo());
            ps.setInt(5,h.getTypeId());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(House h){
        try {
            Connection con = this.openConnection();
            String sql = "update house set title=?,area=?,price=?,info=?,typeid=? where houseid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, h.getTitle());
            ps.setDouble(2, h.getArea());
            ps.setDouble(3, h.getPrice());
            ps.setString(4, h.getInfo());
            ps.setInt(5,h.getTypeId());
            ps.setInt(6,h.getHouseId());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int houseid){
        try{
            Connection con = this.openConnection();
            String sql = "delete from house where houseid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,houseid);
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public int getCount(){
        int count=0;
        try {
            Connection con = this.openConnection();
            String sql = "select count(*) from house";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public List<House> selectUsersByPage(int page, int size){
        List<House> houses = new ArrayList<>();
        try {
            Connection con = this.openConnection();
            String sql = "select * from house limit ?,?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,(page-1)*size);
            ps.setInt(2,size);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                int id = rs.getInt("houseid");
                String title = rs.getString("title");
                double area = rs.getDouble("area");
                double price = rs.getDouble("price");
                String info = rs.getString("info");
                int typeId = rs.getInt("typeid");
                House h = new House(id,title,area,price,info,typeId);
                houses.add(h);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return houses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
