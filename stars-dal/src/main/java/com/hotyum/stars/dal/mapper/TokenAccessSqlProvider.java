package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.TokenAccess;
import com.hotyum.stars.dal.model.TokenAccessExample.Criteria;
import com.hotyum.stars.dal.model.TokenAccessExample.Criterion;
import com.hotyum.stars.dal.model.TokenAccessExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TokenAccessSqlProvider {

    public String countByExample(TokenAccessExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("token_access");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TokenAccessExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("token_access");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TokenAccess record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("token_access");
        
        if (record.getToken() != null) {
            sql.VALUES("token", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTokenCreate() != null) {
            sql.VALUES("token_create", "#{tokenCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTokenExpired() != null) {
            sql.VALUES("token_expired", "#{tokenExpired,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActiveTime() != null) {
            sql.VALUES("active_time", "#{activeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActiveCount() != null) {
            sql.VALUES("active_count", "#{activeCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemember() != null) {
            sql.VALUES("remember", "#{remember,jdbcType=TINYINT}");
        }
        
        if (record.getAnonymous() != null) {
            sql.VALUES("anonymous", "#{anonymous,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TokenAccessExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("token");
        sql.SELECT("user_id");
        sql.SELECT("token_create");
        sql.SELECT("token_expired");
        sql.SELECT("active_time");
        sql.SELECT("active_count");
        sql.SELECT("remember");
        sql.SELECT("anonymous");
        sql.SELECT("status");
        sql.FROM("token_access");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TokenAccess record = (TokenAccess) parameter.get("record");
        TokenAccessExample example = (TokenAccessExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("token_access");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getToken() != null) {
            sql.SET("token = #{record.token,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getTokenCreate() != null) {
            sql.SET("token_create = #{record.tokenCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTokenExpired() != null) {
            sql.SET("token_expired = #{record.tokenExpired,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActiveTime() != null) {
            sql.SET("active_time = #{record.activeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActiveCount() != null) {
            sql.SET("active_count = #{record.activeCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemember() != null) {
            sql.SET("remember = #{record.remember,jdbcType=TINYINT}");
        }
        
        if (record.getAnonymous() != null) {
            sql.SET("anonymous = #{record.anonymous,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("token_access");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("token = #{record.token,jdbcType=VARCHAR}");
        sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        sql.SET("token_create = #{record.tokenCreate,jdbcType=TIMESTAMP}");
        sql.SET("token_expired = #{record.tokenExpired,jdbcType=TIMESTAMP}");
        sql.SET("active_time = #{record.activeTime,jdbcType=TIMESTAMP}");
        sql.SET("active_count = #{record.activeCount,jdbcType=INTEGER}");
        sql.SET("remember = #{record.remember,jdbcType=TINYINT}");
        sql.SET("anonymous = #{record.anonymous,jdbcType=TINYINT}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        
        TokenAccessExample example = (TokenAccessExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TokenAccess record) {
        SQL sql = new SQL();
        sql.UPDATE("token_access");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTokenCreate() != null) {
            sql.SET("token_create = #{tokenCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTokenExpired() != null) {
            sql.SET("token_expired = #{tokenExpired,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActiveTime() != null) {
            sql.SET("active_time = #{activeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActiveCount() != null) {
            sql.SET("active_count = #{activeCount,jdbcType=INTEGER}");
        }
        
        if (record.getRemember() != null) {
            sql.SET("remember = #{remember,jdbcType=TINYINT}");
        }
        
        if (record.getAnonymous() != null) {
            sql.SET("anonymous = #{anonymous,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        sql.WHERE("token = #{token,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TokenAccessExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}