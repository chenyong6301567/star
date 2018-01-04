package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.MyReferralInformation;
import com.hotyum.stars.dal.model.MyReferralInformationExample.Criteria;
import com.hotyum.stars.dal.model.MyReferralInformationExample.Criterion;
import com.hotyum.stars.dal.model.MyReferralInformationExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MyReferralInformationSqlProvider {

    public String countByExample(MyReferralInformationExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("my_referral_information");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MyReferralInformationExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("my_referral_information");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(MyReferralInformation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("my_referral_information");
        
        if (record.getUsId() != null) {
            sql.VALUES("us_id", "#{usId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getStarDegree() != null) {
            sql.VALUES("star_degree", "#{starDegree,jdbcType=VARCHAR}");
        }
        
        if (record.getSumMoney() != null) {
            sql.VALUES("sum_money", "#{sumMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDirectRewardRate() != null) {
            sql.VALUES("direct_reward_rate", "#{directRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRewardRate() != null) {
            sql.VALUES("indirect_reward_rate", "#{indirectRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectReferralNumber() != null) {
            sql.VALUES("indirect_referral_number", "#{indirectReferralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getDirectReferralNumber() != null) {
            sql.VALUES("direct_referral_number", "#{directReferralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MyReferralInformationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("us_id");
        sql.SELECT("user_name");
        sql.SELECT("star_degree");
        sql.SELECT("sum_money");
        sql.SELECT("direct_reward_rate");
        sql.SELECT("indirect_reward_rate");
        sql.SELECT("indirect_referral_number");
        sql.SELECT("direct_referral_number");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("status");
        sql.FROM("my_referral_information");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        MyReferralInformation record = (MyReferralInformation) parameter.get("record");
        MyReferralInformationExample example = (MyReferralInformationExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("my_referral_information");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUsId() != null) {
            sql.SET("us_id = #{record.usId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getStarDegree() != null) {
            sql.SET("star_degree = #{record.starDegree,jdbcType=VARCHAR}");
        }
        
        if (record.getSumMoney() != null) {
            sql.SET("sum_money = #{record.sumMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDirectRewardRate() != null) {
            sql.SET("direct_reward_rate = #{record.directRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRewardRate() != null) {
            sql.SET("indirect_reward_rate = #{record.indirectRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectReferralNumber() != null) {
            sql.SET("indirect_referral_number = #{record.indirectReferralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getDirectReferralNumber() != null) {
            sql.SET("direct_referral_number = #{record.directReferralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("my_referral_information");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("us_id = #{record.usId,jdbcType=INTEGER}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("star_degree = #{record.starDegree,jdbcType=VARCHAR}");
        sql.SET("sum_money = #{record.sumMoney,jdbcType=DECIMAL}");
        sql.SET("direct_reward_rate = #{record.directRewardRate,jdbcType=VARCHAR}");
        sql.SET("indirect_reward_rate = #{record.indirectRewardRate,jdbcType=VARCHAR}");
        sql.SET("indirect_referral_number = #{record.indirectReferralNumber,jdbcType=INTEGER}");
        sql.SET("direct_referral_number = #{record.directReferralNumber,jdbcType=INTEGER}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        
        MyReferralInformationExample example = (MyReferralInformationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MyReferralInformation record) {
        SQL sql = new SQL();
        sql.UPDATE("my_referral_information");
        
        if (record.getUsId() != null) {
            sql.SET("us_id = #{usId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getStarDegree() != null) {
            sql.SET("star_degree = #{starDegree,jdbcType=VARCHAR}");
        }
        
        if (record.getSumMoney() != null) {
            sql.SET("sum_money = #{sumMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDirectRewardRate() != null) {
            sql.SET("direct_reward_rate = #{directRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRewardRate() != null) {
            sql.SET("indirect_reward_rate = #{indirectRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectReferralNumber() != null) {
            sql.SET("indirect_referral_number = #{indirectReferralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getDirectReferralNumber() != null) {
            sql.SET("direct_referral_number = #{directReferralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MyReferralInformationExample example, boolean includeExamplePhrase) {
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