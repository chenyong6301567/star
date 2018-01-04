package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Notice;
import com.hotyum.stars.dal.model.NoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NoticeMapper {
    @SelectProvider(type=NoticeSqlProvider.class, method="countByExample")
    long countByExample(NoticeExample example);

    @DeleteProvider(type=NoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(NoticeExample example);

    @Delete({
        "delete from notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into notice (user_id, type, ",
        "notice_content, gmt_create, ",
        "gmt_modify, status, ",
        "read)",
        "values (#{userId,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{noticeContent,jdbcType=VARCHAR}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
        "#{read,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Notice record);

    @InsertProvider(type=NoticeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Notice record);

    @SelectProvider(type=NoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="read", property="read", jdbcType=JdbcType.TINYINT)
    })
    List<Notice> selectByExample(NoticeExample example);

    @Select({
        "select",
        "id, user_id, type, notice_content, gmt_create, gmt_modify, status, read",
        "from notice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="notice_content", property="noticeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="read", property="read", jdbcType=JdbcType.TINYINT)
    })
    Notice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update notice",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "notice_content = #{noticeContent,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "read = #{read,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);
}