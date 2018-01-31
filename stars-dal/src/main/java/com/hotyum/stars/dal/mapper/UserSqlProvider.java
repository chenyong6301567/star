package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.dal.model.UserExample.Criteria;
import com.hotyum.stars.dal.model.UserExample.Criterion;
import com.hotyum.stars.dal.model.UserExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String countByExample(UserExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getAccount() != null) {
            sql.VALUES("account", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.VALUES("contact_phone", "#{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckEmail() != null) {
            sql.VALUES("check_email", "#{checkEmail,jdbcType=TINYINT}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=TINYINT}");
        }
        
        if (record.getRealName() != null) {
            sql.VALUES("real_name", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getWhetherRealName() != null) {
            sql.VALUES("whether_real_name", "#{whetherRealName,jdbcType=TINYINT}");
        }
        
        if (record.getWheatherGetMoney() != null) {
            sql.VALUES("wheather_get_money", "#{wheatherGetMoney,jdbcType=TINYINT}");
        }
        
        if (record.getSumMoney() != null) {
            sql.VALUES("sum_money", "#{sumMoney,jdbcType=DECIMAL}");
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
        
        if (record.getRefereeQualification() != null) {
            sql.VALUES("referee_qualification", "#{refereeQualification,jdbcType=TINYINT}");
        }
        
        if (record.getAgentCode() != null) {
            sql.VALUES("agent_code", "#{agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentName() != null) {
            sql.VALUES("agent_name", "#{agentName,jdbcType=VARCHAR}");
        }
        
        if (record.getDirectRecommendationAccount() != null) {
            sql.VALUES("direct_recommendation_account", "#{directRecommendationAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRecommendationAccount() != null) {
            sql.VALUES("indirect_recommendation_account", "#{indirectRecommendationAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateType() != null) {
            sql.VALUES("certificate_type", "#{certificateType,jdbcType=TINYINT}");
        }
        
        if (record.getCertificateNumber() != null) {
            sql.VALUES("certificate_number", "#{certificateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateFront() != null) {
            sql.VALUES("certificate_front", "#{certificateFront,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateBack() != null) {
            sql.VALUES("certificate_back", "#{certificateBack,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressPic() != null) {
            sql.VALUES("address_pic", "#{addressPic,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            sql.VALUES("user_type", "#{userType,jdbcType=TINYINT}");
        }
        
        if (record.getWhetherFreeze() != null) {
            sql.VALUES("whether_freeze", "#{whetherFreeze,jdbcType=TINYINT}");
        }
        
        if (record.getFreezeDate() != null) {
            sql.VALUES("freeze_date", "#{freezeDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCustomerAgent() != null) {
            sql.VALUES("customer_agent", "#{customerAgent,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("account");
        sql.SELECT("pwd");
        sql.SELECT("contact_phone");
        sql.SELECT("email");
        sql.SELECT("check_email");
        sql.SELECT("sex");
        sql.SELECT("real_name");
        sql.SELECT("whether_real_name");
        sql.SELECT("wheather_get_money");
        sql.SELECT("sum_money");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("status");
        sql.SELECT("referee_qualification");
        sql.SELECT("agent_code");
        sql.SELECT("agent_name");
        sql.SELECT("direct_recommendation_account");
        sql.SELECT("indirect_recommendation_account");
        sql.SELECT("certificate_type");
        sql.SELECT("certificate_number");
        sql.SELECT("certificate_front");
        sql.SELECT("certificate_back");
        sql.SELECT("address_pic");
        sql.SELECT("user_name");
        sql.SELECT("user_type");
        sql.SELECT("whether_freeze");
        sql.SELECT("freeze_date");
        sql.SELECT("customer_agent");
        sql.FROM("user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAccount() != null) {
            sql.SET("account = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{record.pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckEmail() != null) {
            sql.SET("check_email = #{record.checkEmail,jdbcType=TINYINT}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{record.sex,jdbcType=TINYINT}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        }
        
        if (record.getWhetherRealName() != null) {
            sql.SET("whether_real_name = #{record.whetherRealName,jdbcType=TINYINT}");
        }
        
        if (record.getWheatherGetMoney() != null) {
            sql.SET("wheather_get_money = #{record.wheatherGetMoney,jdbcType=TINYINT}");
        }
        
        if (record.getSumMoney() != null) {
            sql.SET("sum_money = #{record.sumMoney,jdbcType=DECIMAL}");
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
        
        if (record.getRefereeQualification() != null) {
            sql.SET("referee_qualification = #{record.refereeQualification,jdbcType=TINYINT}");
        }
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentName() != null) {
            sql.SET("agent_name = #{record.agentName,jdbcType=VARCHAR}");
        }
        
        if (record.getDirectRecommendationAccount() != null) {
            sql.SET("direct_recommendation_account = #{record.directRecommendationAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRecommendationAccount() != null) {
            sql.SET("indirect_recommendation_account = #{record.indirectRecommendationAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateType() != null) {
            sql.SET("certificate_type = #{record.certificateType,jdbcType=TINYINT}");
        }
        
        if (record.getCertificateNumber() != null) {
            sql.SET("certificate_number = #{record.certificateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateFront() != null) {
            sql.SET("certificate_front = #{record.certificateFront,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateBack() != null) {
            sql.SET("certificate_back = #{record.certificateBack,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressPic() != null) {
            sql.SET("address_pic = #{record.addressPic,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            sql.SET("user_type = #{record.userType,jdbcType=TINYINT}");
        }
        
        if (record.getWhetherFreeze() != null) {
            sql.SET("whether_freeze = #{record.whetherFreeze,jdbcType=TINYINT}");
        }
        
        if (record.getFreezeDate() != null) {
            sql.SET("freeze_date = #{record.freezeDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCustomerAgent() != null) {
            sql.SET("customer_agent = #{record.customerAgent,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("account = #{record.account,jdbcType=VARCHAR}");
        sql.SET("pwd = #{record.pwd,jdbcType=VARCHAR}");
        sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("check_email = #{record.checkEmail,jdbcType=TINYINT}");
        sql.SET("sex = #{record.sex,jdbcType=TINYINT}");
        sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        sql.SET("whether_real_name = #{record.whetherRealName,jdbcType=TINYINT}");
        sql.SET("wheather_get_money = #{record.wheatherGetMoney,jdbcType=TINYINT}");
        sql.SET("sum_money = #{record.sumMoney,jdbcType=DECIMAL}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("referee_qualification = #{record.refereeQualification,jdbcType=TINYINT}");
        sql.SET("agent_code = #{record.agentCode,jdbcType=VARCHAR}");
        sql.SET("agent_name = #{record.agentName,jdbcType=VARCHAR}");
        sql.SET("direct_recommendation_account = #{record.directRecommendationAccount,jdbcType=VARCHAR}");
        sql.SET("indirect_recommendation_account = #{record.indirectRecommendationAccount,jdbcType=VARCHAR}");
        sql.SET("certificate_type = #{record.certificateType,jdbcType=TINYINT}");
        sql.SET("certificate_number = #{record.certificateNumber,jdbcType=VARCHAR}");
        sql.SET("certificate_front = #{record.certificateFront,jdbcType=VARCHAR}");
        sql.SET("certificate_back = #{record.certificateBack,jdbcType=VARCHAR}");
        sql.SET("address_pic = #{record.addressPic,jdbcType=VARCHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("user_type = #{record.userType,jdbcType=TINYINT}");
        sql.SET("whether_freeze = #{record.whetherFreeze,jdbcType=TINYINT}");
        sql.SET("freeze_date = #{record.freezeDate,jdbcType=TIMESTAMP}");
        sql.SET("customer_agent = #{record.customerAgent,jdbcType=VARCHAR}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getAccount() != null) {
            sql.SET("account = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckEmail() != null) {
            sql.SET("check_email = #{checkEmail,jdbcType=TINYINT}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=TINYINT}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getWhetherRealName() != null) {
            sql.SET("whether_real_name = #{whetherRealName,jdbcType=TINYINT}");
        }
        
        if (record.getWheatherGetMoney() != null) {
            sql.SET("wheather_get_money = #{wheatherGetMoney,jdbcType=TINYINT}");
        }
        
        if (record.getSumMoney() != null) {
            sql.SET("sum_money = #{sumMoney,jdbcType=DECIMAL}");
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
        
        if (record.getRefereeQualification() != null) {
            sql.SET("referee_qualification = #{refereeQualification,jdbcType=TINYINT}");
        }
        
        if (record.getAgentCode() != null) {
            sql.SET("agent_code = #{agentCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAgentName() != null) {
            sql.SET("agent_name = #{agentName,jdbcType=VARCHAR}");
        }
        
        if (record.getDirectRecommendationAccount() != null) {
            sql.SET("direct_recommendation_account = #{directRecommendationAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRecommendationAccount() != null) {
            sql.SET("indirect_recommendation_account = #{indirectRecommendationAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateType() != null) {
            sql.SET("certificate_type = #{certificateType,jdbcType=TINYINT}");
        }
        
        if (record.getCertificateNumber() != null) {
            sql.SET("certificate_number = #{certificateNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateFront() != null) {
            sql.SET("certificate_front = #{certificateFront,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificateBack() != null) {
            sql.SET("certificate_back = #{certificateBack,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressPic() != null) {
            sql.SET("address_pic = #{addressPic,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserType() != null) {
            sql.SET("user_type = #{userType,jdbcType=TINYINT}");
        }
        
        if (record.getWhetherFreeze() != null) {
            sql.SET("whether_freeze = #{whetherFreeze,jdbcType=TINYINT}");
        }
        
        if (record.getFreezeDate() != null) {
            sql.SET("freeze_date = #{freezeDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCustomerAgent() != null) {
            sql.SET("customer_agent = #{customerAgent,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserExample example, boolean includeExamplePhrase) {
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