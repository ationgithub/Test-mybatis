package org.sang;

import org.apache.ibatis.session.SqlSession;
import org.sang.bean.User;
import org.sang.db.DBUtils;
import org.sang.db.UserMapper;

import java.util.Scanner;

/**
 * Created by sang on 17-1-14.
 */
public class Main {
    @org.junit.Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(11);
            System.out.println(user);
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
    public void test2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            for (int i = 0; i < 3; i++) {
                userMapper.insertUser(new User(null, "u-" + i, "p-" + i, "a-" + i));
            }
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
    public void test() {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            按名字模糊查询
              Scanner scanner=new Scanner(System.in);
              System.out.println("请输入你要查询的名字：");
              int num=scanner.nextInt();
               System.out.println(num);

           int i = userMapper.deleteUser(num);
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
