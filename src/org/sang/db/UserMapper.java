package org.sang.db;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.sang.bean.User;

/**
 * Created by sang on 17-1-13.
 */
public interface UserMapper {
    @Select(value = "select * from user where id=#{id}")
    public User getUser(int id);

    @Insert({ "insert into user(username,password,address)"
            + "values(#{username},#{password},#{address})" })
    public int insertUser(User user);

    @Delete({"DELETE FROM user WHERE id = #{id}  "})
    public int deleteUser(int id);

//    INSERT INTO user2(user_name,password,address) VALUES (#{userName},#{password},#{address}
}
