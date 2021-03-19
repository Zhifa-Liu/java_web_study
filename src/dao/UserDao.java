package dao;

import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao{
    private static UserDao userDao = null;

    private UserDao(){}

    public static synchronized UserDao getSingletonInstance(){
        if (userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    public User selectById(String id){
        Connection con;
        User u = null;
        try {
            con = this.openConnection();
            String sql = "select * from user where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                String psw = rs.getString("password");
                String un = rs.getString("username");
                String tel = rs.getString("tel");
                rs.getString("tel");
                u = new User(id, psw, un, tel);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> selectUsers(){
        List<User> users = new ArrayList<>();

        try {
            Connection con = this.openConnection();
            String sql = "select * from user";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                String id = rs.getString("userid");
                String psw = rs.getString("password");
                String un = rs.getString("username");
                String tel = rs.getString("tel");
                rs.getString("tel");
                User u = new User(id, psw, un, tel);
                users.add(u);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertUser(User u){
        try {
            Connection con = this.openConnection();
            String sql = "insert into user values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUserid());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getTel());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(User user){
        try {
            Connection con = this.openConnection();
            String sql = "update user set password=?,username=?,tel=? where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getTel());
            ps.setString(4,user.getUserid());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String userid){
        try{
            Connection con = this.openConnection();
            String sql = "delete from user where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,userid);
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
            String sql = "select count(*) from user";
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

    public List<User> selectUsersByPage(int page,int size){
        List<User> users = new ArrayList<>();
        try {
            Connection con = this.openConnection();
            String sql = "select * from user limit ?,?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,(page-1)*size);
            ps.setInt(2,size);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                String id = rs.getString("userid");
                String psw = rs.getString("password");
                String un = rs.getString("username");
                String tel = rs.getString("tel");
                rs.getString("tel");
                User u = new User(id, psw, un, tel);
                users.add(u);
            }
            rs.close();
            ps.close();
            this.closeConnection(con);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
