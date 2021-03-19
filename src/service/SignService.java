package service;

import dao.UserDao;
import bean.User;

public class SignService {
    private static SignService logService;
    UserDao userDao = UserDao.getSingletonInstance();

    private SignService() {}

    public static synchronized SignService getSingletonInstance() {
        if(logService==null) {
            logService=new SignService();
        }
        return logService;
    }

    public User signIn(String id) {
        return userDao.selectById(id);
    }

    public boolean signUp(User u){
        return userDao.insertUser(u);
    }

    public boolean existId(String id){
        return signIn(id) != null;
    }
}
