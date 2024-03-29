package org.sang;

import org.apache.ibatis.session.SqlSession;
import org.sang.bean.User;
import org.sang.db.DBUtils;
import org.sang.db.UserMapper;

public class Test {

    @org.junit.Test
    public void getUserById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(2);
            System.out.println(user.toString());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @org.junit.Test
    public void getUserByStatement() {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            User user = (User) sqlSession.selectOne("org.sang.db.UserMapper.getUser", 3);
            System.out.println(user.toString());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @org.junit.Test
    public void notPackage() {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            User user = (User) sqlSession.selectOne("getUser", 11);
            System.out.println(user.toString());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
