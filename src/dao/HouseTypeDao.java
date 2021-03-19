package dao;

import bean.HouseType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseTypeDao extends BaseDao{
    private static HouseTypeDao houseTypeDao = null;

    private HouseTypeDao(){}

    public static synchronized HouseTypeDao getSingletonInstance(){
        if (houseTypeDao == null){
            houseTypeDao = new HouseTypeDao();
        }
        return houseTypeDao;
    }

    public HouseType selectById(int id){
        Connection con;
        HouseType houseType = null;
        try {
            con = this.openConnection();
            String sql = "select * from housetype where typeid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                String typeName = rs.getString("typename");
                houseType = new HouseType(id,typeName);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return houseType;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HouseType> selectAll(){
        List<HouseType> hts = new ArrayList<>();

        try {
            Connection con = this.openConnection();
            String sql = "select * from housetype";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                int id = rs.getInt("typeid");
                String typeName = rs.getString("typename");
                HouseType ht = new HouseType(id, typeName);
                hts.add(ht);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return hts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertHouseType(HouseType ht){
        try {
            Connection con = this.openConnection();
            String sql = "insert into housetype values (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ht.getTypeId());
            ps.setString(2, ht.getTypeName());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(HouseType ht){
        try {
            Connection con = this.openConnection();
            String sql = "update housetype set typename=? where typeid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ht.getTypeName());
            ps.setInt(2,ht.getTypeId());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String typeid){
        try{
            Connection con = this.openConnection();
            String sql = "delete from housetype where typeid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,typeid);
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
