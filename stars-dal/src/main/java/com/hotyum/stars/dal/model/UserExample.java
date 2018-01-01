package com.hotyum.stars.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameIsNull() {
            addCriterion("whether_real_name is null");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameIsNotNull() {
            addCriterion("whether_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameEqualTo(Byte value) {
            addCriterion("whether_real_name =", value, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameNotEqualTo(Byte value) {
            addCriterion("whether_real_name <>", value, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameGreaterThan(Byte value) {
            addCriterion("whether_real_name >", value, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameGreaterThanOrEqualTo(Byte value) {
            addCriterion("whether_real_name >=", value, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameLessThan(Byte value) {
            addCriterion("whether_real_name <", value, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameLessThanOrEqualTo(Byte value) {
            addCriterion("whether_real_name <=", value, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameIn(List<Byte> values) {
            addCriterion("whether_real_name in", values, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameNotIn(List<Byte> values) {
            addCriterion("whether_real_name not in", values, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameBetween(Byte value1, Byte value2) {
            addCriterion("whether_real_name between", value1, value2, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andWhetherRealNameNotBetween(Byte value1, Byte value2) {
            addCriterion("whether_real_name not between", value1, value2, "whetherRealName");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationIsNull() {
            addCriterion("referee_qualification is null");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationIsNotNull() {
            addCriterion("referee_qualification is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationEqualTo(Byte value) {
            addCriterion("referee_qualification =", value, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationNotEqualTo(Byte value) {
            addCriterion("referee_qualification <>", value, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationGreaterThan(Byte value) {
            addCriterion("referee_qualification >", value, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationGreaterThanOrEqualTo(Byte value) {
            addCriterion("referee_qualification >=", value, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationLessThan(Byte value) {
            addCriterion("referee_qualification <", value, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationLessThanOrEqualTo(Byte value) {
            addCriterion("referee_qualification <=", value, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationIn(List<Byte> values) {
            addCriterion("referee_qualification in", values, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationNotIn(List<Byte> values) {
            addCriterion("referee_qualification not in", values, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationBetween(Byte value1, Byte value2) {
            addCriterion("referee_qualification between", value1, value2, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andRefereeQualificationNotBetween(Byte value1, Byte value2) {
            addCriterion("referee_qualification not between", value1, value2, "refereeQualification");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNull() {
            addCriterion("agent_code is null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNotNull() {
            addCriterion("agent_code is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeEqualTo(String value) {
            addCriterion("agent_code =", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotEqualTo(String value) {
            addCriterion("agent_code <>", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThan(String value) {
            addCriterion("agent_code >", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_code >=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThan(String value) {
            addCriterion("agent_code <", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThanOrEqualTo(String value) {
            addCriterion("agent_code <=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLike(String value) {
            addCriterion("agent_code like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotLike(String value) {
            addCriterion("agent_code not like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIn(List<String> values) {
            addCriterion("agent_code in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotIn(List<String> values) {
            addCriterion("agent_code not in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeBetween(String value1, String value2) {
            addCriterion("agent_code between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotBetween(String value1, String value2) {
            addCriterion("agent_code not between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountIsNull() {
            addCriterion("direct_recommendation_account is null");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountIsNotNull() {
            addCriterion("direct_recommendation_account is not null");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountEqualTo(String value) {
            addCriterion("direct_recommendation_account =", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountNotEqualTo(String value) {
            addCriterion("direct_recommendation_account <>", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountGreaterThan(String value) {
            addCriterion("direct_recommendation_account >", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountGreaterThanOrEqualTo(String value) {
            addCriterion("direct_recommendation_account >=", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountLessThan(String value) {
            addCriterion("direct_recommendation_account <", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountLessThanOrEqualTo(String value) {
            addCriterion("direct_recommendation_account <=", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountLike(String value) {
            addCriterion("direct_recommendation_account like", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountNotLike(String value) {
            addCriterion("direct_recommendation_account not like", value, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountIn(List<String> values) {
            addCriterion("direct_recommendation_account in", values, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountNotIn(List<String> values) {
            addCriterion("direct_recommendation_account not in", values, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountBetween(String value1, String value2) {
            addCriterion("direct_recommendation_account between", value1, value2, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationAccountNotBetween(String value1, String value2) {
            addCriterion("direct_recommendation_account not between", value1, value2, "directRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountIsNull() {
            addCriterion("indirect_recommendation_account is null");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountIsNotNull() {
            addCriterion("indirect_recommendation_account is not null");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountEqualTo(String value) {
            addCriterion("indirect_recommendation_account =", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountNotEqualTo(String value) {
            addCriterion("indirect_recommendation_account <>", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountGreaterThan(String value) {
            addCriterion("indirect_recommendation_account >", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountGreaterThanOrEqualTo(String value) {
            addCriterion("indirect_recommendation_account >=", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountLessThan(String value) {
            addCriterion("indirect_recommendation_account <", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountLessThanOrEqualTo(String value) {
            addCriterion("indirect_recommendation_account <=", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountLike(String value) {
            addCriterion("indirect_recommendation_account like", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountNotLike(String value) {
            addCriterion("indirect_recommendation_account not like", value, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountIn(List<String> values) {
            addCriterion("indirect_recommendation_account in", values, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountNotIn(List<String> values) {
            addCriterion("indirect_recommendation_account not in", values, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountBetween(String value1, String value2) {
            addCriterion("indirect_recommendation_account between", value1, value2, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationAccountNotBetween(String value1, String value2) {
            addCriterion("indirect_recommendation_account not between", value1, value2, "indirectRecommendationAccount");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNull() {
            addCriterion("certificate_type is null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNotNull() {
            addCriterion("certificate_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeEqualTo(Byte value) {
            addCriterion("certificate_type =", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotEqualTo(Byte value) {
            addCriterion("certificate_type <>", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThan(Byte value) {
            addCriterion("certificate_type >", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("certificate_type >=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThan(Byte value) {
            addCriterion("certificate_type <", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("certificate_type <=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIn(List<Byte> values) {
            addCriterion("certificate_type in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotIn(List<Byte> values) {
            addCriterion("certificate_type not in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeBetween(Byte value1, Byte value2) {
            addCriterion("certificate_type between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("certificate_type not between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNull() {
            addCriterion("certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNotNull() {
            addCriterion("certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberEqualTo(String value) {
            addCriterion("certificate_number =", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotEqualTo(String value) {
            addCriterion("certificate_number <>", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThan(String value) {
            addCriterion("certificate_number >", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_number >=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThan(String value) {
            addCriterion("certificate_number <", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("certificate_number <=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLike(String value) {
            addCriterion("certificate_number like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotLike(String value) {
            addCriterion("certificate_number not like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIn(List<String> values) {
            addCriterion("certificate_number in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotIn(List<String> values) {
            addCriterion("certificate_number not in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberBetween(String value1, String value2) {
            addCriterion("certificate_number between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("certificate_number not between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontIsNull() {
            addCriterion("certificate_front is null");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontIsNotNull() {
            addCriterion("certificate_front is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontEqualTo(String value) {
            addCriterion("certificate_front =", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontNotEqualTo(String value) {
            addCriterion("certificate_front <>", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontGreaterThan(String value) {
            addCriterion("certificate_front >", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_front >=", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontLessThan(String value) {
            addCriterion("certificate_front <", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontLessThanOrEqualTo(String value) {
            addCriterion("certificate_front <=", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontLike(String value) {
            addCriterion("certificate_front like", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontNotLike(String value) {
            addCriterion("certificate_front not like", value, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontIn(List<String> values) {
            addCriterion("certificate_front in", values, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontNotIn(List<String> values) {
            addCriterion("certificate_front not in", values, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontBetween(String value1, String value2) {
            addCriterion("certificate_front between", value1, value2, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateFrontNotBetween(String value1, String value2) {
            addCriterion("certificate_front not between", value1, value2, "certificateFront");
            return (Criteria) this;
        }

        public Criteria andCertificateBackIsNull() {
            addCriterion("certificate_back is null");
            return (Criteria) this;
        }

        public Criteria andCertificateBackIsNotNull() {
            addCriterion("certificate_back is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateBackEqualTo(String value) {
            addCriterion("certificate_back =", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackNotEqualTo(String value) {
            addCriterion("certificate_back <>", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackGreaterThan(String value) {
            addCriterion("certificate_back >", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_back >=", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackLessThan(String value) {
            addCriterion("certificate_back <", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackLessThanOrEqualTo(String value) {
            addCriterion("certificate_back <=", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackLike(String value) {
            addCriterion("certificate_back like", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackNotLike(String value) {
            addCriterion("certificate_back not like", value, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackIn(List<String> values) {
            addCriterion("certificate_back in", values, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackNotIn(List<String> values) {
            addCriterion("certificate_back not in", values, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackBetween(String value1, String value2) {
            addCriterion("certificate_back between", value1, value2, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andCertificateBackNotBetween(String value1, String value2) {
            addCriterion("certificate_back not between", value1, value2, "certificateBack");
            return (Criteria) this;
        }

        public Criteria andAddressPicIsNull() {
            addCriterion("address_pic is null");
            return (Criteria) this;
        }

        public Criteria andAddressPicIsNotNull() {
            addCriterion("address_pic is not null");
            return (Criteria) this;
        }

        public Criteria andAddressPicEqualTo(String value) {
            addCriterion("address_pic =", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicNotEqualTo(String value) {
            addCriterion("address_pic <>", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicGreaterThan(String value) {
            addCriterion("address_pic >", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicGreaterThanOrEqualTo(String value) {
            addCriterion("address_pic >=", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicLessThan(String value) {
            addCriterion("address_pic <", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicLessThanOrEqualTo(String value) {
            addCriterion("address_pic <=", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicLike(String value) {
            addCriterion("address_pic like", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicNotLike(String value) {
            addCriterion("address_pic not like", value, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicIn(List<String> values) {
            addCriterion("address_pic in", values, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicNotIn(List<String> values) {
            addCriterion("address_pic not in", values, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicBetween(String value1, String value2) {
            addCriterion("address_pic between", value1, value2, "addressPic");
            return (Criteria) this;
        }

        public Criteria andAddressPicNotBetween(String value1, String value2) {
            addCriterion("address_pic not between", value1, value2, "addressPic");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Byte value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Byte value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Byte value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Byte value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Byte value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Byte> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Byte> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Byte value1, Byte value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeIsNull() {
            addCriterion("freeze_type is null");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeIsNotNull() {
            addCriterion("freeze_type is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeEqualTo(Byte value) {
            addCriterion("freeze_type =", value, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeNotEqualTo(Byte value) {
            addCriterion("freeze_type <>", value, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeGreaterThan(Byte value) {
            addCriterion("freeze_type >", value, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("freeze_type >=", value, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeLessThan(Byte value) {
            addCriterion("freeze_type <", value, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("freeze_type <=", value, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeIn(List<Byte> values) {
            addCriterion("freeze_type in", values, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeNotIn(List<Byte> values) {
            addCriterion("freeze_type not in", values, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeBetween(Byte value1, Byte value2) {
            addCriterion("freeze_type between", value1, value2, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("freeze_type not between", value1, value2, "freezeType");
            return (Criteria) this;
        }

        public Criteria andFreezeDateIsNull() {
            addCriterion("freeze_date is null");
            return (Criteria) this;
        }

        public Criteria andFreezeDateIsNotNull() {
            addCriterion("freeze_date is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeDateEqualTo(Date value) {
            addCriterion("freeze_date =", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateNotEqualTo(Date value) {
            addCriterion("freeze_date <>", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateGreaterThan(Date value) {
            addCriterion("freeze_date >", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("freeze_date >=", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateLessThan(Date value) {
            addCriterion("freeze_date <", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateLessThanOrEqualTo(Date value) {
            addCriterion("freeze_date <=", value, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateIn(List<Date> values) {
            addCriterion("freeze_date in", values, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateNotIn(List<Date> values) {
            addCriterion("freeze_date not in", values, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateBetween(Date value1, Date value2) {
            addCriterion("freeze_date between", value1, value2, "freezeDate");
            return (Criteria) this;
        }

        public Criteria andFreezeDateNotBetween(Date value1, Date value2) {
            addCriterion("freeze_date not between", value1, value2, "freezeDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}